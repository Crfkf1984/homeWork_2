package qa.guru;

import data.TestData;
import io.qameta.allure.Attachment;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.webdriver;
import static io.qameta.allure.Allure.attachment;
import static io.qameta.allure.Allure.step;
import static pages.RegistrationPage.open;
import static pages.RegistrationPage.removeAdvertising;

@Tag("super")
public class CheckFieldsTest extends BaseTest {

    RegistrationPage registration = new RegistrationPage();
    TestData data = new TestData();

    @Test
    @DisplayName("Тест проверяет авторизацию пользователя")
    @Owner("catovich")
    @Severity(SeverityLevel.BLOCKER)
    public void checkAllFieldsTest() {
      
        step("Открываем браузер", () -> {
            open();
        });
        step("Удаляем рекламу", () -> {
            removeAdvertising();
        });
        step("Заполняем страницу данными", () -> {
            registration.setFirstName(data.firstName)
                    .setLastName(data.lastName)
                    .setEmail(data.userEmail)
                    .selectGender(data.gender)
                    .setMobileNumber(data.mobileNumber)
                    .selectDate(data.day, data.month, data.year)
                    .selectSubject(data.subjectsInput)
                    .selectHobbie(data.hobbie)
                    .upploadPicture(data.picture)
                    .setAddress(data.currentAddress)
                    .selectState(data.uttarPradesh)
                    .selectCity(data.needCity).
                    clickSubmitButton();
        });
        step("Проверяем сохранились ли данные", () -> {
            registration.checkResult("Student Name", data.firstName + " " + data.lastName)
                    .checkResult("Student Email", data.userEmail)
                    .checkResult("Gender", data.gender)
                    .checkResult("Mobile", data.mobileNumber)
                    .checkResult("Date of Birth", data.day + " " + data.month + "," + data.year)
                    .checkResult("Subjects", data.subjectsInput)
                    .checkResult("Hobbies", data.hobbie)
                    .checkResult("Picture", data.picture)
                    .checkResult("Address", data.currentAddress)
                    .checkResult("State and City", data.uttarPradesh + " " + data.needCity);
        });

    }

    @Test
    @DisplayName("Тест проверяет авторизацию при неполном заполнении данных")
    @Owner("catovich")
    @Severity(SeverityLevel.BLOCKER)
    public void checkSmokeFieldsTest() {


        step("Открываем браузер", () -> {
            open();
        });
        step("Заполняем форму неполностью", () -> {
            registration.setFirstName(data.firstName)
                    .setLastName(data.lastName)
                    .setMobileNumber(data.mobileNumber)
                    .selectGender(data.gender)
                    .selectDate(data.day, data.month, data.year)
                    .selectSubject(data.subjectsInput)
                    .upploadPicture(data.picture)
                    .selectState(data.uttarPradesh)
                    .selectCity(data.needCity).
                    clickSubmitButton();
        });
        step("Проверяем сохранения данныех при неполной заполнении формы", () -> {
            registration.checkResult("Student Name", data.firstName + " " + data.lastName)
                    .checkResult("Mobile", data.mobileNumber)
                    .checkResult("Gender", data.gender)
                    .checkResult("Date of Birth", data.day + " " + data.month + "," + data.year)
                    .checkResult("Subjects", data.subjectsInput)
                    .checkResult("Picture", data.picture)
                    .checkResult("State and City", data.uttarPradesh + " " + data.needCity);
        });
    }


    @Test
    @DisplayName("Тест проверяет авторизацию пользователя, отрицательный тест-кейс")
    @Owner("catovich")
    @Severity(SeverityLevel.NORMAL)
    public void checkAllFieldsNegativeTest() {

        step("Открываем браузер", () -> {
            open();
        });
        step("Заполняем форму отриц данными", () -> {
            registration.setFirstName(data.firstName)
                    .setLastName(data.lastName)
                    .setMobileNumber(data.mobileNumber)
                    .selectGender(data.gender)
                    .upploadPicture(data.picture)
                    .clickSubmitButton();
        });
        step("Проверка сохранение формы при отриц данных", () -> {
            registration.checkResult("Student Name", data.firstName + " " + data.lastName)
                    .checkResult("Mobile", data.mobileNumber)
                    .checkResult("Gender", data.gender)
                    .checkResult("Picture", data.picture)
                    .checkResult("Subject", " ")
                    .checkResult("State and City", " ")
                    .checkResult("Address", " ");
        });
    }
}