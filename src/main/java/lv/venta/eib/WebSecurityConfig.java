package lv.venta.eib;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	public static ArrayList<UserDetails> allUsers = new ArrayList<>();


	@Autowired
	UserDetailsService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
	auth.userDetailsService(userDetailsService);
	}
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.antMatchers("/favicon.ico", "/images/**", "/contacts", "/index", "/register", "/login").permitAll() //pie šiem diviem url adresēm(localhost:8080/ un localhots:8080/home -> tiks jebkurš no lietotājiem no jebkuras grupas)
		
		.antMatchers("/addComponent/**", "/editComponent/**", "/admin/**").access("hasAuthority('ADMIN')") //Ar ** norāda, ka visas url adreses, kas sāksies ar localhost:8080/admin/ būs pieejams tikai tiem lietotājiem, kuri ir ADMIN grupā

		.antMatchers("/categories", "/showComponents/**", "/component/**").access("hasAuthority('USER') or hasAuthority('ADMIN')")//Ar ** norāda, ka visas url adreses, kas sāksies ar localhost:8080/user/ būs pieejams tikai tiem lietotājiem, kuri ir USER grupā

		//.anyRequest().authenticated() //Te nosaka, ka vienmēr prasīs autentifikāciju

		.and()
		.formLogin()
			.loginPage("/login")//autentifikācijas skats, kas pašam nav jātaisa
			.defaultSuccessUrl("/index")
			.permitAll()//tam var piekļut jebkurš leitotājs
		.and()
		.logout()
			.permitAll();//jebkurš no lietotājiem varēs izlogoties
	}

	/*@Bean
	@Override
	public UserDetailsService userDetailsService() { //
		UserDetails user =
			 User.withDefaultPasswordEncoder()
				.username("user") //statiski izveidots lietotājs ar lietotājvārdu user
				.password("test")//minētajam lietotājam statiska parole password
				.roles("USER")//tas tiek piesaistīts USER lietotāju grupai
				.build();
		
		UserDetails user2 =
			 User.withDefaultPasswordEncoder()
				.username("emils") //statiski izveidots lietotājs ar lietotājvārdu admin
				.password("test")//minētajam lietotājam statiska parole password123
				.roles("ADMIN")//tas tiek piesaistīts ADMIN lietotāju grupai
				.build();
		
		//ArrayList<UserDetails> allUsers = new ArrayList<>();
		allUsers.add(user);
		allUsers.add(user2);

		return new InMemoryUserDetailsManager(allUsers);
	}*/
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	return new BCryptPasswordEncoder();
	}
}