package hw.ModelElements;

import hw.ModelElements.stuff.Angle3D;
import hw.ModelElements.stuff.Point3D;

import java.util.List;

public class Camera {
    public Point3D Location;
    public Angle3D Angle;

    public Camera(List<Scene> Scene){
    }

    public void Rotate(Angle3D angle){}
    public void Move(Point3D point){}
}
