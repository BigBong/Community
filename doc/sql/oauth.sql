Drop table  if exists oauth_client_details;
create table oauth_client_details (
    client_id VARCHAR(256) PRIMARY KEY,
    client_secret VARCHAR(256),
    resource_ids VARCHAR(256),
    scope VARCHAR(256),
    authorized_grant_types VARCHAR(256),
    web_server_redirect_uri VARCHAR(256),
    authorities VARCHAR(256),
    access_token_validity INTEGER,
    refresh_token_validity INTEGER,
    additional_information VARCHAR(4096),
    autoapprove VARCHAR(256),
);

Drop table  if exists oauth_client_token;
create table oauth_client_token (
  token_id VARCHAR(256),
  token BLOB,
  authentication_id VARCHAR(256),
  user_name VARCHAR(256),
  client_id VARCHAR(256)
);

Drop table  if exists oauth_access_token;
create table oauth_access_token (
    token_id VARCHAR(256),
    token BLOB,
    authentication_id VARCHAR(256),
    user_name VARCHAR(256),
    client_id VARCHAR(256),
    authentication BLOB,
    refresh_token VARCHAR(256)
);

Drop table  if exists oauth_refresh_token;
create table oauth_refresh_token (
    token_id VARCHAR(256),
    token BLOB,
    authentication BLOB
);

Drop table  if exists oauth_code;
create table oauth_code (
  code VARCHAR(255),
  authentication BLOB
);


-- Add indexes
create index token_id_index on oauth_access_token (token_id);
create index authentication_id_index on oauth_access_token (authentication_id);
create index user_name_index on oauth_access_token (user_name);
create index client_id_index on oauth_access_token (client_id);
create index refresh_token_index on oauth_access_token (refresh_token);

create index token_id_index on oauth_refresh_token (token_id);

create index code_index on oauth_code (code);


