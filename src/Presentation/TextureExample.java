package Presentation;
import com.sun.j3d.utils.geometry.*;
import com.sun.j3d.utils.universe.*;
import com.sun.j3d.utils.image.*;
import javax.media.j3d.*;
import javax.vecmath.*;
import java.awt.Container;

public class TextureExample {

    public static void main(String[] args) {
    new TextureExample();
    }

    public TextureExample() {
        SimpleUniverse universe = new SimpleUniverse();
        BranchGroup branchGroup = new BranchGroup();
        // Umgebungslicht
        BoundingSphere bounds = new BoundingSphere(new Point3d(0.0,0.0,0.0), 100.0);
        AmbientLight ambientLight = new AmbientLight(new Color3f(1,1,1));
        ambientLight.setInfluencingBounds(bounds);

        branchGroup.addChild(ambientLight);
        branchGroup.addChild(addSphereWithTexture("C:\\Users\\Alex\\Pictures\\Saved Pictures\\TextureExample.jpg"));

        universe.getViewingPlatform().setNominalViewingTransform();
        universe.addBranchGraph(branchGroup);
    }
    public Sphere addSphereWithTexture(String string){
        Appearance appearance = new Appearance();
        TextureLoader loader = new TextureLoader(string,"RGB", new Container());   // Textur laden. RGB = mit Standardfarben der Textur
        Texture texture = loader.getTexture();                                         // Textur in Texture Objekt speichern
        appearance.setTexture(texture);                                                // Textur appearance Objekt übergeben
        int flags = Primitive.GENERATE_NORMALS + Primitive.GENERATE_TEXTURE_COORDS;    // Flags setzen. Wird benötigt, um primitives eine Textur übergeben zu können (Spheres, Cones, Cylinders, Boxes)
        Sphere sphere = new Sphere(0.5f, flags, appearance);
        return sphere;
    }
}
