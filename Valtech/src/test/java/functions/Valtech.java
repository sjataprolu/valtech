package functions;


import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

import static junit.framework.TestCase.assertTrue;

public class Valtech {
    WebDriver driver;

    @Before
    public void Browser(){
        String parentPath=System.getProperty("user.dir");
        String path=parentPath+"\\src\\test\\driver\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", path);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions");
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);

    }

    @Test
    public void ValtechTest(){

       Assert.assertEquals("Latest news", driver.findElement(By.xpath("//header[@class='block-header']/h2[@class='block-header__heading'and contains(text(), 'Latest news')]")).getText());

        WebElement aboutElement=driver.findElement(By.xpath("//li[@class='navigation__menu__item']/a[@href='/about/']"));
        aboutElement.click();
        Assert.assertEquals("About", driver.findElement(By.xpath("//a[@href='/work/']/span")).getText());
        WebElement servicesElement=driver.findElement(By.xpath("//li[@class='navigation__menu__item']/a[@href='/services/']"));
        servicesElement.click();
        Assert.assertEquals("Services", driver.findElement(By.xpath("//a[@href='/services/']/span")).getText());
        WebElement workElement=driver.findElement(By.xpath("//li[@class='navigation__menu__item']/a[@href='/work/']"));
        workElement.click();
        Assert.assertEquals("Work", driver.findElement(By.xpath("//a[@href='/work/']/span")).getText());

        WebElement contact=driver.findElement(By.xpath("//i[@data-icon='earth-contact']"));
        contact.click();

        List<WebElement> totallinks=driver.findElements(By.xpath("//div[@class='contactbody']"));
        System.out.println("Total number of offices are: "+int TotalOffices=totallinks.size()); 

    }

}
