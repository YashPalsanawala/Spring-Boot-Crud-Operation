package com.example.Student.api;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Student.domain.Login;
import com.example.Student.repository.LoginRepository;

@Controller
@RestController
@RequestMapping(value = "api/login/")
public class LoginRestController {

	protected LoginRestController() {
		super();
	}
	
	@Autowired
	private LoginRepository repo;	
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping("/")
	public String getUser(@RequestBody Login login) {
		
		String user = login.getUsername();
		String pass = login.getPassword();
		String response = null;
		
		try {
			
			Login list = repo.findByUserName(user);
			
			if(list != null && user.equals(list.getUsername())) {
				String DBPass = list.getPassword();
				
				if(pass.equals(DBPass)) {
					response = "Valid ID and PWD";
				}
				else {
					response = "Invalid PWD";
				}				
			}
			else {
				response = "Invalid User";
			}		
			
		}catch (Exception e) {
			response = "ERROR";
		}
		
		return response;
	}
	
	/*@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping("/")
	public String getUser(@RequestBody Login login) {
		
		String user = login.getUsername();
		String pass = login.getPassword();
		String response = null;

		System.out.print("\n\tUSER : " + user);
		System.out.print("\n\tPASS : "+ pass);
		Login list = repo.findByUserName(user);
			
			if(list != null && pass.equals(list.getPassword()))
				response = "Valid";
			else
				response = "Invalid";
			
		
		return response;
	}*/
	
	/*@PostMapping("/")
	public String getUser(@RequestBody Login login){
		
		String user = login.getUsername();
		String pass = login.getPassword();		
		String response=null,u,p;
		
		try {
			
			List<Login> l = repo.findAll();			
			for (int i = 0; i < l.size(); i++) {
	            u = l.get(i).getUsername();
	            p = l.get(i).getPassword();
	            
	            if(user.equals(u)) {	            	
	            	if(pass.equals(p)) {
	            		response = "VALID ID PWD";
	            		break;
	            	}else {
	            		response = "VALID ID and PWD WRONG";
	            		break;
	            	}
	            }
	        }
			
			if(response == null)
				response = "USER NOT EXIST";			
		
		}catch (Exception e) {
			System.out.print("\n\t********** ERROR ********");
			response = "ERROR";	
		}			
		return response;
	}*/	
	
}
