package Exercise5;

import acm.graphics.GRect;

import java.awt.*;

public class Brick extends GRect {
    public static final int BRICK_HEIGHT = 8;
    public static final int BRICK_WIDTH = (BreakoutMain.WIDTH - (BreakoutMain.NBRICKS_PER_ROW - 1) * BreakoutMain.BRICK_SEP) / BreakoutMain.NBRICKS_PER_ROW;



    public Brick(double x, double y, Color color) {
        super(x, y, BRICK_WIDTH, BRICK_HEIGHT);
        setFillColor(color);
        setFilled(true);
    }
}
