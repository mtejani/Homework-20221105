package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.SimpleDateFormat;

public class NewsComm03
{
    protected static WebDriver driver; // to assign webdrivers

    public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver", "src/test/Drivers/chromedriver.exe"); //set a driver path for Chrome browser
        driver = new ChromeDriver(); //opening Chrome browser
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());


        driver.manage().window(); //maximize(); //Keeping the browser in fullscreen mode
        driver.get("https://demo.nopcommerce.com/"); //opening given url
        driver.findElement(By.xpath("//div[@class=\"news-items\"]/div[2]/div[3]/a")).click(); // to click on news items.
        driver.findElement(By.id("AddNewComment_CommentTitle")).sendKeys("News you like"); // to comment on news
        driver.findElement(By.id("AddNewComment_CommentText")).sendKeys("News you like and this is worth sharing to you"); // to type a message for news share.
        driver.findElement(By.xpath("//div[@class='fieldset new-comment']/form/div[2]/button")).click(); //to share news click button share.
        driver.close(); // to close webdriver
        String result = driver.findElement(By.xpath("//div[@class='result']")).getText();
        System.out.println(result); // to print registration connfirmation.
        System.out.println(timeStamp); // to print registration confirmation with timestamp.

    }

}
