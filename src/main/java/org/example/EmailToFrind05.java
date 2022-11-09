package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.SimpleDateFormat;

public class EmailToFrind05
{
    protected static WebDriver driver; //to assign webdrivers
    public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver", "src/test/Drivers/chromedriver.exe"); //set a driver path for Chrome browser
        driver = new ChromeDriver(); //opening Chrome browser
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date()); // assign time stamp


        driver.manage().window(); //maximize(); //Keeping the browser in fullscreen mode
        driver.get("https://demo.nopcommerce.com/"); //opening given url
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']/li[1]/a")).click(); // to direct to computer category.
        driver.findElement(By.xpath("//ul[@class='sublist']/li[2]/a")).click(); // to details in computer category
        driver.findElement(By.xpath("//div[@data-productid='4']/div[2]/h2/a")).click(); // to reach to details computer specific item
        driver.findElement(By.xpath("//div[@class='email-a-friend']/button")).click(); // click to share button
        driver.findElement(By.id("FriendEmail")).sendKeys("Friend"+timeStamp+"@testmail.com"); // enter firends email id
        driver.findElement(By.id("YourEmailAddress")).sendKeys("YourEMail"+timeStamp+"@testmail.com"); //to enter senders email id.
        driver.findElement(By.id("PersonalMessage")).sendKeys("I thought this might be the machine that you are looking for a while"); // enter comment before sharing the item.
        driver.findElement(By.name("send-email")).click(); // to button share the utem
        String Msg = driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']/ul/li")).getText(); // read the outcome of sharing the item.
        driver.close(); // to close chromebrowser

        System.out.println("Try to share Apple MacBook Pro 13-inc"); // to print category item.

        System.out.println("Message appear after clicking Sent email button:" +Msg); // to print category item.
        System.out.println("Test completed on :"+timeStamp); // to print registration confirmation with timestamp.

    }

}
