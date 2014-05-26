package com.anucana.web.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.anuacana.web.beans.AnucanaAccessAuthority;
import com.anuacana.web.beans.AnucanaUser;
import com.anuacana.web.beans.UserRole;

public class AuthenticationService implements UserDetailsService {

	private static Map<String,AnucanaUser> users = new HashMap<String,AnucanaUser>();
	
	static{
		GrantedAuthority generalUser = new AnucanaAccessAuthority(new UserRole(1l, "ur_gu", "general User"));
		GrantedAuthority communityMember = new AnucanaAccessAuthority(new UserRole(1l, "ur_cm", "community member"));
		GrantedAuthority communityModerator = new AnucanaAccessAuthority(new UserRole(1l, "ur_cmo", "communit moderator"));
		GrantedAuthority admin = new AnucanaAccessAuthority(new UserRole(1l, "ur_a", "admin User"));
		
		List<GrantedAuthority> guAuthorities = new ArrayList<GrantedAuthority>();
		guAuthorities.add(generalUser);

		List<GrantedAuthority> cmAuthorities = new ArrayList<GrantedAuthority>();
		cmAuthorities.add(generalUser);
		cmAuthorities.add(communityMember);
		
		List<GrantedAuthority> cmoAuthorities = new ArrayList<GrantedAuthority>();
		cmoAuthorities.add(generalUser);
		cmoAuthorities.add(communityMember);
		cmoAuthorities.add(communityModerator);

		List<GrantedAuthority> adminAuthorities = new ArrayList<GrantedAuthority>();
		adminAuthorities.add(generalUser);
		adminAuthorities.add(communityMember);
		adminAuthorities.add(communityModerator);
		adminAuthorities.add(admin);
		
		users.put("arvind01",new AnucanaUser(1,"Arvind","Srivatsava","arvind01", "arvind01", true, true, true, true, guAuthorities)) ;
		users.put("arvind011",new AnucanaUser(2,"Arvind","Srivatsava","arvind011", "arvind011", false, true, true, true, guAuthorities)) ;
		users.put("arvind012",new AnucanaUser(3,"Arvind","Srivatsava","arvind012", "arvind012", true, false, true, true, guAuthorities)) ;
		users.put("arvind013",new AnucanaUser(4,"Arvind","Srivatsava","arvind013", "arvind013", true, true, false, true, guAuthorities)) ;
		users.put("arvind014",new AnucanaUser(5,"Arvind","Srivatsava","arvind014", "arvind014", true, true, true, false, guAuthorities)) ;
		
		users.put("arvind02",new AnucanaUser(6,"Arvind","Srivatsava","arvind02", "arvind02", true, true, true, true, cmAuthorities)) ;
		users.put("arvind03",new AnucanaUser(7,"Arvind","Srivatsava","arvind03", "arvind03", true, true, true, true, cmoAuthorities)) ;
		users.put("arvind04",new AnucanaUser(8,"Arvind","Srivatsava","arvind04", "arvind04", true, true, true, true, adminAuthorities)) ;
		
	}
	
	@Override
	public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException, DataAccessException {
		UserDetails user = users.get(username);
		if(user == null){
			throw new UsernameNotFoundException(username + " could not be found in this dummy service");
		}
		return user;
	}

}
