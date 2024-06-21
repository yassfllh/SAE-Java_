package main;

import main.Sport.SportName;

public class Natation extends Sport{

    public Natation(int nbJoueursMax) {
        super(Sport.SportName.NATATION.getDisplayName(), nbJoueursMax);
    }
}