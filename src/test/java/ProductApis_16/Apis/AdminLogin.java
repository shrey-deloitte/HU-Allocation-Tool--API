package ProductApis_16.Apis;

import ProductApis_16.Utils.AdminClass;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.with;

public class AdminLogin {

    private RequestSpecification requestSpecification;
    private ResponseSpecification responseSpecification;
    public String Adminurl;

    public AdminLogin(String url) {
        this.Adminurl = url;

        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri(url).addHeader("Content-Type", "application/json");
        requestSpecification = with().spec(requestSpecBuilder.build());

        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();
        responseSpecBuilder.expectContentType(ContentType.JSON);
        responseSpecification = responseSpecBuilder.build();
    }
    public void LoginAdmin(AdminClass admin){

        Response response = given().spec(requestSpecification)
                .body(admin.getJsonForAdminLogin().toString())
                .post("/login")
                .then()
                //.spec(responseSpecification)
                .extract().response();

        System.out.println("the response code for admin login is "+ response.statusCode());


    }
}
