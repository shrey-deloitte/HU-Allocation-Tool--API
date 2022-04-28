package Operation;

import com.aventstack.extentreports.ExtentTest;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

import static io.restassured.RestAssured.given;

public class getTaskOperation {
    private RequestSpecification requestSpecification;
    private ResponseSpecification responseSpecification;
    private List<String> tasks;
    private JSONArray tasksJsonArray;
    public String token="1e3fbfc04d510423f16db6b1976f8d49a339e4e486ef5006ebe118b552a2a32", baseUrl;
    public ExtentTest test;
    public Logger log;
    public static String key="";

    public static JSONObject getTrackResJSON() {
        return TrackResJSON;
    }



    public static JSONObject getTrackAllocationJSON() {
        return TrackAllocationJSON;
    }


    public static JSONObject TrackResJSON;
    public static JSONObject TrackAllocationJSON;


    public getTaskOperation(String baseUrl, ExtentTest test, Logger log) {
        RestAssured.useRelaxedHTTPSValidation();
        if (baseUrl.endsWith("/")){
            this.baseUrl=baseUrl+key;
            System.out.println(this.baseUrl);
        }
        else{
        this.baseUrl = baseUrl;
        }
        this.test = test;
        this.log = log;
        RestAssured.baseURI=this.baseUrl;
        requestSpecification = RestAssured.given();
        RequestSpecBuilder reqBuilder = new RequestSpecBuilder();
        reqBuilder.setBaseUri(this.baseUrl).addHeader("Content-Type", "application/json");
        requestSpecification = RestAssured.with().spec(reqBuilder.build());

        ResponseSpecBuilder resBuilder = new ResponseSpecBuilder();
        resBuilder.expectContentType(ContentType.JSON);
        responseSpecification = resBuilder.build();
    }

    public boolean checknotify() {
        test.info("Getting users data from , " + baseUrl);
        log.info("Getting users data from , " + baseUrl);
        // start HTTP GET to get an entry
        try{
            Response response=given().spec(requestSpecification)
                    .when().get().then().spec(responseSpecification)
                    .extract().response();

            if(response.getStatusCode()!=200){
                log.debug("Failed to Fetch data");
                test.fail("Request Failed");
                return false;
            }
            System.out.println(response.asString());
            log.debug(response.asString());
            log.info("Fetched data");
            test.pass("Successfully fetched JSON ");
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return true;
    }

    public boolean getTrackResAll() {
        test.info("Get track results of all linkers data from , " + baseUrl);
        log.info("Get track results of all linkers data from , " + baseUrl);
        // start HTTP GET to get an entry
        try{
            Response response=given().spec(requestSpecification)
                    .when().get().then().spec(responseSpecification)
                    .extract().response();

            if(response.getStatusCode()!=200){
                log.debug("Failed to Fetch data");
                test.fail("Request Failed");
                return false;
            }
            JSONArray ja = new JSONArray(response.asString());
            JSONObject jo=ja.getJSONObject(0);
            TrackResJSON=ja.getJSONObject(ja.length()-1);
            key=jo.getString("email");
            System.out.println(response.asString());
            log.info(response.asString());
            test.info(response.asString());
            log.debug("Fetched data");
            test.pass("Successfully fetched JSON ");
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return true;
    }

    public boolean getTrackResEmail() {
        test.info("Get result of a particular linker by email data from , " + baseUrl);
        log.info("Get result of a particular linker by email data from , " + baseUrl);
        // start HTTP GET to get an entry
        try{
            Response response=given().spec(requestSpecification)
                    .when().get().then().spec(responseSpecification)
                    .extract().response();
            System.out.println(response);
            if(response.getStatusCode()!=200){
                log.debug("Failed to Fetch data");
                test.fail("Request Failed");
                return false;
            }
            System.out.println(response.asString());
            log.info(response.asString());
            test.info(response.asString());
            log.debug("Fetched data");
            test.pass("Successfully fetched JSON ");
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return true;
    }

    public boolean getTrackAllocationAll() {
        test.info("Get all the tracks allocated to linkers. data from , " + baseUrl);
        log.info("Get all the tracks allocated to linkers. data from , " + baseUrl);
        // start HTTP GET to get an entry
        try{
            Response response=given().spec(requestSpecification)
                    .when().get().then().spec(responseSpecification)
                    .extract().response();

            if(response.getStatusCode()!=200){
                log.debug("Failed to Fetch data");
                test.fail("Request Failed");
                return false;
            }
            JSONArray ja = new JSONArray(response.asString());
            JSONObject jo=ja.getJSONObject(0);
            TrackAllocationJSON=ja.getJSONObject(ja.length()-1);
            key=jo.getString("email");
            System.out.println(response.asString());
            log.info(response.asString());
            test.info(response.asString());
            log.debug("Fetched data");
            test.pass("Successfully fetched JSON ");
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return true;
    }

    public boolean getTrackAllocationEmail() {
        test.info("Get track allocated to a particular linker through email data from , " + baseUrl);
        log.info("Get track allocated to a particular linker through email data from , " + baseUrl);
        // start HTTP GET to get an entry
        try{
            Response response=given().spec(requestSpecification)
                    .when().get().then().spec(responseSpecification)
                    .extract().response();

            if(response.getStatusCode()!=200){
                log.debug("Failed to Fetch data");
                test.fail("Request Failed");
                return false;
            }
            System.out.println(response.asString());
            log.info(response.asString());
            test.info(response.asString());
            log.debug("Fetched data");
            test.pass("Successfully fetched JSON ");
        }
        catch (Exception e) {

            System.out.println(e);
            return false;
        }
        return true;
    }

    public boolean getInOneTrackAll() {
        test.info("Get all linkers in particular track data from , " + baseUrl);
        log.info("Get all linkers in particular track data from , " + baseUrl);
        // start HTTP GET to get an entry
        try{
            Response response=given().spec(requestSpecification)
                    .when().get().then().spec(responseSpecification)
                    .extract().response();

            if(response.getStatusCode()!=200){
                log.debug("Failed to Fetch data");
                test.fail("Request Failed");
                return false;
            }

            System.out.println(response.asString());
            log.info(response.asString());
            test.info(response.asString());
            log.debug("Fetched data");
            test.pass("Successfully fetched JSON ");
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return true;
    }


    public boolean getRatingBasedAllocation() {
        test.info("Track allocated on basis of ratings data from , " + baseUrl);
        log.info("Track allocated on basis of ratings data from , " + baseUrl);
        // start HTTP GET to get an entry
        try{
            Response response=given().spec(requestSpecification)
                    .when().get().then().spec(responseSpecification)
                    .extract().response();

            if(response.getStatusCode()!=200){
                log.debug("Failed to Fetch data");
                test.fail("Request Failed");
                return false;
            }

            System.out.println(response.asString());
            log.info(response.asString());
            test.info(response.asString());
            log.debug("Fetched data");
            test.pass("Successfully fetched JSON ");
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return true;
    }

    public boolean getRatingAndEffortBasedAllocation() {
        test.info("Track allocated on basis of rating and effort data from , " + baseUrl);
        log.info("Track allocated on basis of rating and effort data from , " + baseUrl);
        // start HTTP GET to get an entry
        try{
            Response response=given().spec(requestSpecification)
                    .when().get().then().spec(responseSpecification)
                    .extract().response();

            if(response.getStatusCode()!=200){
                log.debug("Failed to Fetch data");
                test.fail("Request Failed");
                return false;
            }

            System.out.println(response.asString());
            log.info(response.asString());
            test.info(response.asString());
            log.debug("Fetched data");
            test.pass("Successfully fetched JSON ");
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return true;
    }

    public boolean getOnlyRatingBasedAllocation() {
        test.info("Track allocated on basis of only ratings data from , " + baseUrl);
        log.info("Track allocated on basis of only ratings data from , " + baseUrl);
        // start HTTP GET to get an entry
        try{
            Response response=given().spec(requestSpecification)
                    .when().get().then().spec(responseSpecification)
                    .extract().response();

            if(response.getStatusCode()!=200){
                log.debug("Failed to Fetch data");
                test.fail("Request Failed");
                return false;
            }

            System.out.println(response.asString());
            log.info(response.asString());
            test.info(response.asString());
            log.debug("Fetched data");
            test.pass("Successfully fetched JSON ");
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return true;
    }

    public boolean getOnlyRatingAndEffortBasedAllocation() {
        test.info("Track allocated on basis of only ratings and effort data from , " + baseUrl);
        log.info("Track allocated on basis of only ratings and effort data from , " + baseUrl);
        // start HTTP GET to get an entry
        try{
            Response response=given().spec(requestSpecification)
                    .when().get().then().spec(responseSpecification)
                    .extract().response();

            if(response.getStatusCode()!=200){
                log.debug("Failed to Fetch data");
                test.fail("Request Failed");
                return false;
            }

            System.out.println(response.asString());
            log.info(response.asString());
            test.info(response.asString());
            log.debug("Fetched data");
            test.pass("Successfully fetched JSON ");
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return true;
    }
}


