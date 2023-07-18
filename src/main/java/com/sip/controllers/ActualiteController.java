package com.sip.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sip.entities.Actualite;
import com.sip.entities.Article;
import com.sip.entities.Provider;
import com.sip.repositories.ActualiteRepository;


@Controller
@RequestMapping("actualite")
public class ActualiteController {
 
	 public static String uploadDirectory = System.getProperty("user.dir")+"/src/main/resources/static/uploads";

	 private final ActualiteRepository actualiteRepository;

		@Autowired
		public ActualiteController(ActualiteRepository actualiteRepository) {
			this.actualiteRepository = actualiteRepository;
		}
		@GetMapping("/list")
		public String listActualites(Model model) {
			List<Actualite> la = (List<Actualite>) actualiteRepository.findAll();
			if (la.size() == 0)
				la = null;
			model.addAttribute("actualites", la);
			return "actualite/listActualites";
		}
		@GetMapping("add")
	    public String showAddActualiteForm(Actualite actualite, Model model) {
	    	
	    	model.addAttribute("actualites", actualiteRepository.findAll());
	    	
	        return "actualite/addActualite";
	    }
	    
	    @PostMapping("add")
	    //@ResponseBody
	    public String addActualite(@Valid Actualite actualite, BindingResult result, 
	    		@RequestParam("files") MultipartFile[] files) {
	    	
	    
				if (result.hasErrors()) {
				return "provider/addProvider";
				}
	    	
	    	/// part upload
	    	
	    	StringBuilder fileName = new StringBuilder();
	    	MultipartFile file = files[0];
	       Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());
	    	
	    	fileName.append(file.getOriginalFilename());
			  try {
				Files.write(fileNameAndPath, file.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
			actualite.setPicture(fileName.toString());
	    	 actualiteRepository.save(actualite);
	    	 System.out.println(actualite);
	    	 return "redirect:list";
	    	
	    	//return article.getLabel() + " " +article.getPrice() + " " + p.toString();
	    }
	    
	    
	    @GetMapping("delete/{id}")
	    public String deleteActualite(@PathVariable("id") long id, Model model) {
	        Actualite actualite = actualiteRepository.findById(id)
	            .orElseThrow(()-> new IllegalArgumentException("Invalid actualite Id:" + id));
	        actualiteRepository.delete(actualite);
	        model.addAttribute("aactualites", actualiteRepository.findAll());
	        return "article/listArticles";
	    }
	    @GetMapping("show/{id}")
	    public String showActualiteDetails1(@PathVariable("id") long id, Model model) {
	    Actualite actualite = actualiteRepository.findById(id)
	            .orElseThrow(()->new IllegalArgumentException("Invalid actualiteId:" + id));
	    	
	        model.addAttribute("actualite", actualite);
	        
	        return "actualite/showActualite";
	    }
}