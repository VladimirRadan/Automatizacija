package main;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();//otvara browser
        Thread.sleep(2000);
        driver.manage().window().maximize();
        Thread.sleep(2000);
        String url = "https://the-internet.herokuapp.com/login";
        driver.get(url);
        Thread.sleep(1500);
        WebElement username = driver.findElement(By.cssSelector("input[name='username']"));
        username.sendKeys("tomsmith");

        //driver.findElement(By.id("username")) bez #
        Thread.sleep(1500);

        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        Thread.sleep(1500);
        driver.findElement(By.className("radius")).click();
        //uhvatiti lokator sa tekstom nakon logovanja i ispisati tekst u konzoli

    }





}
