package com.ormediagroup.myapplication.network;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.ormediagroup.myapplication.BuildConfig;
import com.ormediagroup.myapplication.bean.OAuthCodeBean;
import com.ormediagroup.myapplication.bean.OAuthTokenBean;
import com.ormediagroup.myapplication.utils.User;

import java.util.Calendar;
import java.util.HashMap;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Lau on 2020-01-07.
 */
public class Network {
    public static String baseUrl = "http://keylab.cc/";
    public static String clientId = "AyIH6f8CZ3rp1Tye6wfzW4V3pA6d3IoDg7lnmtZm";
    public static String clientSecret = "wqLykkMrR10N6VQwwWKzF8dWgyjC2jZzKL755UwX";
    public static HashMap<String, Retrofit> hashMap = new HashMap<>();

    public static Retrofit getRetrofit(Context context, String baseUrl, Class service) {
        String hashKey = baseUrl + service.getName();
        // 防止多次实例化
        if (hashMap.containsKey(hashKey)) {
            return hashMap.get(hashKey);
        }
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(getOkHttpClient(context))
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        hashMap.put(hashKey, retrofit);
        return retrofit;
    }

    public static OkHttpClient getOkHttpClient(Context context) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        // 添加请求拦截器
        builder.addInterceptor(new RequestInterceptor(context));
        // 当为Debug时，添加log拦截器
        // 每个module都会有自己的BuildConfig，当提取为module时需要使用app下的BuildConfig
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(httpLoggingInterceptor);
        }
        return builder.build();
    }

    // 获取api
    public static <T> T getService(Context context, Class<T> service) {
        return getRetrofit(context, baseUrl, service).create(service);
    }

    // 将重复的操作符封装
    public static <T> ObservableTransformer<T, T> applySchedulers() {
        return upstream -> upstream.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    // 获取ApiService.class
    public static ApiService getApiService(Context context) {
        return getService(context, ApiService.class);
    }

    // 判断OAuthToken是否过期
    private static boolean isOAuthTokenExpired(Context context) {
        User user = new User(context);
        return getNowTime() >= user.getTokenDue() || TextUtils.isEmpty(user.getToken());
    }

    // 设置OAuthToken
    private static void setOAuthToken(Context context, String token, String tokenType, int expire, String refreshToken) {
        long due = getNowTime() + expire * 1000;
        new User(context).setToken(token).setTokenType(tokenType).setTokenDue(due).setRefreshToken(refreshToken);
    }

    // 获取当前时间戳
    private static long getNowTime() {
        Calendar calendar = Calendar.getInstance();
        return calendar.getTime().getTime();
    }

    private static void showMsg(Context context, String str) {
        Toast.makeText(context, str, Toast.LENGTH_SHORT).show();
    }

    // 根据token是否过期来决定是否重新获取token
    public static Observable<OAuthTokenBean> getToken(Context context) {
        if (Network.isOAuthTokenExpired(context)) {
            Log.e("TAG", "getToken: init");
            return Network.getApiService(context)
                    .getOAuthCode("code", Network.clientId)
                    .flatMap((Function<OAuthCodeBean, ObservableSource<OAuthTokenBean>>)
                            oAuthCodeBean -> Network.getApiService(context)
                                    .getOAuthToken("authorization_code", oAuthCodeBean.getCode(), Network.clientId, Network.clientSecret))
                    .doOnNext(oAuthTokenBean -> setOAuthToken(context, oAuthTokenBean.getAccess_token(), oAuthTokenBean.getToken_type(), oAuthTokenBean.getExpires_in(), oAuthTokenBean.getRefresh_token()))
                    ;
        } else {
            Log.e("TAG", "getToken: not expired");
            return new Observable<OAuthTokenBean>() {
                @Override
                protected void subscribeActual(Observer<? super OAuthTokenBean> observer) {
                    OAuthTokenBean oAuthTokenBean = new OAuthTokenBean();
                    User user = new User(context);
                    oAuthTokenBean.setAccess_token(user.getToken());
                    oAuthTokenBean.setToken_type(user.getTokenType());
                    observer.onNext(oAuthTokenBean);
                }
            };
        }
    }
}
