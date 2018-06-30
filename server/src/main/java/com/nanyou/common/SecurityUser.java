package com.nanyou.common;

import com.nanyou.mybatis.pojo.User;

import lombok.*;

import org.springframework.beans.BeanUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;


@Getter
@ToString
public class SecurityUser extends User implements UserDetails {

    private final String username;
    private final boolean enabled;
    private final boolean accountNonExpired;
    private final boolean credentialsNonExpired;
    private final boolean accountNonLocked;

    public SecurityUser(User user) {
        if (user != null) {
            BeanUtils.copyProperties(user, this);
            setUserId(user.getUserId());
            username = user.getAccount();
            setName(user.getName());
            this.enabled = true;
            this.accountNonExpired = true;
            this.credentialsNonExpired = true;
            this.accountNonLocked = true;
        } else {
            throw new IllegalArgumentException("Cannot pass null or empty values to constructor");
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
}
