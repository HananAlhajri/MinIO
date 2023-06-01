package com.hanan.minio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MinioApplication {

	public static void main(String[] args) {

		ApplicationContext applicationContext = SpringApplication.run(MinioApplication.class, args);
	}

}


