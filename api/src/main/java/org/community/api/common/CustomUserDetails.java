package org.community.api.common;

import org.community.core.common.Privilege;
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
public class CustomUserDetails implements UserDetails {

    private static final String ROLE_PREFIX = "ROLE_";
    private static final GrantedAuthority DEFAULT_USER_ROLE = new SimpleGrantedAuthority(ROLE_PREFIX + Privilege.USER.name());

    private User user;

    private List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

    public CustomUserDetails(User user, List<Privilege> privileges) {
        this.user = user;
        initialAuthorities(privileges);
    }

    private void initialAuthorities(List<Privilege> privileges) {
        //Default, everyone have it
        this.grantedAuthorities.add(DEFAULT_USER_ROLE);
        for (Privilege privilege : privileges) {
            this.grantedAuthorities.add(new SimpleGrantedAuthority(ROLE_PREFIX + privilege.name()));
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
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public User user() {
        return user;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("{user=").append(user);
        sb.append('}');
        return sb.toString();
    }
}

