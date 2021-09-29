package by.sheidak.services;

import by.sheidak.entity.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegistrationTest {
    private final SessionFacade sessionFacade = new SessionFacade();

    @Test
    void saveNewUser() {
        User user = new User("Masha", "mashasheidak", "masha");

        assertTrue(sessionFacade.registration(user));
    }
}