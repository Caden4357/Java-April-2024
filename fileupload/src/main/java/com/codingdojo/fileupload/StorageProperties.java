package com.codingdojo.fileupload;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("storage")
public class StorageProperties {
	// set a path where to upload files 
	String uploadFolder = "src/main/webapp/uploads";
	
	public String getUploadFolder() {
		return uploadFolder;
	}

	public void setUploadFolder(String uploadFolder) {
		this.uploadFolder = uploadFolder;
	}
	
//	This is a singleton class it has no constructor it has one instantiation throughout your app that you use 
}
