package open.trivia.controllers;

import org.junit.Test;

import java.util.UUID;

public class CookieMonsterControllerTest {

    @Test
    public void test() {

        String token = UUID.randomUUID().toString();

        System.out.println(token);
    }

}