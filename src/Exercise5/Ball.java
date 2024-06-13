package Exercise5;

import acm.graphics.GOval;
import acm.util.RandomGenerator;

import java.awt.*;

public class Ball extends GOval {
    public static final int BALL_RADIUS = 10;
    private double vx, vy; //velocity of the ball for the x and y coordinates

    public Ball(double x, double y) {
        super(x, y, BALL_RADIUS*2, BALL_RADIUS*2); //BALL_RADIUS*2 = width and height of the ball
        setColor(Color.BLACK);
        setFilled(true);
        vy = 5.0;
        RandomGenerator randomGen = new RandomGenerator();
        vx = randomGen.nextDouble(1,3);
        if (randomGen.nextBoolean(0.5))
            vx = -vx;
    }

    public void reverseX(){
        vx = -vx;
    }

    public void reverseY(){
        vy = -vy;
    }

    public void moveBall(){
        move(vx,vy);
    }

    public double getVY() {
        return vy;
    }
}
