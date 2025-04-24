package Tests;

import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SeleniumTest {
    WebDriver driver;

    @BeforeClass
    public void beforeAll(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void testing(){
        driver.get("http://localhost:3000");
        driver.findElement(By.linkText("View Movies")).click();
        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.equals("http://localhost:3000/films"), "Didn't reach films page");
    }

    @AfterClass
    public void afterAll(){
            driver.close();
            driver.quit();
    }

}




//    public static void main(String[] args) {
//        System.setProperty("webdriver.chrome.driver", "src/test/resources//chromedriver-win64/chromedriver.exe");
//        final var driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        driver.get("http://localhost:3000");
//
//        driver.findElement(By.linkText("Home Page")).click();



//        final var textBox = driver.findElement(By.name("my-text"));
//        final var submitButton = driver.findElement(By.cssSelector("button[type='submit']"));
//
//        // Type some text in the input field
//        textBox.sendKeys("Example text");
//        // Submit the form
//        submitButton.click();
//
//        System.out.println(submitButton.getText());
//        System.out.println(submitButton.getSize());
//        System.out.println(submitButton.getCssValue("background-color"));
//        System.out.println(submitButton.getAccessibleName());

//        driver.close();
//        driver.quit();
//    }