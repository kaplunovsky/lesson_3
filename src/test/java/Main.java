import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.BeforeClass;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import static com.codeborne.selenide.Selenide.closeWebDriver;


public class Main {
    String login = "kapOleg";
    String password = "123qaz!@#QAZ";
    String Status = "ГОТОВО";

    @BeforeClass
    public static void before(){
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide().
                        screenshots(true).
                        savePageSource(false)
                );
    }

    @BeforeAll
    static void Test_Open() {
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver" , "./src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverRunner.setWebDriver(driver);

    }

    @AfterAll
    static void Test_Close() {
        closeWebDriver();
    }


    @Test
    @DisplayName("Проверка количества задач")
    public void Test1() {
        Selenide.open("https://edujira.ifellow.ru/login.jsp" , AutorizationPage.class)
                .clicButtonLogIn(login)
                .clicButtonPassword(password)
                .clicButtonIn();
        Selenide.open("https://edujira.ifellow.ru/secure/RapidBoard.jspa?rapidView=1&projectKey=TEST&view=planning", MainPage.class)
                .isOpened()
                .checkValue();
    }

    @Test
    @DisplayName("Создание задачи. Изменение статусов.")
    public void Test2() {
        Selenide.open("https://edujira.ifellow.ru/login.jsp" , AutorizationPage.class)
                .clicButtonLogIn(login)
                .clicButtonPassword(password)
                .clicButtonIn();
        Selenide.open("https://edujira.ifellow.ru/secure/RapidBoard.jspa?rapidView=1&projectKey=TEST&view=planning", MainPage.class)
                .isOpened()
                .CreateTask()
                .ChangeStatus()
                .AssertValue(Status);
    }

}
