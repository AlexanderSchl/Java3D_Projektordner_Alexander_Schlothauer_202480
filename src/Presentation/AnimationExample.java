package Presentation;

import com.sun.j3d.utils.geometry.ColorCube;
import com.sun.j3d.utils.universe.*;
import javax.media.j3d.*;
import javax.vecmath.Point3d;


public class AnimationExample {

    public static void main(String[] args) {
        new AnimationExample();
    }

    public AnimationExample() {
        SimpleUniverse universe = new SimpleUniverse();
        BranchGroup branchGroup = new BranchGroup();
        ColorCube colorCube = new ColorCube(0.25);
        TransformGroup transformGroup = new TransformGroup();
        transformGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);

        /*RotationInterpolator rotationInterpolator = new RotationInterpolator(new Alpha(-1, 20000), transformGroup);
        rotationInterpolator.setSchedulingBounds(new BoundingSphere(new Point3d(), 100.0));
        transformGroup.addChild(rotationInterpolator);*/

        /*PositionInterpolator positionInterpolator = new PositionInterpolator(new Alpha(-1, 5000), transformGroup);
        positionInterpolator.setSchedulingBounds(new BoundingSphere(new Point3d(), 100));
        positionInterpolator.setStartPosition(0);
        positionInterpolator.setEndPosition(1);
        transformGroup.addChild(positionInterpolator);*/

        ScaleInterpolator scaleInterpolator = new ScaleInterpolator(new Alpha(-1, 4000), transformGroup);
        scaleInterpolator.setSchedulingBounds(new BoundingSphere(new Point3d(), 100));
        scaleInterpolator.setMinimumScale(1);
        scaleInterpolator.setMaximumScale(2);
        transformGroup.addChild(scaleInterpolator);

        transformGroup.addChild(colorCube);
        universe.getViewingPlatform().setNominalViewingTransform();
        branchGroup.addChild(transformGroup);
        universe.addBranchGraph(branchGroup);
    }

}
