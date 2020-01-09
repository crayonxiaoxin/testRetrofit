package com.ormediagroup.myapplication.utils;

import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Lau on 2019/2/15.
 */

public class User {
    private Context context;
    private SharedPreferences sp;

    public User(Context context) {
        this.context = context;
        initsp();
    }

    private void put(String key, String val) {
        this.sp.edit().putString(key, val).apply();
    }

    private void put(String key, long val) {
        this.sp.edit().putLong(key, val).apply();
    }

    private void put(String key, boolean val) {
        this.sp.edit().putBoolean(key, val).apply();
    }

    private String getString(String key) {
        return this.sp.getString(key, "");
    }

    private long getLong(String key) {
        return this.sp.getLong(key, 0);
    }

    private boolean getBoolean(String key, boolean defaultVal) {
        return this.sp.getBoolean(key, defaultVal);
    }

    private void initsp() {
        sp = context.getSharedPreferences("user_info", MODE_PRIVATE);
    }

    public SharedPreferences getsp() {
        return this.sp;
    }

    public String getUserId() {
        return getString("user_id");
    }

    public String getUserType() {
        return getString("user_type");
    }

    public String getUserInfo() {
        return getString("user_info");
    }

    public boolean isRemember() {
        return getBoolean("user_remember", false);
    }

    public boolean isUserLoggedIn() {
        return !getUserId().equals("");
    }

    public User setUserId(String userId) {
        put("user_id", userId);
        return this;
    }

    public User setUserType(String userType) {
        put("user_type", userType);
        return this;
    }

    public User setUserInfo(String userInfo) {
        put("user_info", userInfo);
        return this;
    }

    public User setUserRemember(boolean isRemember) {
        put("user_remember", isRemember);
        return this;
    }

    public User setUserName(String userName) {
        put("user_name", userName);
        return this;
    }

    public String getUserName() {
        return getString("user_name");
    }

    public void logout() {
        this.sp.edit().clear().apply();
    }

    public User setToken(String token) {
        put("token", token);
        return this;
    }

    public String getToken() {
        return getString("token");
    }

    public User setTokenType(String type) {
        put("token_type", type);
        return this;
    }

    public String getTokenType() {
        return getString("token_type");
    }

    public User setTokenDue(long due) {
        put("token_due", due);
        return this;
    }

    public long getTokenDue() {
        return getLong("token_due");
    }

    public User setRefreshToken(String refreshToken) {
        put("refresh_token", refreshToken);
        return this;
    }

    public String getRefreshToken() {
        return getString("refresh_token");
    }

    public User setUserToken(String userToken) {
        put("user_token", userToken);
        return this;
    }

    public String getUserToken() {
        return getString("user_token");
    }
}
