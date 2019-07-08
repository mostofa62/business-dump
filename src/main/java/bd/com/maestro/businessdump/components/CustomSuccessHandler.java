package bd.com.maestro.businessdump.components;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import bd.com.maestro.businessdump.models.User;
import bd.com.maestro.businessdump.services.UserService;

@Component
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	@Autowired
	private UserService userService;
	
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	
	@Override
    protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)throws IOException {
		
		Object principal = authentication.getPrincipal();
		String targetUrl= "/";
		if (principal instanceof UserDetails) { 
			UserDetails details = (UserDetails)principal; 
			User user = userService.getUserByName(details.getUsername());
			
			if(user!=null ) {
				HttpSession session = request.getSession();
				session.setAttribute("userGlobal", user);
				/*
				if(user.getRole()!=null) {
					session.setAttribute("userRoleGlobal", user.getRole());
				}*/
			}
		}
		
		redirectStrategy.sendRedirect(request, response, targetUrl);
		
	}
	
}
