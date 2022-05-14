package May_Rest_assured_swagger_pet;

import org.json.simple.JSONArray;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class TestngRestassured {
	
	
	
	  @Test(enabled = false)
	  
	  public void test1() {
	  
	  System.out.println("hello");
	  
	  Response resp=RestAssured.get("http://localhost:3000/firstdemo");
	  System.out.println(resp.asString()); System.out.println(resp.statusLine());
	  System.out.println(resp.asPrettyString());
	  System.out.println(resp.statusCode());
	  
	  
	  
	  
	  
	  }
	  
	  @Test(enabled = false) public void test2( ) {
	  
	  System.out.println("hello123 skipped");
	  
	  Response resp=RestAssured.get("http://localhost:3000/firstdemo");
	  System.out.println(resp.asString()); System.out.println(resp.statusLine());
	  System.out.println(resp.asPrettyString());
	  System.out.println(resp.statusCode());
	  
	  
	  
	  
	  
	  }
	  
	  
	  
	  @Test(enabled = false)
	  
	  public void test3() {
	  
	  RestAssured.baseURI="http://localhost:3000";
	  
	  given().get("/firstdemo/1").then().statusCode(200).log().all();
	  
	  
	  
	  }
	  
	  
	  
	  @Test(enabled = false)
	  
	  public void test4() {
	  
	  RestAssured.baseURI="http://localhost:3000";
	  
	  String body=
	  "{\"name\":\"typicode12345\",\"section\":\"fouthvalue124567\",\"batch\":\"145678\"}";
	  
	  given().contentType(ContentType.JSON).body(body).when().put("/apitest").then(
	  ).statusCode(200).log().all();
	  
	  // given().contentType(ContentType.JSON).body(body).when().post("/apitest");
	  
	  
	  
	  
	  }
	  
	  
	  
	  @Test(enabled = false)
	  
	  
	  public void test5() {
	  
	  
	  RestAssured.baseURI="http://localhost:3000";
	  
	  String body=
	  "{\"name\":\"typicode12345\",\"section\":\"fouthvalue124567234\",\"batch\":\"145678\"}";
	  
	  given().contentType(ContentType.JSON).body(body).when().post("/apitest").then
	  ().statusCode(201).log().all();
	  
	  
	  }
	  
	  
	  
	  @Test(enabled = false)
	  
	  public void test6() {
	  
	  RestAssured.baseURI="http://localhost:3000";
	  
	  String body=
	  "{\"name\":\"typicode12345\",\"section\":\"fouthvalue124567234\",\"batch\":\"145678\"}";
	  
	  given().contentType(ContentType.JSON).body(body).when().post("/apitest").then
	  ().statusCode(201).log().all(); given().header(null);
	  
	  }
	  
	  
	  
	  
	  @Test(enabled = false)
	  
	  
	  
	  public void test10() {
	  
	  RestAssured.baseURI="http://localhost:3000";
	  
	  JSONObject obj=new JSONObject(); obj.put("name", "asasdd");
	  obj.put("section", "asasdd"); obj.put("batch", "asasdd");
	  
	  System.out.println(obj.toJSONString());
	  
	   String body=
	  "{\"name\":\"typicode12345\",\"section\":\"fouthvalue124567234\",\"batch\":\"145678\"}";
	  
	  given().contentType(ContentType.JSON).body(obj.toJSONString()).when().post(
	  "/apitest").then().statusCode(201).log().all();
	  
	  
	  }
	  
	  @Test(enabled = false)
	  
	  
	  public void test11() {
	  
	  RestAssured.baseURI="https://petstore.swagger.io/v2";
	  
	  
	  JSONObject parent=new JSONObject(); JSONObject categoryobj=new JSONObject();
	  JSONObject tagsobj=new JSONObject();
	  
	  parent.put("id","1234"); parent.put("name","shadow");
	  parent.put("status","available");
	  
	  categoryobj.put("id", "123");
	  
	  tagsobj.put("id", "456"); tagsobj.put("name", "cat");
	  
	  
	  parent.put("category","categoryobj"); parent.put("tags","tagsobj");
	  
	  
	  JSONArray arr=new JSONArray(); arr.add("image1"); arr.add("image2");
	  arr.add("3");
	  
	  
	  parent.put("photoUrls", arr);
	  
	  
	  System.out.println(parent.toJSONString());
	  
	  
	  //https://petstore.swagger.io/v2/
	  
	  given().contentType(ContentType.JSON).body(parent.toJSONString()).when().post
	  ("/pet").then().statusCode(201).log().all();
	  
	  }
	  
	  
	  @Test(enabled = false,dataProvider = "requestdata") public void
	  testcase6(String bn,String fn, String place ) { RestAssured.baseURI =
	  "http://localhost:3000";
	  
	  JSONObject parent = new JSONObject(); parent.put("batchname",bn);
	  parent.put("filename", fn); parent.put("place", place);
	  
	  
	  given() .header("content-type","application/json")
	  .body(parent.toJSONString()). when() .post("/sample"). then()
	  .statusCode(201).log().all();
	  
	  
	  }
	  
	  @DataProvider(name="requestdata") public Object[][] dataprov() { Object[][]
	  data = new Object[4][3]; data[0][0] = "batchname1"; data[0][1]= "filename1";
	  data[0][2] = "place1";
	  
	  data[1][0] = "batchname2"; data[1][1]= "filename2"; data[1][2] = "place2";
	  
	  data[2][0] = "batchname3"; data[2][1]= "filename3"; data[2][2] = "place3";
	  
	  data[3][0] = "batchname4"; data[3][1]= "filename4"; data[3][2] = "place4";
	  
	  return data;
	  
	  }
	 
	
	
	@SuppressWarnings("unchecked")
	@Test(enabled = true,priority = 1)
	
	
	public void create_user() {
		RestAssured.baseURI="https://petstore.swagger.io/v2";
		
		JSONObject jsonobj = new JSONObject();
		jsonobj.put("username", "john1");
		jsonobj.put("firstName", "john");
		jsonobj.put("lastName", "doe");
		jsonobj.put("email", "abc@yopmail.com");
		jsonobj.put("password", "bellary");
		jsonobj.put("phone", "8765456787");
		jsonobj.put("userStatus", 0);
		
		 given().contentType(ContentType.JSON).body(jsonobj.toJSONString()).when().post
		  ("/user").then().statusCode(200).log().all();
		
		
		
		
		
	}
	
	
	
	
@SuppressWarnings("rawtypes")
@Test(enabled = true,priority = 2)
	
	
	public void login_user() {
RestAssured.baseURI="https://petstore.swagger.io/v2/user/login?username=john1&password=bellary";
Response resp=given().contentType(ContentType.JSON).get();
ResponseBody bod=resp.getBody();
System.out.println(bod.asString()+ "data is ----");



		
		
		
	}

}
