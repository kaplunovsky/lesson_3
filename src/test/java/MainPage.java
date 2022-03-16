import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

import static com.codeborne.selenide.Selenide.page;

public class MainPage {

    @FindBy(how = How.XPATH, using = "//h1[text()='System Dashboard']")
    private SelenideElement Header;

    @FindBy(how = How.XPATH, using = "//div[@class='ghx-issue-count']")
    private SelenideElement TaskCount;

    @FindAll(@FindBy(how = How.XPATH, using = "//div[@class='ghx-issue-content']"))
    private List<WebElement> listTask;

    @FindBy(how = How.XPATH, using = "//span[@id='status-val']/span")
    private SelenideElement assertValue;

    public MainPage isOpened() {
        Header.exists();
        return page(MainPage.class);
    }

    public MainPage checkValue(){
        int HeadValue = Integer.parseInt(TaskCount.text().split(" ")[0]);
        int ListValue = listTask.size();

        System.out.println("Кол-во в шапке/списке:  " + HeadValue + " / " + ListValue);

        Assert.assertEquals(HeadValue, ListValue);
        return page(MainPage.class);
    }


    public MainPage assertValue(String value) {

        return page(MainPage.class);
    }
}


