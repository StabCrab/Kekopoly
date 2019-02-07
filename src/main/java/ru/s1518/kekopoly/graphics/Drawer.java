package ru.s1518.kekopoly.graphics;

import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;
import org.lwjgl.system.*;

import java.nio.*;

import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;

public class Drawer {
    private final long window;
    private Texture board;

    public Drawer() {
        if (!glfwInit()) {
            throw new IllegalStateException("Unable to initialize GLFW");
        }

        glfwWindowHint(GLFW_RESIZABLE, GLFW_FALSE);
        window = glfwCreateWindow(1050, 1050, "Kekopoly", NULL, NULL);

        GLFW.glfwMakeContextCurrent(window);

        GL.createCapabilities();

        board = new Texture();
    }

    private void dices() {
        glColor3d(0.5, 0.5, 0.5);
        glBegin(GL_QUADS);
        glVertex2d(0.5, -0.5);
        glVertex2d(0.5, 0.5);
        glVertex2d(-0.5, 0.5);
        glVertex2d(-0.5, -0.5);
        glEnd();
    }

    private static void background() {
        glClearColor(1, 1, 1, 0);
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
        glEnable(GL_DEPTH_TEST);
    }

    public void run() {
        loop();

        glfwFreeCallbacks(window);
        glfwDestroyWindow(window);

        glfwTerminate();
        glfwSetErrorCallback(null).free();
    }

    private void drawBoard() {
        glEnable(GL_TEXTURE_2D);
        board.bind();

        glBegin(GL_QUADS);
        glColor4d(1, 1, 1, 1);

        glTexCoord2d(1, 1);
        glVertex2d(0.9, -0.9);

        glTexCoord2d(0, 1);
        glVertex2d(-0.9, -0.9);

        glTexCoord2d(0, 0);
        glVertex2d(-0.9, 0.9);

        glTexCoord2d(1, 0);
        glVertex2d(0.9, 0.9);

        glEnd();
    }

    private void loop() {
        GL.createCapabilities();

        while ( !glfwWindowShouldClose(window) ) {
            background();

            dices();
            drawBoard();

            glfwSwapBuffers(window);

            glfwPollEvents();
        }
    }
}
