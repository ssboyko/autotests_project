import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.*;

public class SearchTests {
    @Test
    void fusritName() {

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
    void name() {
    }
}
