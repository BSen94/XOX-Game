package com.bilgeadam.xox.animations;

import android.graphics.Rect;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public class Animations {

    private final static long DURATION = 500;
    private final static float ALPHA = 0.25F;

    /**
     * Rotates given text 360 degree for each 100ms.
     * @param myText Text to be animated.
     * @param duration Duration of the animation.
     */

    public void rotateText(@NotNull View myText, Optional<Long> duration){
        long durationValue = duration.orElse(DURATION);
        myText.animate().rotationXBy(360F * DURATION / 100).setDuration(DURATION).alpha(ALPHA);

    }

    /**
     * Moves the button out of the screen
     * @param myButton Button to be moved
     * @param duration Duration of the animation
     * @param currentWindow Current window manager
     */

    public void moveButton(@NotNull View myButton, Optional<Long> duration, WindowManager currentWindow){
        long durationValue = duration.orElse(DURATION);

        //Get current window boundaries
        Rect bounds = currentWindow.getCurrentWindowMetrics().getBounds();

        //Get current button location
        int[] buttonLocation= new int[2];
        myButton.getLocationInWindow(buttonLocation);

        switch (Direction.generateRandomDirection()){
            case Up:
                myButton.animate().translationYBy(bounds.top-buttonLocation[1] - myButton.getHeight()).setDuration(durationValue).alpha(ALPHA);
                break;
            case Left:
                myButton.animate().translationXBy(bounds.left-buttonLocation[0] - myButton.getWidth()).setDuration(durationValue).alpha(ALPHA);
                break;
            case Right:
                myButton.animate().translationXBy(bounds.right-buttonLocation[0]).setDuration(durationValue).alpha(ALPHA);
                break;
            case Bottom:
                myButton.animate().translationYBy(bounds.bottom-buttonLocation[1]).setDuration(durationValue).alpha(ALPHA);
                break;
        }

    }

    /**
     * Puts given shape into the image
     * @param image Image to be filled
     * @param shape Shape of given image
     * @param duration Duration of the animation
     */
    public void dropDownImage(@NotNull ImageView image, int shape, Optional<Long> duration){
        long durationValue = duration.orElse(DURATION);

        //Setup initial condition
        image.setImageResource(shape);
        image.setTranslationY(-image.getHeight());
        image.setAlpha(ALPHA);

        image.animate().translationYBy(image.getHeight()).alpha(1.0F).setDuration(durationValue);


    }

}
