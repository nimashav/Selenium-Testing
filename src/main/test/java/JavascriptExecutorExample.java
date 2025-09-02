import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//Javascript executor  help to exexute javascript method through selenium web driver
//Javascript exexutor eken selenium walin krn puluwn hama operation ekakm krn puluwn.
//Selenium walin witrk krn bari operations walata meka use krn wenw.

public class JavascriptExecutorExample {

    WebDriver driver;

    JavascriptExecutor jsExecutor;

    @BeforeMethod
    public void openJSExecutorPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");
    }

    @Test
    public void jsExecuorTests() throws InterruptedException {

        jsExecutor = (JavascriptExecutor) driver; //Interface ekakt object hadnn ba

//1) Get a Alert Box in to Web page using JavaScript
        //jsExecutor.executeScript("alert('Welcome to learn wih Hashir...')");


//2) Set a input value in a text box using JavascriptExecutor
    // 2.1) - way 1 > Set the value using the value property(common approach)// Recommended way
        WebElement inputNameTextBox = driver.findElement(By.xpath("//input[@id='name']"));
        jsExecutor.executeScript("arguments[0].value='Learn with Hashir';",inputNameTextBox);


    // 2.2) - way 1 > Set the value using the value property(alternative approach)
        //jsExecutor.executeScript("arguments[0].setAttribute('value','YourValue');",inputNameTextBox);

        Thread.sleep(4000);

//3) Highlight element(mekt aniwaren javascriptExecutor use krn wenw
        jsExecutor.executeScript("arguments[0].style.border='3px solid red';",inputNameTextBox);
        jsExecutor.executeScript("arguments[0].style.background='yellow';",inputNameTextBox);

        Thread.sleep(4000);

//4) Click element using javascriptExecutor
        WebElement maleCheckBox = driver.findElement(By.xpath("//input[@id='male']"));
        jsExecutor.executeScript("arguments[0].click();",maleCheckBox);

        Thread.sleep(4000);

//5) Scrolling the Page
        scrollPage();

        Thread.sleep(4000);

//6) Get all attributes from a wanted element
        //meka kiyl dun na hriyt

//page reload
   //jsExecutor.executeScript("location.reload();"); //or jsExecutor.executeScript("history.go(0);");

//Zoom in
   //jsExecutor.executeScript("document.body.style.zoom='150%';");
//Zoom out
   //jsExecutor.executeScript("document.body.style.zoom='50%';");
//Reset Zoom
   // jsExecutor.executeScript("document.body.style.zoom='100%';");

    }


    public void scrollPage() throws InterruptedException {
        //5.1) Scroll to some position
        jsExecutor.executeScript("window.scrollTo(0,1000);");
        System.out.println("Current page YOffset value is :" + jsExecutor.executeScript("return window.pageYOffset;"));
        jsExecutor.executeScript("window.scrollTo(0,-1000);"); //go again to initial state

        Thread.sleep(3000);

        //5.2) Scroll to the bottom of the page by pixel number
        jsExecutor.executeScript("window.scrollTo(0,document.body.scrollHeight);");

        Thread.sleep(3000);

        //5.3) Scroll to the top of the page
        jsExecutor.executeScript("window.scrollTo(0,0);");

        Thread.sleep(3000);

        //5.4) Scroll the page till element is visible
        WebElement scrollintoElement = driver.findElement(By.xpath("//label[@for='gender']"));
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);",scrollintoElement);
    }
}
