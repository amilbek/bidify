package kz.bidify.dictionaryservice.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@RequiredArgsConstructor
@Service("userDetailsService")
public class UserDetailsServiceImpl {

    public UserDetails loadUserByUsername(final String userName, final String organization, final String ldapUniqueId) {
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        SecurityUser users = SecurityUser.builder()
                .username(userName)
                .email(organization)
                .userUuid(ldapUniqueId)
                .build();

        return buildUserForAuthentication(users, grantedAuthorities);
    }

    private User buildUserForAuthentication(final SecurityUser user, final Set<GrantedAuthority> authorities) {
        CurrentUser currentUser = new CurrentUser(user.getUsername(), UUID.randomUUID().toString(), authorities);
        currentUser.setUser(user);

        return currentUser;
    }
}
