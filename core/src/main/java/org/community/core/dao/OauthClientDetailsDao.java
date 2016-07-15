package org.community.core.dao;

import org.community.core.model.pojo.OauthClientDetails;

import java.util.List;

/**
 * Created by frodo on 2016/7/15.
 */
public interface OauthClientDetailsDao {
    OauthClientDetails findOauthClientDetails(String clientId);

    List<OauthClientDetails> findAllOauthClientDetails();

    void updateOauthClientDetailsArchive(String clientId, boolean archive);

    void saveOauthClientDetails(OauthClientDetails clientDetails);
}
