package org.bridgelabz.login;
import org.bridgelabz.base.Base;
import org.bridgelabz.util.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import java.io.FileNotFoundException;


public class Login extends Base {
    @FindBy(xpath = "//INPUT[@id='email']")
    WebElement emailId;
    @FindBy(how= How.XPATH , using = "//INPUT[@id='pass']")
    WebElement emailPassword;
    @FindBy(how = How.XPATH,using = "//BUTTON[@id='loginbutton']")
    WebElement loginbutton;


    public Login(WebDriver driver) {
        this.driver = driver;
    }

    public void loginToFacebook() throws InterruptedException, FileNotFoundException {
        String  []user = Utility.readjsonFile();
        String usernamePwd = user[0];
        System.out.println(user[0]);
        String PwdArray[] =usernamePwd.split(",");
        String email = PwdArray[0];
        String pwd = PwdArray[1];
        String useremail= email.substring(1,email.length()-1);
        String userpwd =pwd.substring(1,pwd.length()-1);

        emailId.sendKeys(useremail);
        Thread.sleep(1000);
        emailPassword.sendKeys(userpwd);
        Thread.sleep(2000);
        loginbutton.click();
        Thread.sleep(1000);
    }
}
