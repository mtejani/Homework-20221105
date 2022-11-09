package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.SimpleDateFormat;

public class Product02
{

    protected static WebDriver driver; //to assign the driver.

    public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver", "src/test/Drivers/chromedriver.exe"); // to assign chrome driver and path.
        driver = new ChromeDriver(); //driver assigned.
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date()); //timestamp


        driver.manage().window(); //window size open
        driver.get("https://demo.nopcommerce.com/"); //to open url.

        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']/li[1]/a")).click(); //to enter under product category.
        driver.findElement(By.xpath("//ul[@class='sublist']/li[1]/a ")).click(); //to enter in to the products.

        String Mesg1 = driver.findElement(By.xpath(("//div[@class=\"item-grid\"]/div[1]//h2/a"))).getText(); // to read a list of items.
        String Mesg2 = driver.findElement(By.xpath(("//div[@class=\"item-grid\"]/div[2]//h2/a"))).getText(); // to read a list of items.
        String Mesg3 = driver.findElement(By.xpath(("//div[@class=\"item-grid\"]/div[3]//h2/a"))).getText(); // to read a list of items.

        driver.close(); //to close open web browser.
        System.out.println("Item no.1:"+Mesg1); // to print item category msg 1
        System.out.println("Item no.2:"+Mesg2); // to print item category msg 2
        System.out.println("Item no.3:"+Mesg3); // to print item category msg 3
        System.out.println("Test time:"+timeStamp); // to print time at time of stamp.

    }


}
