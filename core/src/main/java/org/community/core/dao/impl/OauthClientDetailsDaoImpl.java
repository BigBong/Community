package org.community.core.dao.impl;

import org.community.core.dao.OauthClientDetailsDao;
import org.community.core.model.mapper.OauthClientDetailsMapper;
import org.community.core.model.pojo.OauthClientDetails;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by frodoking on 2016/7/15.
 */
public class OauthClientDetailsDaoImpl extends SqlSessionDaoSupport implements OauthClientDetailsDao {

    @Autowired
    private OauthClientDetailsMapper oauthClientDetailsMapper;

    @Override
    public OauthClientDetails findOauthClientDetails(String clientId) {
        return null;
    }

    @Override
    public List<OauthClientDetails> findAllOauthClientDetails() {
        return null;
    }

    @Override
    public void updateOauthClientDetailsArchive(String clientId, boolean archive) {

    }

    @Override
    public void saveOauthClientDetails(OauthClientDetails clientDetails) {

    }
}
