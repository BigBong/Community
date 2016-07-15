package org.community.api.service;

import org.community.api.model.OauthClientDetailsDto;
import org.community.core.model.pojo.OauthClientDetails;

import java.util.List;

/**
 * Created by frodo on 2016/7/15.
 */
public interface OauthService {

    OauthClientDetails loadOauthClientDetails(String clientId);

    List<OauthClientDetailsDto> loadAllOauthClientDetailsDtos();

    void archiveOauthClientDetails(String clientId);

    OauthClientDetailsDto loadOauthClientDetailsDto(String clientId);

    void registerClientDetails(OauthClientDetailsDto formDto);
}
