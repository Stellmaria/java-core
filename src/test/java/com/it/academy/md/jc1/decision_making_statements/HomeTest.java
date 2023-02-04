package com.it.academy.md.jc1.decision_making_statements;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test for class Home.")
class HomeTest {
    private Home home;

    static @NotNull Stream<Arguments> getPorchNumberProvideArguments() {
        return Stream.of(
                Arguments.of(2, 10, 45, 3),
                Arguments.of(9, 4, 169, 5),
                Arguments.of(18, 10, 180, 1),
                Arguments.of(1, 1, 1, 1),
                Arguments.of(10, 5, 11, 1),
                Arguments.of(10, 4, 10, 1)
        );
    }

    @BeforeEach
    void init() {
        home = new Home();
    }

    @ParameterizedTest(name = "Floors, apartment of floors and number apartment: {0}")
    @MethodSource("getPorchNumberProvideArguments")
    @DisplayName("Test for method getPorchNumber() from class Home.")
    void getPorchNumber(final int numberFloors, final int numberApartmentsPerFloor, final int apartmentNumber,
                        final int expected) {
        var actual = home.getPorchNumber(numberFloors, numberApartmentsPerFloor, apartmentNumber);

        assertEquals(expected, actual);
    }
}