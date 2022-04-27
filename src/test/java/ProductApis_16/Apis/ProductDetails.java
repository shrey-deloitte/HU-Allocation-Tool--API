package ProductApis_16.Apis;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.with;

public class ProductDetails {
    private RequestSpecification requestSpecification;
    private ResponseSpecification responseSpecification;

    public String url;
    public Logger logger;
    List<String> productsName = new ArrayList<String>();

    public ProductDetails(String url) {
        this.url = url;

        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri(url).addHeader("Content-Type", "application/json");
        requestSpecification = with().spec(requestSpecBuilder.build());

        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();
        responseSpecBuilder.expectContentType(ContentType.JSON);
        responseSpecification = responseSpecBuilder.build();
    }

    public void getAllProductDetail() {

        Response response = given().spec(requestSpecification)
                .when()
                .get("/product-detail")
                .then().spec(responseSpecification)
                .extract().response();

        assert (response.getStatusCode() == 200);
        assert (response.getContentType().contains("json"));
        JSONArray arr = new JSONArray(response.asString());

        for (int i = 0; i < arr.length(); i++) {
            JSONObject obj = arr.getJSONObject(i);
            productsName.add(obj.get("name").toString());
            assert (obj.get("name") instanceof String);
            assert (obj.get("description") instanceof String && (((String) obj.get("description")).length() > 0));
        }
        for (String str : productsName) {
            System.out.println(str);
        }
    }

}
