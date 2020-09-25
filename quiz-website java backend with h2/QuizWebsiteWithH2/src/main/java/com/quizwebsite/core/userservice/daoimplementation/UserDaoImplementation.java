package com.quizwebsite.core.userservice.daoimplementation;

import com.quizwebsite.core.usermodel.User;
import com.quizwebsite.core.userservice.dao.UserDao;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;

//import com.microsoft.sqlserver.jdbc.SQLServerDriver;

//import java.sql.*;
//import java.io.File;

//import org.apache.commons.dbutils.DbUtils;
import org.apache.logging.log4j.*;

/*
 * Class for accessing user data. Will later add orm and spring annotations. Maybe use jpa. Maybe use @repository
 * For now creating stored procedures to have a workable project to test with a production sql server db
 * 
 */
public class UserDaoImplementation implements UserDao{

	//A variable for the database connection string.
	//is it ok to hardcode how the web server connects to db or should there be some form of authentication/security
	//usually would use application.properties datasource but had some issues
	//private String connectionUrl = "jdbc:sqlserver://LAPTOP-NN49TL8N\\SQLEXPRESS:1433;"
	//		+ "databaseName=Test Database;user=webadmin;password=password";
	
	//method for adding user to database
	@Override
	public boolean addUser(User user) {
		//Connection con = null;
		//PreparedStatement stmt= null;
		
		//add user entry data to sql server
		/*try{
				con = DriverManager.getConnection(connectionUrl);
				String createUserUpdate = "EXEC [Test Database].dbo.createUserRecord ?, ?;";
				stmt = con.prepareStatement(createUserUpdate);
				stmt.setString(1, user.getUsername());
				stmt.setString(2, user.getPass());
				stmt.executeUpdate();  
				stmt.close();
				        
			}
			// Handle any errors that may have occurred.
			catch (SQLException e) {
				e.printStackTrace();
				return false;
				
				//close connection and statement
				}finally{
					DbUtils.closeQuietly(stmt);
					DbUtils.closeQuietly(con);
				}
				*/
		return true;
	}

	//method for getting stored encrypyted password given username input
	@Override
	public String getPassword(User user) {
		/*
		
		Connection con = null;
		PreparedStatement stmt= null;
		ResultSet rs=null;
		String passDb= null;
				
		//using username input
		//get correct password from database
		//replace exception stacktrace prints with logger4j eventually
		try 
		{
			//retrieve password from db
			con = DriverManager.getConnection(connectionUrl);
			String queryPass = "EXEC [Test Database].dbo.retrievePassword ?;";
			stmt = con.prepareStatement(queryPass);
			stmt.setString(1, user.getUsername());
			rs = stmt.executeQuery();

			//to string for sql query output
			while (rs.next()) {
				passDb= rs.getString("password");
			}
			        
			stmt.close();
			rs.close();
			        
		}
		// Handle any errors that may have occurred.
		catch (SQLException e) {
			e.printStackTrace();
		   return passDb;
		}finally{
			DbUtils.closeQuietly(rs);
			DbUtils.closeQuietly(stmt);
			DbUtils.closeQuietly(con);
		}
		
		return passDb;
		*/
		return "";
	}

}
