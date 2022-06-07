package scripts;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class CarsSignInPageTest extends Base {

     @Test(priority = 1, description = "TC001")
    public void testSignInWithEmail(){
         driver.get("https://www.cars.com/");
         homePage.signInLink.click();

         Assert.assertTrue(signInPage.emailInputBox.isDisplayed() && signInPage.emailLabel.getText().equals("Email"));
         Assert.assertTrue(signInPage.emailInputBox.isEnabled());
         Assert.assertTrue(signInPage.passwordInputBox.isDisplayed() && signInPage.passwordLabel.getText().equals("Password"));
         Assert.assertTrue(signInPage.passwordInputBox.isEnabled());
         Assert.assertTrue(signInPage.forgotPasswordLink.isDisplayed() && signInPage.forgotPasswordLink.getText().equals("Forgot password?"));
         Assert.assertTrue(signInPage.forgotPasswordLink.isEnabled());
         Assert.assertTrue(signInPage.signInButton.isDisplayed() && signInPage.signInButton.getText().equals("Sign in"));
         Assert.assertTrue(signInPage.signInButton.isEnabled());

     }
    @Test(priority = 2, description = "TC002")
    public void testInvalidCredentials(){
        driver.get("https://www.cars.com/");
        homePage.signInLink.click();

        signInPage.emailInputBox.sendKeys("johndoe@gmail.com", Keys.ENTER);
        signInPage.passwordInputBox.sendKeys("abcd1234", Keys.ENTER);
        signInPage.signInButton.click();
        Assert.assertTrue(signInPage.signInErrorMessage.isDisplayed());
        Assert.assertTrue(signInPage.signInErrorMessage.isDisplayed() && signInPage.signInErrorMessage.getText().equals("We were unable to sign you in.\n"+
                "Your email or password was not recognized. Try again soon."));

    }

    @Test(priority = 3, description = "TC003")
    public void testSignInPage(){
        driver.get("https://www.cars.com/");

        homePage.signInLink.click();

        String actualResult = signInPage.signInText.getText();
        String expectedResult = "By signing in to your profile, you agree to our  Privacy Statement  and  Terms of Service.";

        Assert.assertTrue(signInPage.heading1.isDisplayed() && signInPage.heading1.getText().equals("Sign in"));
        Assert.assertTrue(signInPage.signInMessage.isDisplayed());
        Assert.assertEquals(signInPage.signInMessage.getText(),"New to Cars.com? Sign up. Are you a dealer?");
        Assert.assertTrue(signInPage.warningMessage.isDisplayed() && signInPage.warningMessage.getText().equals("Minimum of eight characters"));
        Assert.assertTrue(signInPage.signInText.isDisplayed());
        Assert.assertEquals(actualResult, expectedResult);

     }

    @Test(priority = 4, description = "TC004")
    public void testSignInPageSocialMedia(){
        driver.get("https://www.cars.com/");
        homePage.signInLink.click();

        Assert.assertTrue(signInPage.heading3.isDisplayed() && signInPage.heading3.getText().equals("Connect with social"));

        for(WebElement elements: signInPage.socialMediaLinks){
            Assert.assertTrue(elements.isDisplayed() && elements.isEnabled());


        for(int i = 0; i <= 2; i++){
            Assert.assertTrue(signInPage.socialMediaLinks.get(0).getText().equals("Sign in with Facebook"));
            Assert.assertTrue(signInPage.socialMediaLinks.get(1).getText().equals("Sign in with Google"));
            Assert.assertTrue(signInPage.socialMediaLinks.get(2).getText().equals("Sign in with Apple"));

            }
        }
    }
}