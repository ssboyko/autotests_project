import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.*;

public class DemoQaPracticeTests {
    LocalDate randomDate = LocalDate.now().minusMonths(5).minusDays(20).minusYears(20);
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
    void demoQaPracticeFormTest() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("Stepan");
        $("#lastName").setValue("Boiko");
        $("#userEmail").setValue("stepan@boiko.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("89132220022");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOptionByValue("2023");
        $(".react-datepicker__month-dropdown-container").$(byText("April")).click();
        $(".react-datepicker__month-container").$(byText("10")).click();
        $("#subjectsContainer").click();
        $("#subjectsInput").setValue("English").pressEnter();
        $("#hobbies-checkbox-1").parent().$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("pictures/bulldog.png");
        $("#currentAddress").setValue("random text");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".modal-body").shouldHave(text("Stepan Boiko"));


    }
}
