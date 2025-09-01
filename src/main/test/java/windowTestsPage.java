import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class windowTestsPage {

    WebDriver driver;

    @BeforeMethod
    public void windows() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://leafground.com/window.xhtml");
        Thread.sleep(3000);
    }

    @Test
    public void WindowExample() throws InterruptedException {
        //1) Click and confirm new window open
        String oldWindow = driver.getWindowHandle();//Meka me extra ekak me deken krnne windows dek thunk hdunm parent element ek hoyagnimt e parent window eke nama print krl tygnwa wage deyk
        System.out.println("Old Window: " + oldWindow);

        WebElement openbutton = driver.findElement(By.id("j_idt88:new"));
        openbutton.click();
        Thread.sleep(3000);

        Set<String> handles = driver.getWindowHandles();
        System.out.println("Handles size: " + handles.size());

        //First method using forEach loop
//        for(String newWindow : handles){ //Loop eke plweni eken denne old window eke details
//            System.out.println("New Window: " + newWindow);
//            driver.switchTo().window(newWindow);//Api e aluthen apu window eke mkkhri krnnm ekt mulin switch wel tyenn one
//            System.out.println("Page Title is :" + driver.getTitle());
//        }
//
//        driver.close(); //antimt switch una tab eka witrk close krnw
        //driver.quit(); //okkom tabs close krnw

      //  driver.switchTo().window(oldWindow);// Driver window ek close krm aye open krgn mek yodnwa*/

        /*WebElement openButton1 = driver.findElement(By.xpath("//*[@id='j_idt88:new']/span"));
        boolean openbuttonVisibility = openButton1.isDisplayed();
        System.out.println("Open button Visibility = " + openbuttonVisibility);
        //Methn xpath ek klin test kala elemnt ekak xpath ekak
        //Me element ek web page eke tyenwd ahnwa*/


        //Second method using List
        List<String> list = new ArrayList<String>(handles); //converting set to the list
        if (list.size() > 1) {
            driver.switchTo().window(list.get(1));
            System.out.println("Page Title is :" + driver.getTitle());
            driver.close();
            driver.switchTo().window(oldWindow);

            WebElement openButton1 = driver.findElement(By.xpath("//*[@id='j_idt88:new']/span"));
            boolean openbuttonVisibility = openButton1.isDisplayed();
            System.out.println("Open button Visibility = " + openbuttonVisibility);
        }

        //2)Find the number of opened tabs
        WebElement multiWindowButton = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[5]/div[2]/form[1]/div[1]/div[1]/div[2]/button[1]/span[1]"));
        multiWindowButton.click();
        Thread.sleep(3000);

        Set<String> multiWindows = driver.getWindowHandles();
        int howmanyWindows = multiWindows.size();
        System.out.println("No of windows opened " + howmanyWindows);

        //3)Close all windows except primary
        WebElement dontclosemeButton = driver.findElement(By.id("j_idt88:j_idt93"));
        dontclosemeButton.click();
        Thread.sleep(3000);

        Set<String> newWindowsHandles = driver.getWindowHandles();
        for (String allWindows : newWindowsHandles) {
            if (!allWindows.equals(oldWindow)) {
                driver.switchTo().window(allWindows);
                driver.close();
            }
        }
        //4)close main also
        driver.switchTo().window(oldWindow);
        driver.close();
    }
    //driver.close();  --> close single browser window driver which on focus
//driver.quit();   --> close all browser windows

}
