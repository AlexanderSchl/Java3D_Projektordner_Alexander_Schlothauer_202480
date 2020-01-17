package Project;


import com.sun.j3d.utils.applet.MainFrame;
import com.sun.j3d.utils.behaviors.keyboard.KeyNavigatorBehavior;
import com.sun.j3d.utils.geometry.ColorCube;
import com.sun.j3d.utils.geometry.Sphere;
import com.sun.j3d.utils.pickfast.behaviors.PickTranslateBehavior;
import com.sun.j3d.utils.pickfast.behaviors.PickZoomBehavior;
import com.sun.j3d.utils.pickfast.behaviors.PickRotateBehavior;

import com.sun.j3d.utils.universe.PlatformGeometry;
import com.sun.j3d.utils.universe.SimpleUniverse;

import javax.media.j3d.*;
import javax.vecmath.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.util.Enumeration;
import java.util.Random;


public class Main extends Applet{

    Transform3D transform3D;
    TransformGroup transformGroup;
    BranchGroup branchGroup;
    SimpleUniverse universe;
    PlatformGeometry platformGeom;
    Canvas3D canvas3D;

    public static void main(String[] args) {
new MainFrame(new Main(), 1920,1080);

    }


    public Main(){
        setLayout(new BorderLayout());
        GraphicsConfiguration config = SimpleUniverse.getPreferredConfiguration();
        canvas3D = new Canvas3D(config);
        add("Center", canvas3D);
        universe = new SimpleUniverse(canvas3D);
        Transform3D transform3Dmultiply = new Transform3D();
        transform3Dmultiply.rotY(Math.PI);
        transform3D = new Transform3D();
        transform3D.set(new Vector3d(75,0,0));
        transform3D.mul(transform3Dmultiply);
        TransformGroup transformGroup1 = new TransformGroup();
        transformGroup1.setTransform(transform3D);
        branchGroup = new BranchGroup();

        BoundingSphere boundingSphere = new BoundingSphere(new Point3d(), 300);
        PickZoomBehavior zoom = new PickZoomBehavior(branchGroup, canvas3D, boundingSphere);
        PickRotateBehavior rotate = new PickRotateBehavior(branchGroup, canvas3D, boundingSphere);
        PickTranslateBehavior translate = new PickTranslateBehavior(branchGroup, canvas3D, boundingSphere);
        transformGroup = new TransformGroup();
        transformGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
        transformGroup.setCapability(TransformGroup.ENABLE_PICK_REPORTING);


        branchGroup.addChild(zoom);
        branchGroup.addChild(rotate);
        branchGroup.addChild(translate);
        branchGroup.addChild(transformGroup);
        transformGroup.addChild(new House(new DoorWall(100,50,10, "C:\\Users\\Alex\\Pictures\\Saved Pictures\\Texture.jpg"), new WindowWall(100,50,10, "C:\\Users\\Alex\\Pictures\\Saved Pictures\\Texture.jpg"), new Wall(100,50,10, "C:\\Users\\Alex\\Pictures\\Saved Pictures\\Texture.jpg"), new Wall(100,50,10, "C:\\Users\\Alex\\Pictures\\Saved Pictures\\Texture.jpg")).getHouse());
        transformGroup1.addChild(new House(new DoorWall(100,50,10, "C:\\Users\\Alex\\Pictures\\Saved Pictures\\Texture.jpg"), new WindowWall(100,50,10, "C:\\Users\\Alex\\Pictures\\Saved Pictures\\Texture.jpg"), new Wall(100,50,10, "C:\\Users\\Alex\\Pictures\\Saved Pictures\\Texture.jpg"), new Wall(100,50,10, "C:\\Users\\Alex\\Pictures\\Saved Pictures\\Texture.jpg")).getHouse());
        branchGroup.addChild(transformGroup1);

        branchGroup.addChild(createFloorTile());
        KeyNavigatorBehavior keyNavBeh = new KeyNavigatorBehavior(universe.getViewingPlatform().getViewPlatformTransform());
        keyNavBeh.setSchedulingBounds(new BoundingSphere(new Point3d(), 10000.0));
        platformGeom = new PlatformGeometry();
        platformGeom.addChild(keyNavBeh);

        universe.getViewingPlatform().setPlatformGeometry(platformGeom);
        universe.addBranchGraph(branchGroup);

KeyListener keyListener = new KeyListener() {
    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getKeyChar()=='1'){
            Appearance appearance = new Appearance();
            Material material = new Material();
            Random random = new Random();
            material.setEmissiveColor(new Color3f(random.nextFloat()*1,random.nextFloat()*1,random.nextFloat()*1));
            appearance.setMaterial(material);
            BranchGroup branchGroup1 = new BranchGroup();
            TransformGroup transformGroup1 = new TransformGroup();
            Transform3D transform3D1 = new Transform3D();

            transformGroup1.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
            transformGroup1.setCapability(TransformGroup.ENABLE_PICK_REPORTING);
            Sphere sphere = new Sphere(0.50f);
            sphere.setAppearance(appearance);
            Shoot shoot = new Shoot(sphere);
            transformGroup1.addChild(shoot.transformGroup1);
            transformGroup1.addChild(shoot);
            universe.getViewingPlatform().getViewPlatformTransform().getTransform(transform3D1);
            transformGroup1.setTransform(transform3D1);



            branchGroup1.addChild(transformGroup1);
            universe.addBranchGraph(branchGroup1);

        }
        /*if(e.getKeyChar()=='a'){
            Transform3D mul = new Transform3D();
            Transform3D transform3D = new Transform3D();
            mul.set(new Vector3d(-0.25,0,0));
            universe.getViewingPlatform().getViewPlatformTransform().getTransform(transform3D);
            transform3D.mul(mul);
            universe.getViewingPlatform().getViewPlatformTransform().setTransform(transform3D);
        }*/

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
};
universe.getCanvas().addKeyListener(keyListener);


    }
    public Shape3D createFloorTile(){

        Appearance appearance = new Appearance();
        QuadArray quadArray = new QuadArray(4, QuadArray.COORDINATES);

        quadArray.setCoordinate(0, new Point3d(-500, -50, -500));
        quadArray.setCoordinate(1, new Point3d(-500, -50, 500));
        quadArray.setCoordinate(2, new Point3d(500, -50, 500));
        quadArray.setCoordinate(3, new Point3d(500, -50, -500));

        appearance.setColoringAttributes(new ColoringAttributes(new Color3f(0.2f,1f,0.2f), ColoringAttributes.NICEST));
        Shape3D shape3D = new Shape3D(quadArray, appearance);
        return shape3D;
    }

public class Shoot extends Behavior{
    WakeupOnElapsedFrames wakeFrame;
    private Transform3D t3dstep = new Transform3D();
    private TransformGroup transformGroup1;
    private Transform3D transform3D1;
    public Shoot(Sphere sphere) {

        transformGroup1 = new TransformGroup();
        transform3D1 = new Transform3D();
        transform3D1.setTranslation(new Vector3d(0.0, 0.0, 0.0));
        transformGroup1.setTransform(transform3D1);
        transformGroup1.addChild(sphere);
        transformGroup1.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);

        BoundingSphere bounds = new BoundingSphere(new Point3d(0.0, 0.0,
                0.0), 1000.0);
        this.setSchedulingBounds(bounds);
    }
    @Override
    public void initialize() {
        wakeFrame = new WakeupOnElapsedFrames(0);
        wakeupOn(wakeFrame);
    }

    @Override
    public void processStimulus(Enumeration enumeration) {
        t3dstep.set(new Vector3d(0.0, 0.0, -0.25f));
        transformGroup1.getTransform(transform3D1);
        transform3D1.mul(t3dstep);
        transformGroup1.setTransform(transform3D1);
        wakeupOn(wakeFrame);
    }
  }
}