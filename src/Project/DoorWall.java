package Project;

import com.sun.j3d.utils.geometry.Box;
import com.sun.j3d.utils.image.TextureLoader;

import javax.media.j3d.*;
import javax.vecmath.Color3f;
import javax.vecmath.Vector3d;
import java.awt.*;
import java.util.ArrayList;

public class DoorWall {
    TransformGroup transformGroupPart1;
    public DoorWall(float x, float y, float z) {
        Appearance appearance = new Appearance();
        Color3f color3f = new Color3f(0.5f,0.5f,0.5f);
        appearance.setColoringAttributes(new ColoringAttributes(color3f, ColoringAttributes.NICEST));
        ArrayList<Box> boxArrayList = new ArrayList<>();
        // Teil 1
        boxArrayList.add(new Box(x/5, y, z, appearance));
        // Türteil
        boxArrayList.add(new Box(x/5, y/4, z, appearance));
        // Teil 3
        boxArrayList.add(new Box((x/5)*3, y, z, appearance));
        createDoorWall(boxArrayList, x, y);
    }
    public DoorWall(float x, float y, float z, String TextureLocation) {
        Appearance appearance = new Appearance();
        TextureLoader textureLoader = new TextureLoader(TextureLocation, "RGB", new Container());
        Texture texture = textureLoader.getTexture();
        appearance.setTexture(texture);
        ArrayList<Box> boxArrayList = new ArrayList<>();
        // Teil 1
        boxArrayList.add(new Box(x/5, y, z, Box.GENERATE_TEXTURE_COORDS, appearance));
        // Türteil
        boxArrayList.add(new Box(x/5, y/4, z, Box.GENERATE_TEXTURE_COORDS, appearance));
        // Teil 3
        boxArrayList.add(new Box((x/5)*3, y, z, Box.GENERATE_TEXTURE_COORDS, appearance));
        createDoorWall(boxArrayList, x,y);
    }
    public DoorWall(float x, float y, float z, float r,float g,float b) {
        Appearance appearance = new Appearance();
        Color3f color3f = new Color3f(r,g,b);
        appearance.setColoringAttributes(new ColoringAttributes(color3f, ColoringAttributes.NICEST));
        //createDoorWall(x,y,z).setAppearance(appearance);
        ArrayList<Box> boxArrayList = new ArrayList<>();
        // Teil 1
        boxArrayList.add(new Box(x/5, y, z, appearance));
        // Türteil
        boxArrayList.add(new Box(x/5, y/4, z, appearance));
        // Teil 3
        boxArrayList.add(new Box((x/5)*3, y, z, appearance));
        createDoorWall(boxArrayList, x,y);
    }
    public void createDoorWall(ArrayList<Box> boxes, float x, float y){
        transformGroupPart1 = new TransformGroup();
        TransformGroup transformGroupPart2 = new TransformGroup();
        TransformGroup transformGroupPart3 = new TransformGroup();
        Transform3D transform3DPart1 = new Transform3D();
        Transform3D transform3DPart2 = new Transform3D();
        Transform3D transform3DPart3 = new Transform3D();
        transform3DPart1.set(new Vector3d(0,0,0));
        transform3DPart2.set(new Vector3d(0+(x/5)*2,(y/2)+(y/4),0));
        transform3DPart3.set(new Vector3d(0+(x/5)*4,(-y/2)-(y/4),0));
        transformGroupPart1.setTransform(transform3DPart1);
        transformGroupPart2.setTransform(transform3DPart2);
        transformGroupPart3.setTransform(transform3DPart3);

        transformGroupPart1.addChild(boxes.get(0));
        transformGroupPart2.addChild(boxes.get(1));
        transformGroupPart3.addChild(boxes.get(2));

        transformGroupPart1.addChild(transformGroupPart2);
        transformGroupPart2.addChild(transformGroupPart3);


    }
    public TransformGroup getDoorWall(){
        return transformGroupPart1;
    }
}
