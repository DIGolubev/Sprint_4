import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
@Story("Печать строки на карте")
public class CorrectNameTest {
    private final String nameSurname;
    private final boolean expected;

    public CorrectNameTest(String nameSurname, boolean expected) {
        this.nameSurname = nameSurname;
        this.expected = expected;
    }

    @Parameterized.Parameters(name = "Тестовые данные: имя  = {0}; корректность = {1}")
    public static Object[][] getNameData() {
        return new Object[][] {
                {" Шаламе", false},
                {" Т Ш ", false},
                {"ТимотейШевроле", false},
                {"Тимоти Шаламе", true},
                {null, false},
                {"Т Ш", true},
                {"Тиммоттей Шеввролле", true},
                {"Тиммоттей Шеввроллее", false},
                {"", false},
        };
    }

    @Test
    @Description("в строке не меньше 3 и не больше 19 символов,\n" +
            "в строке есть только один пробел,\n" +
            "пробел стоит не в начале и не в конце строки.")
    public void shouldBeTrimmed() {
        Account account = new Account(nameSurname);
        account.checkNameToEmboss();
        assertEquals("Требования не соблюдены",expected, account.checkNameToEmboss());
    }
}
