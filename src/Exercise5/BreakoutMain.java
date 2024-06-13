package Exercise5;

import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.program.GraphicsProgram;
import java.awt.Color;
import java.awt.event.MouseEvent;

public class BreakoutMain extends GraphicsProgram {
    public static final int WIDTH = 400;
    public static final int HEIGHT = 600;
    public static final int NBRICKS_PER_ROW = 10;
    public static final int NBRICK_ROWS = 10;
    public static final int BRICK_SEP = 4;
    public static final int BRICK_Y_OFFSET = 70;
    public static final int NTURNS = 3;
    private static final int DELAY = 30;

    private Ball ball;
    private Paddle paddle;
    private int brickCount = NBRICK_ROWS * NBRICKS_PER_ROW;
    private int turnsLeft = NTURNS;
    private GLabel turnLabel;
    private Color[] brickColors = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.CYAN};

    public void init() {
        setSize(417, 658);
    }

    public void run() {
        brickSetup();
        ballSetup();
        paddleSetup();
        placeLabel();
        addMouseListeners();
        while (brickCount > 0 && turnsLeft > 0) {
            ball.moveBall();
            checkForCollision();
            pause(DELAY);
        }
        gameOver();
    }

    private void placeLabel() {
        turnLabel = new GLabel("Turns left: " + turnsLeft);
        add(turnLabel, WIDTH - 65, 15);
    }

    private void brickSetup() {
        int x;
        int y = BRICK_Y_OFFSET;

        for (int j = 0; j < NBRICK_ROWS; j++) {
            x = (WIDTH - (NBRICKS_PER_ROW * (Brick.BRICK_WIDTH + BRICK_SEP))) / 2 + BRICK_SEP / 2;
            for (int i = 0; i < NBRICKS_PER_ROW; i++) {
                add(new Brick(x, y, brickColors[j / 2]));
                x += Brick.BRICK_WIDTH + BRICK_SEP;
            }
            y += Brick.BRICK_HEIGHT + BRICK_SEP;
        }
    }

    private void paddleSetup() {
        paddle = new Paddle((WIDTH - Paddle.PADDLE_WIDTH) / 2, HEIGHT - Paddle.PADDLE_Y_OFFSET);
        add(paddle);
    }

    public void mouseMoved(MouseEvent e) {
        paddle.movePaddle(e.getX());
    }

    private void ballSetup() {
        ball = new Ball(WIDTH / 2.0 - Ball.BALL_RADIUS, HEIGHT / 2.0 - Ball.BALL_RADIUS);
        add(ball);
    }

    private void checkForCollision() {
        if ((ball.getX() + Ball.BALL_RADIUS * 2 >= WIDTH) || (ball.getX() <= 0)) {
            ball.reverseX();
        }
        if (ball.getY() + Ball.BALL_RADIUS * 2 >= HEIGHT) {
            turnsLeft--;
            remove(turnLabel);
            placeLabel();
            remove(ball);
            ballSetup();
        }
        if (ball.getY() <= 0) {
            ball.reverseY();
        }
        GObject collider = getCollidingObject();
        if (collider == paddle) {
            ball.reverseY();
        } else if (collider != null && collider != turnLabel) {
            remove(collider);
            ball.reverseY();
            brickCount--;
        }
    }

    private GObject getCollidingObject() {
        GObject collider;
        if (ball.getVY() < 0) {
            collider = getElementAt(ball.getX(), ball.getY());
            if (collider != null) return collider;
            collider = getElementAt(ball.getX() + Ball.BALL_RADIUS * 2, ball.getY());
            return collider;
        } else {
            collider = getElementAt(ball.getX() + Ball.BALL_RADIUS * 2, ball.getY() + Ball.BALL_RADIUS * 2);
            if (collider != null) return collider;
            collider = getElementAt(ball.getX(), ball.getY() + Ball.BALL_RADIUS * 2);
        }
        return collider;
    }

    private void gameOver() {
        remove(ball);
        GLabel endText;
        if (turnsLeft == 0) {
            endText = new GLabel("GAME OVER");
        } else if (brickCount == 0) {
            endText = new GLabel("YOU WIN!!!");
        } else {
            endText = new GLabel("ERROR");
        }
        endText.setFont("Serif-50");
        add(endText, WIDTH / 2.0 - endText.getWidth() / 2.0, HEIGHT / 2.0 - endText.getAscent());
    }

    public static void main(String[] args) {
        (new BreakoutMain()).start(args);
    }
}