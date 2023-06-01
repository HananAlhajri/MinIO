package com.hanan.minio.components;

import com.hanan.minio.services.MinIOService;
import io.minio.errors.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Component
public class MinIOComponent {
    @Autowired
    private MinIOService minIOService;

    public void readWriteMinIO(String filename) throws IOException, NoSuchAlgorithmException, InvalidKeyException, ServerException, InvalidBucketNameException, InsufficientDataException, ErrorResponseException, InvalidResponseException, XmlParserException, InternalException {
        minIOService.writeToMinIO(filename);
        minIOService.readFromMinIO(filename);
        System.out.println("MinIODemo");

    }
}
