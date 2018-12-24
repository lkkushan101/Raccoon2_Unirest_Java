package ReusableRequest;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.*;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class deleteRequest {
	public HttpResponse<JsonNode> sendDeleteRequest (String requestURL ) throws UnirestException
	{
		 HttpResponse<JsonNode> jsonResponse1 = Unirest.delete(requestURL)
	      .header("accept", "application/json")
	      .asJson();
	 
	    assertEquals(204, jsonResponse1.getStatus());
	     return jsonResponse1;
	}
}
