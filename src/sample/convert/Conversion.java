package sample.convert;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Conversion {
    public static final String RANDOMIZED_EVOLUTIONS = "--Randomized Evolutions--";
    public static final String CONDENSED_LEVEL_EVOLUTIONS = "--Condensed Level Evolutions--";
    public static final String POKEMON_BASE_STATS_TYPES = "--Pokemon Base Stats & Types--";
    private static final String RANDOM_STARTERS = "--Random Starters--";
    private static final String MOVE_DATA = "--Move Data--";
    private static final String POKEMON_MOVSETS = "--Pokemon Movesets--";
    private final File inputLog;
    public ArrayList<String> pokemons = new ArrayList<>();
    public ArrayList<Pokemon> pokemonObjects = new ArrayList<>();
    public ArrayList<String> fields = new ArrayList<>();
    ArrayList<String> evolutions = new ArrayList<>();

    public Conversion(String path) {
        this.inputLog = new File(path);
    }

    /**
     * Estrae dal file e carica in un ArrayList i metadati dei pokemon
     */
    public void extractFromLog() {
        try {
            String value;
            Scanner reader = new Scanner(inputLog);
            do {
                value = reader.nextLine();
            } while (isEndOfReading(value));
            StringTokenizer splitFields = new StringTokenizer(reader.nextLine(), "|");
            while (splitFields.hasMoreTokens()) {
                fields.add(splitFields.nextToken().trim());
            }
            do {
                int nFields = 0;
                StringTokenizer splitPokemon = new StringTokenizer(reader.nextLine(), "|");
                while (splitPokemon.hasMoreTokens()) {
                    value = splitPokemon.nextToken().trim();
                    if (isEndOfReading(value))
                        pokemons.add(value);
                    nFields++;
                }
                if (nFields == 12)
                    if (isEndOfReading(value))
                        pokemons.add("-");
            } while (isEndOfReading(value));
            do {
                value = reader.nextLine();
                if (!value.equalsIgnoreCase("") && isEndOfReading(value)) {
                    evolutions.add(value.substring(value.indexOf("into") + 5).trim());
                    evolutions.add(value.substring(0, value.indexOf("now evolves")).trim());
                }
            } while (isEndOfReading(value));

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        }
    }

    public void toPokemon() {
        for (int i = 0; i < pokemons.size(); i = i + 13) {
            int NUM = Integer.parseInt(pokemons.get(i));
            int HP = Integer.parseInt(pokemons.get(i + 3));
            int ATK = Integer.parseInt(pokemons.get(i + 4));
            int DEF = Integer.parseInt(pokemons.get(i + 5));
            int SATK = Integer.parseInt(pokemons.get(i + 6));
            int SDEF = Integer.parseInt(pokemons.get(i + 7));
            int SPE = Integer.parseInt(pokemons.get(i + 8));
            pokemonObjects
                    .add(new Pokemon(NUM, String.valueOf(pokemons.get(i + 1)), String.valueOf(pokemons.get(i + 2)), HP,
                            ATK, DEF, SATK, SDEF, SPE, String.valueOf(pokemons.get(i + 9)),
                            String.valueOf(pokemons.get(i + 10)), String.valueOf(pokemons.get(i + 11)),
                            String.valueOf(pokemons.get(i + 12))));
        }

    }

    public void printPokemons() {
        for (Pokemon pokemonObject : pokemonObjects) {
            System.out.println(pokemonObject.getName() + ": \n" +
                    fields.get(0) + ": " + pokemonObject.getNUM() + "\n" +
                    fields.get(1) + ": " + pokemonObject.getName() + "\n" +
                    fields.get(2) + "1: " + pokemonObject.getType1() + "\n" +
                    fields.get(2) + "2: " + pokemonObject.getType2() + "\n" +
                    fields.get(3) + ": " + pokemonObject.getHP() + "\n" +
                    fields.get(4) + ": " + pokemonObject.getATK() + "\n" +
                    fields.get(5) + ": " + pokemonObject.getDEF() + "\n" +
                    fields.get(6) + ": " + pokemonObject.getSATK() + "\n" +
                    fields.get(7) + ": " + pokemonObject.getSDEF() + "\n" +
                    fields.get(8) + ": " + pokemonObject.getSPE() + "\n" +
                    fields.get(9) + ": " + pokemonObject.getAbility1() + "\n" +
                    fields.get(10) + ": " + pokemonObject.getAbility2() + "\n" +
                    fields.get(11) + ": " + pokemonObject.getAbility3() + "\n" +
                    fields.get(12) + ": " + pokemonObject.getItem() + "\n" +
                    fields.get(13) + ": " + pokemonObject.getEvolution() + "\n");
        }
    }

    public String printPokemonElement(int nElement, int field) {
        if (field == 0)
            return pokemonObjects.get(nElement).getName();
        else if (field == 1)
            return pokemonObjects.get(nElement).getType();
        else if (field == 2)
            return String.valueOf(pokemonObjects.get(nElement).getHP());
        else if (field == 3)
            return String.valueOf(pokemonObjects.get(nElement).getATK());
        else if (field == 4)
            return String.valueOf(pokemonObjects.get(nElement).getDEF());
        else if (field == 5)
            return String.valueOf(pokemonObjects.get(nElement).getSATK());
        else if (field == 6)
            return String.valueOf(pokemonObjects.get(nElement).getSDEF());
        else if (field == 7)
            return String.valueOf(pokemonObjects.get(nElement).getSPE());
        else if (field == 8) {
            String ability = pokemonObjects.get(nElement).getAbility1();
            if (!pokemonObjects.get(nElement).getAbility2().equals("-")) {
                ability = ability + ", " + pokemonObjects.get(nElement).getAbility2();
                if (!pokemonObjects.get(nElement).getAbility3().equals("-"))
                    ability = ability + ", " + pokemonObjects.get(nElement).getAbility3();
            }
            return ability;
        } else if (field == 9)
            return pokemonObjects.get(nElement).getItem();
        else if (field == 10) {
            return pokemonObjects.get(nElement).getEvolution();
        }
        return "missing field";
    }

    public int nameToInt(String name) {
        for (int i = 0; i < pokemonObjects.size(); i++) {
            if (pokemonObjects.get(i).getName().equals(name))
                return i;
        }
        return -1;
    }

    public String intToName(int name) {
        return pokemonObjects.get(name).getName();
    }

    public void setEvolutions() {
        for (int j = 0; j < evolutions.size(); j = j + 2) {
            for (Pokemon pokemonObject : pokemonObjects) {
                if (evolutions.get(j + 1).equals(pokemonObject.getName()))
                    pokemonObject.setEvolution(evolutions.get(j));
            }
        }

    }

    public boolean isEndOfReading(String reading) {
        return !reading.equalsIgnoreCase(RANDOMIZED_EVOLUTIONS) &&
                !reading.equalsIgnoreCase(CONDENSED_LEVEL_EVOLUTIONS) &&
                !reading.equalsIgnoreCase(POKEMON_BASE_STATS_TYPES) && !reading.equalsIgnoreCase(RANDOM_STARTERS) &&
                !reading.equalsIgnoreCase(MOVE_DATA) && !reading.equalsIgnoreCase(POKEMON_MOVSETS);
    }

}