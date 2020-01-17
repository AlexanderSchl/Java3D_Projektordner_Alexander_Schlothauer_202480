package Project;

import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.vecmath.Vector3d;

public class House {
    TransformGroup transformGroup1;
    public House(DoorWall doorWall, WindowWall windowWall, Wall wall, Wall wall2){


        createHouse(doorWall, windowWall, wall, wall2);
    }
    public void createHouse(DoorWall doorWall, WindowWall windowWall, Wall wall, Wall wall2){
Transform3D transform3D = new Transform3D();
transform3D.rotY(Math.PI/2);
 transformGroup1 = new TransformGroup();
TransformGroup transformGroup2 = new TransformGroup();
TransformGroup transformGroup3 = new TransformGroup();
TransformGroup transformGroup4 = new TransformGroup();

Transform3D transform3D1 = new Transform3D();

Transform3D transform3D2 = new Transform3D();
Transform3D transform3D3 = new Transform3D();

Transform3D transform3D4 = new Transform3D();

transform3D1.set(new Vector3d(0,0,0));
transform3D2.set(new Vector3d(0,0,200)); // -75
transform3D3.set(new Vector3d(-10,0,-100));
transform3D4.set(new Vector3d(0,0,180));  // 75
transform3D3.mul(transform3D);
//transform3D3.rotY(Math.PI/2-180);

transformGroup1.setTransform(transform3D1);
transformGroup2.setTransform(transform3D2);
transformGroup3.setTransform(transform3D3);
transformGroup4.setTransform(transform3D4);


        /*transformGroup1.addChild(wall.getWall());
        transformGroup2.addChild(windowWall.getWindowWall());
        transformGroup3.addChild(doorWall.getDoorWall());
        transformGroup4.addChild(wall2.getWall());*/

transformGroup1.addChild(doorWall.getDoorWall());
transformGroup2.addChild(windowWall.getWindowWall());
transformGroup3.addChild(wall.getWall());
transformGroup4.addChild(wall2.getWall());
transformGroup1.addChild(transformGroup2);
transformGroup2.addChild(transformGroup3);
transformGroup3.addChild(transformGroup4);

    }
    public TransformGroup getHouse(){
        return transformGroup1;
    }
}
