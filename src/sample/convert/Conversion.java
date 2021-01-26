package sample.convert;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Conversion {
    public static final String RANDOMIZED_EVOLUTIONS = "--Randomized Evolutions--";
    public static final String POKEMON_BASE_STATS_TYPES = "--Pokemon Base Stats & Types--";
    private File inputLog;
    public ArrayList<String> pokemon = new ArrayList<String>();
    public ArrayList<Pokemon> pokemonObject = new ArrayList<>();
    public ArrayList<String> fields = new ArrayList<>();
    public Conversion(String path){
                this.inputLog = new File(path);
    }
    public void extractFromLog(){
        ArrayList in = new ArrayList();
        try {
            String data;
            Scanner reader = new Scanner(inputLog);
            do{
                data = reader.nextLine();
            }while(!data.equals(POKEMON_BASE_STATS_TYPES));
            StringTokenizer splitFields = new StringTokenizer(reader.nextLine(), "|");
            while(splitFields.hasMoreTokens()){
                fields.add(splitFields.nextToken().trim());
            }
            String value = "";

            do{
                int nFields = 0;
                StringTokenizer splitPokemon = new StringTokenizer(reader.nextLine(), "|");
                while(splitPokemon.hasMoreTokens()){
                    value = splitPokemon.nextToken().trim();
                    if(!value.equalsIgnoreCase(RANDOMIZED_EVOLUTIONS))
                    pokemon.add(value);
                    nFields++;
                }
                if(nFields==12)
                    if(!value.equalsIgnoreCase(RANDOMIZED_EVOLUTIONS))
                    pokemon.add("-");
            }while(!value.equalsIgnoreCase(RANDOMIZED_EVOLUTIONS));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void toPokemon(){
        for (int i=0; i<pokemon.size();i=i+13){
                int NUM = Integer.valueOf(pokemon.get(i));
                int HP = Integer.valueOf(pokemon.get(i+3));
                int ATK = Integer.valueOf(pokemon.get(i+4));
                int DEF = Integer.valueOf(pokemon.get(i+5));
                int SATK = Integer.valueOf(pokemon.get(i+6));
                int SDEF = Integer.valueOf(pokemon.get(i+7));
                int SPE = Integer.valueOf(pokemon.get(i+8));
                pokemonObject.add(new Pokemon(NUM, String.valueOf(pokemon.get(i+1)), String.valueOf(pokemon.get(i+2)), HP, ATK, DEF, SATK, SDEF, SPE, String.valueOf(pokemon.get(i+9)), String.valueOf(pokemon.get(i+10)), String.valueOf(pokemon.get(i+11)), String.valueOf(pokemon.get(i+12))));
        }

    }
    public void printPokemon(){
        for (int i=0; i<pokemonObject.size(); i++){
            System.out.println(pokemonObject.get(i).getName()+":");
            System.out.println(fields.get(0)+": "+pokemonObject.get(i).getNUM());
            System.out.println(fields.get(1)+": "+pokemonObject.get(i).getName());
            System.out.println(fields.get(2)+"1: "+pokemonObject.get(i).getTipe1());
            System.out.println(fields.get(2)+"2: "+pokemonObject.get(i).getTipe2());
            System.out.println(fields.get(3)+": "+pokemonObject.get(i).getHP());
            System.out.println(fields.get(4)+": "+pokemonObject.get(i).getATK());
            System.out.println(fields.get(5)+": "+pokemonObject.get(i).getDEF());
            System.out.println(fields.get(6)+": "+pokemonObject.get(i).getSATK());
            System.out.println(fields.get(7)+": "+pokemonObject.get(i).getSDEF());
            System.out.println(fields.get(8)+": "+pokemonObject.get(i).getSPE());
            System.out.println(fields.get(9)+": "+pokemonObject.get(i).getAbility1());
            System.out.println(fields.get(10)+": "+pokemonObject.get(i).getAbility2());
            System.out.println(fields.get(11)+": "+pokemonObject.get(i).getAbility3());
            System.out.println(fields.get(12)+": "+pokemonObject.get(i).getItem());
        }
    }
}
