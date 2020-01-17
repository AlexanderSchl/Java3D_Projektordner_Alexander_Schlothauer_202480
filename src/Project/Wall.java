package Project;

import com.sun.j3d.utils.geometry.Box;
import com.sun.j3d.utils.image.TextureLoader;

import javax.media.j3d.*;
import javax.vecmath.Color3f;
import javax.vecmath.Vector3d;
import java.awt.*;
import java.util.ArrayList;

public class Wall {
    Box box;
    TransformGroup transformGroupPart1;
    public Wall(float x, float y, float z) {
        Appearance appearance = new Appearance();
        Color3f color3f = new Color3f(0.5f,0.5f,0.5f);
        appearance.setColoringAttributes(new ColoringAttributes(color3f, ColoringAttributes.NICEST));

        box = new Box(x, y, z, Box.GENERATE_TEXTURE_COORDS, appearance);

    }
    public Wall(float x, float y, float z, String TextureLocation) {
        Appearance appearance = new Appearance();
        TextureLoader textureLoader = new TextureLoader(TextureLocation, "RGB", new Container());
        Texture texture = textureLoader.getTexture();
        appearance.setTexture(texture);

        box = new Box(x, y, z, Box.GENERATE_TEXTURE_COORDS, appearance);

    }
    public Wall(float x, float y, float z, float r,float g,float b) {
        Appearance appearance = new Appearance();
        Color3f color3f = new Color3f(r,g,b);
        appearance.setColoringAttributes(new ColoringAttributes(color3f, ColoringAttributes.NICEST));

        box = new Box(x, y, z, Box.GENERATE_TEXTURE_COORDS, appearance);

    }

    public Box getWall(){
        return box;
    }
}