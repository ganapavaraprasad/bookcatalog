package com.book.catalog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookcatalogApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookcatalogApplication.class, args);
		System.out.println("Hello Bookcatlog");
	}

}
