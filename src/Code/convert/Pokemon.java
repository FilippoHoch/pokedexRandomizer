package Code.convert;

@SuppressWarnings("unused")
public class Pokemon {
    private int NUM;
    private String name;
    private String type;
    private String type1;
    private String type2;
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
    private String evolution;

    public Pokemon(int NUM, String name, String type, int HP, int ATK, int DEF, int SATK, int SDEF, int SPE,
                   String ability1, String ability2, String ability3, String item) {
        this.NUM = NUM;
        this.name = name;
        this.type = type;
        setTypes(type);
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

    public String getEvolution() {
        return evolution;
    }

    public void setEvolution(String evolution) {
        this.evolution = evolution;
    }

    public String getType1() {
        return type1;
    }

    public void setType1(String type1) {
        this.type1 = type1;
    }

    public String getType2() {
        if (type2 == null)
            setType2("-");
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
        setTypes(type);
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

    /**
     * @param type la stringa contenente uno o due tipi separati da '/'
     */
    public void setTypes(String type) {
        String[] types = type.split("/");
        if (types.length > 2)
            throw new IllegalArgumentException("The number of pokemon types must be 2, but it is " + types.length);
        setType1(types[0]);
        if (types.length == 2)
            setType2(types[1]);
    }
}
