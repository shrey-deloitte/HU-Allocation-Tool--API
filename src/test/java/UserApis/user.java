package UserApis;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.core.Is;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class user {

  String baseUri="https://huallocation-backend-urtjok3rza-wl.a.run.app";


  //login test
  @Test(priority = 1)
  public  void login() throws IOException {

    given().
            baseUri(baseUri)
            .formParam("username","HUDIRECTOR")
            .formParam("password","HUDIRECTOR").
            when().
            post("/HUAllocation/login").
            then().statusCode(200);
         //   log.info("Logged in Successfully");
  }


  //Get tha data of all the linkers
  @Test(priority = 2)
  public void getLinkerData(){
    given().
            baseUri(baseUri).
            header("Content-Type","application/json").
            when().
            get("/HUAllocation/linker-data/").
            then().
            statusCode(200)
            .body("id[0]",equalTo(701))
            .body("email[0]",equalTo("edorkins0"));
    // log.info("get all the linker data");


  }

  //Test to get the data of the linker by email
  @Test(priority = 3)
  public void getLinkerDataByEmail(){
   try {
     String userEmail="edorkins68";
     given().
             baseUri(baseUri).
             when().
             get("/HUAllocation/linker-data/"+userEmail).
             then().statusCode(200).
             assertThat().body("email", Is.is(userEmail));

   }catch (Exception e){
     System.out.println("this problem is due to: "+e);
   }

      // log.info("get all the linker data by email verified");
   }

//test to upload linker data file
    //needs to change the data everytime


   @Test(priority = 4)
  public void PostLinkersData(){

      try {
          File file= new File("src/test/java/resources/linkerdata.csv");

          Response response= RestAssured.
                  given().baseUri(baseUri).
                  multiPart("myfile",file).
                  post("/HUAllocation/linkerdata-upload").
                  then().
                  statusCode(200).extract().response();
      }catch (Exception e){
          System.out.println("Error due to :" + e);
      }
       // log.info("upload linker data successful");
   }


//logout
   @Test(priority = 5)
    public void logout(){

       given()
               .baseUri(baseUri).
               contentType("multipart/form-data").
               post("/HUAllocation/logout").
               then().
               statusCode(200);

       // log.info("logout successful");

   }


}
