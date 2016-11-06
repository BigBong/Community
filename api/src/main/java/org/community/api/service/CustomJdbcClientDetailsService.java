package org.community.api.service;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * Created by frodo on 2016/7/15.
 */
public class CustomJdbcClientDetailsService extends JdbcClientDetailsService {
    private static final Logger LOG = LoggerFactory.getLogger(CustomJdbcClientDetailsService.class);

    private static final String SELECT_CLIENT_DETAILS_SQL = "select client_id, client_secret, resource_ids, scope, authorized_grant_types, " +
            "web_server_redirect_uri, authorities, access_token_validity, refresh_token_validity, additional_information, autoapprove " +
            "from oauth_client_details where client_id = ? and archived = 0 ";

    public CustomJdbcClientDetailsService(DataSource dataSource) {
        super(dataSource);
        setSelectClientDetailsSql(SELECT_CLIENT_DETAILS_SQL);
    }

    @Override
    public ClientDetails loadClientByClientId(String clientId) {
        ClientDetails clientDetails = super.loadClientByClientId(clientId);

        if (clientDetails != null) {
            ObjectMapper mapper = new ObjectMapper();
            try {
                LOG.info("ClientDetails >> " + mapper.writeValueAsString(clientDetails));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            LOG.error("ClientDetails >> error");
        }
        return clientDetails;
    }
}
