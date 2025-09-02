import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;


    public class HandlingAllControls {

        @Test
        public void googleTest() throws InterruptedException {

            WebDriver driver = new ChromeDriver();
            driver.get("https://www.google.com");
            driver.manage().window().maximize();
            //driver.quit();


            // Launch the Edureka Website
            driver.get("https://www.edureka.co/");


            //Click Login
            driver.findElement(org.openqa.selenium.By.xpath("//button[normalize-space()='Log in']")).click();

            Actions actions = new Actions(driver);

            WebElement email = driver.findElement(By.xpath("//input[@id='loginFormEmail']")); //input[@id='loginFormEmail']
            Thread.sleep(2000);
            email.sendKeys("TestingEdureka@gmail.com");
            Thread.sleep(2000);


        }


    }

