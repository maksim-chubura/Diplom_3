package org.example.Resources;

import org.apache.commons.lang3.RandomStringUtils;

public class UserGenerator {
    public static User random() {
        return new User(RandomStringUtils.randomAlphabetic(8) + "@praktikum.ru", RandomStringUtils.randomAlphanumeric(6), RandomStringUtils.randomAlphabetic(6));
    }
}
