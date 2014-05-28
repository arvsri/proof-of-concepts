package com.anucana.service.images;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.Date;

import org.jets3t.service.S3ServiceException;
import org.jets3t.service.ServiceException;
import org.jets3t.service.impl.rest.httpclient.RestS3Service;
import org.jets3t.service.model.S3Bucket;
import org.jets3t.service.model.S3Object;
import org.jets3t.service.security.AWSCredentials;


public class AWSS3Service {

	private static String username = "AKIAIMDJLM32LQYM4ELQ";
	
	private static String password = "L8skQQevYcMhcBHeoRmOQxMBsOzNvZkMMMfcWO8a";
	
	
	
	public static void main(String[] args) {
		//readFromS3();
		//writeToS3();
		readTimedURL();
		//reWriteToS3();
	}


	private static void reWriteToS3()  {
		AWSCredentials cred = new AWSCredentials(username, password);
		RestS3Service service = new RestS3Service(cred);
		S3Bucket[] buckets;
		try {
			buckets = service.listAllBuckets();
			S3Object s3Obj = new S3Object(new File("img1.jpg"));
			s3Obj.setContentType("image/jpeg");
			s3Obj.setKey("profiles/img1.jpg");

			service.putObject(buckets[0], s3Obj);

		} catch (S3ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	private static void readTimedURL() {
		AWSCredentials cred = new AWSCredentials(username, password);
		RestS3Service service = new RestS3Service(cred);
		try {
			S3Bucket[] buckets = service.listAllBuckets();
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.MINUTE, 1);
			Date expiryDate = cal.getTime();
			System.out.println("Url valid for one minute : " + service.createSignedGetUrl(buckets[0].getName(), "profiles/img1.jpg", expiryDate));
			
		} catch (S3ServiceException e) {
			e.printStackTrace();
		}
	}


	private static void readFromS3() {
		AWSCredentials cred = new AWSCredentials(username, password);
		RestS3Service service = new RestS3Service(cred);
		InputStream is = null;
		FileOutputStream fos = null;
		try {
			S3Bucket[] buckets = service.listAllBuckets();
			System.out.println("Number of buckets : " + buckets.length);
			
			for(S3Bucket bucket : buckets){
				System.out.println(bucket);
				
				S3Object obj = service.getObject(bucket.getName(), "profiles/narayana_murthy.jpg");
				System.out.println(obj);
				
				is = obj.getDataInputStream();
				byte[] bytes = new byte[1]; 
				fos = new FileOutputStream(new File("narayana_murthy.jpg"));
				int i = 0;
				while(true){
					i = is.read(bytes);
					if(i > 0){
						fos.write(bytes);
					}else{
						break;
					}
				}
			}
			
			
		} catch (S3ServiceException e) {
			e.printStackTrace();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(is !=null){
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(fos != null){
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}



	private static void writeToS3()  {
		AWSCredentials cred = new AWSCredentials(username, password);
		RestS3Service service = new RestS3Service(cred);
		S3Bucket[] buckets;
		try {
			buckets = service.listAllBuckets();
			S3Object s3Obj = new S3Object(new File("narayana_murthy.jpg"));
			s3Obj.setContentType("image/jpeg");
			s3Obj.setKey("profiles/narayana_murthy.jpg");

			service.putObject(buckets[0], s3Obj);

		} catch (S3ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
