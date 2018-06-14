import org.junit.Test;
import pages.MainPage;
import pages.QuestionnairePage;

import java.util.ArrayList;

public class MyRefactoredTest extends BaseTest{

    @Test
    public void newInsuranceTest(){
        MainPage mainPage = new MainPage(driver);

        mainPage.selectMainMenu("Страхование");

        mainPage.selectSubMenu(driver,"Путешествия и покупки");

        mainPage.selectRegisterOnline(driver);

        ArrayList tabs2 = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window((String) tabs2.get(1));

        QuestionnairePage questionnairePage = new QuestionnairePage(driver);

        questionnairePage.selectMinimal(driver);

        questionnairePage.selectRegister(driver);

        questionnairePage.fillField("insuredSurname","FAMILINS");
        questionnairePage.fillField("insuredName","NAMES");
        questionnairePage.fillField("insuredBirthDate","26021990");

        questionnairePage.fillField("surname","Фамилинс");
        questionnairePage.fillField("name","Нэймс");
        questionnairePage.fillField("middlename","Батькович");
        questionnairePage.fillField("birthDate","26021990");

        questionnairePage.fillField("passportSeries","5555");
        questionnairePage.fillField("passportNumber","555555");
        questionnairePage.fillField("issueDate","10102010");
        questionnairePage.fillField("issuePlace","Кем то выдан");


        questionnairePage.selectContinue(driver);
    }


}
