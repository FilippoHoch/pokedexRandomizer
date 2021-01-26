package sample.convert;

public class Pokemon {
    private int NUM;
    private String name;
    private String tipe;
    private String tipe1;
    private String tipe2;
    private int HP;
    private int ATK;
    private int DEF;
    private int SATK;
    private int SDEF;
    private int SPE;
    private String ability1;
    private String ability2;
    private String ability3;
    private String item;

    public Pokemon(int NUM, String name, String tipe, int HP, int ATK, int DEF, int SATK, int SDEF, int SPE, String ability1, String ability2, String ability3, String item) {
        this.NUM = NUM;
        this.name = name;
        this.tipe = tipe;
        impostTipe(tipe);
        this.HP = HP;
        this.ATK = ATK;
        this.DEF = DEF;
        this.SATK = SATK;
        this.SDEF = SDEF;
        this.SPE = SPE;
        this.ability1 = ability1;
        this.ability2 = ability2;
        this.ability3 = ability3;
        this.item = item;
    }

    public String getTipe1() {
        return tipe1;
    }

    public void setTipe1(String tipe1) {
        this.tipe1 = tipe1;
    }

    public String getTipe2() {
        if(tipe2==null)
            setTipe2("-");
        return tipe2;
    }

    public void setTipe2(String tipe2) {
        this.tipe2 = tipe2;
    }

    public int getNUM() {
        return NUM;
    }

    public void setNUM(int NUM) {
        this.NUM = NUM;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
        impostTipe(tipe);
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

    public String getAbility1() {
        return ability1;
    }

    public void setAbility1(String ability1) {
        this.ability1 = ability1;
    }

    public String getAbility2() {
        return ability2;
    }

    public void setAbility2(String ability2) {
        this.ability2 = ability2;
    }

    public String getAbility3() {
        return ability3;
    }

    public void setAbility3(String ability3) {
        this.ability3 = ability3;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public void impostTipe(String tipe){
        boolean first = true;
        for (String newTipe: tipe.split("/")){
            if(first)
                setTipe1(newTipe);
            else
                setTipe2(newTipe);

        }
    }
}
