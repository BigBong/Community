package org.community.core.model.pojo;

import java.util.Date;

public class OauthCode {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oauth_code.create_time
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oauth_code.code
     *
     * @mbggenerated
     */
    private String code;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column oauth_code.authentication
     *
     * @mbggenerated
     */
    private byte[] authentication;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oauth_code.create_time
     *
     * @return the value of oauth_code.create_time
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oauth_code.create_time
     *
     * @param createTime the value for oauth_code.create_time
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oauth_code.code
     *
     * @return the value of oauth_code.code
     *
     * @mbggenerated
     */
    public String getCode() {
        return code;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oauth_code.code
     *
     * @param code the value for oauth_code.code
     *
     * @mbggenerated
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column oauth_code.authentication
     *
     * @return the value of oauth_code.authentication
     *
     * @mbggenerated
     */
    public byte[] getAuthentication() {
        return authentication;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column oauth_code.authentication
     *
     * @param authentication the value for oauth_code.authentication
     *
     * @mbggenerated
     */
    public void setAuthentication(byte[] authentication) {
        this.authentication = authentication;
    }
}