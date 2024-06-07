package com.codingdojo.flashfeed.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.codingdojo.flashfeed.StorageProperties;
import com.codingdojo.flashfeed.exceptions.StorageExceptions;
import com.codingdojo.flashfeed.repositories.StorageRepository;



@Service
public class UploadService implements StorageRepository {
	// The root location where files will be stored, initialized via the constructor
	private final Path rootLocation; // "src/main/webapp/uploads"

	// Constructor that initializes the rootLocation using the upload folder path from StorageProperties
	public UploadService(StorageProperties properties) {
	    // Converts the upload folder path from StorageProperties to a Path object
	    this.rootLocation = Paths.get(properties.getUploadFolder());
	}

	// Initializes the storage directory
	@Override
	public void init() {
	    // Check if the directory represented by rootLocation exists
	    if (!Files.exists(rootLocation)) {
	        try {
	            // If it doesn't exist, create the directory
	            Files.createDirectory(rootLocation);
	        } catch (IOException error) {
	            // If an IOException occurs, throw a custom StorageExceptions with a message and the caught exception
	            throw new StorageExceptions("Could not initialize upload folder", error);
	        }
	    }
	}

	// Stores a given MultipartFile in the storage directory
	@Override
	public void store(MultipartFile file) {
	    try {
	        // Check if the file is empty
	        if (file.isEmpty()) {
	            // If the file is empty, throw a custom StorageExceptions with a message
	            throw new StorageExceptions("Failed to upload empty file " + file.getOriginalFilename());
	        }
	        // Copy the file's input stream to the target location (resolved from rootLocation and the file's original filename)
	        Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getOriginalFilename()));
	    } catch (IOException e) {
	        // If an IOException occurs during file copy, throw a custom StorageExceptions with a message and the caught exception
	        throw new StorageExceptions("Failed to store file " + file.getOriginalFilename(), e);
	    }
	}

	@Override
	public Set<String> loadAll() {
	    // Create a new File object using the rootLocation path and list all files and directories within it
	    return Stream.of(new File(rootLocation.toString()).listFiles())
	                 // Filter the stream to exclude directories, keeping only regular files
	                 .filter(file -> !file.isDirectory())
	                 // Map each remaining File object to its name (a String)
	                 .map(File::getName)
	                 // Collect the resulting stream of file names into a Set to ensure unique values
	                 .collect(Collectors.toSet());
	}
}
