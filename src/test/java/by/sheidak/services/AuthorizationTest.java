package by.sheidak.services;

import by.sheidak.entity.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuthorizationTest {
    private final SessionFacade sessionFacade = new SessionFacade();

    @Test
    void logIn() {
        User user = new User("Masha", "mashasheidak", "masha");
        sessionFacade.registration(user);

        assertTrue(sessionFacade.authorization(user));
    }
}