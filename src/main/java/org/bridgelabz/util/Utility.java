package org.bridgelabz.util;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonParser.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.*;
import java.util.Iterator;


public class Utility {
    public static String screenShotsCapture(WebDriver driver) throws IOException {
        //1. take screenShots and store it as file format;
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        File file = new File("src/../applicationImage/" + System.currentTimeMillis() + ".jpg");
        String fileAbsolutePath = file.getAbsolutePath();
        FileUtils.copyFile(screenshot, file);
        return fileAbsolutePath;
    }
    public static  String[] readjsonFile() throws FileNotFoundException {
        FileReader fileReader = new FileReader("C:\\Users\\ankit\\Desktop" +
                "\\jsonDataDrivenFrameWork\\src\\test\\resources\\Data.json");

        Object jsnelement = JsonParser.parseReader(fileReader);
        JsonObject jsonObject = (JsonObject) jsnelement;

        JsonArray jsonArray = (JsonArray)jsonObject.get("userlogins");
        String userArray[] = new String[jsonArray.size()];

        for (int index =0;index<jsonArray.size();index++){
            JsonObject users = (JsonObject) jsonArray.get(index);
            String user = String.valueOf(users.get("username")) ;
            String pwd = String.valueOf(users.get("password"));
           System.out.println(user);

            userArray[index] = user+ ","+pwd;
        }

        return userArray;
    }


}
