package Code.convert;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Move {
    private int num;
    private String name;
    private String type;
    private int power;
    private int accuracy;
    private int PP;
    private String category;
    private ImageView imageView;

    // Costruttore
    public Move(int num) {
        this.num = num;
    }

    public Move() {
        this.imageView = new ImageView();
    }

    public int getNum() {
        return num;
    }

    // Getter e Setter
    public void setNum(int num) {
        this.num = num;
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
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public int getPP() {
        return PP;
    }

    public void setPP(int PP) {
        this.PP = PP;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
        setImageView(category);
    }

    public ImageView getImageView() {
        return imageView;
    }

    /**
     * Serve per impostare l'immagine in base alla categoria della mossa presa in esame
     * @param categoryImage stringa contenente il tipo della mossa
     */
    public void setImageView(String categoryImage) {
        if (categoryImage.equalsIgnoreCase("Physical")) {
            try {
                this.imageView.setImage(new Image(new FileInputStream(
                        "src/Graphic/img/moveCategory/Physical.png")));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else if (categoryImage.equalsIgnoreCase("Special")) {
            try {
                this.imageView.setImage(new Image(new FileInputStream(
                        "src/Graphic/img/moveCategory/Special.png")));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            try {
                this.imageView.setImage(new Image(new FileInputStream(
                        "src/Graphic/img/moveCategory/Status.png")));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
