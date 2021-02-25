package Graphic;

import Code.Conversion;
import Code.convert.Move;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.io.File;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Controller {

    @FXML
    public TableView<Move> tableViewMove;
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



    @FXML
    /**
     * All'evento di selezione di un file, si apre un menu di scelta e vengono caricati all'interno degli array pokemonObjects i pokemon estratti dal file
     */
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

            for (int i = 0; i < conversion.pokemonObjects.size(); i++) {
                listView.getItems().add(conversion.pokemonElement(i, 0));

                Path imageFileSprite = Paths.get(
                        "src/Graphic/img/pokemonSpriteDataBase/" +
                                conversion.intToName(i).toLowerCase() + ".png");
                try {
                    imagesSprite[i] = new Image(imageFileSprite.toUri().toURL().toExternalForm());
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                listView.setCellFactory(param -> new ListCell<>() {
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
            ObservableList<Move> moves = FXCollections.observableArrayList(conversion.movePokemonObjects);
            tableViewMove.setItems(moves);
            TableColumn<Move, String> nameMoveColumn = new TableColumn<>("Nome");
            TableColumn<Move, String> typeMoveColumn = new TableColumn<>("Tipo");
            TableColumn<Move, String> powerMoveColumn = new TableColumn<>("Power");
            TableColumn<Move, String> accuracyMoveColumn = new TableColumn<>("Acc.");
            TableColumn<Move, String> pPMoveColumn = new TableColumn<>("PP");
            TableColumn<Move, ImageView> categoryMoveColumn = new TableColumn<>("Category");
            nameMoveColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
            typeMoveColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
            powerMoveColumn.setCellValueFactory(new PropertyValueFactory<>("power"));
            accuracyMoveColumn.setCellValueFactory(new PropertyValueFactory<>("accuracy"));
            pPMoveColumn.setCellValueFactory(new PropertyValueFactory<>("PP"));
            categoryMoveColumn.setCellValueFactory(new PropertyValueFactory<>("imageView"));
            tableViewMove.getColumns().addAll(nameMoveColumn, typeMoveColumn, powerMoveColumn, accuracyMoveColumn, pPMoveColumn, categoryMoveColumn);
        }
    }


    @FXML
    /**
     * Questo è il metodo utilizzato per visualizzare tutte le caratteristiche del Pokemon che selezioniamo dalla lista
     */
    private void selectElementOfList() {
        int elementNumber = conversion.nameToInt(listView.getSelectionModel().selectedItemProperty().getValue());
        name.setText(conversion.pokemonElement(elementNumber, 0));
        type.setText(conversion.pokemonElement(elementNumber, 1));
        HP.setText(conversion.pokemonElement(elementNumber, 2));
        ATK.setText(conversion.pokemonElement(elementNumber, 3));
        DEF.setText(conversion.pokemonElement(elementNumber, 4));
        SATK.setText(conversion.pokemonElement(elementNumber, 5));
        SDEF.setText(conversion.pokemonElement(elementNumber, 6));
        SPE.setText(conversion.pokemonElement(elementNumber, 7));
        ability.setText(conversion.pokemonElement(elementNumber, 8));
        item.setText(conversion.pokemonElement(elementNumber, 9));
        evolution.setText(conversion.pokemonElement(elementNumber, 10));
        String url;
        if (elementNumber+1 < 10) {
            url = "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/00" + (elementNumber+1) + ".png";
        }
        else if (elementNumber+1 < 100) {
            url = "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/0" + (elementNumber+1) + ".png";
        }
        else {
            url = "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/" + (elementNumber+1) + ".png";
        }
        Image image = new Image(url);
        if (image.isError()) {
            System.out.println("Errore");
            // if you need more details
            // image.getException().printStackTrace();
        }
        img.setImage(image);
    }

    @FXML
    /**
     * Quando si clicca sul nome dell'evoluzione del Pokemon si aprono direttamente le caratteristiche dell'evoluzioneX
     */
    private void selectEvolution() {
        try {
            int elementNumber = conversion.nameToInt(evolution.getText());
            name.setText(conversion.pokemonElement(elementNumber, 0));
            type.setText(conversion.pokemonElement(elementNumber, 1));
            HP.setText(conversion.pokemonElement(elementNumber, 2));
            ATK.setText(conversion.pokemonElement(elementNumber, 3));
            DEF.setText(conversion.pokemonElement(elementNumber, 4));
            SATK.setText(conversion.pokemonElement(elementNumber, 5));
            SDEF.setText(conversion.pokemonElement(elementNumber, 6));
            SPE.setText(conversion.pokemonElement(elementNumber, 7));
            ability.setText(conversion.pokemonElement(elementNumber, 8));
            item.setText(conversion.pokemonElement(elementNumber, 9));
            evolution.setText(conversion.pokemonElement(elementNumber, 10));
            String url;
            if (elementNumber+1 < 10) {
                url = "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/00" + (elementNumber+1) + ".png";
            }
            else if (elementNumber+1 < 100) {
                url = "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/0" + (elementNumber+1) + ".png";
            }
            else {
                url = "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/" + (elementNumber+1) + ".png";
            }
            Image image = new Image(url);
            if (image.isError()) {
                System.out.println("Errore");
                // if you need more details
                // image.getException().printStackTrace();
            }
            img.setImage(image);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
