
	package com.sip.controllers;

	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.ResponseBody;

	import com.sip.entities.Article;
	import com.sip.entities.Provider;
	import com.sip.repositories.ArticleRepository;
	import com.sip.repositories.ProviderRepository;

	@Controller
	@RequestMapping("/count")

	public class CountController {

		
		private final ProviderRepository providerRepository;
		private final ArticleRepository articleRepository;
		@Autowired
	    public CountController(ProviderRepository providerRepository,ArticleRepository articleRepository) {
	        this.providerRepository = providerRepository;
	        this.articleRepository = articleRepository ;
		}
	        @GetMapping("nbrProviders")
	        @ResponseBody()
		    public String  nbrProviders(Model model) {
		    	
		    	List<Provider> providers = (List<Provider>)providerRepository.findAll();
		    	long nbrprovider = providerRepository.count();
		    	if(providers.size()==0)
		    		providers = null;
		        model.addAttribute("nbrprovider", nbrprovider);
		        return "graphe/graphic1";
	            }
	}

