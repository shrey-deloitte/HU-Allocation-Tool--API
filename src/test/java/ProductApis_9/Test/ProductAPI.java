package ProductApis_9.Test;

import ProductApis_9.Pages.Base;
import org.testng.annotations.Test;

public class ProductAPI {

    //specify Base URI
    public static String baseURI = "https://huallocation-backend-urtjok3rza-wl.a.run.app/HUAllocation";
    public Base base = new Base();

    //All Section Lead Remarks
    @Test(priority = 1)
    void all_section_lead_remarks() {
        base.sectionLeadRemarks();
    }

    //Section Lead Remarks by E-mail
    @Test(priority = 2)
    void SectionLeadRemarks_byEmail() {
        base.section_Lead_remarks_byEmail();
    }

    //Preference of linker by Email
    @Test(priority = 3)
    void Preferences_of_linker_by_email() {
        base.PreferenceOfLinkerByEmail();
    }

    //Single product detail by Name
    @Test(priority = 4)
    void Single_product_by_name(){
        base.SingleProductByName();
    }

    //Product details by ID
    @Test(priority = 5)
    void Product_details_by_id(){
        base.ProductDetailById();
    }

    //All the linkers with a particular track as first preference
    @Test(priority = 6)
    void All_linkers_with_first_pref_Track(){
        base.AllLinkerWithFirstPreftrack();
    }

    //Product Allocated to all linkers
    @Test(priority = 7)
    void Product_allocated_to_all_linkers(){
        base.ProductAllocatedToAllLinkers();
    }

    //Product allocated to a linker by email
    @Test(priority = 8)
    void Product_allocated_to_linker_byEmail(){
        base.ProductAllocatedToLinkerByEmail();
    }

}