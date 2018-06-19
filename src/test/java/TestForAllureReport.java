import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Title;
import steps.BaseSteps;
import steps.MainSteps;
import steps.QuestionnaireSteps;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class TestForAllureReport extends BaseSteps{

    @Test
    @Title("Страхование")
    public void testInsurance(){
        MainSteps mainSteps = new MainSteps();
        QuestionnaireSteps questionnaireSteps = new QuestionnaireSteps();

        HashMap<String,String> testData = new HashMap <>();

        testData.put("insuredSurname", "FAMILINS");
        testData.put("insuredName", "NAMES");
        testData.put("insuredBirthDate", "26021990");

        testData.put("surname", "Фамилинс");
        testData.put("name", "Нэймс");
        testData.put("middlename", "Батькович");
        testData.put("birthDate", "26021990");

        testData.put("passportSeries", "5555");
        testData.put("passportNumber", "555555");
        testData.put("issueDate", "10102010");
        testData.put("issuePlace", "Кем то выдан");

        mainSteps.selectMainMenu("Страхование");
        mainSteps.selectSubMenu("Путешествия и покупки");
        mainSteps.selectRegisterOnline();

        ArrayList tabs2 = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window((String) tabs2.get(1));

        questionnaireSteps.selectMinimal();

        questionnaireSteps.selectRegister();

        questionnaireSteps.stepFillFields(testData);

        assertEquals("11102010",testData.get("issueDate"));

        questionnaireSteps.selectContinue();
    }
}
