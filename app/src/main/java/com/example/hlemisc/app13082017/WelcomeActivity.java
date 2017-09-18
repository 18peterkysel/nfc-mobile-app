package com.example.hlemisc.app13082017;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.hlemisc.app13082017.CardList.CardListActivity;

public class WelcomeActivity extends AppCompatActivity {
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Animation animation_zoom_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.welcome_animation_zoom_in);
        final Animation animation_zoom_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.welcome_animation_zoom_out);
        imageView = (ImageView) findViewById(R.id.imageView);

        animation_zoom_in.setDuration(2000);
        animation_zoom_out.setDuration(1000);
        animation_zoom_in.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                animation_zoom_out.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        finish();
                        startActivity(new Intent(getApplicationContext(), CardListActivity.class));
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                imageView.setAnimation(animation_zoom_out);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        imageView.setAnimation(animation_zoom_in);
    }
}
