package Code;

public class Main {
    public static void main(String[] args) {
        Conversion conversion =
                new Conversion("src/PokemonNero2.log");
        conversion.extractFromLog();
        conversion.toPokemon();
        conversion.printPokemons();
    }
}
