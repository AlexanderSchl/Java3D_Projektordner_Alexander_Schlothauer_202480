package Presentation;

import com.sun.j3d.utils.universe.SimpleUniverse;

import javax.media.j3d.*;
import javax.vecmath.Color3f;
import javax.vecmath.Point3d;

public class Shape3dExample {
    public static void main(String[] args) { new Shape3dExample();}

    public Shape3dExample(){
        SimpleUniverse universe = new SimpleUniverse();
        BranchGroup branchGroup = new BranchGroup();
        Appearance appearance = new Appearance();
        appearance.setColoringAttributes(new ColoringAttributes(new Color3f(0,1,0), ColoringAttributes.NICEST));

        branchGroup.addChild(new Shape3D(createGeometry(), appearance));
        universe.addBranchGraph(branchGroup);
        universe.getViewingPlatform().setNominalViewingTransform();
    }
    public QuadArray createGeometry(){

        QuadArray quadArray = new QuadArray(4,QuadArray.COORDINATES);
        quadArray.setCoordinate(0, new Point3d(0,0,0));
        quadArray.setCoordinate(1, new Point3d(1,0,0));
        quadArray.setCoordinate(2, new Point3d(1,1,0));
        quadArray.setCoordinate(3, new Point3d(0,1,0));

        return quadArray;
    }
}
