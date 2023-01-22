package com.it.academy.md.jc1.operators;

/**
 * <p>RU: Типы данных. Переменные. Операторы. Методы.</p>
 * <p>EN: Data types. Variables. Operators. Methods.</p>
 *
 * @author Anastasia Melnikova.
 */
public class Cargo {

    /**
     * <p>RU: Рассчитывает количество полностью загруженных грузовиков,
     * необходимых для перевозки некоторого груза.</p>
     * <p>EN: Calculates the number of fully loaded trucks needed to carry
     * a given load.</p>
     *
     * @param cargo            вес всего груза/the weight of the entire load..
     * @param carryingCapacity грузоподъемность грузовиков/truck capacity.
     * @return количество грузовиков / number of trucks.
     */
    public int getNumberFullTrucks(final int cargo,
                                   final int carryingCapacity) {
        return cargo / carryingCapacity;
    }

    /**
     * RU:
     * <p>Рассчитывает количество некоторого груза, который останется на складе,
     * после полной загрузки его в грузовики, т.е. грузовики должны
     * быть загружены полностью.</p>
     * <p>EN:</p>
     * <p>Calculates the amount of some cargo that will remain in the warehouse
     * after it is fully loaded into trucks,
     * i.e. trucks must be fully loaded</p>
     *
     * @param cargo            вес всего груза / the weight of the entire load..
     * @param carryingCapacity грузоподъемность грузовиков / truck capacity.
     * @return количество груза / amount of cargo.
     */
    public int getAmountRemainingCargo(final int cargo,
                                       final int carryingCapacity) {
        return cargo % carryingCapacity;
    }
}
