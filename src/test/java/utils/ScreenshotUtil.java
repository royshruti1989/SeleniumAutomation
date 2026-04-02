package utils;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
 
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
 
public class ScreenshotUtil {
 
    public static String capture(WebDriver driver, String testName) {
 
        String timeStamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
 
        String folderPath = "test-output/screenshots/";
        String fileName = testName + "_" + timeStamp + ".png";
        String fullPath = folderPath + fileName;
 
        try {
            File source = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.FILE);
 
            File destination = new File(fullPath);
            destination.getParentFile().mkdirs();
 
            Files.copy(source.toPath(),
                    destination.toPath(),
                    StandardCopyOption.REPLACE_EXISTING);
 
        } catch (IOException e) {
            e.printStackTrace();
        }
 
        return "screenshots/" + fileName;
    }
}