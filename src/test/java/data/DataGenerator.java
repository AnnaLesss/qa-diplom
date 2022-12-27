package data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Value;
import org.junit.jupiter.api.BeforeEach;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import com.github.javafaker.Faker;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;


public class DataGenerator {
    private static Faker faker;

    @BeforeEach
    void beforeAll() {
        faker = new Faker(new Locale("eng"));
    }

//    public static String generateDate(int months) {
//        return LocalDate.now().minusMonths(months).format(DateTimeFormatter.ofPattern("MM.yy"));
//    }
    public static String generateMonths(int months) {
        return LocalDate.now().minusMonths(months).format(DateTimeFormatter.ofPattern("MM"));
    }
    public static String generateYear() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("yy"));
    }

    public static String generateName(String locale) {
        var faker = new Faker(new Locale(locale));
        return faker.name().fullName();
    }

    public static String generateCvc() {
        var faker = new Faker();
        return faker.numerify("###");
    }

    public static CardInfo generateCard(String locale) {
        return new CardInfo("number",generateMonths(1), generateYear(), generateName(locale), generateCvc());
    }
    @Value
    @Data
    @AllArgsConstructor
    public static class CardInfo {
        String number;
        String months;
        String year;
        String name;
        String cvc;
    }

    public static String getValidCard() {

        return new Card("4444 4444 4444 4441","10","25","eng","");
    }

    public static Card getDeclinedCard() {

        return new Card("4444 4444 4444 4442","10","21","eng","");
    }

    public static Card getFakeCard() {

        return new Card("4444 4444 4444 4449","10","25","eng","");
    }

    public static Card getInvalidHolderCard() {
        return new Card("4444 4444 4444 4441","10","25","ru","");
    }

    public static Card getInvalidExpDateCard() {
        return new Card("4444 4444 4444 4441","10","20","eng","");
    }
    public static Card getInvalidExpDateCard(int months) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, months);
        String date =  new SimpleDateFormat("dd.MM.yy").format(calendar.getTime());
        String month = new SimpleDateFormat("MM").format(calendar.getTime());
        String year = new SimpleDateFormat("yy").format(calendar.getTime());
        return new Card("4444 4444 4444 4441", month, year, "Card Holder", "123");
    }
}