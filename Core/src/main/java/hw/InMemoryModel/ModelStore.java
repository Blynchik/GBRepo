package hw.InMemoryModel;

import hw.ModelElements.Camera;
import hw.ModelElements.Flash;
import hw.ModelElements.PoligonalModel;
import hw.ModelElements.Scene;

import java.util.ArrayList;
import java.util.List;

public class ModelStore implements IModelChanger {
    public List<PoligonalModel> Models;
    public List<Scene> Scenes;
    public List<Flash> Flashes;
    public List<Camera> Cameras;
    private List<IModelChangedObserver> changeObservers;

    public ModelStore(List<IModelChangedObserver> changeObservers){
        this.changeObservers = changeObservers;
        this.Models = new ArrayList<>();
        this.Scenes = new ArrayList<>();
        this.Flashes = new ArrayList<>();
        this.Cameras = new ArrayList<>();
    }

    public Scene GetScena(Integer num){
        return new Scene();
    }

    @Override
    public void NotifyChange(IModelChanger sender) {
    }
}
