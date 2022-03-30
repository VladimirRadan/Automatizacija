package main;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();//otvara browser
        driver.manage().window().maximize();
        String url = "https://the-internet.herokuapp.com/login";
        driver.get(url);
        WebElement username = driver.findElement(By.cssSelector("input[name='username']"));
        username.sendKeys("tomsmith");

        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.className("radius")).click();

        WebElement loggedInText = driver.findElement(By.id("flash"));
//        System.out.println("Text u elementu: " + loggedInText.getText());
//        System.out.println("Boja elementa: " + loggedInText.getCssValue("background-color"));

        String axtualBackgroundColor = loggedInText.getCssValue("background-color");

        String expectedText = "You logged into a secure area!";
        String expectedColor = "rgba(93, 164, 35, 1)";

        String actual[] = loggedInText.getText().split("(?<=!)"); //regex
//        System.out.println("actual prvi " + actual[0]);
//        System.out.println("actual drugi" + actual[1]);

        String actualtext = actual[0];
        String actualText2 = loggedInText.getText().substring(0, loggedInText.getText().length()-1);
        //System.out.println("Actual 2: " + actualText2);
        Thread.sleep(3000);

        boolean result = expectedText.equals(actualtext);

        Assert.assertTrue(result);

        Assert.assertEquals(actualtext, expectedText);
        Assert.assertEquals(axtualBackgroundColor, expectedColor);

        driver.quit();

        //runner

    }

    @Test
    public void test(){
        System.out.println("Hello from test");
    }






}
