package com.it.academy.md.jc1.operators;

import com.it.academy.md.jc1.operators.util.Const;

/**
 * <p>RU: Типы данных. Переменные. Операторы. Методы.</p>
 * <p>EN: Data types. Variables. Operators. Methods.</p>
 *
 * @author Anastasia Melnikova.
 */
public class SoundSpeed {
    /**
     * <p>RU: Высчитывает расстояние (в метрах) до ближайшего
     * места удара молнии. Расстояние = скорость * время,
     * если используются одинаковые единицы CI.</p>
     * <p>EN: Calculates the distance (in meters) to the nearest
     * lightning strike location.
     * distance = speed * time if the same CI units are used.</p>
     *
     * @param milliseconds время (в миллисекундах) между срабатыванием
     *                     датчика света и звука/time (in milliseconds)
     *                     between the activation of the light and sound sensor.
     * @return дистанцию/distance.
     */
    public float getDistance(final float milliseconds) {
        return Const.SOUND_SPEED * milliseconds / Const.SECONDS_TO_HOURS;
    }
}
