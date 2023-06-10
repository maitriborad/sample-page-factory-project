package com.nopcommerce.demo.browserfactory;

import com.nopcommerce.demo.propertyreader.PropertyReader;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class ManageBrowser {
    private static final Logger log = LogManager.getLogger(ManageBrowser.class);
    public static WebDriver driver;
    static String baseUrl = PropertyReader.getInstance().getProperty("baseUrl");

    public ManageBrowser(){
        PageFactory.initElements(driver,this);
        PropertyConfigurator.configure(System.getProperty("user.dir")+"/src/test/java/resources/propertiesfile/log4j2.properties");
    }

    public void selectBrowser(String browser){
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
            log.info("Chrome browser lunch......");
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
            log.info("Firefox browser lunch......");
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
            log.info("Edge browser lunch......");
        } else {
            System.out.println("Wrong browser name");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get(baseUrl);
    }

    public void closeBrowser(){
        if (driver!= null){
            driver.quit();
        }
    }
}
