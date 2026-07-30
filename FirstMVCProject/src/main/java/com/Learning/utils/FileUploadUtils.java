package com.Learning.utils;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtils {
	public static void saveFile(String uploadDir, String fileName, MultipartFile multipart) {
		Path uploadPathObj = Paths.get(uploadDir);
		 
		try (InputStream inputstream = multipart.getInputStream()){
			if(!Files.exists(uploadPathObj)) {
				Files.createDirectories(uploadPathObj);
			}
			Path filePath = uploadPathObj.resolve(fileName);
			Files.copy(inputstream, filePath, StandardCopyOption.REPLACE_EXISTING);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
