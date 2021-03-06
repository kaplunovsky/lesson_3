import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.Assert;
//import org.apache.logging.log4j.core.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.Selenide.sleep;

public class MainPage {

    @FindBy(how = How.XPATH, using = "//h1[text()='System Dashboard']")
    private SelenideElement Header;

    @FindBy(how = How.XPATH, using = "//div[@class='ghx-issue-count']")
    private SelenideElement TaskCount;

    @FindAll(@FindBy(how = How.XPATH, using = "//div[@class='ghx-issue-content']"))
    private List<WebElement> listTask;

    @FindBy(how = How.XPATH, using = "//span[@id='status-val']/span")
    private SelenideElement assertValue;

    @FindBy(how = How.XPATH, using = "//a[@id='create_link']")
    private SelenideElement btnCreate;

    @FindBy(how = How.XPATH, using = "//input[@id='summary']")
    private SelenideElement fldSummary;

    @FindBy(how = How.XPATH, using = "//*[@id='description-wiki-edit']")
    private SelenideElement fldDesc;

    @FindBy(how = How.XPATH, using = "//*[@id=\"assign-to-me-trigger\"]")
    private SelenideElement lnkAssignToMe;

    @FindBy(how = How.XPATH, using = "//input[@id='create-issue-submit']")
    private SelenideElement btnCreateSub;

    @FindBy(how = How.XPATH, using = "//a[@id='find_link']")
    private SelenideElement navTasks;

    @FindBy(how = How.XPATH, using = "//*[@id=\"issues_new_search_link_lnk\"]")
    private SelenideElement lnkNewSearch;

    @FindBy(how = How.XPATH, using = "//*[@id=\"searcher-query\"]")
    private SelenideElement fldSearchQuery;

    @FindBy(how = How.XPATH, using = "//*[@id=\"action_id_21\"]")
    private SelenideElement lnkInProgress;

    @FindBy(how = How.XPATH, using = "//*[@id=\"opsbar-transitions_more\"]")
    private SelenideElement lnkBProcess;

    @FindBy(how = How.XPATH, using = "//*[@id=\"action_id_31\"]")
    private SelenideElement lnkResolved;

    @FindBy(how = How.XPATH, using = "span[@id='status-val']/span")
    private SelenideElement txtStatus;

    public String SummaryText = "?????????????????? ?????? ?????????????????? 2";
    public String DescText = "???????????????? ?????? ?????????????????? 2";

    public MainPage isOpened() {
        Header.exists();
        return page(MainPage.class);
    }

    @Step("???????????????? ???????????????????? ?????????? d ??????????/???????????? {HeadValue}/{ListValue}")
    public MainPage checkValue(){
        int HeadValue = Integer.parseInt(TaskCount.text().split(" ")[0]);
        int ListValue = listTask.size();

        System.out.println("??????-???? ?? ??????????/????????????:  " + HeadValue + " / " + ListValue);

        Assert.assertEquals(HeadValue, ListValue);
        return page(MainPage.class);
    }

    @Step("???????????????? ????????????. Summary: {SummaryText}")
    public MainPage CreateTask(){

        btnCreate.click();
        sleep(1000);
        fldSummary.click();
        fldSummary.sendKeys(SummaryText);
        //      fldDesc.click();       // element not interactable
        //      fldDesc.sendKeys(DescText);  // element not interactable
        lnkAssignToMe.click();
        btnCreateSub.click();
        return page(MainPage.class);
    }

    @Step("?????????????????? ????????????????.")
    public MainPage ChangeStatus(){
        navTasks.click();
        lnkNewSearch.click();
        fldSearchQuery.click();
        fldSearchQuery.setValue(SummaryText);
        fldSearchQuery.sendKeys(Keys.ENTER);
        lnkInProgress.click();
        sleep(1000);
        lnkBProcess.click();
        lnkResolved.click();
        return page(MainPage.class);
    }

    @Step("???????????????? ?????????????? {statusvalue}")
    public MainPage AssertValue(String statusvalue) {
        sleep(1000);
        Assertions.assertEquals(assertValue.text(), statusvalue);
        System.out.println("????????????: " + assertValue.text());
        return page(MainPage.class);
    }
}


