package org.community.core.oauth;

import org.community.core.dao.OauthDao;
import org.community.core.model.pojo.OauthClientDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.AuthorizationRequest;
import org.springframework.security.oauth2.provider.approval.TokenStoreUserApprovalHandler;

/**
 * Created by frodo on 2016/11/16.
 */
public class OauthUserApprovalHandler extends TokenStoreUserApprovalHandler {

    private OauthDao oauthDao;

    public OauthUserApprovalHandler() {
        // Do nothing
    }


    /**
     * 这儿扩展了默认的逻辑, 若 OauthClientDetails 中的 trusted 字段为true, 将会自动跳过 授权流程
     *
     * @param authorizationRequest AuthorizationRequest
     * @param userAuthentication   Authentication
     * @return True is approved
     */
    public boolean isApproved(AuthorizationRequest authorizationRequest, Authentication userAuthentication) {
        if (super.isApproved(authorizationRequest, userAuthentication)) {
            return true;
        }
        if (!userAuthentication.isAuthenticated()) {
            return false;
        }

        OauthClientDetails clientDetails = oauthDao.loadOauthClientDetails(authorizationRequest.getClientId());
        return clientDetails != null && clientDetails.getTrusted();

    }

    public void setOauthDao(OauthDao oauthDao) {
        this.oauthDao = oauthDao;
    }
}