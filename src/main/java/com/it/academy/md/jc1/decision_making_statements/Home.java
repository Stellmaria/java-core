package com.it.academy.md.jc1.decision_making_statements;

/**
 * <h3>RU: Принятие решений.</h3>
 *
 * <h3>EN: Decision making statements.</h3>
 *
 * @author Anastasia Melnikova.
 */
public class Home {
    /**
     * <h4>RU: Задание 9.</h4>
     * <p>Разработать программу для сервиса доставки.</p>
     * <p>Определить номер подъезда дома для текущего клиента.</p>
     * <p>Определяет номер подъезда дома для текущего клиента.</p><br>
     *
     * <h4>EN: Task 9.</h4>
     * <p>Develop a program for a delivery service.</p>
     * <p>Determine the house entrance number for the current client.</p>
     * <p>Determines the house entrance number for the current client.</p><br>
     *
     * @param numberFloors             количество этажей / number of floors.
     * @param numberApartmentsPerFloor количество квартир на этаже / number of apartments per floor.
     * @param apartmentNumber          номер квартиры / apartment number.
     * @return номер подъезда / entrance number.
     */
    public int getPorchNumber(final int numberFloors, final int numberApartmentsPerFloor, final int apartmentNumber) {
        final var untilOfMeasurePerFloor = 1;

        return (apartmentNumber - untilOfMeasurePerFloor) /
               (numberFloors * numberApartmentsPerFloor) +
               untilOfMeasurePerFloor;
    }
}
