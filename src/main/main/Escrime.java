package main;

import main.Sport.SportName;

public class Escrime extends Sport {

    public Escrime(int nbJoueursMax) {
        super(Sport.SportName.ESCRIME.getDisplayName(), nbJoueursMax);
    }
}
