package ru.mikhaildruzhinin.simulation.entity.creature;

import ru.mikhaildruzhinin.simulation.entity.Entity;

public abstract class Creature extends Entity {

    protected int speed;

    protected int hp;

    public abstract void makeMove();
}
