package org.community.core.model.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.community.core.model.pojo.OauthClientDetails;
import org.community.core.model.pojo.OauthClientDetailsExample;

public interface OauthClientDetailsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oauth_client_details
     *
     * @mbggenerated
     */
    int countByExample(OauthClientDetailsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oauth_client_details
     *
     * @mbggenerated
     */
    int deleteByExample(OauthClientDetailsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oauth_client_details
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String clientId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oauth_client_details
     *
     * @mbggenerated
     */
    int insert(OauthClientDetails record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oauth_client_details
     *
     * @mbggenerated
     */
    int insertSelective(OauthClientDetails record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oauth_client_details
     *
     * @mbggenerated
     */
    List<OauthClientDetails> selectByExampleWithBLOBs(OauthClientDetailsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oauth_client_details
     *
     * @mbggenerated
     */
    List<OauthClientDetails> selectByExample(OauthClientDetailsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oauth_client_details
     *
     * @mbggenerated
     */
    OauthClientDetails selectByPrimaryKey(String clientId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oauth_client_details
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") OauthClientDetails record, @Param("example") OauthClientDetailsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oauth_client_details
     *
     * @mbggenerated
     */
    int updateByExampleWithBLOBs(@Param("record") OauthClientDetails record, @Param("example") OauthClientDetailsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oauth_client_details
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") OauthClientDetails record, @Param("example") OauthClientDetailsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oauth_client_details
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(OauthClientDetails record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oauth_client_details
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(OauthClientDetails record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table oauth_client_details
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(OauthClientDetails record);
}