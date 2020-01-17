package Presentation;

import com.sun.j3d.utils.geometry.Sphere;
import com.sun.j3d.utils.universe.SimpleUniverse;
import javax.media.j3d.*;



public class MaterialExample {

    public static void main(String[] args) {
        new MaterialExample();
    }

    public MaterialExample(){
        SimpleUniverse universe = new SimpleUniverse();
        BranchGroup branchGroup = new BranchGroup();
        Sphere ball = new Sphere(0.4f);
        Appearance appearance= new Appearance();
        Material material = new Material();


           material.setEmissiveColor(0,0,0.5f);
          // material.setSpecularColor(5,0,0);
          // material.setShininess(1.0f);
           material.setDiffuseColor(0,0,1);


        appearance.setMaterial(material);
        ball.setAppearance(appearance);

        branchGroup.addChild(LightExample.addLightToObjectGroup(0.5f,0.5f,0.5f,-1,1,-1));
        branchGroup.addChild(ball);
        universe.getViewingPlatform().setNominalViewingTransform();
        universe.addBranchGraph(branchGroup);

    }


}
