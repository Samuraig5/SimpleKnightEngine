package GameSpace;

import Core.SimpleKnightEngine;
import Objects.GameObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Cell
{
    /**
     * Logger used for logging
     */
    private static final Logger logger = LoggerFactory.getLogger(Cell.class);
    /**
     * List of all the gameObjects found within this cell
     */
    public final List<GameObject> gameObjects = new ArrayList<>();
}
