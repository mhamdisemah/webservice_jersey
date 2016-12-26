package com.test.service;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.test.dao.*;

@Path("/courseService")
public class CourseService {

	@GET
	@Path("/courses")
	@Produces("application/json")
	public CourseListe  courses()
	{
		String courses = null;
		ArrayList<Course> courseList = new ArrayList<Course>();
		
		try
		{
			courseList = new AccessManager().getCourses();
			/*Gson gson = new Gson();
			courses = gson.toJson(courseList);	*/
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return new CourseListe(courseList);
	}
	
	@Path("/Addcourses")
	@POST
	@Produces("application/x-www-form-urlencoded")
	@Consumes("application/x-www-form-urlencoded")
	public String AddCourse(@FormParam("name") String name,@FormParam("duration") String duration,@FormParam("fee") double fee){
		String reponse="";
		Course p=new Course();
		try{
			//System.out.println(name);
			p.setName(name);
			p.setDuration(duration);
			p.setFee(fee);
			System.out.println(p.getFee());
			Gson gson=new Gson();
			new AccessManager().ajouterCourse(p);
			 reponse=gson.toJson(p);
	
		}catch(Exception er){
			er.printStackTrace();
			 String etat="ECHEC";
				Gson gson=new Gson();
				 reponse=gson.toJson(etat);
		}
		return reponse;
	}
	
	@Path("/Updatecourses")
	@PUT
	@Produces("application/x-www-form-urlencoded")
	public String UpdateCourse(@FormParam("id") int id,@FormParam("name") String name,@FormParam("duration") String duration,@FormParam("fee") double fee){
		String reponse="";
		Course p=new Course();
		try{
			p.setId(id);
			p.setName(name);
			p.setDuration(duration);
			p.setFee(fee);
			Gson gson=new Gson();
			new AccessManager().modifierCourse(p);
			 reponse=gson.toJson(p);
	
		}catch(Exception er){
			er.printStackTrace();
			 String etat="ECHEC";
				Gson gson=new Gson();
				 reponse=gson.toJson(etat);
		}
		return reponse;
	}
	
	@DELETE  
    @Path("/delete/{id}")  
	@Produces("application/json")
		 public String deleteCourse(@PathParam("id") int id)  
		 {  
		String reponse="";

			try{
				new AccessManager().suppCourse(id);
				String etat="Success";
				Gson gson=new Gson();
				 reponse=gson.toJson(etat);
			}
			catch(Exception er)
			{
	
				er.printStackTrace();
				 String etat="ECHEC";
					Gson gson=new Gson();
					 reponse=gson.toJson(etat);
			}
			return reponse;
		 }  



}
