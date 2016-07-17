package org.community.core.dao.impl;

import org.community.core.dao.OauthClientDetailsDao;
import org.community.core.model.mapper.OauthClientDetailsMapper;
import org.community.core.model.pojo.OauthClientDetails;
import org.community.core.model.pojo.OauthClientDetailsExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by frodoking on 2016/7/15.
 */
@Repository("oauthClientDetailsDao")
public class OauthClientDetailsDaoImpl extends BaseDaoImpl<OauthClientDetails> implements OauthClientDetailsDao {

    @Autowired
    private OauthClientDetailsMapper oauthClientDetailsMapper;

    @Override
    public OauthClientDetails findOauthClientDetails(String clientId) {
        OauthClientDetailsExample example = new OauthClientDetailsExample();
        OauthClientDetailsExample.Criteria criteria = example.createCriteria();
        criteria.andClientIdEqualTo(clientId);

        List<OauthClientDetails> list = oauthClientDetailsMapper.selectByExample(example);
        if (!list.isEmpty()) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public List<OauthClientDetails> findAllOauthClientDetails() {
        OauthClientDetailsExample example = new OauthClientDetailsExample();
        return oauthClientDetailsMapper.selectByExample(example);
    }

    @Override
    public void updateOauthClientDetailsArchive(String clientId, boolean archive) {
        OauthClientDetailsExample example = new OauthClientDetailsExample();
        OauthClientDetailsExample.Criteria criteria = example.createCriteria();
        criteria.andClientIdEqualTo(clientId);
        criteria.andArchivedEqualTo(archive);
//        oauthClientDetailsMapper.updateByExample(example);
    }

    @Override
    public void saveOauthClientDetails(OauthClientDetails clientDetails) {
        oauthClientDetailsMapper.insert(clientDetails);
    }
}
