package main;

import main.Sport.SportName;

public class Handball extends Sport {
    public Handball(int nbJoueursMax) {
        super(Sport.SportName.HANDBALL.getDisplayName(), nbJoueursMax);
    }
}