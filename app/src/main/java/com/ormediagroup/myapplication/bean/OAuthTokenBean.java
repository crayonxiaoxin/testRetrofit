package com.ormediagroup.myapplication.bean;

/**
 * Created by Lau on 2020-01-07.
 */
public class OAuthTokenBean {

    /**
     * access_token : ue7zc75ezjppgiixuq3ylsjmnliflzl0nsqtwbml
     * expires_in : 3600
     * token_type : Bearer
     * scope : basic
     * refresh_token : 6mkjrfgq8apgxgowzndnp4i1k9chefq4mt0if8tk
     */

    private String access_token;
    private int expires_in;
    private String token_type;
    private String scope;
    private String refresh_token;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    @Override
    public String toString() {
        return "OAuthTokenBean{" +
                "access_token='" + access_token + '\'' +
                ", expires_in=" + expires_in +
                ", token_type='" + token_type + '\'' +
                ", scope='" + scope + '\'' +
                ", refresh_token='" + refresh_token + '\'' +
                '}';
    }
}