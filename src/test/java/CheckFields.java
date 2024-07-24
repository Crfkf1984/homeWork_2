import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CheckFields {

    @BeforeAll
    public static void before() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    public void checkAllFieldsTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Иван");
        $("#lastName").setValue("Иванов");
        $("#userEmail").setValue("lenin@mail.ru");
        $("div.custom-control.custom-radio.custom-control-inline", 0).click();
        $("#userNumber").setValue("8911567349");
        $("#dateOfBirthInput").click();
        $("[aria-label='Choose Monday, July 22nd, 2024']").click();
        $("#subjectsInput").setValue("Hindi").sendKeys(Keys.ENTER);
        $("div.custom-control.custom-checkbox.custom-control-inline", 0).click();
        $("#uploadPicture").uploadFromClasspath("google.avif");
        $("#currentAddress").setValue("https://demoqa.com/automation-practice-form");
        $("#state").click();
        $(By.id("react-select-3-input")).setValue("Uttar Pradesh").sendKeys(Keys.ENTER);
        $("#city").click();
        $(By.id("react-select-4-input")).setValue("Agra").sendKeys(Keys.ENTER);
        $("#submit").click();

        $(".modal-body tr:nth-child(1) td:nth-child(2)").shouldHave(text("Иван Иванов"));
        $(".modal-body tr:nth-child(2) td:nth-child(2)").shouldHave(text("lenin@mail.ru"));
        $(".modal-body tr:nth-child(3) td:nth-child(2)").shouldHave(text("Male"));
        $(".modal-body tr:nth-child(4) td:nth-child(2)").shouldHave(text("8911567349"));
        $(".modal-body tr:nth-child(5) td:nth-child(2)").shouldHave(text("22 July,2024"));
        $(".modal-body tr:nth-child(6) td:nth-child(2)").shouldHave(text("Hindi"));
        $(".modal-body tr:nth-child(7) td:nth-child(2)").shouldHave(text("Sports"));
        $(".modal-body tr:nth-child(8) td:nth-child(2)").shouldHave(text("google.avif"));
        $(".modal-body tr:nth-child(9) td:nth-child(2)").shouldHave(text("https://demoqa.com/automation-practice-form"));
        $(".modal-body tr:nth-child(10) td:nth-child(2)").shouldHave(text("Uttar Pradesh"));
    }
}