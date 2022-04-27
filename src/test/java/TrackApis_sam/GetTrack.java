package TrackApis_sam;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class GetTrack {
    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;

    @BeforeClass
    public void setup() {
        String BaseURI = "https://huallocation-backend-urtjok3rza-wl.a.run.app/HUAllocation";
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri(BaseURI).addHeader("Content-Type", "application/json");
        requestSpecification = RestAssured.with().spec(requestSpecBuilder.build());
        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder().expectContentType(ContentType.JSON);
        responseSpecification = responseSpecBuilder.build();
    }

    @Test(priority = 1)
    public void Get_Track_Allocated() {
        requestSpecification.given()
                .when().
                get("/track-allocated").
                then().spec(responseSpecification).statusCode(200).log().status()
                .extract().response();
    }
    @Test(priority = 2)
    public void Get_Track_Email() {
        requestSpecification.given()
                .when().
                get("/track-allocated/email/jtrembath1i").
                then().spec(responseSpecification).statusCode(200).log().status()
                .extract().response();

    }
    @Test(priority = 3)
    public void Get_Perform_Track_YES() {
        requestSpecification.given()
                .when().
                get("/perform-track-analysis-rate-yes").
                then().spec(responseSpecification).statusCode(200).log().status()
                .extract().response();

    }
}