package com.anucana.web.controllers;

import javax.servlet.ServletContext;

import org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.anucana.service.images.IImageService;
import com.anucana.service.images.ImageBucket;


@Controller
public class LoginController  implements ServletContextAware{
	
	private String imagePath;

	@RequestMapping(value = {"/","/home"})
	public ModelAndView homePage(ModelMap model){
		ModelAndView mv = new ModelAndView("imageUpload");
		String imgPath = imageService.getImagePath(new ImageBucket.Builder(null).withUserInfo("user_profile").withModelMap(mv.getModelMap()).build());
		if(StringUtils.isEmpty(imgPath)){
			mv.addObject(new ImageUploadResponse("http://localhost:8081/contents/images/profile_dummy.png", true));
		}else{
			mv.addObject(new ImageUploadResponse("http://localhost:8080/ImageUpload/" + imgPath, false));
		}
		return mv;
	}

	@Autowired
	private IImageService imageService; 

	@RequestMapping(value = "/{id}/saveimage", method = RequestMethod.POST)
	public ModelAndView uploadProfileImage(@PathVariable("id") long loginNumber, MultipartFile image,ModelMap model) throws Exception {		
		ModelAndView mv = new ModelAndView("imageUpload");
		if (imageService.validateImageFormat(image, model)) {
			imageService.saveImage(new ImageBucket.Builder(image).withUserInfo("user_profile").withModelMap(mv.getModelMap()).build());
			
			model.put("imgURL", this.imagePath + "/user_profile/main.jpg");
			mv.addObject("isdummy",false);
		}else{
			mv.addObject("imgURL", "http://localhost:8081/contents/images/profile_dummy.png");
			mv.addObject("isdummy",true);
		}
		
		return mv;
	}
	
	@RequestMapping(value = "/saveimage", method = RequestMethod.POST)
	public ModelAndView uploadImage(MultipartFile image,ModelMap model) throws Exception {
		Thread.sleep(4000l);

		ModelAndView mv = new ModelAndView("imageUpload");
		ImageBucket bucket = new ImageBucket.Builder(image).withUserInfo("user_profile").withModelMap(mv.getModelMap()).build();
		if (imageService.validateImageFormat(image, model)) {
			imageService.saveImage(bucket);
		}
		
		String imgPath = imageService.getImagePath(bucket);
		if(StringUtils.isEmpty(imgPath)){
			mv.addObject(new ImageUploadResponse("http://localhost:8081/contents/images/profile_dummy.png", true));
		}else{
			mv.addObject(new ImageUploadResponse("http://localhost:8080/ImageUpload/" + imgPath, false));
		}
		return mv;
	}

	
	@RequestMapping(value = "/cropImage", method = RequestMethod.POST)
	public ModelAndView cropImage(ImageCropCordinates cordinates,ModelMap model) throws Exception {
		System.out.println(cordinates.toString());
		ModelAndView mv = new ModelAndView("imageUpload");
		ImageBucket bucket = new ImageBucket.Builder(null).withUserInfo("user_profile").withModelMap(mv.getModelMap()).build();
		imageService.cropImage(bucket, cordinates);
		
		String imgPath = imageService.getImagePath(new ImageBucket.Builder(null).withUserInfo("user_profile").withModelMap(mv.getModelMap()).build());
		if(StringUtils.isEmpty(imgPath)){
			mv.addObject(new ImageUploadResponse("http://localhost:8081/contents/images/profile_dummy.png", true));
		}else{
			mv.addObject(new ImageUploadResponse("http://localhost:8080/ImageUpload/" + imgPath, false));
		}
		return mv;
	}
	
	@Override
	public void setServletContext(ServletContext servletContext) {
		this.imagePath = "/" + servletContext.getInitParameter("profile-image-repo");
	}
}



