package ru.mikhaildruzhinin.simulation;

import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import ru.mikhaildruzhinin.simulation.entity.Entity;
import ru.mikhaildruzhinin.simulation.entity.creature.Herbivore;
import ru.mikhaildruzhinin.simulation.entity.creature.Predator;
import ru.mikhaildruzhinin.simulation.entity.terrain.Grass;
import ru.mikhaildruzhinin.simulation.entity.terrain.Rock;
import ru.mikhaildruzhinin.simulation.entity.terrain.Tree;

import java.io.IOException;

public class Renderer {

    private final Terminal terminal;

    public Renderer() {
        try {
            DefaultTerminalFactory defaultTerminalFactory = new DefaultTerminalFactory();
            this.terminal = defaultTerminalFactory.createTerminal();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void render(WorldMap worldMap) {

        try {
            for (int x = 0; x < worldMap.getLength(); x++) {
                for (int y = 0; y < worldMap.getWidth(); y++) {
                    int n = y * worldMap.getWidth() + x;

                    String element = switch (worldMap.getWorld()[n]) {
                        case Herbivore ignored -> "H";
                        case Predator ignored -> "P";
                        case Grass ignored -> "g";
                        case Rock ignored -> "r";
                        case Tree ignored -> "t";
                        case Entity ignored -> "E";
                        case null -> ".";
                    };

                    terminal.setCursorPosition(x, y);
                    terminal.putString(element);

                }
            }
            terminal.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void close() {
        if (terminal != null) {
            try {
                terminal.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
