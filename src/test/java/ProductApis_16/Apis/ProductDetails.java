package ProductApis_16.Apis;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.Test;
import java.util.Iterator;
import java.io.File;
import java.io.FileReader;
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

        RestAssured.baseURI="https://huallocation-backend-urtjok3rza-wl.a.run.app/HUAllocation";
        System.out.println("inside cons of producct details");

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
            assert (obj.get("description") instanceof String  );
        }
        for (String str : productsName) {
            System.out.println(str);
        }
    }




    @Test
    public void postProductDetails(){
        File jsonData = new File("C:\\Users\\shubhamkumar32\\IdeaProjects\\HU-Allocation-Tool--API\\src\\test\\java\\resources\\productDetails.json");
//


        System.out.println("url is "+url);
        Response response = given()

                .header("Content-type", "application/json")
                .and()
                        .body(jsonData)
                                .when()
                                        .post("/product-detail")
                                                .then()

                                                        .extract().response();


        System.out.println(response.getStatusCode());
        assert (response.getStatusCode() == 201);
       JSONObject object = new JSONObject(response.asString());
        assert (object.get("name").equals("newproduct_shubham")
                && object.get("description").equals("Wow! amazing Product1 added by shubham"));
    }

}
