package ReusableRequest;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.*;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
public class postRequest {

	public HttpResponse<JsonNode> sendPostRequest (String request_url, String Request_body) throws UnirestException
	{
		
		  HttpResponse<JsonNode> jsonResponse1 
	      = Unirest.post(request_url)
	    
	      .body(Request_body)
	      .asJson();
		 
		 
		  return jsonResponse1;
	}
}
