package sample;

import sample.convert.Conversion;

public class Pokedex {
    public static void main(String[] args) {
        Conversion conversion =
                new Conversion("C:\\Users\\DELL\\IdeaProjects\\pokedexRandomizer\\src\\PokemonNero2.log");
        conversion.extractFromLog();
        conversion.toPokemon();
        conversion.printPokemons();
    }
}
