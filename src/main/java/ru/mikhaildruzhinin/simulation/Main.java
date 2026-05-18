package ru.mikhaildruzhinin.simulation;

public class Main {
    public static void main(String[] args) {
        int length = 16;
        int width = 16;
        WorldMap worldMap = new WorldMap(length, width);
        Renderer renderer = new Renderer();
        Simulation simulation = new Simulation(worldMap, renderer);
        simulation.startSimulation();
    }
}
