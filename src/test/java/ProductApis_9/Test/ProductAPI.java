package ProductApis_9.Test;

import ProductApis_9.Pages.Base;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static io.restassured.RestAssured.given;

public class ProductAPI {

    //specify Base URI
    public static String baseURI = "https://huallocation-backend-urtjok3rza-wl.a.run.app/HUAllocation";
    public Base base = new Base();

    @Test(priority = 1)
    void all_section_lead_remarks() throws IOException {
        base.sectionLeadRemarks();

//            Response response = given().spec(request).
//                    get("/section-lead-remarks").then().spec(resSpec).extract().response();
//        int statusCode = response.getStatusCode();
//
//        Assert.assertEquals(statusCode,200);
//
//            JSONArray jsonArray = new JSONArray(response.asString());
//            System.out.println(jsonArray.length());
        }

        //Section Lead Remarks by E-mail
    @Test(priority = 2)
    void SectionLeadRemarks_byEmail() throws IOException{
        base.section_Lead_remarks_byEmail();
    }
    }