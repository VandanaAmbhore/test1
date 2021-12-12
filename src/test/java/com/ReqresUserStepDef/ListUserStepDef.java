package com.ReqresUserStepDef;

import org.junit.Assert;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ListUserStepDef {
	RequestSpecification request;
	Response respose;
	JsonPath path;
	@Given("Uer is authenticated")
	public void uer_is_authenticated() {
		//request.get();
		request=RestAssured.given();
	}
	
	@Given("url {string}")
	public void url(String string) {
	 request.baseUri(string)  ;
	}
	@When("user is using Get method")
	public void user_is_using_get_method() {
		respose=request.get();
		path=new JsonPath(respose.asString());
	    
	}
	@Then("user will get the list of users")
	public void user_will_get_the_list_of_users() {
		Assert.assertEquals(200, respose.statusCode());
	}
	@Then("response content type is {string}")
	public void response_status_line_is(String string) {
	    //Assert.assertEquals("json", respose.contentType().contains(string));
		Assert.assertTrue(respose.contentType().contains(string));
	}
	@Then("respone status line is {string}")
	public void respone_status_line_is(String string) {
		System.out.println("---Status line- "+respose.getStatusLine());
		//Assert.assertEquals("OK", respose.statusLine().contains(string));
		Assert.assertTrue(respose.getStatusLine().contains(string));
	}

	@Then("get response in less than {int} ms")
	public void get_response_in_less_than_ms(Integer int1) {
	  //Assert.assertTrue("response time is as expected", respose.getTime());
		System.out.println("Time is "+respose.getTime());
	  Assert.assertTrue(respose.getTime()<int1);
	}

	
	@When("query paramter is ID is {int}")
	public void query_paramter_is_id_is(Integer int1) {
		request.param("id", "8");
	}
	
	@Then("user is getting first name {string}")
	public void user_is_getting_first_name(String string) {
		System.out.println(path.getString("data.first_name"));
		Assert.assertEquals(string,path.getString("data.first_name"));
	}


	

	





	


}
