package com.sip.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
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


import com.sip.repositories.ProviderRepository;
import com.sip.entities.Provider;
import com.sip.entities.Article;

@Controller

@RequestMapping("/provider/")
public class ProviderController {

	public static String uploadDirectory = System.getProperty("user.dir")+"/src/main/resources/static/uploads";
	private final ProviderRepository providerRepository;
	@Autowired
	public ProviderController(ProviderRepository providerRespository) {
		this.providerRepository = providerRespository;
	}
	
	@GetMapping("/list")
	public String listProviders(Model model) {
		//model.addAttribute("providers", null);
        model.addAttribute("providers", providerRepository.findAll());
		return "provider/listProviders";
	}
	
	 @GetMapping("add")
	 public String showAddArticleForm(Provider provider, Model model) {
	    	
	    	model.addAttribute("providers", providerRepository.findAll());
	    	//model.addAttribute("provider", new Provider());
	        return "provider/addProvider";
	    }
	@PostMapping("add")
	public String addProvider(@Valid Provider provider,
	BindingResult result, Model model, @RequestParam("files") MultipartFile[] files) {
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
	provider.setLogo(fileName.toString());
	providerRepository.save(provider);
	return "redirect:list";
	}
	
	@GetMapping("delete/{id}")
	public String deleteProvider(@PathVariable("id") long id, Model
	model) {
	//long id2 = 100L;
	Provider provider = providerRepository.findById(id)
			.orElseThrow(()-> new IllegalArgumentException("Invalid provider Id:" + id));
	System.out.println("suite du programme...");
	providerRepository.delete(provider);
	return "redirect:../list";
	}
	@GetMapping("show/{id}")
	public String showProviderDetails(@PathVariable("id") long id, Model model) {
    	Provider provider = providerRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("Invalid provider Id:" + id));
        	
           
            model.addAttribute("provider", provider);
    
            return "provider/showProvider";
        }
	@GetMapping("edit/{id}")
    public String showProviderFormToUpdate(@PathVariable("id") long id, Model model) {
    	Provider provider = providerRepository.findById(id)
            .orElseThrow(()->new IllegalArgumentException("Invalid provider Id:" + id));
    	
        model.addAttribute("provider", provider);
       
        return "provider/updateProvider";
    }
    @PostMapping("edit/{id}")
    public String updateProvider(@PathVariable("id") long id, @Valid Provider provider, BindingResult result,
        Model model, @RequestParam(name = "providerId", required = false) Long p) {
        if (result.hasErrors()) {
        	provider.setId(id);
            return "provider/listProviders";
        }
        providerRepository.save(provider);
        model.addAttribute("provider", providerRepository.findAll());
        return "provider/listProviders";
    }	
}
