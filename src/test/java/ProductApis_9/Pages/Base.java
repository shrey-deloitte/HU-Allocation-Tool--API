package ProductApis_9.Pages;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class Base {

    public static Properties prop;
    static {
        try{
            prop = new Properties();
            FileInputStream ip=new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\resources\\source.properties");
            prop.load(ip);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sectionLeadRemarks() throws IOException {

        //specify Base URI
        RestAssured.baseURI = "https://huallocation-backend-urtjok3rza-wl.a.run.app/HUAllocation";

        //Request object
        RequestSpecification request = given();

        //Response object
        Response response = request.request(Method.GET,"/section-lead-remarks");

        //print response in console window
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is: " + responseBody);

        //Status code validation
        int statusCode = response.getStatusCode();
        System.out.println("Status code is: " + statusCode);
        Assert.assertEquals(statusCode,200);

        JSONArray arr = new JSONArray(response.asString());
        for (int i = 0; i < arr.length(); i++) {
            JSONObject obj = arr.getJSONObject(i);
            assert obj.get("effort") instanceof Integer;
        }
    }


    public void section_Lead_remarks_byEmail() throws IOException {

        //specify Base URI
        RestAssured.baseURI = "https://huallocation-backend-urtjok3rza-wl.a.run.app/HUAllocation";

        //Request object
        RequestSpecification request = given();

//        String email = prop.getProperty("email");
//        System.out.println(email);
        //Response object
        Response response = request.request(Method.GET,"/section-lead-remarks/"+prop.getProperty("email"));

        //print response in console window
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is: " + responseBody);

        //Status code validation
        int statusCode = response.getStatusCode();
        System.out.println("Status code is: " + statusCode);
        Assert.assertEquals(statusCode,200);

        /*JSONArray arr = new JSONArray(response.asString());
        for (int i = 0; i < arr.length(); i++) {
            JSONObject obj = arr.getJSONObject(i);
            assert obj.get("effort") instanceof Integer;
        }*/
    }
}
