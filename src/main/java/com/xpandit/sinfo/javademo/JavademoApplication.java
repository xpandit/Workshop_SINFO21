package com.xpandit.sinfo.javademo;

import java.util.HashMap;
import java.util.Map;

import com.xpandit.sinfo.javademo.JavademoApplication.Customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.Data;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;


@SpringBootApplication
public class JavademoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavademoApplication.class, args);
	}

	@RestController
	@RequestMapping(path = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
	public class SinfoController {
		
		private final Map<String, Customer> customers = new HashMap<>() {{
			put("1", new Customer("1", "João"));
			put("2", new Customer("2", "Maria"));
			put("3", new Customer("3", "Manuel"));
		}};

		@GetMapping(path ="/customers")
		public ResponseEntity<?> getCustomers() {
			return ResponseEntity.ok().body(customers.values());
		}
	}

	@Data
	@AllArgsConstructor
	public class Customer {
		String id;
		String name;
	}
		
}
