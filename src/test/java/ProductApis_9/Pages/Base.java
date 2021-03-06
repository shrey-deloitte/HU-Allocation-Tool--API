package ProductApis_9.Pages;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import java.io.FileInputStream;
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

    public void sectionLeadRemarks() {

        //specify Base URI
        RestAssured.baseURI = prop.getProperty("URI");

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


    public void section_Lead_remarks_byEmail(){

        RestAssured.baseURI = prop.getProperty("URI");
        RequestSpecification request = given();

        Response response = request.request(Method.GET,"/section-lead-remarks/"+prop.getProperty("email"));

        //print response in console window
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is: " + responseBody);

        //Status code validation
        int statusCode = response.getStatusCode();
        System.out.println("Status code is: " + statusCode);
        Assert.assertEquals(statusCode,200);

        JSONObject obj = new JSONObject(response.asString());
        assert obj.get("effort") instanceof Integer;
        Assert.assertEquals(obj.get("email"),prop.getProperty("email"));

    }

    public void PreferenceOfLinkerByEmail(){

        RestAssured.baseURI = prop.getProperty("URI");
        RequestSpecification request = given();

        Response response = request.request(Method.GET,"/product-pref/email/"+prop.getProperty("email"));

        //print response in console window
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is: " + responseBody);

        //Status code validation
        int statusCode = response.getStatusCode();
        System.out.println("Status code is: " + statusCode);
        Assert.assertEquals(statusCode,200);

        JSONObject obj = new JSONObject(response.asString());
        assert obj.get("email") instanceof String;
        Assert.assertEquals(obj.get("email"),prop.getProperty("email"));

    }

    public void SingleProductByName() {

        RestAssured.baseURI = prop.getProperty("URI");
        RequestSpecification request = given();

        Response response = request.request(Method.GET,"/product-detail/name/"+prop.getProperty("name"));

        //print response in console window
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is: " + responseBody);

        //Status code validation
        int statusCode = response.getStatusCode();
        System.out.println("Status code is: " + statusCode);
        Assert.assertEquals(statusCode,200);

        JSONObject obj = new JSONObject(response.asString());
        assert obj.get("name") instanceof String;
        Assert.assertEquals(obj.get("name"),prop.getProperty("name"));

    }

    public void ProductDetailById(){

        RestAssured.baseURI = prop.getProperty("URI");
        RequestSpecification request = given();

        int ID = Integer.parseInt(prop.getProperty("id"));
        Response response = request.request(Method.GET,"/product-detail/id/"+prop.getProperty("id"));

        //print response in console window
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is: " + responseBody);

        //Status code validation
        int statusCode = response.getStatusCode();
        System.out.println("Status code is: " + statusCode);
        Assert.assertEquals(statusCode,200);

        JSONObject obj = new JSONObject(response.asString());
        assert obj.get("name") instanceof String;
        Assert.assertEquals(obj.getInt("id"),ID);

    }

    public void AllLinkerWithFirstPreftrack(){

        RestAssured.baseURI = prop.getProperty("URI");
        RequestSpecification request = given();

        Response response = request.request(Method.GET,"/product-pref/preference/"+prop.getProperty("1_preference"));

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
            assert obj.get("email") instanceof String;
            Assert.assertEquals(obj.get("preference_1"), prop.getProperty("1_preference"));
        }

    }

    public void ProductAllocatedToAllLinkers(){

        RestAssured.baseURI = prop.getProperty("URI");
        RequestSpecification request = given();

        Response response = request.request(Method.GET,"/product-allocated");

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
            assert obj.get("name") instanceof String;
            assert obj.get("islead") instanceof String;
            assert obj.get("id") instanceof Integer;
        }

    }

    public void ProductAllocatedToLinkerByEmail(){

        RestAssured.baseURI = prop.getProperty("URI");
        RequestSpecification request = given();

        Response response = request.request(Method.GET,"/product-allocated/email/"+prop.getProperty("email"));

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
            assert obj.get("name") instanceof String;
            assert obj.get("islead") instanceof String;
            assert obj.get("id") instanceof Integer;
        }
//        Assert.assertEquals(arr.get(0),prop.getProperty("email"));

    }
}