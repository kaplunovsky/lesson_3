import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
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
    public void Test1() {
        Selenide.open("https://edujira.ifellow.ru/login.jsp" , AutorizationPage.class)
                .clicButtonLogIn()
                .clicButtonPassword()
                .clicButtonIn();
        Selenide.open("https://edujira.ifellow.ru/secure/RapidBoard.jspa?rapidView=1&projectKey=TEST&view=planning", MainPage.class)
                .isOpened()
                .checkValue();
    }

    @Test
    public void Test2() {
        Selenide.open("https://edujira.ifellow.ru/login.jsp" , AutorizationPage.class)
                .clicButtonLogIn()
                .clicButtonPassword()
                .clicButtonIn();
        Selenide.open("https://edujira.ifellow.ru/secure/RapidBoard.jspa?rapidView=1&projectKey=TEST&view=planning", MainPage.class)
                .isOpened()
                .CreateTask()
                .ChangeStatus()
                .AssertValue(Status);
    }


}
