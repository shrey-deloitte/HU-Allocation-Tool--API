package TrackApis_sam;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.util.Properties;

public class GetTrack {
    //Properties file
    public static Properties prop;
    static {
        try{
            prop = new Properties();
            FileInputStream ip=new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\resources\\getdata.properties");
            prop.load(ip);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

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
    // Track Allocated
    public void Get_Track_Allocated() {
       Response response = requestSpecification.given()
                .when().
                get("/track-allocated").
                then().spec(responseSpecification).statusCode(200).log().status()
                .extract().response();

        JSONArray arr = new JSONArray(response.asString());
        for (int i = 0; i < arr.length(); i++) {
            JSONObject obj = arr.getJSONObject(i);
            assert obj.get("assigned_track") instanceof String;
        }

    }
    // Track email
    @Test(priority = 2)
    public void Get_Track_Email() {
       Response response =  requestSpecification.given()
                .when().
                get("/track-allocated/email/" + prop.getProperty("email")).
                then().spec(responseSpecification).statusCode(200).log().status()
                .extract().response();

        System.out.println(response.getStatusCode());
        ResponseBody body = response.getBody();
        System.out.println(body.asString());

        JSONArray arr = new JSONArray(response.asString());
        for (int i = 0; i < arr.length(); i++) {
            JSONObject obj = arr.getJSONObject(i);
            assert obj.get("email") instanceof String;
        }

    }
    //perform-track-analysis-rate-yes
    @Test(priority = 3)
    public void Get_Perform_Track_YES() {
       Response response= requestSpecification.given()
                .when().
                get("/perform-track-analysis-rate-yes").
                then().spec(responseSpecification).statusCode(200).log().status()
                .extract().response();
        JSONObject obj = new JSONObject(response.asString());
        assert obj.get("message") instanceof String;
        Assert.assertEquals(obj.get("message"),"Done");

    }
    //perform-track-analysis-rate-no
    @Test(priority = 4)
    public void Get_Perform_Track_NO() {
        Response response = requestSpecification.given()
                .when().
                get("/perform-track-analysis-only-rate-no").
                then().spec(responseSpecification).statusCode(200).log().status()
                .extract().response();
        JSONObject obj = new JSONObject(response.asString());
        assert obj.get("message") instanceof String;
        Assert.assertEquals(obj.get("message"),"Done");
    }
    //perform-track-analysis-score-no
    @Test(priority = 5)
    public void Get_Perform_Track_Score() {
      Response response=   requestSpecification.given()
                .when().
                get("/perform-track-analysis-score-no").
                then().spec(responseSpecification).statusCode(200).log().status()
                .extract().response();
        JSONObject obj = new JSONObject(response.asString());
        assert obj.get("message") instanceof String;
        Assert.assertEquals(obj.get("message"),"Done");

    }
    //parallel-track-pref
    @Test(priority = 6)
    public void Get_Parallel_Track() {
        Response response = requestSpecification.given()
                .when().
                get("/parallel-track-pref/email/" + prop.getProperty("email")).
                then().spec(responseSpecification).statusCode(200).extract().response();
        System.out.println(response.getStatusCode());
        ResponseBody body = response.getBody();
        System.out.println(body.asString());

        JSONObject obj = new JSONObject(response.asString());
        assert obj.get("email") instanceof String;
        Assert.assertEquals(obj.get("email"),prop.getProperty("email"));


    }
}