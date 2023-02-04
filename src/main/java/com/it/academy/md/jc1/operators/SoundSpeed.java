package com.it.academy.md.jc1.operators;

import com.it.academy.md.jc1.operators.util.Const;

/**
 * <h4>RU: Типы данных. Переменные. Операторы. Методы.</h4>
 *
 * <h4>EN: Data types. Variables. Operators. Methods.</h4>
 *
 * @author Anastasia Melnikova.
 */
public class SoundSpeed {
    /**
     * <p>RU: Высчитывает расстояние (в метрах) до ближайшего
     * места удара молнии. Расстояние = скорость * время,
     * если используются одинаковые единицы CI.</p><br>
     *
     * <p>EN: Calculates the distance (in meters) to the nearest
     * lightning strike location.
     * distance = speed * time if the same CI units are used.</p><br>
     *
     * @param milliseconds время (в миллисекундах) между срабатыванием
     *                     датчика света и звука / time (in milliseconds)
     *                     between the activation of the light and sound sensor.
     * @return дистанцию / distance.
     */
    public float getDistance(final float milliseconds) {
        return Const.SOUND_SPEED * milliseconds / Const.SECONDS_TO_HOURS;
    }
}
