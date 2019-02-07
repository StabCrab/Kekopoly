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
    private Dice first;
    private Dice second;

    public Drawer() {
        if (!glfwInit()) {
            throw new IllegalStateException("Unable to initialize GLFW");
        }

        //glfwWindowHint(GLFW_RESIZABLE, GLFW_FALSE);
        GLFWVidMode monitor = glfwGetVideoMode(glfwGetPrimaryMonitor());
        window = glfwCreateWindow(monitor.width() - 10, monitor.height() - 100, "Kekopoly", NULL, NULL);

        GLFW.glfwMakeContextCurrent(window);

        GL.createCapabilities();

        board = new Texture();
        first = new Dice(0.275, 0.89);
        second = new Dice(0.385, 0.89);
    }

    private void dices() {
        glColor3d(0, 0, 0);
        first.draw();
        second.draw();
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
        glColor3d(1, 1, 1);

        glTexCoord2d(1, 1);
        glVertex2d(0.2, -0.99);

        glTexCoord2d(0, 1);
        glVertex2d(-0.995, -0.99);

        glTexCoord2d(0, 0);
        glVertex2d(-0.995, 0.99);

        glTexCoord2d(1, 0);
        glVertex2d(0.2, 0.99);

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
