package com.end.beck.desafio.imedback;


// import java.util.HashMap;
// import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class ImedbackApplication {

	public static void main(String[] args) {
		SpringApplication.run(ImedbackApplication.class, args);

		// Map<String, PasswordEncoder> encoders = new HashMap<>();
        // encoders.put("pbkdf2", new Pbkdf2PasswordEncoder());
        // DelegatingPasswordEncoder passwordEncoder = new DelegatingPasswordEncoder("pbkdf2", encoders);
        // passwordEncoder.setDefaultPasswordEncoderForMatches(new Pbkdf2PasswordEncoder());
        
        // String result = passwordEncoder.encode("admin234");
        // System.out.println("My hash " + result);
	}

	 
       
        

}
