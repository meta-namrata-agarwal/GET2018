package com.resources;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

import com.dao.advertisement.AdvertisementHelper;
import com.dao.category.CategoryHelper;
import com.model.Category;
import com.model.ResponseBuilder;

@Path("/category")
public class CategoryResource {

	@POST
	@Path("/postName")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addCategory(@HeaderParam("authorization") String authKey, Category category)
			throws ClassNotFoundException, SQLException {

		if (!isAuthentic(authKey)) {
			return Response.status(Status.UNAUTHORIZED).entity("{\"error\":\"Unauthorized Access\"}").build();
		}

		int status = CategoryHelper.insertCategoryName(category.getName());
		if (status == 1)
			return Response.ok("{\"success\":\"Added Successfully\"}", MediaType.APPLICATION_JSON).build();
		else
			return Response.status(Status.NOT_ACCEPTABLE).entity("{\"error\":\"Attribute is not defined\"}").build();
	}

	@GET
	@Path("/getCategory")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserByID(@HeaderParam("authorization") String authKey)
			throws ClassNotFoundException, SQLException, JsonGenerationException, JsonMappingException, IOException {

		if (!isAuthentic(authKey)) {
			return Response.status(Status.UNAUTHORIZED).entity("{\"error\":\"Unauthorized Access\"}").build();
		} else {
			List<Category> category = CategoryHelper.retrieveAllCategory();
			ResponseBuilder response = new ResponseBuilder();
			if (category != null) {
				response.setStatus(200);
				response.setPayload(category);
				ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
				String json = ow.writeValueAsString(response);
				return Response.ok(json, MediaType.APPLICATION_JSON).build();
			} else {
				return Response.status(Status.NOT_ACCEPTABLE).entity("{\"error\":\"Attribute is not defined\"}").build();
			}
		}
	}

	@PUT
	@Path("/updateCategory/{id}/{name}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateCategory(@HeaderParam("authorization") String authKey, @PathParam("id") int id,
			@PathParam("name") String name) throws ClassNotFoundException, SQLException {
		if (!isAuthentic(authKey)) {
			return Response.status(Status.UNAUTHORIZED).entity("{\"error\":\"Unauthorized Access\"}").build();
		}
		int status = CategoryHelper.updateCategoryNameHelper(name, id);
		if (status == 1)
			return Response.ok("{\"success\":\"Added Successfully\"}", MediaType.APPLICATION_JSON).build();
		else
			return Response.status(Status.NOT_ACCEPTABLE).entity("{\"error\":\"Attribute is not defined\"}").build();
	}
	
	@GET
	@Path("/{id}/advertisement/{advID}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllAdsByCategoryId(@HeaderParam("authorization") String authKey, @PathParam("id") int id, @PathParam("advID") int advID) throws JsonGenerationException, JsonMappingException, IOException {
		if (!isAuthentic(authKey)) {
			return Response.status(Status.UNAUTHORIZED).entity("{\"error\":\"Unauthorized Access\"}").build();
		}
		List<Category> advList = AdvertisementHelper.retrieveAllAdvertisementByCategoryIdHelper(id);
		//List<Category> category=new ArrayList<Category>();
		
		//category.add(advList);
		
		ResponseBuilder response = new ResponseBuilder();
		if (advList != null) {
			response.setStatus(200);
			response.setPayload(advList);
			ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
			String json = ow.writeValueAsString(response);
			return Response.ok(json, MediaType.APPLICATION_JSON).build();
		} else {
			return Response.status(Status.NOT_ACCEPTABLE).entity("{\"error\":\"Attribute is not defined\"}").build();
		}
	}


	/**
	 * helper method to authenticate client
	 * 
	 * @param authKey
	 *            is authorization key
	 * @return true if authorized
	 */
	private boolean isAuthentic(String authKey) {
		return "get-2018".equals(authKey);
	}

}
