package com.it_academy.md_jc1.operators;

/**
 * <p>RU: Типы данных. Переменные. Операторы. Методы.</p>
 * <p>EN: Data types. Variables. Operators. Methods.</p>
 *
 * @author Anastasia Melnikova.
 */
public class Weight {
    private static final int INDEX = 110;

    /**
     * RU:
     * <p>Рассчитывает избыточность веса пользователя.</p>
     * <ul>
     *     <li>Под избыточность веса понимается разница между текущим весом и стандартным весом для текущего роста
     * (стандартный вес = текущий рост - 110), т.н. индекс Брока.</li>
     *     <li>Может быть как положительной, так и отрицательной.</li>
     * </ul>
     * <p>EN:</p>
     * <p>Calculates the excess weight of the user.</p>
     * <ul>
     *      <li>Weight overweight refers to the difference between current weight and standard weight for current height
     * (standard weight = current height - 110), so-called. Brock's index.</li>
     *       <li>Can be either positive or negative.</li>
     * </ul>
     *
     * @param height рост/height.
     * @param weight вес/weight.
     */
    public int calculateDeviationStandardWeight(int height, int weight) {
        return weight - (height - INDEX);
    }
}
