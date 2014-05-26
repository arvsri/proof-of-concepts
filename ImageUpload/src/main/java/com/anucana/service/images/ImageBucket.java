package com.anucana.service.images;

import java.io.Serializable;

import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartFile;

public class ImageBucket implements Serializable {

	/**
	 * default serial version uid
	 */
	private static final long serialVersionUID = 1L;

	private MultipartFile image = null;

	private String bucketName = null;

	private ModelMap modelMap = null;

	private ImageBucket(Builder builder) {
		this.image = builder.image;
		this.bucketName = builder.bucketName;
		this.modelMap = builder.modelMap;
	}

	public MultipartFile getImage() {
		return image;
	}

	public String getBucketName() {
		return bucketName;
	}

	public ModelMap getModelMap() {
		return modelMap;
	}

	public static class Builder {

		private MultipartFile image = null;
		private String bucketName = null;
		private ModelMap modelMap = null;

		public Builder(MultipartFile image) {
			this.image = image;
		}

		public Builder withUserInfo(String bucketName) {
			this.bucketName = "" + bucketName;
			return this;
		}

		public Builder withModelMap(ModelMap modelMap) {
			this.modelMap = modelMap;
			return this;
		}

		public ImageBucket build() {
			return new ImageBucket(this);
		}
	}
}
