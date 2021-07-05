package com.book.catalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookcatalogServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookcatalogServiceApplication.class, args);
		System.out.println("Hello Bookcatlog");
	}

}
