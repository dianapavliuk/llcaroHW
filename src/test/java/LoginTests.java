import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    @BeforeMethod(alwaysRun = true)
    public void precondition(){
        if (isLogged()) logout();

    }
@Test (groups = {"positive"})
    public void loginPositiveTest(){
        String email = "love@gmail.com";
        String password = "abC121314#";
    User user = new User ().withEmail("love@gmail.com").withPassword("abC121314#");

    openLoginForm();
    fillLoginForm(user);
    logger.info("registrationPositiveTest starts with:"+ email+ " and "+ password );
    submitLogin();
    Assert.assertTrue(isLoggedSuccess());


    }
    @Test(groups = {"positive"})
    public void loginPositiveTestProps(){


        openLoginForm();
        fillLoginForm(getEmail(),
                getPassword());
       // logger.info("registrationPositiveTest starts with:"+ email+ " and "+ password );
        submitLogin();
        Assert.assertTrue(isLoggedSuccess());


    }
    @Test(groups = {"positive"})
    public void loginPositiveTest1(){
        User user = new User ().withEmail("love@gmail.com").withPassword("abC121314#");

        openLoginForm();
        fillLoginForm(user);
        submitLogin();
        Assert.assertTrue(isLoggedSuccess());


    }

    @AfterMethod(alwaysRun = true)
    public void postcondition(){

    clickOkButton();

    }
}
