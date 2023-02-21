package com.it.academy.gd.jc1.statements;

/**
 * <h3>RU: Принятие решений.</h3>
 *
 * <h3>EN: Decision making statements.</h3>
 *
 * @author Anastasia Melnikova.
 */
public class House {
    /**
     * <h4>RU: Задание 11.</h4>
     * <p>Имеются два дома размерами a на b и c на d. Имеется участок размерами е на f.
     * Проверить, помещаются ли эти дома на данном участке. Стороны домов - параллельны сторонам участка,
     * в остальном размещение может быть любым.</p><br>
     *
     * <h4>EN: Task 11.</h4>
     * <p>There are two houses with sizes a by b and c by d. There is an area measuring e by f.
     * Check if these houses fit on this site. The sides of the houses are parallel to the sides of the plot,
     * otherwise the placement can be any.</p><br>
     *
     * @param widthFirstHouse   ширина первого дома / width of the first house.
     * @param lengthFirstNumber длина первого дома / length of the first house.
     * @param widthSecondHome   ширина второго дома / second house width.
     * @param lengthSecondHome  длина второго дома / length of the second house.
     * @param weight            ширина участка / plot width.
     * @param length            длина участка / section length.
     * @return <code>true</code> если поместится <code>false</code> если не поместится /
     * <code>true</code> if it fits <code>false</code> if it doesn't fit.
     */
    public boolean isEnoughSpace(final double widthFirstHouse, final double lengthFirstNumber,
                                 final double widthSecondHome, final double lengthSecondHome,
                                 final double weight, final double length) {
        return (((weight >= widthFirstHouse) && (weight >= widthSecondHome))
                && (length >= (lengthFirstNumber + lengthSecondHome)))
               || (((weight >= lengthFirstNumber) && (weight >= widthSecondHome))
                   && (length >= (widthFirstHouse + lengthSecondHome)))
               || (((weight >= widthFirstHouse) && (weight >= lengthSecondHome))
                   && (length >= (lengthFirstNumber + widthSecondHome)))
               || (((weight >= lengthFirstNumber) && (weight >= lengthSecondHome))
                   && (length >= (widthFirstHouse + widthSecondHome)))
               || (((length >= widthFirstHouse) && (length >= widthSecondHome))
                   && (weight >= (lengthFirstNumber + lengthSecondHome)))
               || (((length >= lengthFirstNumber) && (length >= widthSecondHome))
                   && (weight >= (widthFirstHouse + lengthSecondHome)))
               || (((length >= widthFirstHouse) && (length >= lengthSecondHome))
                   && (weight >= (lengthFirstNumber + widthSecondHome)))
               || (((length >= lengthFirstNumber) && (length >= lengthSecondHome))
                   && (weight >= (widthFirstHouse + widthSecondHome)));
    }
}
