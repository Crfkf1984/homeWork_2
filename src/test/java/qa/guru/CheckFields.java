package qa.guru;

import org.junit.jupiter.api.Test;

import static qa.guru.RegistrationPage.open;

public class CheckFields extends BaseTest {

    RegistrationPage registration = new RegistrationPage();

    @Test
    public void checkAllFieldsTest() {
        open();
        registration.setFirstName("Иван")
                .setLastName("Иванов")
                .setEmail("lenin@mail.ru")
                .selectGender("Male")
                .setNumber("8911567349")
                .selectDate("6", "August", "2024")
                .selectSubjects("Hindi")
                .selectHobbies("Sports")
                .upploadPicture("google.avif")
                .currentAddress("https://demoqa.com/automation-practice-form")
                .selectState("Uttar Pradesh")
                .selectCity("Agra").
                clickButtonSubmit();

        registration.checkResult("Student Name", "Иван Иванов")
                .checkResult("Student Email", "lenin@mail.ru")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "8911567349")
                .checkResult("Date of Birth", "6 August,2024")
                .checkResult("Subjects", "Hindi")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "google.avif")
                .checkResult("Address", "https://demoqa.com/automation-practice-form")
                .checkResult("State and City", "Uttar Pradesh Agra");
    }

    @Test
    public void checkSmokeFieldsTest() {
        open();
        registration.setFirstName("Иван")
                .setLastName("Иванов")
                .setNumber("8911567349")
                .selectGender("Male")
                .selectDate("6", "August", "2024")
                .selectSubjects("Hindi")
                .upploadPicture("google.avif")
                .selectState("Uttar Pradesh")
                .selectCity("Agra").
                clickButtonSubmit();

        registration.checkResult("Student Name", "Иван Иванов")
                .checkResult("Mobile", "8911567349")
                .checkResult("Gender", "Male")
                .checkResult("Date of Birth", "6 August,2024")
                .checkResult("Subjects", "Hindi")
                .checkResult("Picture", "google.avif")
                .checkResult("State and City", "Uttar Pradesh Agra");
    }

    @Test
    public void checkAllFieldsNegativeTest() {
        open();
        registration.setFirstName("@#")
                .setLastName("^&")
                .setNumber("0123789457")
                .selectGender("Male")
                .upploadPicture("google.txt")
                .clickButtonSubmit();

        registration.checkResult("Student Name", "@# ^&")
                .checkResult("Mobile", "0123789457")
                .checkResult("Gender", "Male")
                .checkResult("Picture", "google.txt")
                .checkResult("Subject", " ")
                .checkResult("State and City", " ")
                .checkResult("Address", " ");
    }
}