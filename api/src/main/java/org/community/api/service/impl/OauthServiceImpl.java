package org.community.api.service.impl;

import org.community.api.model.OauthClientDetailsDto;
import org.community.api.service.OauthService;
import org.community.core.dao.OauthClientDetailsDao;
import org.community.core.model.pojo.OauthClientDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by frodo on 2016/7/15.
 */
@Service("oauthService")
public class OauthServiceImpl implements OauthService {

    @Autowired
    private OauthClientDetailsDao oauthClientDetailsDao;

    @Override
    public OauthClientDetails loadOauthClientDetails(String clientId) {
        return oauthClientDetailsDao.findOauthClientDetails(clientId);
    }

    @Override
    public List<OauthClientDetailsDto> loadAllOauthClientDetailsDtos() {
        List<OauthClientDetails> clientDetailses = oauthClientDetailsDao.findAllOauthClientDetails();
        return OauthClientDetailsDto.toDtos(clientDetailses);
    }

    @Override
    public void archiveOauthClientDetails(String clientId) {
        oauthClientDetailsDao.updateOauthClientDetailsArchive(clientId, true);
    }

    @Override
    public OauthClientDetailsDto loadOauthClientDetailsDto(String clientId) {
        final OauthClientDetails oauthClientDetails = oauthClientDetailsDao.findOauthClientDetails(clientId);
        return oauthClientDetails != null ? new OauthClientDetailsDto(oauthClientDetails) : null;
    }

    @Override
    public void registerClientDetails(OauthClientDetailsDto formDto) {
        OauthClientDetails clientDetails = formDto.createDomain();
        oauthClientDetailsDao.saveOauthClientDetails(clientDetails);
    }
}