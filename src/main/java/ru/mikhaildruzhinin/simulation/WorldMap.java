package ru.mikhaildruzhinin.simulation;

import ru.mikhaildruzhinin.simulation.entity.Entity;

public class WorldMap {

    private final Entity[] world;

    private final int length;

    private final int width;

    public WorldMap(int length, int width) {
        this.length = length;
        this.width = width;

        // world map:
        // w
        // i
        // d
        // t
        // h
        // l e n g t h

        world = new Entity[length * width];
    }

    public Entity[] getWorld() {
        return world;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }
}
