-- admin, password is admin  ( All privileges)
insert into user(uid,username,password,name,gender,birthday,avatar_url,email,phone,location,archived,created_at,update_at,last_login_at,description)
values
('29f6004fb1b0466f9572b02bf2ac1be8','admin_nickname','21232f297a57a5a743894a0e4a801fc3','admin',1,now(),'https://avatars0.githubusercontent.com/u/7484982?v=3&u=4e45871de440c2bd2302a5420358118d6a4950f7&s=140','admin@mail.com','028-1234567','beijing',1,now(),now(),now(),'admin description.');

-- unity, password is unity  ( ROLE_UNITY)
insert into user(id,uid,username,password,name,gender,birthday,avatar_url,email,phone,location,archived,created_at,update_at,last_login_at,description)
values
(22,'55b713df1c6f423e842ad68668523c49','unity_nickname','439b3a25b555b3bc8667a09a036ae70c','unity',1,now(),'https://avatars0.githubusercontent.com/u/7484982?v=3&u=4e45871de440c2bd2302a5420358118d6a4950f7&s=140','admin@mail.com','028-1234567','beijing',1,now(),now(),now(),'unity description.');

insert into user_privilege(user_id,privilege) values (22,'UNITY');

-- mobile, password is mobile  ( ROLE_MOBILE)
insert into user(id,uid,username,password,name,gender,birthday,avatar_url,email,phone,location,archived,created_at,update_at,last_login_at,description)
values
(23,'612025cb3f964a64a48bbdf77e53c2c1','mobile_nickname','532c28d5412dd75bf975fb951c740a30','mobile',1,now(),'https://avatars0.githubusercontent.com/u/7484982?v=3&u=4e45871de440c2bd2302a5420358118d6a4950f7&s=140','admin@mail.com','028-1234567','beijing',1,now(),now(),now(),'mobile description.');

insert into user_privilege(user_id,privilege) values (23,'MOBILE');

-- initial oauth client details test data
-- 'unity-client'   support browser, js(flash) visit
-- 'mobile-client'  only support mobile-device visit
truncate  oauth_client_details;
insert into oauth_client_details
(client_id, resource_ids, client_secret, scope, authorized_grant_types,
web_server_redirect_uri,authorities, access_token_validity,
refresh_token_validity, additional_information, create_time, archived, trusted)
values
('unity-client','unity-resource', 'unity', 'read,write','authorization_code,refresh_token,implicit',
null,'ROLE_CLIENT',null,
null,null, now(), 0, 0),
('mobile-client','mobile-resource', 'mobile', 'read,write','password,refresh_token',
null,'ROLE_CLIENT',null,
null,null, now(), 0, 0);