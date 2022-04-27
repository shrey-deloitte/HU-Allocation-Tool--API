package ProductApis_16;


import ProductApis_16.Apis.AdminLogin;
import ProductApis_16.Apis.GetLinkersByProduct;
import ProductApis_16.Apis.ProductDetails;

import ProductApis_16.Apis.UploadFiles;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static io.restassured.RestAssured.given;

public class testClass {

    ExtentHtmlReporter htmlReporter;
    ExtentReports extent;


    @BeforeSuite
    public void setExtents() {

        // start reporters
        htmlReporter = new ExtentHtmlReporter("extent.html");

        // create ExtentReports and attach reporter(s)
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    @Test(priority = 1)
    public void getProductDetails() throws IOException {

        ExtentTest test = extent.createTest("get Product Detail", "Fetch all Product Details");
        ProductDetails productDetails = new ProductDetails(baseClass.baseUrl);
        productDetails.getAllProductDetail();

    }

    @Test(priority = 2)
    public void postProductDetail() {
        ProductDetails productDetails = new ProductDetails(baseClass.baseUrl);
        productDetails.postProductDetails();
    }

    @Test(priority = 3)
    public void getLinkersNameByprod() {
        GetLinkersByProduct getLinkersByProduct = new GetLinkersByProduct(baseClass.baseUrl);
        getLinkersByProduct.getLinkersByProduct();
    }
    @Test(priority = 4)
    public void postDetailsOfAllProduct() {
        UploadFiles uploadFiles =new UploadFiles(baseClass.baseUrl);
        uploadFiles.postDetailsOfAllProducts();

    }
    @Test(priority = 5)
    public void getAllProductsName(){
        UploadFiles uploadFiles =new UploadFiles(baseClass.baseUrl);
        uploadFiles.getAllProductsNames();
    }
    @Test(priority = 6)
    public void verifyProductDetail() throws IOException {
        UploadFiles uploadFiles =new UploadFiles(baseClass.baseUrl);
        uploadFiles.postDetailsOfAllProducts();
        uploadFiles.getAllProductsNames();
        uploadFiles.verifyProductDetails();
    }

}
