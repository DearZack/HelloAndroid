package io.github.dearzack.helloandroid.activity;

import android.app.Fragment;
import android.support.transition.ChangeBounds;
import android.support.transition.Fade;
import android.support.transition.Scene;
import android.support.transition.TransitionManager;
import android.support.transition.TransitionSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;

import io.github.dearzack.helloandroid.R;

public class TransitionAnimationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition_animation);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new Fragment())
                    .commit();
        }
        goToScene();
    }


    private void goToScene() {
        ChangeBounds changeBounds = new ChangeBounds();
        changeBounds.setDuration(2000);
        Fade fadeOut = new Fade(Fade.OUT);
        fadeOut.setDuration(2000);
        Fade fadeIn = new Fade(Fade.IN);
        fadeIn.setDuration(2000);
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.setOrdering(TransitionSet.ORDERING_SEQUENTIAL);
        transitionSet.addTransition(fadeOut)
                .addTransition(changeBounds)
                .addTransition(fadeIn);
        ViewGroup container = (ViewGroup) findViewById(R.id.container);
        TransitionManager.go(Scene.getSceneForLayout(container, R.layout.scene_after, this), transitionSet);
    }
}
