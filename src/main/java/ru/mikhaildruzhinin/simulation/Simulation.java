package ru.mikhaildruzhinin.simulation;

import ru.mikhaildruzhinin.simulation.entity.creature.Herbivore;

import java.util.List;

public class Simulation {

    private final WorldMap worldMap;

    private int turnCounter = 0;

    private Renderer renderer;

    private List<Action> actions;

    public Simulation(WorldMap worldMap, Renderer renderer) {
        this.worldMap = worldMap;
        this.renderer = renderer;
    }

    public void nextTurn() {
        turnCounter++;
        System.out.println("Turn: " + turnCounter);
        renderer.render(worldMap);
    }

    public void startSimulation() {
        worldMap.getWorld()[0] = new Herbivore();

        try {
            while (true) {
                nextTurn();
                Thread.sleep(2000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            renderer.close();
        }
    }

    public void pauseSimulation() {
        throw new UnsupportedOperationException();
    }
}
