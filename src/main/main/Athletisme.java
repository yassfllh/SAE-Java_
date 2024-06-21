package main;

import main.Sport.SportName;

public class Athletisme extends Sport {
    public Athletisme(int nbJoueursMax) {
        super(Sport.SportName.ATHLETISME.getDisplayName(), nbJoueursMax);
    }
}