package hw.ModelElements;

import java.util.ArrayList;
import java.util.List;

public class PoligonalModel {
    public List<Poligon> Poligons;
    public List<Texture> Textures;

    public PoligonalModel(List<Texture> Textures,
                          List<Scene> Scenes){
        this.Textures = Textures;
        this.Poligons = new ArrayList<>();
    }
}
