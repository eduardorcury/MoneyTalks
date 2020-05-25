package com.erc.controls;

import javafx.geometry.Orientation;
import javafx.scene.control.Separator;

public class Separators {

    private final Separator separator1 = new Separator(Orientation.HORIZONTAL);
    private final Separator separator2 = new Separator(Orientation.HORIZONTAL);
    private final Separator separator3 = new Separator(Orientation.HORIZONTAL);

    public Separator getSeparator1() {
        separator1.setCenterShape(true);
        return separator1;
    }

    public Separator getSeparator2() {
        separator2.setCenterShape(true);
        return separator2;
    }

    public Separator getSeparator3() {
        separator3.setCenterShape(true);
        return separator3;
    }
}
