//import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenGoogle {

    //Open google
    //Go to Google home page

    public static void main(String[] args){
          //1 st ,method
          //System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\Downloads\\drivers\\chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://www.google.com/");

        //2nd method
        //WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://www.google.com/");

        //3rd method
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.quit();

    }
}
