package com.it.academy.md.jc1.operators;

/**
 * <p>RU: Типы данных. Переменные. Операторы. Методы.</p>
 * <p>EN: Data types. Variables. Operators. Methods.</p>
 *
 * @author Anastasia Melnikova.
 */
public class SoundSpeed {
    private static final float SOUND_SPEED = 1191.6f;
    private static final int METERS_TO_KILOMETERS = 1000;
    private static final int SECONDS_TO_HOURS = 3600;
    private static final int SECONDS_TO_MINUTES = 1000;

    /**
     * RU:
     * <p>Высчитывает расстояние (в метрах) до ближайшего места удара молнии. Расстояние = скорость * время, если
     * используются одинаковые единицы CI.</p>
     * <p>EN:</p>
     * <p>Calculates the distance (in meters) to the nearest lightning strike location. distance = speed * time if
     * the same CI units are used.</p>
     *
     * @param milliseconds время (в миллисекундах) между срабатыванием датчика света и звука/time (in milliseconds)
     *                     between the activation of the light and sound sensor.
     */
    public float getDistance(float milliseconds) {
        return SOUND_SPEED * METERS_TO_KILOMETERS / SECONDS_TO_HOURS * milliseconds / SECONDS_TO_MINUTES;
    }
}
