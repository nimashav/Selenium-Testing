import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DropDownExample {

    WebDriver driver;

    @BeforeMethod
    public void dropDownTestPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
//        driver.get("https://leafground.com/select.xhtml");
    }

    @Test
    public  void leafgroundpageDropDownTest() throws InterruptedException {
        //1.1) ways of select values in Basic dropdown
        WebElement dropdown = driver.findElement(By.xpath("//select[@class='ui-selectonemenu']"));
        Select select = new Select(dropdown);
        select.selectByIndex(1);
        Thread.sleep(3000);
        select.selectByVisibleText("Playwright");
        Thread.sleep(3000);

        //1.2) Get the number of dropDown options

        List<WebElement> listofOptions =select.getOptions();
        int size = listofOptions.size();
        System.out.println("Number of elements in dropdown: " +size);

        for (WebElement element:listofOptions) {
            System.out.println(element.getText());
        }

        //1.3) Using sendkeys select dropdown value
        dropdown.sendKeys("Cypress");
        Thread.sleep(3000);

        //1.4) Selecting value in a Bootstrap dropdown
        WebElement dropdown2 = driver.findElement(By.xpath("//div[@id='j_idt87:country']"));
        dropdown2.click();
        List<WebElement> listofdropdown2values = driver.findElements(By.xpath("//ul[@id='j_idt87:country_items']/li"));
        for (WebElement element :listofdropdown2values) {
           String dropDownValue = element.getText();
           if(dropDownValue.equals("USA")){
               element.click();
               break;
           }
        }
    }


//2) Google Search - pick a value from suggestions

    @Test
    public void googleSearchDropDown() throws InterruptedException {
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("palitha");
        Thread.sleep(3000);
        List<WebElement> googlesearchList = driver.findElements(By.xpath("//ul[@role='listbox']/li//div[@class='wM6W7d']"));
        System.out.println(googlesearchList.size());
        for(WebElement element:googlesearchList){
           System.out.println(element.getText());
        }
    }
//3) Handle Hidden Auto Suggestions Drop Down And Search using DOM Debugger Trick
}
