package com.telusko.demorest;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("aliens")
public class AlienResource {
	
	static final AlienRepository repo = new AlienRepository();
/*
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Alien getAlien() {
		System.out.println("getAlien called . . . .");
		Alien a1 = new Alien();
		a1.setName("Navin");
		a1.setPoints(60);
		
		return a1;
	}
*/
	
	/*
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Alien> getAliens() {
		System.out.println("getAlien called . . . .");
		Alien a1 = new Alien();
		a1.setName("Navin");
		a1.setPoints(60);
		
		Alien a2 = new Alien();
		a2.setName("Siri");
		a2.setPoints(90);
		
		List<Alien> aliens = Arrays.asList(a1,a2);
		return aliens;
	}
	*/
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Alien> getAliens() {
		System.out.println("getAlien called . . . .");
		
		return repo.getAliens();
	}
	
	@POST
	@Path("alien")
	public Alien createAlien(Alien a1) {
		System.out.println("createAlien called . . . ."+a1);
		
		Alien alien = repo.createAlien(a1);
		return alien;
	}
	
	@GET
	@Path("alien/{id}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Alien getAlien(@PathParam("id") int id) {
		return repo.getAlien(id);
	}
}