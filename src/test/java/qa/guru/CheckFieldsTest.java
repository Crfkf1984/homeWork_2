package qa.guru;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static data.TestData.*;
import static pages.RegistrationPage.open;
import static pages.RegistrationPage.removeAdvertising;

public class CheckFieldsTest extends BaseTest {

    RegistrationPage registration = new RegistrationPage();

    @Test
    public void checkAllFieldsTest() {
        open();
        removeAdvertising();
        registration.setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .selectGender(gender)
                .setMobileNumber(mobileNumber)
                .selectDate(day, month, year)
                .selectSubject(subjectsInput)
                .selectHobbie(hobbie)
                .upploadPicture(picture)
                .setAddress(currentAddress)
                .selectState(uttarPradesh)
                .selectCity(needCity).
                clickSubmitButton();

        registration.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", gender)
                .checkResult("Mobile", mobileNumber)
                .checkResult("Date of Birth", day + " " + month + "," + year)
                .checkResult("Subjects", subjectsInput)
                .checkResult("Hobbies", hobbie)
                .checkResult("Picture", picture)
                .checkResult("Address", currentAddress)
                .checkResult("State and City", uttarPradesh + " " + needCity);
    }

    @Test
    public void checkSmokeFieldsTest() {
        open();
        registration.setFirstName(firstName)
                .setLastName(lastName)
                .setMobileNumber(mobileNumber)
                .selectGender(gender)
                .selectDate(day, month, year)
                .selectSubject(subjectsInput)
                .upploadPicture(picture)
                .selectState(uttarPradesh)
                .selectCity(needCity).
                clickSubmitButton();

        registration.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Mobile", mobileNumber)
                .checkResult("Gender", gender)
                .checkResult("Date of Birth", day + " " + month + "," + year)
                .checkResult("Subjects", subjectsInput)
                .checkResult("Picture", picture)
                .checkResult("State and City", uttarPradesh + " " + needCity);
    }

    @Test
    public void checkAllFieldsNegativeTest() {
        open();
        registration.setFirstName(firstName)
                .setLastName(lastName)
                .setMobileNumber(mobileNumber)
                .selectGender(gender)
                .upploadPicture(picture)
                .clickSubmitButton();

        registration.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Mobile", mobileNumber)
                .checkResult("Gender", gender)
                .checkResult("Picture", picture)
                .checkResult("Subject", " ")
                .checkResult("State and City", " ")
                .checkResult("Address", " ");
    }
}