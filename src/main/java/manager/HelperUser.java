package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.interactions.Actions;

public interface HelperUser extends HelperBase {

    default void openLoginForm(){
        click(By.xpath("//*[.='Log in']"));
      // click(By.xpath("/html/body/app-root/app-navigator/div[1]/a[6]"));

     }
    default void openRegistrationForm(){

       click(By.xpath("//*[.='Sign up']"));


    }

    default void fillLoginForm(User user){
     type(By.id("email"), user.getEmail());
        //type(By.xpath("/html/body/app-root/app-navigator/app-login-registration/div/div/div/app-login/form/div[1]/input"), user.getEmail());
      type(By.id("password"), user.getPassword());


     }
    default void fillLoginForm(String email, String password){
        type(By.id("email"),email);
      //  type(By.xpath("/html/body/app-root/app-navigator/app-login-registration/div/div/div/app-login/form/div[1]/input"), email);
        type(By.id("password"),password);


    }



    default void fillRegistrationForm(User user){
        type(By.id("name"), user.getName());
        type(By.id("lastName"), user.getLastName());
        type(By.id("email"), user.getEmail());
        type(By.id("password"), user.getPassword());
        clickCheckbox();


    }

  default   void clickCheckbox(){
        //variant 1
       // click(By.cssSelector("label[for='terms-of-use']"));
      //variant 2 universal!!!
      JavascriptExecutor js = (JavascriptExecutor) wd;
     js.executeScript("document.querySelector('#terms-of-use').click();");
      //variant 3
     // Rectangle rect = wd.findElement(By.cssSelector("label[for='terms-of-use']")).getRect();
     // int x = rect.getX() +rect.getWidth()*7/8;
     // int y = rect.getY()+rect.getWidth()/2;
    //  Actions actions = new Actions(wd);
    //  actions.moveByOffset(x, y).click().perform();

  }

    default void submitLogin(){
     click(By.xpath("//button[@type='submit']"));
     }
    default void submitRegistration(){
        click(By.xpath("//button[@type='submit']"));
    }
default boolean isLoggedSuccess(){
    //return isElementPresent(By.xpath("//h2[contains(text(),'success')]"));
    return isElementPresent(
            By.xpath("//h2[contains(text(),'success')]"));
     }
    default boolean isLogged(){
        //return isElementPresent(By.xpath("//h2[contains(text(),'success')]"));
        return isElementPresent(
                By.xpath("//*[.='Logout'] "));
    }
default void logout(){
    click(By.xpath("//*[.='Logout'] "));
      }

default void clickOkButton(){
click(By.xpath("//button[@type = 'button']"));
    }
    default void login (User user){
      openLoginForm();
      fillLoginForm(user);
      submitLogin();
      clickOkButton();

    }
}
