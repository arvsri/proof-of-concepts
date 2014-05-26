package com.anucana.web.controllers;

public class ImageUploadResponse {

	private String imgURL;
	
	private boolean dummy;
	
	public ImageUploadResponse(String imgURL, boolean dummy){
		this.imgURL = imgURL;
		this.dummy = dummy;
	}

	public String getImgURL() {
		return imgURL;
	}

	public boolean isDummy() {
		return dummy;
	}
	
	
	
}
