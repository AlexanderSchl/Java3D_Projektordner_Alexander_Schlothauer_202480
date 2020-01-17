package Presentation;

import com.sun.j3d.utils.geometry.Sphere;
import com.sun.j3d.utils.universe.SimpleUniverse;

import javax.media.j3d.*;
import javax.vecmath.Color3f;
import javax.vecmath.Point3d;
import javax.vecmath.Vector3f;

public class LightExample {

    public static void main(String[] args) {
        new LightExample();
    }

    public LightExample(){
        SimpleUniverse universe = new SimpleUniverse();
        BranchGroup branchGroup = new BranchGroup();

        branchGroup.addChild(addLightToObjectGroup(1,1,5,-1,1,-1));
        branchGroup.addChild(new Sphere(0.5f));

        universe.getViewingPlatform().setNominalViewingTransform();
        universe.addBranchGraph(branchGroup);

    }
    public static DirectionalLight addLightToObjectGroup(float r, float g, float b, float x, float y, float z){
        Color3f color3f = new Color3f(r, g, b);                                                              // Farbe festlegen
        BoundingSphere bounds = new BoundingSphere(new Point3d(0,0,0), 100.0);                 // Festlegen innerhalb welchen Bereiches Licht auf Objekte wirken soll
        Vector3f vector3f = new Vector3f(x, y, z);                                                           // Richtung aus der Licht kommt festlegen
        DirectionalLight directionalLight = new DirectionalLight(color3f, vector3f);                         // Werte directionalLight übergeben
        directionalLight.setInfluencingBounds(bounds);                                                       // BoundingSphere übergeben
        return directionalLight;
    }
}

