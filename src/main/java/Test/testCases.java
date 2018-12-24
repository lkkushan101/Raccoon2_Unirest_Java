package Test;
import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;

import ReusableRequest.*;
import Utility.JSONReader;
public class testCases {

	getRequest getReq = new getRequest();
	postRequest postReq = new postRequest();
	deleteRequest deleteReq = new deleteRequest();
	@Test 
	public void testGet () throws UnirestException, IOException, IOException, ParseException
	{
	  JSONReader _JSONRead = new JSONReader();
	  JsonNode response = 	getReq.sendGetRequest(_JSONRead.ReadJSONFile("Request_Get", ".\\Data\\wsData.json"));
	  System.out.println(response.getObject().get("Temperature"));
	
	}
	
	@Test 
	public void testPost () throws UnirestException, IOException, IOException, ParseException
	{
		JSONReader _JSONRead = new JSONReader();
		
		String Req_URL = _JSONRead.ReadJSONFile("Request_Post", ".\\Data\\wsData.json");
		String email = _JSONRead.ReadJSONFile("email", ".\\Data\\wsData.json");
		String password = _JSONRead.ReadJSONFile("password", ".\\Data\\wsData.json");
	  HttpResponse<JsonNode> response = postReq.sendPostRequest(Req_URL, "{\"email:"+ email+", \"password:"+password+"}");
	 // System.out.println(response.getObject().get("Temperature"));
	  System.out.println(response.getStatus());

	  assertEquals(200, response.getStatus());
	}
	
	@Test 
	public void testDelete () throws UnirestException, IOException, IOException, ParseException
	{
		JSONReader _JSONRead = new JSONReader();
		 HttpResponse<JsonNode> response = deleteReq.sendDeleteRequest (_JSONRead.ReadJSONFile("Request_Delete", ".\\Data\\wsData.json")); 
	 // System.out.println(response.getObject().get("Temperature"));
	  System.out.println(((HttpResponse<JsonNode>) response).getStatus());

	  assertEquals(204, response.getStatus());
	}
}
