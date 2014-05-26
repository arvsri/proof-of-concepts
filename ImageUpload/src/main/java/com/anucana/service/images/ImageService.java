package com.anucana.service.images;

import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.imgscalr.Scalr;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;

import com.anucana.web.controllers.ImageCropCordinates;


@Component
public class ImageService implements IImageService,ServletContextAware {

	private String imagePath = null;
	
	@Override
	public boolean validateImageFormat(MultipartFile image, ModelMap model) {
		if(isImageNull(image, model)){
			return false;
		}
		if(isImageFormatNotSupported(image, model)){
			return false;
		}
		
		return true;
	}


	@Override
	public boolean validateImageSize(MultipartFile image, ModelMap model) {
		return false;
	}

	public boolean saveImage(ImageBucket bucket) {
		File bucketDir = new File(this.imagePath + "" + bucket.getBucketName());
		try {
			if(!bucketDir.exists()){
				bucketDir.mkdir();
			}

			File file = new File(bucketDir.getAbsolutePath() + "\\main.jpg"); 
			byte[] bytes = bucket.getImage().getBytes();
			FileUtils.writeByteArrayToFile(file, bytes);
			
		} catch (IOException e) {
			e.printStackTrace();
			bucket.getModelMap().put("imageuploaderror", e.getMessage());
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			bucket.getModelMap().put("imageuploaderror", e.getMessage());
			return false;
		}
		return true;
	}

	
	public String getImagePath(ImageBucket bucket) {
		String imgPath = this.imagePath + "" + bucket.getBucketName() + "\\main.jpg";
		if(new File(imgPath).exists()){
			return servletContext.getInitParameter("profile-image-repo") + "/" + bucket.getBucketName() + "/main.jpg" ;
		}else{
			return null;
		}
	}
	
	private boolean isImageNull(MultipartFile image, ModelMap model){
		if(image == null || image.getSize() <= 0){
			model.put("imageuploaderror", "Please select a an image to upload");
			return true;
		}
		return false;
	}

	private boolean isImageFormatNotSupported(MultipartFile image,ModelMap model) {
		String fileName = image.getOriginalFilename();
		if(StringUtils.isEmpty(fileName) || ( ! fileName.endsWith("jpg") )){
			model.put("imageuploaderror", "Image Format Not supported");
			return true;
		}
		return false;
	}
	
	private ServletContext servletContext;
	
	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
		this.imagePath = servletContext.getRealPath("") + "\\" + servletContext.getInitParameter("profile-image-repo")+ "\\";
	}


	@Override
	public void cropImage(ImageBucket bucket, ImageCropCordinates cordiantes) {
		File file = new File(this.imagePath + "" + bucket.getBucketName()+ "\\main.jpg");
		if (!file.exists()) {
			bucket.getModelMap().put("imageuploaderror","Image not found in the server side. Please refresh your screen and try again");
			return;
		}
		try {
			BufferedImageOp ops = null;

			BufferedImage image = ImageIO.read(new FileInputStream(file));
			BufferedImage croppedImage = Scalr.crop(image, cordiantes.getX(), cordiantes.getY(), cordiantes.getW(), cordiantes.getH(), ops);
			
			ImageIO.write(croppedImage, "jpg", new FileOutputStream(file));
		} catch (IOException e) {
			e.printStackTrace();
			bucket.getModelMap().put("imageuploaderror", e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			bucket.getModelMap().put("imageuploaderror", e.getMessage());
		}
		
	}
	
}
