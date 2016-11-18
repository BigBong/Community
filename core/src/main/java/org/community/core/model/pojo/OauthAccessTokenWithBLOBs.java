package org.community.core.model.pojo;

public class OauthAccessTokenWithBLOBs extends OauthAccessToken {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oauth_access_token.token
     *
     * @mbggenerated
     */
    private byte[] token;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oauth_access_token.authentication
     *
     * @mbggenerated
     */
    private byte[] authentication;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oauth_access_token.token
     *
     * @return the value of oauth_access_token.token
     *
     * @mbggenerated
     */
    public byte[] getToken() {
        return token;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oauth_access_token.token
     *
     * @param token the value for oauth_access_token.token
     *
     * @mbggenerated
     */
    public void setToken(byte[] token) {
        this.token = token;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oauth_access_token.authentication
     *
     * @return the value of oauth_access_token.authentication
     *
     * @mbggenerated
     */
    public byte[] getAuthentication() {
        return authentication;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oauth_access_token.authentication
     *
     * @param authentication the value for oauth_access_token.authentication
     *
     * @mbggenerated
     */
    public void setAuthentication(byte[] authentication) {
        this.authentication = authentication;
    }
}