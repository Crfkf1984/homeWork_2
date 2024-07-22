import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.remote.tracing.EventAttribute.setValue;

public class CheckFields {

    @BeforeAll
    public static void before() {
        System.setProperty("webdriver.chrome.driver", "C:\\.cache\\selenium\\chromedriver\\win64\\126.0.6478.126\\chromedriver.exe");
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        //Configuration.timeout = 5000;
    }

    @Test
    public void checkAllFieldsTest() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue("Иван");
        $("#lastName").setValue("Иванов");
        $("#userEmail").setValue("lenin@mail.ru");
        $("div.custom-control.custom-radio.custom-control-inline", 0).click();
        $("#userNumber").setValue("891156734912");
        $("#dateOfBirthInput").click();
        $("[aria-label='Choose Monday, July 22nd, 2024']").click();
        $("#subjectsInput").setValue("Student");
        $("div.custom-control.custom-checkbox.custom-control-inline", 0).click();
        $("#uploadPicture").sendKeys("C:\\homeWork_2\\src\\test\\resources\\pictures\\pictures with google.avif");
        $("#currentAddress").setValue("https://demoqa.com/automation-practice-form");
        $("#state").click();
        $(By.id("react-select-3-input")).setValue("Uttar Pradesh").sendKeys(Keys.ENTER);
        $("#city").click();
        $(By.id("react-select-4-input")).setValue("Agra").sendKeys(Keys.ENTER);
        $("#submit").click();
    }
}