package com.it.academy.md.jc1.statements;

/**
 * <h3>RU: Принятие решений.</h3>
 *
 * <h3>EN: Decision making statements.</h3>
 *
 * @author Anastasia Melnikova.
 */
public class Floor {
    /**
     * <h4>RU: Задание 13.</h4>
     * <p>Разработать программу для сервиса доставки.</p>
     * <p>Определить номер этажа дома для текущего клиента.</p>
     * <p>Определяет номер этажа дома для текущего клиента.</p><br>
     *
     * <h4>EN: Task 13.</h4>
     * <p>Develop a program for a delivery service.</p>
     * <p>Determine the floor number of the house for the current client.</p>
     * <p>Specifies the floor number of the building for the current client.</p><br>
     *
     * @param numberFloors             количество этажей / number of floors.
     * @param numberApartmentsPerFloor количество квартир на этаже / number of apartments per floor.
     * @param apartmentNumber          номер квартиры / apartment number.
     * @return номер этажа / floor number.
     */
    public int getFloorNumber(final int numberFloors, final int numberApartmentsPerFloor, final int apartmentNumber) {
        final var untilOfMeasurePerFloor = 1;

        return (
                (apartmentNumber - untilOfMeasurePerFloor) % (numberApartmentsPerFloor * numberFloors)
                / numberApartmentsPerFloor + untilOfMeasurePerFloor
        );
    }
}
