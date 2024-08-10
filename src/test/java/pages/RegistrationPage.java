package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {

    private final SelenideElement firstName = $("#firstName");
    private final SelenideElement lastName = $("#lastName");
    private final SelenideElement userEmail = $("#userEmail");
    private final SelenideElement userNumber = $("#userNumber");
    private final SelenideElement subjectsInput = $("#subjectsInput");
    private final SelenideElement uploadPicture = $("#uploadPicture");
    private final SelenideElement currentAddress = $("#currentAddress");
    private final SelenideElement state = $("#state");
    private final SelenideElement city = $("#city");
    private final SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
    private final SelenideElement submit = $("#submit");

    public static void open() {
        Selenide.open("/automation-practice-form");
    }

    public static void removeAdvertising() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
    }

    public RegistrationPage setFirstName(String name) {
        $(firstName).setValue(name);
        return this;
    }

    public RegistrationPage setLastName(String valueName) {
        $(lastName).setValue(valueName);
        return this;
    }

    public RegistrationPage setEmail(String email) {
        $(userEmail).setValue(email);
        return this;
    }

    public RegistrationPage selectGender(String gender) {
        $(byText(gender)).click();
        return this;
    }

    public RegistrationPage setMobileNumber(String mobile) {
        $(userNumber).setValue(mobile);
        return this;
    }

    public RegistrationPage selectDate(String day, String month, String year) {
        $(dateOfBirthInput).click();
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").click();
        $("select.react-datepicker__year-select").selectOption(year);
        List<SelenideElement> list = $$(".react-datepicker__month div.react-datepicker__week div");
        SelenideElement res = list.stream().filter(e -> e.getText().equals(day)).findFirst().get();
        res.click();

        return this;
    }

    public RegistrationPage selectSubject(String subject) {
        $(subjectsInput).setValue(subject).pressEnter();
        return this;
    }

    public RegistrationPage selectHobbie(String hobbie) {
        $(byText(hobbie)).click();
        return this;
    }

    public RegistrationPage upploadPicture(String picture) {
        $(uploadPicture).uploadFromClasspath(picture);
        return this;
    }

    public RegistrationPage setAddress(String adress) {
        $(currentAddress).setValue(adress);
        return this;
    }

    public RegistrationPage selectState(String stateCity) {
        $(state).click();
        $("#react-select-3-input").setValue(stateCity).pressEnter();
        return this;
    }

    public RegistrationPage selectCity(String needCity) {
        $(city).click();
        $("#react-select-4-input").setValue(needCity).pressEnter();
        return this;
    }

    public void clickSubmitButton() {
        $(submit).click();
    }

    public RegistrationPage checkResult(String key, String value) {
        $(By.className("table-responsive")).shouldHave(text(key)).parent().shouldHave(text(value));
        return this;
    }
}