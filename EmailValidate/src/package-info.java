import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class test{
    @Test
    void testEmailvalidator(){
        EmailValidator email = new EmailValidator();
        boolean bool = email.isValidEmail("asdf@gmail.com");
        assertTrue(bool);
    }
}