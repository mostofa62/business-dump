package bd.com.maestro.businessdump.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import bd.com.maestro.businessdump.components.CustomSuccessHandler;
import bd.com.maestro.businessdump.services.UserDetailsServiceExtend;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	private UserDetailsServiceExtend userDetailsService;
	private CustomSuccessHandler customSuccessHandler;
	
	@Autowired
	public WebSecurityConfig(UserDetailsServiceExtend userDetailsService,
			CustomSuccessHandler customSuccessHandler) {
		this.userDetailsService = userDetailsService;
		this.customSuccessHandler = customSuccessHandler;
	}
	
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        // Setting Service to find User in the database.
        // And Setting PassswordEncoder
        auth.userDetailsService(userDetailsService);

    }
	
	
	@Bean
	GrantedAuthorityDefaults grantedAuthorityDefaults() {
	    return new GrantedAuthorityDefaults(""); // Remove the ROLE_ prefix
	}
	
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        
            .authorizeRequests()
                 .antMatchers("/login*").anonymous()
                 .antMatchers("/themefiles/**", "/js/**", "/node_modules/**", "/css/**").permitAll()
                 .antMatchers("/area/**","/product/**","/producttype/**").access("hasRole('ADMIN')")
                 .anyRequest().authenticated()
                 .and()                
             .formLogin()
                 .loginPage("/login")
                 .successHandler(customSuccessHandler)
                 //.defaultSuccessUrl("/")
                 .permitAll()
                 .and()
             .logout()
                 .permitAll().and().csrf().disable();
         
         
     }
                 
	
	
	@SuppressWarnings("deprecation")
    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }

}
