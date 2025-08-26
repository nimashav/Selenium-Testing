import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

public class downloaduploadfileexample {


    WebDriver driver;

    @BeforeMethod
    public void beforeMethod() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void DownloadTest() throws InterruptedException {
        driver.get("https://leafground.com/file.xhtml");
        Thread.sleep(3000);

        WebElement downloadBtn =driver.findElement(By.id("j_idt93:j_idt95"));
        downloadBtn.click();
        Thread.sleep(3000);

        File file = new File("C:\\Users\\HP\\Downloads");
        File[] totalFiles = file.listFiles();

        for (File findFile:totalFiles) {
            if (findFile.getName().equals("TestLeaf Logo.png")){
                System.out.println("File is downloaded");
                break;
            }
        }
    }

    @Test
    public void UploadTest() throws InterruptedException, AWTException {
        driver.get("https://leafground.com/file.xhtml");
        //1st way - Using Robot class
        WebElement uploadBtn = driver.findElement(By.id("j_idt88:j_idt89"));
        uploadBtn.click();

//windows control begin here
        String data = "C:\\Users\\HP\\Downloads\\TestLeaf Logo.png";
        StringSelection selection = new StringSelection(data);//String eka convert krnw plain text ekakt
//Copying the path to clip board
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

        Thread.sleep(3000);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL); //VK->virtual keyC:\Users\HP\Downloads\TestLeaf Logo.png
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        Thread.sleep(4000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        //2nd way - Using Send keys (Applicable only element type is file)
        //Input type ek file nm selenium wlinm handle krnn plwan id ek denneth input ekk tyen id ekkmi
       /* String data = "C:\\Users\\HP\\Downloads\\TestLeaf Logo.png";
        WebElement uploadusingSenKeys =driver.findElement(By.id("j_idt88:j_idt89_input"));
        uploadusingSenKeys.sendKeys(data);*/


    }


}
//File yanu java walin file ekk wd krnn dunn class ekak
/*Upload button ek ebuwam apiwa windows eke file  upload krn thnat genynwa ethkot api selenium eken ain wenawa ettpse e upload
  krn wde wenne java walin

   getDefaultToolkit() denne clipboard ek windows eke tyen default tool kit ekk nisa


Setcontents() walt direct link ek dnn ba Stringselection() walin ar link ek plain text krnwa
Setcontents() accept krnne e plain text wtri
Robort ek yodnne windows wal selenum wl thm action class ek yodnee
Input type ek file nm selenium wlinm handle krnn plwan id ek denneth input ekk tyen id ekkmi
 */