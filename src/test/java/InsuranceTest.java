import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class InsuranceTest extends BaseTest {
    public void fillField(By locator, String value){
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);

    }

    @Test
    public void testInsuranceSb() {

        Wait <WebDriver> wait = new WebDriverWait(driver, 15, 1000);

        WebElement insurance = driver.findElement(By.xpath("//span[text()='Страхование']"));

        wait.until(ExpectedConditions.visibilityOf(insurance)).click();

        WebElement travelPushcase = driver.findElement
                (By.xpath("//*[contains(@class,'lg-menu__sub-item')]//*[contains(text(),'Путешествия и покупки')]"));
        wait.until(ExpectedConditions.visibilityOf(travelPushcase)).click();

        WebElement registerOnline = driver.findElement
                (By.xpath("//div[@data-pid='SBRF-TEXT-2247407']/..//a[text()='Оформить онлайн']"));
        wait.until(ExpectedConditions.visibilityOf(registerOnline)).click();


        ArrayList tabs2 = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window((String) tabs2.get(1));


        WebElement minimal = driver.findElement(By.xpath("//*[text()='Минимальная']"));
        wait.until(ExpectedConditions.visibilityOf(minimal)).click();


        driver.findElement(By.xpath("//span[text()='Оформить']")).click();


        fillField(By.name("insured0_surname"), "FAMILINS");
        fillField(By.name("insured0_name"), "NAMES");
        fillField(By.name("insured0_birthDate"), "26021990");

        fillField(By.name("surname"), "Фамилинс");
        fillField(By.name("name"), "Нэймс");
        fillField(By.name("middlename"), "Батькович");
        fillField(By.name("birthDate"), "26021990");

        fillField(By.name("passport_series"), "5555");
        fillField(By.name("passport_number"), "555555");
        fillField(By.name("issueDate"), "10102010");
        fillField(By.name("issuePlace"), "Кем то выдан");

        driver.findElement(By.xpath("//*[text()='Продолжить']")).click();

        WebElement errorText = driver.findElement
                (By.xpath("//*[text()='Заполнены не все обязательные поля']"));

        wait.until(ExpectedConditions.visibilityOf(errorText));

        assertEquals("FAMILINS",
                driver.findElement(By.name("insured0_surname")).getAttribute("value"));
        assertEquals("NAMES",
                driver.findElement(By.name("insured0_name")).getAttribute("value"));
        assertEquals("26.02.1990",
                driver.findElement(By.name("insured0_birthDate")).getAttribute("value"));

        assertEquals("Фамилинс",
                driver.findElement(By.name("surname")).getAttribute("value"));
        assertEquals("Нэймс",
                driver.findElement(By.name("name")).getAttribute("value"));
        assertEquals("Батькович",
                driver.findElement(By.name("middlename")).getAttribute("value"));
        assertEquals("26.02.1990",
                driver.findElement(By.name("birthDate")).getAttribute("value"));

        assertEquals("5555",
                driver.findElement(By.name("passport_series")).getAttribute("value"));
        assertEquals("555555",
                driver.findElement(By.name("passport_number")).getAttribute("value"));
        assertEquals("10.10.2010",
                driver.findElement(By.name("issueDate")).getAttribute("value"));
        assertEquals("Кем то выдан",
                driver.findElement(By.name("issuePlace")).getAttribute("value"));

        assertEquals("Заполнены не все обязательные поля",driver.findElement
                (By.xpath("//*[text()='Заполнены не все обязательные поля']")).getText());



    }
}

