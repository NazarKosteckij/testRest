package com.test.rest.services.security;

 
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.rest.contstants.users.UserRoles;
import com.test.rest.dao.UserDao;
import com.test.rest.models.UserModel;

@Service
@Transactional(readOnly = true)
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
	
	@Autowired
	private UserDao userDao;
 
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
			UserModel domainUser = userDao.getByEmail(username);
			
			boolean enabled = true;
			boolean accountNonExpired = true;
			boolean credentialsNonExpired = true;
			boolean accountNonLocked = true;
			
			return new User(
					domainUser.getEmail(), 
					domainUser.getPassword(),
					enabled,
					accountNonExpired,
					credentialsNonExpired,
					accountNonLocked,
					getAuthorities(domainUser.getRole()));
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public Collection<? extends GrantedAuthority> getAuthorities(String role) {
		List<GrantedAuthority> authList = getGrantedAuthorities(getRoles(role));
		return authList;
	}
	
	public List<String> getRoles(String role) {
		List<String> roles = new ArrayList<String>();
		
		if (role.equals(UserRoles.ROLE_ADMIN)) {
			roles.add("ROLE_ADMIN");
			roles.add("ROLE_USER");
			
		} else if (role.equals(UserRoles.ROLE_USER)) {
			roles.add("ROLE_USER");
			
		} else if (role.equals(UserRoles.ROLE_MODERATOR)) {
			roles.add("ROLE_MODERATOR");
		}
		
		return roles;
	}
	
	public static List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (String role : roles) {
			authorities.add(new SimpleGrantedAuthority(role));
		}
		return authorities;
	}
}