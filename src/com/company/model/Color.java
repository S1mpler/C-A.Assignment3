package com.company.model;

/**
 * Representation of a color
 * Created by S1mpler on 1/6/2017.
 */
public class Color {
    public enum ColorType {
        BLACK("black"), ORANGE("orange"), PINK("pink"), GREEN("green"), FINISH("finish");
        private String name;

        ColorType(String name) {
            this.name = name;
        }

        public String toString() {
            return name;
        }
    }

    ///////////////////////////////////////////////////////////////////////////
    // Properties
    ///////////////////////////////////////////////////////////////////////////
    private ColorType color;

    /**
     * Constructor
     * @param color ColorType
     */
    public Color(ColorType color) {
        this.color = color;
    }

    /**
     * Constructor (for parsing initial data)
     * @param colorShirtCut A shirt cut of the color
     */
    public Color(String colorShirtCut) {
        switch (colorShirtCut) {
            case "b":
                this.color = ColorType.BLACK;
                break;
            case "o":
                this.color = ColorType.ORANGE;
                break;
            case "p":
                this.color = ColorType.PINK;
                break;
            case "g":
                this.color = ColorType.GREEN;
                break;
            case "f":
                this.color = ColorType.FINISH;
                break;
        }
    }

    @Override
    public String toString() {
        return color.toString();
    }

    ///////////////////////////////////////////////////////////////////////////
    // Getters
    ///////////////////////////////////////////////////////////////////////////
    public ColorType getColorType() {
        return this.color;
    }
}
