package com.quizwebsite.core.userservice;

import org.apache.logging.log4j.*;

import com.quizwebsite.core.usermodel.User;
import com.quizwebsite.core.userservice.dao.UserDao;
import com.quizwebsite.core.userservice.daoimplementation.UserDaoImplementation;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Service;

//IMPORTANT. REPLACE E stack trace and system out print lin with log4j logging later

@Service
public class UserLoginRegistrationService {
	
	private User currentUser;
	
	private UserDao serviceDAO = new UserDaoImplementation();
	
	//constructors instantiate user
	public UserLoginRegistrationService()
	{
		super();
		currentUser = new User();
	}
	
	public UserLoginRegistrationService(User current)
	{
		super();
		currentUser = current;
	}
	
	//add salt based on username
	private String AddSalt(String password, String username)
	{
		String saltedOutput = password.concat(username);
		return saltedOutput;
	}
	
	//convert salted passwords to sha256 hash
	private byte[] GetSHA(String input) throws NoSuchAlgorithmException 
	{   
	        MessageDigest md = MessageDigest.getInstance("SHA-256");  
	        return md.digest(input.getBytes(StandardCharsets.UTF_8));  
	} 
	
	//convert sha256 hash to hexadecimal string 
	private String BytesToHex(byte[] hash) 
	{
		StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < hash.length; i++) 
		{
			String hex = Integer.toHexString(0xff & hash[i]);
		    if(hex.length() == 1) hexString.append('0');
		        hexString.append(hex);
		}
		    return hexString.toString();
	}
	
	//encrypt password using salt from unique id and sha256. output as hex string
	private String encryptPass(String password, String username)
	{
		String encryptedPass= null;
		try {
			encryptedPass =BytesToHex(GetSHA(AddSalt(password, username)));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return encryptedPass;
	}
	
	public boolean verifyPassword(String username, String password)
	{
		
		currentUser.setUsername(username);
		currentUser.setPass(encryptPass(password, username));
		
		//encrypt user input
		String encryptedPass = encryptPass(password,username);
		
		String passDb = serviceDAO.getPassword(currentUser);
		
		//verify password input by user 
		if(encryptedPass.equals(passDb))
			return true;
		else
			return false;
		
	}
	
	//create user account with username, unique id, and password
	public boolean createUser(String username, String password)
	{
		currentUser.setUsername(username);
		currentUser.setPass(encryptPass(password, username));
		
		return serviceDAO.addUser(currentUser);
	}

	
}
