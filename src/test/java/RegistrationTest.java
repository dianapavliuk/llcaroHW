import models.User;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase{
@Test

    public void registrationPositive(){
    int i = (int)(System.currentTimeMillis()/1000)%3600;
    String email = "jessy"+ i +"@gmail.com";
    String password = "abC121212#";
    String name = "Jessy";
    String lastName = "Baker";



   User user = new User ().withName("Jessy")
            .withLastName("Baker")
            .withEmail("jessy"+ i+ "@gmail.com")
            .withPassword("abC121212#");

    openRegistrationForm();
    fillRegistrationForm(user);
    logger.info("registrationPositiveTest starts with:" + name+ lastName + email+ password );
    submitRegistration();


}
@Test
public void registrationNegativeWrongEmail(){
    String email = "jessygmail.com";
    String password = "abC121212#";
    String name = "Jessy";
    String lastName = "Baker";
 User user = new User().withName("Jessy")
                 .withLastName("Baker")
                         .withEmail("jessygmail.com")
                                 .withPassword("abC121314#");
    openRegistrationForm();
    fillRegistrationForm(user);
    logger.info("registrationNegativeWrongEmail starts with:" + name+ lastName + email+ password );
    submitRegistration();
}
    @Test
    public void registrationNegativeWrongPassword(){
        String email = "jessy@gmail.com";
        String password = "abC121212";
        String name = "Jessy";
        String lastName = "Baker";

        User user = new User().withName("Jessy")
                .withLastName("Baker")
                .withEmail("jessy@gmail.com")
                .withPassword("abC121314");
        openRegistrationForm();
        fillRegistrationForm(user);
        logger.info("registrationNegativeWrongPassword starts with:" + name+ lastName + email+ password );
        submitRegistration();
    }


}
