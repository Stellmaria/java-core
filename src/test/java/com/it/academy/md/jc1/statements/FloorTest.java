package com.it.academy.md.jc1.statements;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test for class Floor.")
class FloorTest {
    private Floor floor;

    @BeforeEach
    void init() {
        floor = new Floor();
    }

    static @NotNull Stream<Arguments> getFloorNumberProvideArguments() {
        return Stream.of(
                Arguments.of(2, 10, 45, 1),
                Arguments.of(9, 4, 169, 7),
                Arguments.of(18, 10, 180, 18),
                Arguments.of(1, 1, 1, 1),
                Arguments.of(10, 5, 11, 3),
                Arguments.of(10, 4, 10, 3)
        );
    }

    @ParameterizedTest(name = "Floors, apartment of floors and number apartment: {0}")
    @MethodSource("getFloorNumberProvideArguments")
    @DisplayName("Test for method getFloorNumber() from class Floor.")
    void getFloorNumber(final int numberFloors, final int numberApartmentsPerFloor, final int apartmentNumber,
                        final int expected) {
        var actual = floor.getFloorNumber(numberFloors, numberApartmentsPerFloor, apartmentNumber);

        assertEquals(expected, actual);
    }
}