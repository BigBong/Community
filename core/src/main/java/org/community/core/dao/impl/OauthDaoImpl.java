package org.community.core.dao.impl;

import org.community.core.dao.OauthDao;
import org.community.core.model.mapper.OauthClientDetailsMapper;
import org.community.core.model.pojo.OauthClientDetails;
import org.community.core.model.pojo.OauthClientDetailsExample;
import org.community.core.oauth.dto.OauthClientDetailsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by frodoking on 2016/11/16.
 */
@Repository("oauthDao")
public class OauthDaoImpl extends BaseDaoImpl<OauthClientDetails> implements OauthDao {

    @Autowired
    private OauthClientDetailsMapper oauthClientDetailsMapper;

    @Override
    public OauthClientDetails loadOauthClientDetails(String clientId) {
        OauthClientDetailsExample example = new OauthClientDetailsExample();
        OauthClientDetailsExample.Criteria criteria = example.createCriteria();
        criteria.andClientIdEqualTo(clientId);

        List<OauthClientDetails> oauthClientDetailses = oauthClientDetailsMapper.selectByExample(example);
        if (!oauthClientDetailses.isEmpty()) {
            return oauthClientDetailses.get(0);
        }
        return null;
    }

    @Override
    public List<OauthClientDetailsDto> loadAllOauthClientDetailsDtos() {
        OauthClientDetailsExample example = new OauthClientDetailsExample();
        List<OauthClientDetails> oauthClientDetailses = oauthClientDetailsMapper.selectByExample(example);
        return OauthClientDetailsDto.toDtos(oauthClientDetailses);
    }

    @Override
    public void archiveOauthClientDetails(String clientId) {
        OauthClientDetailsExample example = new OauthClientDetailsExample();
        OauthClientDetailsExample.Criteria criteria = example.createCriteria();
        criteria.andClientIdEqualTo(clientId);

        List<OauthClientDetails> oauthClientDetailses = oauthClientDetailsMapper.selectByExample(example);
        if (!oauthClientDetailses.isEmpty()) {
            return;
        }

        oauthClientDetailsMapper.updateByExample(oauthClientDetailses.get(0), example);
    }

    @Override
    public OauthClientDetailsDto loadOauthClientDetailsDto(String clientId) {
        OauthClientDetails oauthClientDetails = loadOauthClientDetails(clientId);
        return oauthClientDetails != null ? new OauthClientDetailsDto(oauthClientDetails) : null;
    }

    @Override
    public void registerClientDetails(OauthClientDetailsDto formDto) {
        oauthClientDetailsMapper.insert(formDto.createDomain());
    }
}
