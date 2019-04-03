package com.revature.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.revature.dao.ZipCodeDAOImpl;
import com.revature.model.ZipCode;

@Path(value="zipcodes")
public class ZipCodeService {
	
	@GET
	@Path("/{zipCode}")
	@Produces(value= {"application/json","application/xml"})	
	public Response getZipCode(@PathParam("zipCode") int zipCode) {
		ZipCode z= ZipCodeDAOImpl.getInfoByZip(zipCode);
		return Response.status(Response.Status.OK).entity(z).build();
	}
	@POST
	@Path("/")
	@Produces(value= {"application/json","application/xml"})
	public Response createZipCode(ZipCode z) {
		ZipCodeDAOImpl.addZipCode(z);
		System.out.println(z);
		return Response.status(Response.Status.OK)
				.entity("ZipCode "+ z.getZipCode()+ " was added successfully").build();
	}
	
	@GET
	@Path("/")
	@Produces(value= {"application/json","application/xml"})
	public Response getZipCodeList() {
		List<ZipCode> zipcodelist= ZipCodeDAOImpl.getAllZipCodes();
		return Response.status(Response.Status.OK).entity(zipcodelist).build();
	}
}
