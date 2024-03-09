import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.*;

public class SearchTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }
    @Test
    void firstTest() {
        LocalDate parsed = LocalDate.parse("24.02.2024", DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        assertEquals(DayOfWeek.SATURDAY, parsed.getDayOfWeek());
    }

    @Test
    void successfulSearchTest() {
        open("https://www.google.com/");
        $("[name=q]").setValue("selenide").pressEnter();
        $("[id=search]").shouldHave(text("https://selenide.org"));
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("Stepan");
        $("#lastName").setValue("Boiko");
        $("#userEmail").setValue("stepan@boiko.com");
        $("#genterWrapper").$(byText("Male")).click();
//        $("#currentAddress").setValue("Some address 1");
//        $("#permanentAddress").setValue("Another address 1");
//        $("#submit").click();

    }
}
