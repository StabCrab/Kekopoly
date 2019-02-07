package ru.s1518.kekopoly.graphics;

import static org.lwjgl.opengl.GL11.*;

public class Quad {

    private double x;
    private double y;

    public Quad(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void draw() {
        glBegin(GL_LINE_LOOP);
        glColor3d(0,0,0);
        glVertex2d(x - 0.01, y - 0.02);
        glVertex2d(x + 0.01, y - 0.02);
        glVertex2d(x + 0.01, y + 0.02);
        glVertex2d(x - 0.01, y + 0.02);
        glEnd();
    }
}
