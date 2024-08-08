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
                .upploadPicture(pictureAv)
                .setAddress(currentAddress)
                .selectState(uttarPradesh)
                .selectCity(agra).
                clickSubmitButton();

        registration.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", gender)
                .checkResult("Mobile", mobileNumber)
                .checkResult("Date of Birth", day + " " + month + "," + year)
                .checkResult("Subjects", subjectsInput)
                .checkResult("Hobbies", hobbie)
                .checkResult("Picture", pictureAv)
                .checkResult("Address", currentAddress)
                .checkResult("State and City", uttarPradesh + " " + agra);
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
                .upploadPicture(pictureAv)
                .selectState(uttarPradesh)
                .selectCity(agra).
                clickSubmitButton();

        registration.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Mobile", mobileNumber)
                .checkResult("Gender", gender)
                .checkResult("Date of Birth", day + " " + month + "," + year)
                .checkResult("Subjects", subjectsInput)
                .checkResult("Picture", pictureAv)
                .checkResult("State and City", uttarPradesh + " " + agra);
    }

    @Test
    public void checkAllFieldsNegativeTest() {
        open();
        registration.setFirstName(firstName)
                .setLastName(lastName)
                .setMobileNumber(mobileNumber)
                .selectGender(gender)
                .upploadPicture(pictureTxT)
                .clickSubmitButton();

        registration.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Mobile", mobileNumber)
                .checkResult("Gender", gender)
                .checkResult("Picture", pictureTxT)
                .checkResult("Subject", " ")
                .checkResult("State and City", " ")
                .checkResult("Address", " ");
    }
}