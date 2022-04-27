package ProductApis_16;


import ProductApis_16.Apis.AdminLogin;
import ProductApis_16.Apis.GetLinkersByProduct;
import ProductApis_16.Apis.ProductDetails;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.IOException;

public class testClass {

    ExtentHtmlReporter htmlReporter;
    ExtentReports extent;


    @BeforeSuite
    public void setExtents(){

        // start reporters
        htmlReporter = new ExtentHtmlReporter("extent.html");

        // create ExtentReports and attach reporter(s)
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    @Test(priority = 1)
    public void getProductDetails() throws IOException {

        ExtentTest test = extent.createTest("get Product Detail", "Fetch all Product Details");
        ProductDetails productDetails =new ProductDetails(baseClass.baseUrl);
        productDetails.getAllProductDetail();

    }
    @Test(priority = 2)
    public void getLinkersNameByprod(){
        GetLinkersByProduct getLinkersByProduct = new GetLinkersByProduct(baseClass.baseUrl);
        getLinkersByProduct.getLinkersByProduct();
    }

}
