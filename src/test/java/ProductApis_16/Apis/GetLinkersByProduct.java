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

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.with;

public class GetLinkersByProduct {

    private RequestSpecification requestSpecification;
    private ResponseSpecification responseSpecification;

    public String url;

    List<String> linkersName = new ArrayList<String>();

    public GetLinkersByProduct(String url) {
        this.url = url;

        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri(url).addHeader("Content-Type", "application/json");
        requestSpecification = with().spec(requestSpecBuilder.build());

        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();
        responseSpecBuilder.expectContentType(ContentType.JSON);
        responseSpecification = responseSpecBuilder.build();
    }

    public void getLinkersByProduct() {
        Response response = given()
                .spec(requestSpecification)
                .when()
                .get("product-allocated/product/GHOUSE")
                .then().spec(responseSpecification)
                .extract().response();

        assert (response.getStatusCode() == 200);
        assert (response.getContentType().contains("json"));
        JSONArray arr = new JSONArray(response.asString());

        for (int i = 0; i < arr.length(); i++) {
            JSONObject obj = arr.getJSONObject(i);
            linkersName.add(obj.get("name").toString());
            assert (obj.has("name") && obj.get("name") instanceof String && ((String) obj.get("name")).length() > 0);
            assert (obj.has("id") && obj.get("id") instanceof Integer);
            assert (obj.has("product") && obj.get("product") instanceof String && (((String) obj.get("product")).length() > 0));
            assert (obj.has("islead") && obj.get("islead") instanceof String && (obj.get("islead").equals("Yes") || obj.get("islead").equals("No")));
        }
        for (String str : linkersName) {
            System.out.println(str);
        }
    }
}
