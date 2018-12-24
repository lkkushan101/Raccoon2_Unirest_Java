package ReusableRequest;
import static org.testng.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.*;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import Utility.JSONReader;
public class getRequest {
	
	public JsonNode sendGetRequest (String requestURL ) throws UnirestException, IOException,  ParseException
	{

		 HttpResponse<JsonNode> jsonResponse1 = Unirest.get(requestURL)
	      .header("accept", "application/json")
	      .asJson();
	 
	    assertEquals(200, jsonResponse1.getStatus());
	     return jsonResponse1.getBody();
	}

}
