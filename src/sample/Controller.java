package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import sample.convert.Conversion;

import java.io.File;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Controller {

    @FXML
    public ListView listViewMove;
    @FXML
    public Label evolution;
    @FXML
    private Label name;
    @FXML
    private Label type;
    @FXML
    private Label HP;
    @FXML
    private Label ATK;
    @FXML
    private Label DEF;
    @FXML
    private Label SATK;
    @FXML
    private Label SDEF;
    @FXML
    private Label SPE;
    @FXML
    private Label ability;
    @FXML
    private Label item;
    @FXML
    private ImageView img;
    @SuppressWarnings("FieldMayBeFinal")
    @FXML
    private ListView<String> listView = new ListView<>();
    private Conversion conversion;
    private Image[] imagesSprite;
    private Image[] imagesArtwork;

    @FXML
    private void handleButtonAction() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open log file");
        File file = fileChooser.showOpenDialog(null);

        if (file != null) {
            conversion = new Conversion(String.valueOf(file.getAbsoluteFile()));
            conversion.extractFromLog();
            conversion.toPokemon();
            conversion.setEvolutions();
            imagesSprite = new Image[conversion.pokemonObjects.size()];
            imagesArtwork = new Image[conversion.pokemonObjects.size()];
            for (int i = 0; i < conversion.pokemonObjects.size(); i++) {
                listView.getItems().add(conversion.printPokemonElement(i, 0));
                Path imageFileArtwork = Paths.get(
                        "C:\\Users\\DELL\\IdeaProjects\\pokedexRandomizer\\src\\img\\pokemonArtworkDataBase\\" +
                                (i + 1) + ".png");
                try {
                    imagesArtwork[i] = new Image(imageFileArtwork.toUri().toURL().toExternalForm());
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                Path imageFileSprite = Paths.get(
                        "C:\\Users\\DELL\\IdeaProjects\\pokedexRandomizer\\src\\img\\pokemonSpriteDataBase\\" +
                                conversion.intToName(i).toLowerCase() + ".png");
                try {
                    imagesSprite[i] = new Image(imageFileSprite.toUri().toURL().toExternalForm());
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                listView.setCellFactory(param -> new ListCell<String>() {
                    private final ImageView imageView = new ImageView();

                    @Override
                    public void updateItem(String name, boolean empty) {
                        super.updateItem(name, empty);
                        if (empty) {
                            setText(null);
                            setGraphic(null);
                        } else {
                            for (int j = 0; j < conversion.pokemonObjects.size(); j++) {
                                if (conversion.nameToInt(name) == j) {
                                    imageView.setImage(imagesSprite[j]);
                                }
                            }
                            setText(name);
                            setGraphic(imageView);
                        }
                    }
                });
            }

        }
    }

    @FXML
    private void selectElementOfList() {
        int elementNumber = conversion.nameToInt(listView.getSelectionModel().selectedItemProperty().getValue());
        name.setText(conversion.printPokemonElement(elementNumber, 0));
        type.setText(conversion.printPokemonElement(elementNumber, 1));
        HP.setText(conversion.printPokemonElement(elementNumber, 2));
        ATK.setText(conversion.printPokemonElement(elementNumber, 3));
        DEF.setText(conversion.printPokemonElement(elementNumber, 4));
        SATK.setText(conversion.printPokemonElement(elementNumber, 5));
        SDEF.setText(conversion.printPokemonElement(elementNumber, 6));
        SPE.setText(conversion.printPokemonElement(elementNumber, 7));
        ability.setText(conversion.printPokemonElement(elementNumber, 8));
        item.setText(conversion.printPokemonElement(elementNumber, 9));
        evolution.setText(conversion.printPokemonElement(elementNumber, 10));
        img.setImage(imagesArtwork[elementNumber]);
    }
}
