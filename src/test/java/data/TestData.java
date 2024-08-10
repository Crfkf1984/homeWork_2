package data;

import com.github.javafaker.Faker;

public class TestData {

    static Faker faker = new Faker();

    public String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            userEmail = faker.internet().emailAddress(),
            mobileNumber = faker.number().digits(10),
            subjectsInput = faker.options().option("Hindi", "History"),
            gender = faker.options().option("Male", "Female", "Other"),
            hobbie = faker.options().option("Sports", "Reading", "Music"),
            picture = faker.options().option("google.txt", "google.avif"),
            currentAddress = faker.address().streetAddress(),
            uttarPradesh = faker.options().option("Uttar Pradesh", "NCR", "Haryana", "Rejasthan"),
            needCity = getCity(uttarPradesh),
            day = String.valueOf(faker.date().birthday().getDay()),
            month = faker.options().option("August", "September", "October"),
            year = faker.options().option("2024", "2025", "1974");

    private static String getCity(String currentState) {
        String chooseCity;
        if (currentState.equals("NCR")) {
            chooseCity = new Faker().options().option("Delhi", "Gurgaon", "Noida");
        } else if (currentState.equals("Uttar Pradesh")) {
            chooseCity = new Faker().options().option("Agra", "Lucknow", "Merrut");
        } else if (currentState.equals("Haryana")) {
            chooseCity = new Faker().options().option("Kamal", "Panipat");
        } else {
            chooseCity = new Faker().options().option("Jaipur", "Jaiselmer");
        }
        return chooseCity;
    }
}