package com.anucana.service.images;

import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartFile;

import com.anucana.web.controllers.ImageCropCordinates;


/**
 * 
 * @author asrivastava
 * @since Apr 2, 2014
 */
public interface IImageService {
	
	boolean validateImageFormat(MultipartFile image,ModelMap model);
	
	boolean validateImageSize(MultipartFile image,ModelMap model);

	boolean saveImage(ImageBucket bucket);

	String getImagePath(ImageBucket bucket);
	
	void cropImage(ImageBucket bucket,ImageCropCordinates cordiantes);


}
