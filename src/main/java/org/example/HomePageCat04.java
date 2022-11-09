package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.SimpleDateFormat;

public class HomePageCat04
{
    protected static WebDriver driver; //to assign webdrivers

    public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver", "src/test/Drivers/chromedriver.exe"); //set a driver path for Chrome browser
        driver = new ChromeDriver(); //opening Chrome browser
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date()); // assign time stamp

        driver.manage().window(); //maximize(); //Keeping the browser in fullscreen mode
        driver.get("https://demo.nopcommerce.com/"); //opening given url
        String read1 = driver.findElement(By.xpath("//div[@class='header-menu']/ul/li[1]/a")).getText(); // to catch header item category msg 01.
        String read2 = driver.findElement(By.xpath("//div[@class='header-menu']/ul/li[2]/a")).getText(); // to catch header item category msg 02.
        String read3 = driver.findElement(By.xpath("//div[@class='header-menu']/ul/li[3]/a")).getText(); // to catch header item category msg 03.
        String read4 = driver.findElement(By.xpath("//div[@class='header-menu']/ul/li[4]/a")).getText(); // to catch header item category msg 04.
        String read5 = driver.findElement(By.xpath("//div[@class='header-menu']/ul/li[5]/a")).getText(); // to catch header item category msg 05.
        String read6 = driver.findElement(By.xpath("//div[@class='header-menu']/ul/li[6]/a")).getText(); // to catch header item category msg 06.
        String read7 = driver.findElement(By.xpath("//div[@class='header-menu']/ul/li[7]/a")).getText(); // to catch header item category msg 07.

        driver.close(); // to close webbrowser

        System.out.println("Category of Item available at NopCommerce"); // to print category items header.
        System.out.println();  // to leave blank line.
        System.out.println("Category 01: "+read1); // to print category item.
        System.out.println("Category 02: "+read2); // to print category item.
        System.out.println("Category 03: "+read3); // to print category item.
        System.out.println("Category 04: "+read4); // to print category item.
        System.out.println("Category 05: "+read5); // to print category item.
        System.out.println("Category 07: "+read7); // to print category item.
        System.out.println(); // to leave blank line.

        System.out.println("Date and time at time of test completed:"+timeStamp); // to print registration confirmation with timestamp.

    }


}
