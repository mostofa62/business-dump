package bd.com.maestro.businessdump.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import bd.com.maestro.businessdump.models.User;
@Service
public class UserDetailsServiceExtend implements UserDetailsService {

	@Autowired
	private UserService userService;
	
	@Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = userService.getUserByName(userName);
		
		if(user == null) {
			throw new UsernameNotFoundException("User " + userName + " was not found in the database");
		}
		System.out.println(user.getPassword());
		String roleNames = user.getRole().getName();
		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		
		if (roleNames != null) {
			GrantedAuthority authority = new SimpleGrantedAuthority(roleNames);
            grantList.add(authority);
		}
		
		UserDetails userDetails = (UserDetails) new org.springframework.security.core.userdetails.User(user.getUserName(),user.getPassword(), grantList);
		
		return userDetails;
	}
	
}
