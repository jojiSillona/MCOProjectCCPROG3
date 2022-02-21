package com.pokechess.gui;

public enum DefendNames {
    ABSOL("FEINT"),
    BLASTOISE("RAPID SPIN"),
    BLISSEY("SOFT BOILED"),
    CHARIZARD("BLAZE"),

    CINDERACE("FEINT"),
    CRAMORANT("DIVE"),
    CRUSTLE("SHELL SMASH"),
    ELDEGOSS("COTTON GUARD"),

    GARCHOMP("DIG"),
    GARDEVOIR("TELEPORT"),
    GENGAR("HEX"),
    GRENINJA("DOUBLE TEAM"),

    LUCARIO("BONE RUSH"),
    MACHAMP("BULK UP"),
    MAMOSWINE("ICE FANG"),
    MRMIME("BARRIER"),

    NINETALES("AURORA VEIL"),
    PIKACHU("STATIC"),
    SLOWBRO("TELEKINESIS"),
    SNORLAX("HEAVY SLAM"),

    SYLVEON("CALM MIND"),
    TALONFLAME("FLY"),
    VENUSAUR("OVERGROW"),
    WIGGLYTUFF("SING"),

    ZERAORA("VOLT SWITCH");

    private String displayDefendAction;

    public String getDisplayDefendAction(){
        return this.displayDefendAction;
    }

    private DefendNames(String displayBattleAction){
        this.displayDefendAction = displayBattleAction;
    }
}
