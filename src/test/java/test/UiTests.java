package test;

import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.open;

public class UiTests {

    @BeforeEach
    void setUp() {
        open("http://localhost:8080/");
    }

}
