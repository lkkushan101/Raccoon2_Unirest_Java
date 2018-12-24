package stepdefs;

import com.mashape.unirest.http.JsonNode;

import Utility.JSONReader;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;
import ReusableRequest.*;

public class GetRequest1 {
	static getRequest _getReq;
	static String  URL_Requst;
	static JsonNode response1;
	@Given("^I have url to get weather for Pune$")
	public void i_have_url_to_get_weather_for_Pune() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		JSONReader _JSONRead = new JSONReader();
		URL_Requst = _JSONRead.ReadJSONFile("Request_Get", ".\\Data\\wsData.json");
		
	}

	@When("^I successfully sent the request$")
	public void i_successfully_sent_the_request() throws Throwable {
	    response1 = _getReq.sendGetRequest(URL_Requst);
	
	}

	@Then("^I should get weather details$")
	public void i_should_get_weather_details() throws Throwable {
		  System.out.println(response1.getObject().get("Temperature"));	
	}
}
