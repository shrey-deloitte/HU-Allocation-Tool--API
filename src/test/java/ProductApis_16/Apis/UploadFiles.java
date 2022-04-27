package ProductApis_16.Apis;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.with;

public class UploadFiles {

    public String url;

    File productPreference= new File("C:\\Users\\shubhamkumar32\\Downloads\\productpref (1).csv");
    private RequestSpecification requestSpecification;
    private ResponseSpecification responseSpecification;
    List<String>productsNames=new ArrayList<String>();
    String addedProductNames;

    public UploadFiles(String url) {
        this.url = url;
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri(url).addHeader("Content-Type", "multipart/json");
        requestSpecification = with().spec(requestSpecBuilder.build());

        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder();
        responseSpecBuilder.expectContentType(ContentType.JSON);
        responseSpecification = responseSpecBuilder.build();
    }





public void postDetailsOfAllProducts(){

        File productDetailfile = new File("C:\\Users\\shubhamkumar32\\Downloads\\productdetail (1).csv");

    Response response =
            given()

            .multiPart("myfile",productDetailfile,"text/csv")
                    .when()
            .post("https://huallocation-backend-urtjok3rza-wl.a.run.app/HUAllocation/productdetail-upload")
            .thenReturn();

    System.out.println(response.getStatusCode());

}
    public void getAllProductsNames(){
        Response response = given()
                .spec(requestSpecification)
                .when()
                .get("product-detail")
                .then().spec(responseSpecification)
                .extract().response();

        JSONArray arr = new JSONArray(response.asString());
        for (int i = 0; i < arr.length(); i++) {
            JSONObject obj = arr.getJSONObject(i);
            productsNames.add(obj.get("name").toString());
            assert (obj.has("name") && obj.get("name") instanceof String && ((String) obj.get("name")).length()>0);
            assert (obj.has("id") &&obj.get("id") instanceof Integer);
            System.out.println(obj.get("name"));
        }
    }


    @Test
public void verifyProductDetails() throws IOException {


        String file="C:\\Users\\shubhamkumar32\\Downloads\\productdetail (1).csv";

        BufferedReader reader = null;
        int i=0;
        String line= "";
        try{
            reader = new BufferedReader(new FileReader(file));
            while ((line=reader.readLine())!=null){
                String[] row = line.split(",");
               if(i>0){
                  if(productsNames.contains(row[0])){
                      Assert.assertTrue(true);
                  }else{
                      Assert.assertTrue(false);
                  }
               }

                for(String index:row){
                    //System.out.println(index);
                }
                System.out.println();
                i++;

            }

        }catch (Exception e){

        }finally {

        }



}
}
