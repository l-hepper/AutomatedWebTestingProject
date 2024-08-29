package com.sparta.awtp.webtestframework;

import com.sparta.awtp.webtestframework.pages.Website;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class TestSetup {

    private static final String DRIVER_LOCATION = "src/test/resources/chromedriver.exe";
    private static final String BASE_URL = "https://automationexercise.com/";
    private static ChromeDriverService service;
    private static WebDriver webDriver;

    private static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--headless"); // means it runs in the background without the GUI
        options.addArguments("--remote-allow-origins="); // allows access from the test program and CORS
        options.setImplicitWaitTimeout(Duration.ofSeconds(10));
        return options;
    }

    public static void startChromeService() throws IOException {
        service = new ChromeDriverService.Builder().usingDriverExecutable(new File(DRIVER_LOCATION)).usingAnyFreePort().build();
        service.start();
    }

    public static void stopService() {
        service.stop();
    }

    // create a new driver on the start of each test?
    public static void createWebDriver() {
        webDriver = new RemoteWebDriver(service.getUrl(), getChromeOptions());
    }

    public static void quitWebDriver() {
        webDriver.quit();
    }

    public static Website getWebsite(String url) {
        webDriver.get(url);
        return new Website(webDriver);
    }
}

