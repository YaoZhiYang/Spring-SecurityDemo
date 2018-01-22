package com.cisdi.security.securitydemo;

import org.apache.catalina.security.SecurityUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SecuritydemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecuritydemoApplication.class, args);
	}
}

@RestController
@RequestMapping("/api")
class DemoRestController {
	@GetMapping("/hello")
	@PreAuthorize("hasRole('ADMIN')")
	public String greeting() {
		return "Security"+ SecurityUtils.getCurrentUser();
	}

    @GetMapping("/public/api")
    public String publicAPI() {
        return "this is public API";
    }
}