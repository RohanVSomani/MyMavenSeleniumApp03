package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class App {

    public static void main(String[] args) throws Exception {

        ChromeOptions options = new ChromeOptions();
        
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.manage().window().maximize();

        try {
           
            driver.get("https://automationexercise.com/");

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("body")));

            wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//a[@href='/products']"))).click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search_product")))
                    .sendKeys("Tshirt");

            driver.findElement(By.id("submit_search")).click();

            wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("(//a[contains(text(),'Add to cart')])[1]"))).click();

            wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//u[contains(text(),'View Cart')]"))).click();

            Thread.sleep(5000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
