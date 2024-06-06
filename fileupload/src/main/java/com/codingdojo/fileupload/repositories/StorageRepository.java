package com.codingdojo.fileupload.repositories;

import java.util.List;
import java.util.Set;

import org.springframework.web.multipart.MultipartFile;

public interface StorageRepository {
// initialize the upload folder
	void init();
	
//	store the file in the upload folder 
	void store(MultipartFile file);
	
//	get a list of paths for all the images in the uploads folder 
	Set<String> loadAll();
}
