package com.libreria;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
     
@Configuration//esto se hace en especifico en spring security como el extends webSecurity...
public class SecurityAdapter extends WebSecurityConfigurerAdapter{
	
	
	@Bean//La línea @Bean es para crear un objeto que puede ser utilizado en otros lugares de la aplicación. En este caso, se está 
	//creando un objeto de tipo BCryptPasswordEncoder que se utiliza para encriptar contraseñas.
	public static BCryptPasswordEncoder passwordEncoder() {
	
		return new BCryptPasswordEncoder();
	}
	
	
	@Override//este override, lo hemos implmentado nosotros para que no te pida el poner el usuario en cuanto entras a la pagina
	//para que asi un usuario normal puede acceder a ver la informacion y no este todo en privado
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
	    .antMatchers("/","/resources/**","/registro/**","/static/**" ,"/mapa/**","/lectura/**", "/eventos/**",
	    		"/events/**","/libros/{id}/comprar","/libros/{id}/devolver","/libreria").permitAll()
	    .antMatchers("/libros/{id}/editar/**").hasAnyRole("ADMIN")
	    .antMatchers("/libros/{id}/eliminar/**").hasAnyRole("ADMIN")
	    .antMatchers("/libros/nuevo/**").hasAnyRole("ADMIN")
	    .and()
	        .formLogin().loginPage("/login")
	        .permitAll()
	    .and()
	        .logout().permitAll()
	    .and()
	        .authorizeRequests().anyRequest().authenticated();
		
		
	}


	@Autowired//inyectamos una interfaz que ya te da springboot
	public void configurerGlobal(AuthenticationManagerBuilder builder) throws Exception{
		
		PasswordEncoder encoder= passwordEncoder();// PasswordEncoder funcion con ese nombre dada ya por Spring
		////UserBuilder que permite crear usuarios con contraseñas encriptadas usando el objeto BCryptPasswordEncoder	
		UserBuilder users = User.builder().passwordEncoder(encoder::encode);
		
		builder.inMemoryAuthentication()//Este es el ususario y contraseña literal, para el usuario admin, aqui esta sin ecriptar
		.withUser(users.username("Jose").password("Oceania18.@").roles("ADMIN","USER")).//voy a tener 2 roles
		 withUser(users.username("andres").password("12345").roles("USER"));
		
		
		}
		
	}
