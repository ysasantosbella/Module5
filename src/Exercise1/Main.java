package Exercise1;

import acm.program.*;

public class Main extends GraphicsProgram {
    public void run() {
        int rows = 5;
        int cols = 5;
        double flagWidth = 100;
        double flagHeight = 50;
        double xOffset = flagWidth + 10;
        double yOffset = flagHeight + 10;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                PhilippineFlag flag = new PhilippineFlag(flagWidth, flagHeight);
                add(flag, col * xOffset, row * yOffset);
            }
        }
    }

    public static void main(String[] args) {
        new Main().start(args);
    }
}

