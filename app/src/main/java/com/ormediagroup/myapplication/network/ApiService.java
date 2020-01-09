package com.ormediagroup.myapplication.network;


import com.ormediagroup.myapplication.bean.OAuthCodeBean;
import com.ormediagroup.myapplication.bean.OAuthTokenBean;
import com.ormediagroup.myapplication.bean.PropertyBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Lau on 2020-01-07.
 */
public interface ApiService {

    @GET("oauth/authorize")
    Observable<OAuthCodeBean> getOAuthCode(
            @Query("response_type") String response_type,
            @Query("client_id") String client_id
    );

    @FormUrlEncoded
    @POST("oauth/token")
    Observable<OAuthTokenBean> getOAuthToken(
            @Field("grant_type") String grant_type,
            @Field("code") String code,
            @Field("client_id") String client_id,
            @Field("client_secret") String client_secret
    );

    @FormUrlEncoded
    @POST("api/data")
    Observable<PropertyBean> getProperty(
            @Field("action") String action,
            @Field("admin_wp_id") int uid
    );

}
