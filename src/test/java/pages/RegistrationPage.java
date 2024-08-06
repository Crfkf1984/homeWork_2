package pages;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {

    private String firstName = "#firstName";
    private String lastName = "#lastName";
    private String userEmail = "#userEmail";
    private String userNumber = "#userNumber";
    private String subjectsInput = "#subjectsInput";
    private String uploadPicture = "#uploadPicture";
    private String currentAddress = "#currentAddress";
    private String state = "#state";
    private String city = "#city";
    private String dateOfBirthInput = "#dateOfBirthInput";
    private String submit = "#submit";

    public static void open() {
        Selenide.open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
    }

    public RegistrationPage setFirstName(String name) {
        $(firstName).setValue(name);
        return this;
    }

    public RegistrationPage setLastName(String lastName) {
        $(lastName).setValue(lastName);
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
        $(".react-datepicker__day--006.react-datepicker__day--today").click();

        return this;
    }

    public RegistrationPage selectSubjects(String subject) {
        $(subjectsInput).setValue(subject).pressEnter();
        return this;
    }

    public RegistrationPage selectHobbies(String hobbie) {
        $(byText(hobbie)).click();
        return this;
    }

    public RegistrationPage upploadPicture(String picture) {
        $(uploadPicture).uploadFromClasspath(picture);
        return this;
    }

    public RegistrationPage currentToAddress(String adress) {
        $(currentAddress).setValue(adress);
        return this;
    }

    public RegistrationPage selectState(String stateCity) {
        $(state).click();
        $("#react-select-3-input").setValue(stateCity).pressEnter();
        return this;
    }

    public RegistrationPage selectCity(String currentCity) {
        $(city).click();
        $("#react-select-4-input").setValue(currentCity).pressEnter();
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