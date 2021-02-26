/*****------------------------------------*******
   @Author: aayush
   @Purpose: data driven framework using by Json;
   @date 25-02-2021
 ***------------------------------------------*******/

package org.bridgelabz;
import com.relevantcodes.extentreports.LogStatus;
import org.bridgelabz.base.Base;
import org.bridgelabz.login.Login;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import java.io.IOException;
import static org.bridgelabz.util.Utility.screenShotsCapture;

public class ApplicationTest extends Base {
    @Test
    public void loginToApplication() throws InterruptedException, IOException {
        Login login = PageFactory.initElements(driver, Login.class);
        login.loginToFacebook();
        test = report.startTest("Login to Application");
        test.log(LogStatus.PASS, "Test Passes");
        test.log(LogStatus.PASS,test.addScreenCapture(screenShotsCapture(driver))+"TestPass");
        screenShotsCapture(driver);
    }
}
