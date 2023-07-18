package com.sip.controllers;

import java.util.Objects;
import java.util.Set;

import javax.management.relation.RoleInfo;

import org.apache.catalina.User;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class HomeController {
	@RequestMapping("/home")
	//@ResponseBody
	public String home() {
		/* Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findUserByEmail(auth.getName());
        model.addAttibute("user", user);
        Set<RoleInfo> userroles = user.getRoles();
        Objects roles = userRoles.toArray();
        Role  role =(Role)roles[0];
        String userRole = role.getRole();
        switch(userRole)
        case  Superadmin: return "home/superadmin";
        case  Admin: return "home/admin";
        case  User: return "home/agent";*/
       
		return "front/index.html";		 
       }
	@RequestMapping("/listproviders")
	//@ResponseBody
	public String listPartnaires() {
		return"front/listProviders.html";
	}
	
	@RequestMapping("/contact")
	//@ResponseBody
	public String contact() {
		return"front/contact.html";
	}
}
