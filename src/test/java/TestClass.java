
import Operation.getTaskOperation;

import Operation.postTaskOperation;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Listener.class)
public class TestClass {
    Logger log = extentController.log;
    ExtentReports extent = extentController.extent;
    @Test (priority = 1)
    void notificationcheck() {
        ExtentTest regUserTest = extent.createTest("CHECKING NOTIFICATION");
        getTaskOperation op = new getTaskOperation(extentController.baseUrl+"/notification",  regUserTest,extentController.log);
        assert (op.checknotify()==true);
    }
    @Test (priority = 2)
    void getTrackResAllcheck() {
        ExtentTest regUserTest = extent.createTest("17. Get track results of all linkers");
        getTaskOperation op = new getTaskOperation(extentController.baseUrl+"/track-result",  regUserTest,extentController.log);
        assert (op.getTrackResAll()==true);
    }
    @Test (priority = 3)
    void getTrackResEmailcheck() {
        ExtentTest regUserTest = extent.createTest("18. Get result of a particular linker by email.");
        getTaskOperation op = new getTaskOperation(extentController.baseUrl+"/track-result/",  regUserTest,extentController.log);
        assert (op.getTrackResEmail()==true);
    }
    @Test (priority = 4)
    void getTrackAllocationAllcheck() {
        ExtentTest regUserTest = extent.createTest("19. Get all the tracks allocated to linkers.");
        getTaskOperation op = new getTaskOperation(extentController.baseUrl+"/track-allocated",  regUserTest,extentController.log);
        assert (op.getTrackAllocationAll()==true);
    }
    @Test (priority = 5)
    void getTrackAllocationEmailcheck() {
        ExtentTest regUserTest = extent.createTest("20. Get track allocated to a particular linker through email.");
        getTaskOperation op = new getTaskOperation(extentController.baseUrl+"/track-allocated/email/",  regUserTest,extentController.log);
        assert (op.getTrackAllocationEmail()==true);
    }
    @Test (priority = 6)
    void getInOneTrackAllcheck() {
        ExtentTest regUserTest = extent.createTest("21. Get all the linkers in a particular track.");
        getTaskOperation op = new getTaskOperation(extentController.baseUrl+"/track-allocated/track/Advance%20Angular",  regUserTest,extentController.log);
        assert (op.getInOneTrackAll()==true);
    }
    @Test (priority = 6)
    void postParallelTrackPrefcheck() {
        ExtentTest regUserTest = extent.createTest("22. Post parallel track preference");
        postTaskOperation op = new postTaskOperation(extentController.baseUrl+"/parallelpref-upload",  regUserTest,extentController.log);
        assert (op.postParallelTrackPref()==true);
    }
    @Test (priority = 7)
    void postSectionLeadRemarkcheck() {
        ExtentTest regUserTest = extent.createTest("23. Post section lead remark");
        postTaskOperation op = new postTaskOperation(extentController.baseUrl+"/sectionlead-upload",  regUserTest,extentController.log);
        assert (op.postSectionLeadRemark()==true);
    }
    @Test (priority = 8)
    void postTrackResultcheck() {
        ExtentTest regUserTest = extent.createTest("24. Post track result");
        postTaskOperation op = new postTaskOperation(extentController.baseUrl+"/trackresult-upload",  regUserTest,extentController.log);
        assert (op.postTrackResult()==true);
    }
    @Test (priority = 9)
    void postParallelTrackcheck() {
        ExtentTest regUserTest = extent.createTest("25. Post parallel track details");
        postTaskOperation op = new postTaskOperation(extentController.baseUrl+"/paralleltrack-upload",  regUserTest,extentController.log);
        assert (op.postParallelTrack()==true);
    }
    @Test (priority = 10)
    void getRatingBasedAllocationcheck() {
        ExtentTest regUserTest = extent.createTest("26. Track allocated on basis of ratings");
        getTaskOperation op = new getTaskOperation(extentController.baseUrl+"/perform-track-analysis-rate-no",  regUserTest,extentController.log);
        assert (op.getRatingBasedAllocation()==true);
    }
    @Test (priority = 11)
    void getRatingAndEffortBasedAllocationcheck() {
        ExtentTest regUserTest = extent.createTest("27. Track allocated on basis of ratings and effort");
        getTaskOperation op = new getTaskOperation(extentController.baseUrl+"/perform-track-analysis-rate-yes",  regUserTest,extentController.log);
        assert (op.getRatingAndEffortBasedAllocation()==true);
    }
    @Test (priority = 12)
    void getOnlyRatingBasedAllocationcheck() {
        ExtentTest regUserTest = extent.createTest("28. Track allocated on basis of only ratings");
        getTaskOperation op = new getTaskOperation(extentController.baseUrl+"/perform-track-analysis-only-rate-no",  regUserTest,extentController.log);
        assert (op.getOnlyRatingBasedAllocation()==true);
    }
    @Test (priority = 13)
    void getOnlyRatingAndEffortBasedAllocationcheck() {
        ExtentTest regUserTest = extent.createTest("29. Track allocated on basis of only ratings and effort");
        getTaskOperation op = new getTaskOperation(extentController.baseUrl+"/perform-track-analysis-only-rate-yes",  regUserTest,extentController.log);
        assert (op.getOnlyRatingAndEffortBasedAllocation()==true);
    }


}