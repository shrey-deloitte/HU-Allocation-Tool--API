package ProductApis_16.Apis;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.json.JSONObject;

import java.io.Reader;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.with;

public class ProductsAllocated {
    private RequestSpecification requestSpecification;
    private ResponseSpecification responseSpecification;
    public String url;

    public ProductsAllocated(String url) {
        this.url = url;

        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri(url).addHeader("Content-Type", "application/json");
        requestSpecification = with().spec(requestSpecBuilder.build());

        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();
        responseSpecBuilder.expectContentType(ContentType.JSON).expectStatusCode(200);
        responseSpecification = responseSpecBuilder.build();
    }

    public void ProductAllocatedBasedOnScore() {
        Response response = given()
                .spec(requestSpecification)
                .when()
                .get("/perform-product-analysis-score")
                .then()
                .spec(responseSpecification)
                .extract().response();

        JSONObject object = new JSONObject(response.asString());
        assert (object.get("message").equals("Done"));
    }

    public void ProductAllocatedBasedOnRatings() {

        Response response = given()
                .spec(requestSpecification)
                .when()
                .get("/perform-product-analysis-rate")
                .then()
                .spec(responseSpecification)
                .extract().response();

        JSONObject object = new JSONObject(response.asString());
        assert (object.get("message").equals("Done"));
    }

    public void ProductAllocatedBasedOnOnlyRatings() {

        Response response = given()
                .spec(requestSpecification)
                .when()
                .get("/perform-product-analysis-only-rate")
                .then()
                .spec(responseSpecification)
                .extract().response();

        JSONObject object = new JSONObject(response.asString());
        assert (object.get("message").equals("Done"));
    }
}
