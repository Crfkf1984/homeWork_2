package data;

import com.github.javafaker.Faker;

public class TestData {

    static Faker faker = new Faker();

    public static String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            mobileNumber = faker.number().digits(10),
            subjectsInput = "Hindi",
            gender = "Male",
            hobbie = "Sports",
            pictureAv = "google.avif",
            pictureTxT = "google.txt",
            currentAddress = faker.address().streetAddress(),
            uttarPradesh = "Uttar Pradesh",
            agra = "Agra",
            day = "6",
            month = "August",
            year = "2024";
}