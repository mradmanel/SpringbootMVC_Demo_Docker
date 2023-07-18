package com.sip;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sip.controllers.ArticleController;
import com.sip.controllers.ProviderController;



@SpringBootApplication
public class AmsMvc2Application   {

	public static void main(String[] args)throws IOException  {
		SpringApplication.run(AmsMvc2Application.class, args); 
		Path path = Paths.get(ProviderController.uploadDirectory);
        Files.createDirectory(path);
		//System.out.println("Couche data");
        Path path1 = Paths.get(ArticleController.uploadDirectory);
        Files.createDirectory(path1);

	
	
	}
}

