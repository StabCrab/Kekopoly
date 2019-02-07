package ru.s1518.kekopoly.graphics;

import static java.lang.Math.*;
import static java.lang.Math.PI;
import static org.lwjgl.opengl.GL11.*;

public class Dice {
    private static final double[] BLACK = {0, 0, 0};
    private static final double RADIUS = 0.01;
    private static final int NUMBER_OF_SIDES = 500;

    private double x;
    private double y;

    private DicePoints points = DicePoints.ZERO;

    public Dice(double x, double y) {
        this.x = x;
        this.y = y;

        this.points = DicePoints.THREE;
    }

    public DicePoints getPoints() {
        return points;
    }

    public void setPoints(DicePoints points) {
        this.points = points;
    }

    public void draw() {
        glBegin(GL_LINE_LOOP);
        glVertex2d(x - 0.05, y - 0.1);
        glVertex2d(x + 0.05, y - 0.1);
        glVertex2d(x + 0.05, y + 0.1);
        glVertex2d(x - 0.05, y + 0.1);
        glEnd();

        switch (points) {
            case ONE:
                drawCircle(x, y);
                break;
            case TWO:
                drawCircle(x - 0.038, y + 0.08);
                drawCircle(x + 0.038, y - 0.08);
                break;
        }
    }

    private void drawCircle(double x, double y) {
        glColor3dv(BLACK);
        glBegin(GL_POLYGON);
        for (int i = 0; i < NUMBER_OF_SIDES; i++) {
            glVertex2d(x + RADIUS * cos(i * PI * 2 / NUMBER_OF_SIDES) / 1.7,
                    y + RADIUS * sin(i * PI * 2 / NUMBER_OF_SIDES));
        }
        glEnd();
    }

    private enum DicePoints {
        ZERO,
        ONE,
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX
    }
}
