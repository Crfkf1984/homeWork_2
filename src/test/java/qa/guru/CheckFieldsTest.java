package qa.guru;

import data.TestData;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static data.TestData.*;
import static pages.RegistrationPage.open;
import static pages.RegistrationPage.removeAdvertising;

@Tag("super")
public class CheckFieldsTest extends BaseTest {

    RegistrationPage registration = new RegistrationPage();
    TestData data = new TestData();

    @Test
    public void checkAllFieldsTest() {
        open();
        removeAdvertising();
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
    }

    @Test
    public void checkSmokeFieldsTest() {
        open();
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

        registration.checkResult("Student Name", data.firstName + " " + data.lastName)
                .checkResult("Mobile", data.mobileNumber)
                .checkResult("Gender", data.gender)
                .checkResult("Date of Birth", data.day + " " + data.month + "," + data.year)
                .checkResult("Subjects", data.subjectsInput)
                .checkResult("Picture", data.picture)
                .checkResult("State and City", data.uttarPradesh + " " + data.needCity);
    }

    @Test
    public void checkAllFieldsNegativeTest() {
        open();
        registration.setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setMobileNumber(data.mobileNumber)
                .selectGender(data.gender)
                .upploadPicture(data.picture)
                .clickSubmitButton();

        registration.checkResult("Student Name", data.firstName + " " + data.lastName)
                .checkResult("Mobile", data.mobileNumber)
                .checkResult("Gender", data.gender)
                .checkResult("Picture", data.picture)
                .checkResult("Subject", " ")
                .checkResult("State and City", " ")
                .checkResult("Address", " ");
    }
}