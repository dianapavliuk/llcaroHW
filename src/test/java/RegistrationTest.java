import models.User;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase{
@Test

    public void registrationPositive(){
    int i = (int)(System.currentTimeMillis()/1000)%3600;

   User user = new User ().withName("Jessy")
            .withLastName("Baker")
            .withEmail("jessy"+ i+ "@gmail.com")
            .withPassword("abC121212#");

    openRegistrationForm();
    fillRegistrationForm(user);
    submitRegistration();


}
}
