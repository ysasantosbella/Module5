package Exercise1;

import acm.graphics.*;

import java.awt.*;

public class FlagSun extends GCompound {
    public FlagSun(double radius) {
        // Center circle
        GOval centerCircle = new GOval(radius / 2, radius / 2);
        centerCircle.setFilled(true);
        centerCircle.setFillColor(Color.YELLOW);
        add(centerCircle, -radius / 4, -radius / 4);

        // Sun rays
        int rays = 8;
        double rayLength = radius;
        double angleIncrement = 360.0 / rays;

        for (int i = 0; i < rays; i++) {
            double angle = Math.toRadians(i * angleIncrement);
            double x = Math.cos(angle) * rayLength;
            double y = Math.sin(angle) * rayLength;
            GLine ray = new GLine(0, 0, x, y);
            ray.setColor(Color.yellow);
            add(ray);
        }
    }
}
