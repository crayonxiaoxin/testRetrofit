package com.ormediagroup.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.ormediagroup.myapplication.bean.OAuthCodeBean;
import com.ormediagroup.myapplication.bean.OAuthTokenBean;
import com.ormediagroup.myapplication.bean.PropertyBean;
import com.ormediagroup.myapplication.network.BaseObserver;
import com.ormediagroup.myapplication.network.Network;
import com.ormediagroup.myapplication.utils.User;

import java.lang.reflect.InvocationTargetException;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "TAG";
    @BindView(R.id.text)
    TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
//        orginalRequest();

//        testGetToken();
        test();
//        testGetProperty();
        testReflection();
    }

    private void testGetToken() {
        Network.getApiService(MainActivity.this)
                .getOAuthCode("code", Network.clientId)
                .flatMap((Function<OAuthCodeBean, ObservableSource<OAuthTokenBean>>)
                        oAuthCodeBean -> Network.getApiService(MainActivity.this)
                                .getOAuthToken("authorization_code", oAuthCodeBean.getCode(), Network.clientId, Network.clientSecret))
                .compose(Network.applySchedulers())
                .subscribe(new BaseObserver<OAuthTokenBean>() {

                    @Override
                    public void onSuccess(OAuthTokenBean oAuthTokenBean) {
                        Log.i(TAG, "onSuccess: " + oAuthTokenBean.toString());
                        new User(MainActivity.this).setToken(oAuthTokenBean.getToken_type() + " " + oAuthTokenBean.getAccess_token());
                    }

                    @Override
                    public void onFailed(Throwable e) {

                    }
                });
    }

    private void testGetProperty() {
        Network.getApiService(MainActivity.this)
                .getProperty("r_property", 6)
                .compose(Network.applySchedulers())
                .subscribe(new BaseObserver<PropertyBean>() {
                    @Override
                    public void onSuccess(PropertyBean propertyBean) {
                        Log.i(TAG, "onSuccess: " + propertyBean.toString());
                    }

                    @Override
                    public void onFailed(Throwable e) {
                        Log.e(TAG, "onFailed: " + e);
                    }
                });
    }


    private void test() {
        Network.getToken(MainActivity.this)
                .flatMap((Function<OAuthTokenBean, ObservableSource<PropertyBean>>)
                        oAuthTokenBean -> Network.getApiService(MainActivity.this).getProperty("r_property", 6))
                .compose(Network.applySchedulers())
                .subscribe(new BaseObserver<PropertyBean>() {
                    @Override
                    public void onSuccess(PropertyBean propertyBean) {
                        Log.e(TAG, "onSuccess: " + propertyBean.toString());
                        text.setText(propertyBean.getList().get(2).getDmc_file().get(0).toString());
                    }

                    @Override
                    public void onFailed(Throwable e) {
                        Log.e(TAG, "onFailed: " + e.toString());
                    }
                });
    }

    public String showToast(String str) {
        Log.e(TAG, "showToast: ");
        return str + " success";
//        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

    private void testReflection() {
        try {
            Class<?> a = Class.forName("com.ormediagroup.myapplication.MainActivity");
            String b = (String) a.getMethod("showToast", String.class).invoke(a.newInstance(), "test");
            Log.e("TAG", "testReflection: " + b);
        } catch (ClassNotFoundException | IllegalAccessException | InvocationTargetException | NoSuchMethodException | InstantiationException e) {
            e.printStackTrace();
        }
    }
}
