import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Selenide.page;

public class AutorizationPage  {

    @FindBy(how = How.XPATH, using = "//input[@id='login-form-username']")
    private SelenideElement fldLogin;

    @FindBy(how = How.XPATH, using = "//input[@id='login-form-password']")
    private SelenideElement fldPassword;

    @FindBy(how = How.XPATH, using = "//*[@id='login-form-submit']")
    private SelenideElement btnLogIn;

    @FindBy(how = How.XPATH, using = "//*[@id='login-form-cancel']")
    private SelenideElement btnCantIn;

    @Step("Авторизация пользователем. Ввод логина: {login}")
    public AutorizationPage clicButtonLogIn(String login) {
        fldLogin.click();
        fldLogin.sendKeys(login);
        return page(AutorizationPage.class);
    }
    @Step("Авторизация пользователем. Ввод пароля. ")
    public AutorizationPage clicButtonPassword(String password) {
        fldPassword.click();
        fldPassword.sendKeys(password);
        return page(AutorizationPage.class);
    }

    public AutorizationPage clicButtonIn() {
        btnLogIn.click();
        return page(AutorizationPage.class);
    }
}

