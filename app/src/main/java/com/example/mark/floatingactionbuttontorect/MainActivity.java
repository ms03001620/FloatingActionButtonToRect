package com.example.mark.floatingactionbuttontorect;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        Animation animation = null;
        if (id == R.id.action_in) {
            animation = AnimationUtils.makeInAnimation(getBaseContext(), false);
            animation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationEnd(Animation animation) { }

                @Override
                public void onAnimationRepeat(Animation animation) { }

                @Override
                public void onAnimationStart(Animation animation) {
                    fab.setVisibility(View.VISIBLE);
                }
            });
        }else if (id == R.id.action_out) {
            animation = AnimationUtils.makeOutAnimation(getBaseContext(), true);
            animation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationEnd(Animation animation) {
                    fab.setVisibility(View.INVISIBLE);
                }

                @Override
                public void onAnimationRepeat(Animation animation) { }

                @Override
                public void onAnimationStart(Animation animation) { }
            });
        }else if (id == R.id.action_test) {
            LayoutAnimationController controller = AnimationUtils.loadLayoutAnimation(this, R.anim.slide_right);
            //fab.setLayoutAnimation(controller);
        }




        fab.startAnimation(animation);


        return super.onOptionsItemSelected(item);
    }
}
