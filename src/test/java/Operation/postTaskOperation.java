package Operation;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.logging.log4j.Logger;

import static io.restassured.RestAssured.given;

public class postTaskOperation {
    ExtentTest test;
    Logger log;
    String baseUrl;
    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;
    public postTaskOperation(String baseUrl,ExtentTest test, Logger log ) {
        RestAssured.useRelaxedHTTPSValidation();
        this.test = test;
        this.log = log;
        this.baseUrl = baseUrl;
        System.out.println(baseUrl);

        RequestSpecBuilder reqBuilder = new RequestSpecBuilder();
        reqBuilder.setBaseUri(baseUrl).addHeader("Content-Type", "application/json");
        requestSpecification = RestAssured.with().spec(reqBuilder.build());

        ResponseSpecBuilder resBuilder = new ResponseSpecBuilder();
        //resBuilder.expectContentType(ContentType.JSON);
        responseSpecification = resBuilder.build();
    }
    public boolean postParallelTrackPref() {
        log.info("Post parallel track preference");
        test.info("Post parallel track preference");
        String bdy=getTaskOperation.getTrackAllocationJSON().toString();
        test.debug(bdy);
        try{
            Response response = given().spec(requestSpecification).body(bdy).post().then().
                    spec(responseSpecification).extract().response();


            if (response.getStatusCode()!=201){
                log.debug("Request Failed");
                test.info("Status Code: "+String.valueOf(response.getStatusCode()));
                test.fail("Request Failed");
                return false;
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        log.info("Post parallel track preference registered");
        test.log(Status.PASS, "Post parallel track preference registered");
        return true;
    }

    public boolean postSectionLeadRemark() {
        log.info("Post section lead remark");
        test.info("Post section lead remark");
        String bdy=getTaskOperation.getTrackAllocationJSON().toString();
        test.debug(bdy);
        try{
            Response response = given().spec(requestSpecification).body(bdy).post().then().
                    spec(responseSpecification).extract().response();


            if (response.getStatusCode()==400){
                log.debug("Request Failed");
                test.info("Status Code: "+String.valueOf(response.getStatusCode()));
                test.fail("Request Failed");
                return false;
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        log.info("Post section lead remark registered");
        test.log(Status.PASS, "Post section lead remark registered");
        return true;
    }

    public boolean postTrackResult() {
        log.info("Post track result");
        test.info("Post track result");
        String bdy=getTaskOperation.getTrackResJSON().toString();
        test.debug(bdy);
        try{
            Response response = given().spec(requestSpecification).body(bdy).post().then().
                    spec(responseSpecification).extract().response();


            if (response.getStatusCode()==400){
                log.debug("Request Failed");
                test.info("Status Code: "+String.valueOf(response.getStatusCode()));
                test.fail("Request Failed");
                return false;
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        log.info("Post track result registered");
        test.log(Status.PASS, "Post track result registered");
        return true;
    }

    public boolean postParallelTrack() {
        log.info("Post parallel track details");
        test.info("Post parallel track details");
        String bdy=getTaskOperation.getTrackAllocationJSON().toString();
        test.debug(bdy);
        try{
            Response response = given().spec(requestSpecification).body(bdy).post().then().
                    spec(responseSpecification).extract().response();


            if (response.getStatusCode()==400){
                log.debug("Request Failed");
                test.info("Status Code: "+String.valueOf(response.getStatusCode()));
                test.fail("Request Failed");
                return false;
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        log.info("Post parallel track details registered");
        test.log(Status.PASS, "Post parallel track details registered");
        return true;
    }
}

