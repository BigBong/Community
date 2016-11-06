package org.community.api.common;

import org.community.api.service.OauthClientDetailsService;
import org.community.core.model.pojo.OauthClientDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.AuthorizationRequest;
import org.springframework.security.oauth2.provider.approval.TokenStoreUserApprovalHandler;

public class OauthUserApprovalHandler extends TokenStoreUserApprovalHandler {

    private OauthClientDetailsService oauthClientDetailsService;

    @Override
    public boolean isApproved(AuthorizationRequest authorizationRequest, Authentication userAuthentication) {
        if (super.isApproved(authorizationRequest, userAuthentication)) {
            return true;
        }
        if (!userAuthentication.isAuthenticated()) {
            return false;
        }

        OauthClientDetails clientDetails = oauthClientDetailsService.loadOauthClientDetails(authorizationRequest.getClientId());
        return clientDetails != null && clientDetails.getTrusted();
    }

    public void setOauthClientDetailsService(OauthClientDetailsService oauthClientDetailsService) {
        this.oauthClientDetailsService = oauthClientDetailsService;
    }
}
