package sample.convert;

import java.io.File;
import java.util.ArrayList;

public class Conversion {
    private File inputLog;
    public ArrayList<Pokemon> pokemon = new ArrayList<Pokemon>();
    public Conversion(String path){
       this.inputLog = new File("\""+path+"\"");
    }
    public void extractFromLog(){

    }


}
