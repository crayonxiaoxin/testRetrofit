package com.ormediagroup.myapplication.network;

import android.content.Context;

import com.ormediagroup.myapplication.utils.User;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Lau on 2020-01-07.
 */
public class RequestInterceptor implements Interceptor {
    private Context context;

    public RequestInterceptor(Context context) {
        this.context = context;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Request.Builder builder = request.newBuilder();
        if (context != null) {
            User user = new User(context);
            if (user.getToken() != null && user.getTokenType() != null) {
                builder.addHeader("Authorization", user.getTokenType() + " " + user.getToken());
            }
        }
        return chain.proceed(builder.build());
    }
}
