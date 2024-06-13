package Exercise1;

import acm.graphics.*;

import java.awt.*;

public class PhilippineFlag extends GCompound {
    public PhilippineFlag(double width, double height) {
        // Flag dimensions
        double halfHeight = height / 2;

        // Blue rectangle
        GRect blueRect = new GRect(width, height);
        blueRect.setFilled(true);
        blueRect.setFillColor(Color.blue);
        add(blueRect, 0, 0);

        // Red rectangle
        GRect redRect = new GRect(width, halfHeight);
        redRect.setFilled(true);
        redRect.setFillColor(Color.RED);
        add(redRect, 0, halfHeight);

        // White triangle
        GPolygon triangle = new GPolygon();
        triangle.addVertex(0, 0);
        triangle.addVertex(0, height);
        triangle.addVertex(width / 2, height / 2);
        triangle.setFilled(true);
        triangle.setFillColor(Color.WHITE);
        add(triangle, 0, 0);

        // Adding the sun (we will create a separate GCompound for the sun)
        FlagSun sun = new FlagSun(halfHeight / 2); // Assuming radius is half the height of the half flag
        add(sun, 7, halfHeight / 2);

        addStar(5, 10);
        addStar(35, 25);
        addStar(5, 40);
    }

    private void addStar(double x, double y) {
        PhilippineFlag.GStar star = new PhilippineFlag.GStar(8);
        star.setFilled(true);
        star.setFillColor(Color.YELLOW);
        add(star, x, y);
    }

    public class GStar extends GPolygon {
        public GStar(double size) {
            double sinTheta = GMath.sinDegrees(18);
            double b = 0.5 * sinTheta / (1.0 + sinTheta);
            double edge = (0.5 - b) * size;
            addVertex(-size / 2, -b * size);
            int angle = 0;
            for (int i = 0; i < 5; i++) {
                addPolarEdge(edge, angle);
                addPolarEdge(edge, angle + 72);
                angle -= 72;
            }
        }
    }
}
