import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class Task1 {
    public static void main(String[]args){

    }

    public String baseUrl = "https://textbin.net";
    public WebDriver driver;
    public void setBaseUrl() {
        driver = new ChromeDriver();
        driver.get(baseUrl);

        WebElement textInput = driver.findElement(By.xpath("//*[@class=\"ace_text-input\"]"));
        textInput.sendKeys("Hello from WebDriver");
        WebElement searchInput1 = driver.findElement(By.name("title"));
        searchInput1.sendKeys("helloweb");
        Select highlighting = new Select(driver.findElement(By.xpath("//*[@class=\"form-control select2 select2-hidden-accessible\"]")));
        highlighting.selectByVisibleText("Bash");
        Select pasteExpiration = new Select(driver.findElement(By.name("expire")));
        pasteExpiration.selectByVisibleText("10 Minutes");
        WebElement submit = driver.findElement(By.xpath("//*[@class=\"btn btn-success waves-effect waves-light\"]"));
        submit.click();
        driver.quit();
    }



}

