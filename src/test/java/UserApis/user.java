package UserApis;

import com.google.gson.Gson;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class user {

  String baseUri="https://huallocation-backend-urtjok3rza-wl.a.run.app";


  @Test
  public  void login() throws IOException {

    given().

            baseUri(baseUri)
            .formParam("username","HUDIRECTOR")
            .formParam("password","HUDIRECTOR").
            when().
            post("/HUAllocation/login").
            then().statusCode(200);
  }

  @Test
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

  }


}
