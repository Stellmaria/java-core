package com.it.academy.md.jc1.decision_making_statements;

/**
 * <h3>RU: Принятие решений.</h3>
 *
 * <h3>EN: Decision making statements.</h3>
 *
 * @author Anastasia Melnikova.
 */
public class Damage {
    /**
     * <h4>RU: Задание 8.</h4>
     * <p>Разработать программу для игрового движка.</p>
     * <p>Оружие имеет в себе атрибут святости и какой-то чистый урон. Если оружие имеет атрибут святости,
     * то оно наносит:</p>
     * <ul>
     *     <li>В 1,5 раза больше урона по "НЕЖИТЬ" и "ЗОМБИ"</li>
     *     <li>В 2 раза меньше урона на "СВЯТОЙ"</li>
     *     <li>Без изменений на «ЖИВОТНОЕ», «ГУМАНОИД», «РАСТЕНИЕ», «ПРИЗРАК».</li>
     * </ul>
     * <p>Определить сколько урона нанесет оружие по данному типу моба
     * (моб - персонаж в игре управляемый компьютером).</p>
     * <p>Определяет итоговый урон оружия для данного типу моба.</p><br>
     *
     * <h4>EN: Task 8.</h4>
     * <p>Develop a program for a game engine.</p>
     * <p>The weapon has an attribute of holiness and some pure damage.
     * If a weapon has a holy attribute, it deals:</p>
     * <ul>
     *     <li>1.5 times more damage on "UNDEAD" and "ZOMBIE".</li>
     *     <li>2 times less damage on "SAINT".</li>
     *     <li>No change on “ANIMAL”, “HUMANOID”, “PLANT”, “GHOST”.</li>
     * </ul>
     * <p>Determine how much damage the weapon will inflict on a given type of mob
     * (a mob is a computer-controlled character in the game).</p>
     * <p>Determines the resulting weapon damage for the given mob type.</p><br>
     *
     * @param damage           чистый урон оружия (без атрибута) / true weapon damage (no attribute).
     * @param typeMob          тип моба / mob type.
     * @param hasHolyAttribute наличие у оружия атрибута святости / the presence of a weapon attribute of holiness.
     * @return итоговый урон по данному типу моба / total damage for this type of mob.
     */
    public int getTotalDamage(int damage, final String typeMob, final boolean hasHolyAttribute) {
        final float damageAdditional = 1.5F;
        final byte damageAdditionalForSaint = 2;

        final var undead = "UNDEAD";
        final var zombie = "ZOMBIE";
        final var saint = "SAINT";

        if (hasHolyAttribute) {
            if (undead.equals(typeMob) || zombie.equals(typeMob)) {
                damage *= damageAdditional;
            } else if (saint.equals(typeMob)) {
                damage /= damageAdditionalForSaint;
            }
        }

        return damage;
    }
}
