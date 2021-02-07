package io.duke.demo.service;

import io.duke.demo.model.UserInfo;
import io.duke.demo.repos.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service(value="userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService{
    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) {
        Optional<UserInfo> user = userInfoRepository.findByUsername(username);
        if (user.isEmpty()) throw new UsernameNotFoundException(username);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        // TODO
//        for (Role role : user.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority("admin"));
//        }

        return new org.springframework.security.core.userdetails.User(user.get().getUsername(), user.get().getPassword(), grantedAuthorities);
    }
}
