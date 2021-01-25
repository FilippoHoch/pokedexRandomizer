package sample.convert;

import java.util.ArrayList;

public class Pokemon {
    private String tipo1;
    private String tipo2;
    private int HP;
    private int ATK;
    private int DEF;
    private int SATK;
    private int SDEF;
    private int SPE;
    private ArrayList<String> ability;
    private String item;

    public Pokemon(String tipo1, String tipo2, int HP, int ATK, int DEF, int SATK, int SDEF, int SPE, ArrayList<String> ability, String item) {
        this.tipo1 = tipo1;
        this.tipo2 = tipo2;
        this.HP = HP;
        this.ATK = ATK;
        this.DEF = DEF;
        this.SATK = SATK;
        this.SDEF = SDEF;
        this.SPE = SPE;
        this.ability = ability;
        this.item = item;
    }

    public String getTipo1() {
        return tipo1;
    }

    public void setTipo1(String tipo1) {
        this.tipo1 = tipo1;
    }

    public String getTipo2() {
        return tipo2;
    }

    public void setTipo2(String tipo2) {
        this.tipo2 = tipo2;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getATK() {
        return ATK;
    }

    public void setATK(int ATK) {
        this.ATK = ATK;
    }

    public int getDEF() {
        return DEF;
    }

    public void setDEF(int DEF) {
        this.DEF = DEF;
    }

    public int getSATK() {
        return SATK;
    }

    public void setSATK(int SATK) {
        this.SATK = SATK;
    }

    public int getSDEF() {
        return SDEF;
    }

    public void setSDEF(int SDEF) {
        this.SDEF = SDEF;
    }

    public int getSPE() {
        return SPE;
    }

    public void setSPE(int SPE) {
        this.SPE = SPE;
    }

    public ArrayList<String> getAbility() {
        return ability;
    }

    public void setAbility(ArrayList<String> ability) {
        this.ability = ability;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
}
