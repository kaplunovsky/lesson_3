import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class AutorizationPage extends Main {

    @FindBy(how = How.XPATH, using = "//input[@id='login-form-username']")
    private SelenideElement fldLogin;

    @FindBy(how = How.XPATH, using = "//input[@id='login-form-password']")
    private SelenideElement fldPassword;

    @FindBy(how = How.XPATH, using = "//*[@id='login-form-submit']")
    private SelenideElement btnLogIn;

    @FindBy(how = How.XPATH, using = "//*[@id='login-form-cancel']")
    private SelenideElement btnCantIn;

    public AutorizationPage clicButtonLogIn() {
        fldLogin.click();
        fldLogin.sendKeys(login);
        return page(AutorizationPage.class);
    }
    public AutorizationPage clicButtonPassword() {
        fldPassword.click();
        fldPassword.sendKeys(password);
        return page(AutorizationPage.class);
    }

    public AutorizationPage clicButtonIn() {
        btnLogIn.click();
        return page(AutorizationPage.class);
    }
}

