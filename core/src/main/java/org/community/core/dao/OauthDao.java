package org.community.core.dao;

import org.community.core.model.pojo.OauthClientDetails;
import org.community.core.oauth.dto.OauthClientDetailsDto;

import java.util.List;

/**
 * Created by frodo on 2016/11/16.
 */
public interface OauthDao {
    OauthClientDetails loadOauthClientDetails(String clientId);

    List<OauthClientDetailsDto> loadAllOauthClientDetailsDtos();

    void archiveOauthClientDetails(String clientId);

    OauthClientDetailsDto loadOauthClientDetailsDto(String clientId);

    void registerClientDetails(OauthClientDetailsDto formDto);
}
