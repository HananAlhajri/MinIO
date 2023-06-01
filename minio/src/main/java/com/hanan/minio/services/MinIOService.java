package com.hanan.minio.services;


import io.minio.*;
import io.minio.errors.*;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Service
public class MinIOService {

    final static String endPoint = "http://127.0.0.1:9000";
    final static String accessKey = "your_access_key";
    final static String secretKey = "your_secret_key";
    final static String bucketName = "your_bucket_name";
    final static String localFileFolder = "path";

    public void writeToMinIO(String filename) throws IOException, NoSuchAlgorithmException, InvalidKeyException {
        try {
            MinioClient minioClient = MinioClient.builder()
                    .endpoint(endPoint)
                    .credentials(accessKey, secretKey).build();

            boolean bucketExists = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
            if(!bucketExists){
                minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
                System.out.println("Created Bucket: " + bucketName);
            }

            String uploadFile = localFileFolder + filename;
            UploadObjectArgs args = UploadObjectArgs.builder()
                    .bucket(bucketName)
                    .object(filename)
                    .filename(uploadFile).build();
            minioClient.uploadObject(args);
            System.out.println(uploadFile + "successfully uploaded to: \n container: "+ bucketName +" \n blob: " + filename + "\n");


        }catch (MinioException e){
            System.out.println("Error occurred: "+ e);
        }

    }

    public void readFromMinIO(String filename) throws ServerException, InvalidBucketNameException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        try {
            MinioClient minioClient = MinioClient.builder().endpoint(endPoint).credentials(accessKey, secretKey).build();
            String downloadFile = localFileFolder + "D_" + filename;
            DownloadObjectArgs args = DownloadObjectArgs.builder().bucket(bucketName).object(filename).filename(downloadFile).build();
            minioClient.downloadObject(args);
        }catch(MinioException e){
            System.out.println("Error occurred: "+ e);
        }

    }
}
