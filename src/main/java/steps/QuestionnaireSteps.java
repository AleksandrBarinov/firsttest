package steps;

import pages.QuestionnairePage;
import ru.yandex.qatools.allure.annotations.Step;
import java.util.HashMap;

public class QuestionnaireSteps extends BaseSteps{

    @Step("Поле {0} заполняется значением {1}")
    public void stepFillField(String field, String value){
        new QuestionnairePage(driver).fillField(field,value);
    }

    @Step("Заполняются поля:")
    public void stepFillFields(HashMap<String,String> fields){
        fields.forEach( (key,value) ->
            stepFillField(key, value));
    }

    @Step("Нажата кнопка 'Минимальный'")
    public  void selectMinimal(){
        new QuestionnairePage(driver).selectMinimal(driver);
    }

    @Step("Нажата кнопка 'Оформить'")
    public void selectRegister(){
        new QuestionnairePage(driver).selectRegister(driver);
    }

    @Step("Нажата кнопка 'Продолжить'")
    public void selectContinue(){
        new QuestionnairePage(driver).selectContinue(driver);
    }

}
