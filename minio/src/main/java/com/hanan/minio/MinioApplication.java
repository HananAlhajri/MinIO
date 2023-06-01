package com.hanan.minio;

import com.hanan.minio.components.MinIOComponent;
import io.minio.errors.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@SpringBootApplication
public class MinioApplication {

	public static void main(String[] args) throws ServerException, InvalidBucketNameException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {

		ApplicationContext applicationContext = SpringApplication.run(MinioApplication.class, args);
		String filename = "test.txt";
		MinIOComponent minIOComponent = applicationContext.getBean(MinIOComponent.class);
		minIOComponent.readWriteMinIO(filename);

		System.out.println("Done! ");
	}

}


