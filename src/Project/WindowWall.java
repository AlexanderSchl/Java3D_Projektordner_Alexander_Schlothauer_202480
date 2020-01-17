package Project;

import com.sun.j3d.utils.geometry.Box;
import com.sun.j3d.utils.image.TextureLoader;

import javax.media.j3d.*;
import javax.vecmath.Color3f;
import javax.vecmath.Vector3d;
import java.awt.*;
import java.util.ArrayList;

public class WindowWall {
    TransformGroup transformGroupPart1;
    public WindowWall(float x, float y, float z) {
        Appearance appearance = new Appearance();
        Color3f color3f = new Color3f(0.5f,0.5f,0.5f);
        appearance.setColoringAttributes(new ColoringAttributes(color3f, ColoringAttributes.NICEST));
        ArrayList<Box> boxArrayList = new ArrayList<>();
        // Teil 1
        boxArrayList.add(new Box(x/5, y, z, appearance));
        // Fenster Teil 1
        boxArrayList.add(new Box(x/5, y/4, z, appearance)); // Block 1.1
        boxArrayList.add(new Box(x/5, y/4, z, appearance)); // Block 1.2
        // Teil 3
        boxArrayList.add(new Box(x/5, y, z, appearance));
        // Fenster Teil 2
        boxArrayList.add(new Box(x/5, y/4, z, appearance)); // Block 2.1
        boxArrayList.add(new Box(x/5, y/4, z, appearance)); // Block 2.2
        // Teil 4
        boxArrayList.add(new Box(x/5, y, z, appearance));
        createDoorWall(boxArrayList, x, y);
    }
    public WindowWall(float x, float y, float z, String TextureLocation) {
        Appearance appearance = new Appearance();
        TextureLoader textureLoader = new TextureLoader(TextureLocation, "RGB", new Container());
        Texture texture = textureLoader.getTexture();
        appearance.setTexture(texture);
        ArrayList<Box> boxArrayList = new ArrayList<>();
        // Teil 1
        boxArrayList.add(new Box(x/5, y, z, Box.GENERATE_TEXTURE_COORDS, appearance));
        // Fenster Teil 1
        boxArrayList.add(new Box(x/5, y/4, z, Box.GENERATE_TEXTURE_COORDS, appearance)); // Block 1.1
        boxArrayList.add(new Box(x/5, y/4, z, Box.GENERATE_TEXTURE_COORDS, appearance)); // Block 1.2
        // Teil 3
        boxArrayList.add(new Box(x/5, y, z,Box.GENERATE_TEXTURE_COORDS, appearance));
        // Fenster Teil 2
        boxArrayList.add(new Box(x/5, y/4, z, Box.GENERATE_TEXTURE_COORDS, appearance)); // Block 2.1
        boxArrayList.add(new Box(x/5, y/4, z, Box.GENERATE_TEXTURE_COORDS, appearance)); // Block 2.2
        // Teil 4
        boxArrayList.add(new Box(x/5, y, z, Box.GENERATE_TEXTURE_COORDS, appearance));
        createDoorWall(boxArrayList, x,y);
    }
    public WindowWall(float x, float y, float z, float r,float g,float b) {
        Appearance appearance = new Appearance();
        Color3f color3f = new Color3f(r,g,b);
        appearance.setColoringAttributes(new ColoringAttributes(color3f, ColoringAttributes.NICEST));
        //createDoorWall(x,y,z).setAppearance(appearance);
        ArrayList<Box> boxArrayList = new ArrayList<>();
        // Teil 1
        boxArrayList.add(new Box(x/5, y, z, appearance));
        // Fenster Teil 1
        boxArrayList.add(new Box(x/5, y/4, z, appearance)); // Block 1.1
        boxArrayList.add(new Box(x/5, y/4, z, appearance)); // Block 1.2
        // Teil 3
        boxArrayList.add(new Box(x/5, y, z, appearance));
        // Fenster Teil 2
        boxArrayList.add(new Box(x/5, y/4, z, appearance)); // Block 2.1
        boxArrayList.add(new Box(x/5, y/4, z, appearance)); // Block 2.2
        // Teil 4
        boxArrayList.add(new Box(x/5, y, z, appearance));
        createDoorWall(boxArrayList, x,y);
    }
    public void createDoorWall(ArrayList<Box> boxes, float x, float y){
        transformGroupPart1 = new TransformGroup();
        TransformGroup transformGroupPart2 = new TransformGroup();
        TransformGroup transformGroupPart3 = new TransformGroup();
        TransformGroup transformGroupPart4 = new TransformGroup();
        TransformGroup transformGroupPart5 = new TransformGroup();
        TransformGroup transformGroupPart6 = new TransformGroup();
        TransformGroup transformGroupPart7 = new TransformGroup();

        Transform3D transform3DPart1 = new Transform3D();
        Transform3D transform3DPart2 = new Transform3D();
        Transform3D transform3DPart3 = new Transform3D();
        Transform3D transform3DPart4 = new Transform3D();
        Transform3D transform3DPart5 = new Transform3D();
        Transform3D transform3DPart6 = new Transform3D();
        Transform3D transform3DPart7 = new Transform3D();

        transform3DPart1.set(new Vector3d(0,0,0));
        transform3DPart2.set(new Vector3d(0+(x/5)*2,(y/2)+(y/4),0));
        transform3DPart3.set(new Vector3d(0,((-y/2)-(y/4)*4),0));
        transform3DPart4.set(new Vector3d(0+(x/5)*2,y-y/4,0));
        transform3DPart5.set(new Vector3d(0+(x/5)*2,(y/2)+(y/4),0));
        transform3DPart6.set(new Vector3d(0,((-y/2)-(y/4)*4),0));
        transform3DPart7.set(new Vector3d(0+(x/5)*2,y-y/4,0));

        transformGroupPart1.setTransform(transform3DPart1);
        transformGroupPart2.setTransform(transform3DPart2);
        transformGroupPart3.setTransform(transform3DPart3);
        transformGroupPart4.setTransform(transform3DPart4);
        transformGroupPart5.setTransform(transform3DPart5);
        transformGroupPart6.setTransform(transform3DPart6);
        transformGroupPart7.setTransform(transform3DPart7);

        transformGroupPart1.addChild(boxes.get(0));
        transformGroupPart2.addChild(boxes.get(1));
        transformGroupPart3.addChild(boxes.get(2));
        transformGroupPart4.addChild(boxes.get(3));
        transformGroupPart5.addChild(boxes.get(4));
        transformGroupPart6.addChild(boxes.get(5));
        transformGroupPart7.addChild(boxes.get(6));

        transformGroupPart1.addChild(transformGroupPart2);
        transformGroupPart2.addChild(transformGroupPart3);
        transformGroupPart3.addChild(transformGroupPart4);
        transformGroupPart4.addChild(transformGroupPart5);
        transformGroupPart5.addChild(transformGroupPart6);
        transformGroupPart6.addChild(transformGroupPart7);
    }
    public TransformGroup getWindowWall(){
        return transformGroupPart1;
    }
}