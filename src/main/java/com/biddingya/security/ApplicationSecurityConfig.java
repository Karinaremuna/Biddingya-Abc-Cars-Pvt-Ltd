package com.biddingya.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
    private PasswordEncoder passwordencoder;
    @Autowired
    UserDetailsService userservice;
	@Autowired
	UserDetailsService userdetail;
    @Autowired
    ApplicationSecurityConfig (PasswordEncoder encoder){
    	this.passwordencoder=encoder;
    }
    @Autowired
    RolesHandler roles;
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.antMatchers("/",
				"home",
				"/register",
				"registration",
				"/myreg",
				"Thankyou",
				"/login",
				"login",
				"/thankyou",
				"thankyou",
				"/emailvalidation",
				"EmailConfirmation",
				"/verifcode",
				"ForgetPasswordCode",
				"/verifemail",
				"ForgetPasswordEmail",
				"/forgotpassword",
				"ForgotPassword",
				"/about",
				"About",
				"/contact",
				"Contact",
				"My-Header",
				"My-Footer",
				"/login_error",
				"/css/**",
				"/img/**",
				"/fonts/**",
				"/js/**",
				"/lib/**",
				"/scss/**",
				"/vendor/**").permitAll()
		.antMatchers("/admin", 
				"/updateUser/**", 
				"/deleteUser/**",
				"/deleteCar/**",
				"/updateCar/**",
				"/bulkemail",
				"/sendbulkemail",
				"/resultBulkEmail",
				"/viewcarresultadmin",
				"/ppadmin",
				"/updateProfile-admin/updateprofile-admin",
				"/updateUser/update",
				"/search-admin",
				"/searchusadmin",
				"/viewcaradmin",
				"/searchcar-admin",
				"/searchcaradmin",
				"/viewcarresultadmin",
				"/viewcaradmin",
				"Header-In-Admin",
				"Footer-In-Admin").hasAnyAuthority("ADMIN")
		.antMatchers("/user",
				"/updateProfile/updateprofile",
				"/search",
				"/postcar",
				"/searchus",
				"/viewcar",
				"/searchcar",
				"/searchcars",
				"/postcar",
				"/viewcar",
				"/carbidding",
				"/viewcarbidding",
				"/viewcarresult",
				"My-Header-In",
				"My-Footer-In").hasAnyAuthority("USER")
		.anyRequest()
		.authenticated()
		.and()
		.formLogin()
		.loginPage("/login")
		.permitAll()
		.usernameParameter("username")
		.passwordParameter("password")
		.successHandler(roles)
		.failureUrl("/login_error")
		.and()
		.exceptionHandling()
		.accessDeniedPage("/AccessDenied")
		.and()
		.logout()
		.logoutUrl("/logout")
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.clearAuthentication(true)
		.invalidateHttpSession(true);
		
	}
	@Autowired
	AuthenticationProvider authProvider() {
		DaoAuthenticationProvider  dao=new DaoAuthenticationProvider();
		dao.setPasswordEncoder(passwordencoder);
		dao.setUserDetailsService(userservice);
		
		return dao;
	}

}

