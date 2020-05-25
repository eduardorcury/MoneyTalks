package com.erc.domain;

import javafx.scene.paint.Color;

//Available Category colors
public class Colors {

    private static final Color[] COLORS = {
            Color.rgb(255, 102, 102),
            Color.rgb(255, 51, 51),
            Color.rgb(255, 0, 0),
            Color.rgb(204, 0, 0),
            Color.rgb(153, 0, 0),
            Color.rgb(51, 204, 255),
            Color.rgb(51, 153, 255),
            Color.rgb(0, 0, 255),
            Color.rgb(0, 0, 204),
            Color.rgb(102, 0, 153),
            Color.rgb(102, 255, 102),
            Color.rgb(0, 255, 51),
            Color.rgb(0, 204, 0),
            Color.rgb(0, 153, 0),
            Color.rgb(0, 102, 0),
            Color.rgb(255, 255, 153),
            Color.rgb(255, 255, 0),
            Color.rgb(255, 204, 0),
            Color.rgb(255, 153, 0),
            Color.rgb(255, 102, 0),
            Color.rgb(204, 204, 204),
            Color.rgb(153, 153, 153),
            Color.rgb(102, 102, 102),
            Color.rgb(51, 51, 51)
    };

    public Color[] getColors() {
        return COLORS;
    }

    public static Color getButtonColor(String buttonId) {
        return COLORS[Integer.parseInt(buttonId.substring(7)) - 1];
    }

    public static String getRGB(Color color) {

        return color.getRed() * 255 + "," + color.getGreen() * 255 + "," + color.getBlue() * 255;

    }

}
