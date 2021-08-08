package qa_guru_git;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SimpleTest2 {


    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    void FindCodeJUnit5OnPageSoftAssertionTest() {
        open("https://github.com/");

        //ищем Selenide
        $("[name=q]").setValue("Selenide").pressEnter();
        // слева ищем и переходим в Wikis
        $("#js-pjax-container").$(byText("Wikis")).click();
        // ищем SoftAssertions и переходим в него
        $(byText("SoftAssertions")).click();
        //проверяем, что внутри есть пример кода для JUnit5
        $("#js-repo-pjax-container").shouldHave(text("Using JUnit5 extend test class:"));
    }
}

