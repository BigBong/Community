package org.community.api.common;

import org.community.core.model.pojo.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by frodo on 2016/7/16.
 */
public class OauthUserDetails implements UserDetails {

    private static final GrantedAuthority DEFAULT_USER_ROLE = new SimpleGrantedAuthority("ROLE_USER");

    private User user;

    private List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();

    public OauthUserDetails(User user, String privileges) {
        this.user = user;
        initialAuthorities(privileges);
    }

    private void initialAuthorities(String privileges) {
        //Default, everyone have it
        this.grantedAuthorities.add(DEFAULT_USER_ROLE);
        if (privileges != null && !privileges.isEmpty()) {
            if (privileges.contains(",")) {
                String[] array = privileges.split(",");
                for (String privilege : array) {
                    this.grantedAuthorities.add(new SimpleGrantedAuthority(privilege));
                }
            } else {
                this.grantedAuthorities.add(new SimpleGrantedAuthority(privileges));
            }
        }
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return this.grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return user.getArchived();
    }

    @Override
    public boolean isAccountNonLocked() {
        return user.getArchived();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return user.getArchived();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("{user=").append(user);
        sb.append('}');
        return sb.toString();
    }
}

