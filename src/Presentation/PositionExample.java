package Presentation;

import com.sun.j3d.utils.geometry.ColorCube;
import com.sun.j3d.utils.universe.SimpleUniverse;

import javax.media.j3d.BranchGroup;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.vecmath.Vector3d;

public class PositionExample {

    public static void main(String[] args) {
    new PositionExample();
    }

    public PositionExample(){
       SimpleUniverse universe = new SimpleUniverse();
       BranchGroup branchGroup = new BranchGroup();
        for (double i = 0; i<1.0; i = i + 0.2) {
            branchGroup.addChild(positionObjects(i, 0, 0)); // entlang der X-Achse
            branchGroup.addChild(positionObjects(0, i, 0)); // entlang der Y-Achse
        }
        universe.getViewingPlatform().setNominalViewingTransform();
        universe.addBranchGraph(branchGroup);

    }
    public TransformGroup positionObjects(double x, double y, double z){
        Transform3D transform3D = new Transform3D();
        TransformGroup transformGroup = new TransformGroup();
        transform3D.set(new Vector3d(x,y,z));                 // Position übergeben
        transformGroup.setTransform(transform3D);             // Transform zu Transformgroup hinzufügen
        transformGroup.addChild(new ColorCube(0.05));      // Objekt hinzufügen
        return transformGroup;
    }
}
