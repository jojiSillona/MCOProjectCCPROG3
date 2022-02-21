package com.pokechess.gui;

public enum AttackNames {
    ABSOL("PURSUIT"),
    BLASTOISE("HYDRO PUMP"),
    BLISSEY("EGG BOMB"),
    CHARIZARD("FLARE BLITZ"),

    CINDERACE("BLAZE KICK"),
    CRAMORANT("SURF"),
    CRUSTLE("X-SCISSORS"),
    ELDEGOSS("LEAF TORNADO"),

    GARCHOMP("DRAGON PUSH"),
    GARDEVOIR("MOONBLAST"),
    GENGAR("SLUDGE BOMB"),
    GRENINJA("SURF"),

    LUCARIO("EXTREME SPEED"),
    MACHAMP("CLOSE COMBAT"),
    MAMOSWINE("EARTHQUAKE"),
    MRMIME("CONFUSION"),

    NINETALES("BLIZZARD"),
    PIKACHU("THUNDER"),
    SLOWBRO("SURF"),
    SNORLAX("HEAVY SLAM"),

    SYLVEON("MYSTICAL FIRE"),
    TALONFLAME("BRAVE BIRD"),
    VENUSAUR("SOLAR BEAM"),
    WIGGLYTUFF("DOUBLE SLAP"),

    ZERAORA("DISCHARGE");

    private String displayBattleAction;

    public String getDisplayBattleAction(){
        return this.displayBattleAction;
    }

    private AttackNames(String displayBattleAction){
        this.displayBattleAction = displayBattleAction;
    }


}
