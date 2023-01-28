package com.it.academy.md.jc1.operators;

import com.it.academy.md.jc1.operators.util.Const;

/**
 * <h4>RU: Типы данных. Переменные. Операторы. Методы.</h4>
 *
 * <h4>EN: Data types. Variables. Operators. Methods.</h4>
 *
 * @author Anastasia Melnikova.
 */
public class Weight {
    /**
     * <p>RU: Рассчитывает избыточность веса пользователя.</p>
     * <ul>
     *     <li>Под избыточность веса понимается разница между текущим весом
     *     и стандартным весом для текущего роста
     *     (стандартный вес = текущий рост - 110), т.н. индекс Брока.</li>
     *     <li>Может быть как положительной, так и отрицательной.</li>
     * </ul><br>
     *
     * <p>EN: Calculates the excess weight of the user.</p>
     * <ul>
     *      <li>Weight overweight refers to the difference between current
     *      weight and standard weight for current height (standard weight
     *      = current height - 110), so-called. Brock's index.</li>
     *       <li>Can be either positive or negative.</li>
     * </ul>
     *
     * @param height рост / height.
     * @param weight вес / weight.
     * @return избыточность веса/overweight.
     */
    public int calculateDeviationStandardWeight(final int height,
                                                final int weight) {
        return weight - (height - Const.BROCKS_INDEX);
    }
}
