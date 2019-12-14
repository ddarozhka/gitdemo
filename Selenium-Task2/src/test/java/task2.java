import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.util.concurrent.TimeUnit;

public class task2 {

    public String baseUrl = "https://textbin.net";
    public WebDriver driver;

    @BeforeTest
    public void setBaseUrl() {
        driver = new ChromeDriver();
        driver.get(baseUrl);

        WebElement textInput = driver.findElement(By.xpath("//*[@class=\"ace_text-input\"]"));
        textInput.sendKeys("git config --global user.name  \"New Sheriff in Town\"\n" +
                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                "git push origin master --force");
        WebElement searchInput1 = driver.findElement(By.name("title"));
        searchInput1.sendKeys("how to gain dominance among developers");
        Select highlighting = new Select(driver.findElement(By.xpath("//*[@class=\"form-control select2 select2-hidden-accessible\"]")));
        highlighting.selectByVisibleText("Bash");
        Select pasteExpiration = new Select(driver.findElement(By.name("expire")));
        pasteExpiration.selectByVisibleText("10 Minutes");
        WebElement submit = driver.findElement(By.xpath("//*[@class=\"btn btn-success waves-effect waves-light\"]"));
        submit.click();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    @Test
    public void verifyTitle() {
        String expectedTitle = "how to gain dominance among developers - TextBin";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);

    }

    @AfterTest
    public void cleanUp(){
        driver.manage().deleteAllCookies();
    }

}

