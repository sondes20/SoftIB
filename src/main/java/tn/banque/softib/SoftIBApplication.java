package tn.banque.softib;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class SoftIBApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoftIBApplication.class, args);
		
	}

}
