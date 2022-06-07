package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class SignInPage {
    public SignInPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(tagName = "h1")
    public WebElement heading1;

    @FindBy(xpath = "//p[contains(@class,'sds')]")
    public WebElement signInMessage;

    @FindBy(id = "email")
    public WebElement emailInputBox;

    @FindBy(css = "label[class='sds-label']")
    public WebElement emailLabel;

    @FindBy(id = "password")
    public WebElement passwordInputBox;

    @FindBy(xpath = "//label[text()='Password']")
    public WebElement passwordLabel;

    @FindBy(xpath = "//p[text()='Minimum of eight characters']")
    public WebElement warningMessage;

    @FindBy(xpath = "//a[text()='Forgot password?']")
    public WebElement forgotPasswordLink;

    @FindBy(css = "div[class='sds-disclaimer ']")
    public WebElement signInText;

    @FindBy(css = "button[class='sds-button']")
    public WebElement signInButton;

    @FindBy(tagName = "h3")
    public WebElement heading3;

    @FindBy(xpath = "//div[@class='column-2 sidebar-social-login']//a")
    public List<WebElement> socialMediaLinks;

    @FindBy(css = "div[class='sds-notification__content']")
    public WebElement signInErrorMessage;



}