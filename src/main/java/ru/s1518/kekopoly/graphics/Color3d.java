package ru.s1518.kekopoly.graphics;

public enum Color3d {
    WHITE  (new double[]{1, 1, 1}),
    BLACK  (new double[]{0, 0, 0}),
    RED    (new double[]{1, 0, 0}),
    GREEN  (new double[]{0, 1, 0}),
    BLUE   (new double[]{0, 0, 1}),
    YELLOW (new double[]{1, 1, 0}),
    MAGENTA(new double[]{1, 0, 1}),
    ORANGE (new double[]{1, 0.55, 0}),
    CYAN   (new double[]{0, 1, 1});
    private double[] color;

    Color3d(double[] color) {
        this.color = color;
    }

    public double[] getColor() {
        return color;
    }
}
