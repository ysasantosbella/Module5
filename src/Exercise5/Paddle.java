package Exercise5;

import acm.graphics.GRect;

import java.awt.*;

public class Paddle extends GRect {
    public static final int PADDLE_WIDTH = 60;
    public static final int PADDLE_HEIGHT = 10;
    public static final int PADDLE_Y_OFFSET = 50;
    private static final double PADDLE_LIMIT = BreakoutMain.WIDTH - PADDLE_WIDTH;

    public Paddle(double x, double y) {
        super(x, y, PADDLE_WIDTH, PADDLE_HEIGHT);
        setColor(Color.magenta);
        setFilled(true);
    }

    public void movePaddle(double mouse){
        double paddle = mouse - PADDLE_WIDTH / 2.0;
        if(paddle > PADDLE_LIMIT) paddle = PADDLE_LIMIT;
        if (paddle < 0) paddle = 0;
        setLocation(paddle, getY());
    }
}
