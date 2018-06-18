package util;

import org.junit.runner.notification.Failure;
import ru.yandex.qatools.allure.junit.AllureRunListener;

public class AllureListener extends AllureRunListener {
    @Override
    public void testFailure(Failure failure){
        super.testFailure(failure);
    }
}
