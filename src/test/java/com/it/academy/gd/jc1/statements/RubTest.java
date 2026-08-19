package com.it.academy.gd.jc1.statements;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test for class Rub.")
class RubTest {
    private Rub rub;

    @BeforeEach
    void init() {
        rub = new Rub();
    }

    static Stream<Arguments> rubleForms() {
        return Stream.of(
                Arguments.of(0, "0 рублей."),
                Arguments.of(1, "1 рубль."),
                Arguments.of(2, "2 рубля."),
                Arguments.of(4, "4 рубля."),
                Arguments.of(5, "5 рублей."),
                Arguments.of(11, "11 рублей."),
                Arguments.of(14, "14 рублей."),
                Arguments.of(21, "21 рубль."),
                Arguments.of(22, "22 рубля."),
                Arguments.of(25, "25 рублей."),
                Arguments.of(1092, "1092 рубля."),
                Arguments.of(1111, "1111 рублей."),
                Arguments.of(-1, "Некорректная сумма -1")
        );
    }

    @ParameterizedTest(name = "Amount {0}")
    @MethodSource("rubleForms")
    @DisplayName("Test for method getSum() from class Rub.")
    void getSum(final int amount, final String expected) {
        assertEquals(expected, rub.getSum(amount));
    }
}
