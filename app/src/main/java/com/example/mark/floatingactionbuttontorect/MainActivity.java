package com.example.mark.floatingactionbuttontorect;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

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
        if (id == R.id.action_zoom) {
            animation = AnimationUtils.loadAnimation(getBaseContext(), R.anim.zoon_in);
            animation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationEnd(Animation animation) { }

                @Override
                public void onAnimationRepeat(Animation animation) { }

                @Override
                public void onAnimationStart(Animation animation) {
                    fab.setVisibility(View.INVISIBLE);
                }
            });
        }else if (id == R.id.action_in) {
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
        }else if (id == R.id.action_child) {
            animation = AnimationUtils.makeInChildBottomAnimation(getBaseContext());
            animation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationEnd(Animation animation) {
                    fab.setVisibility(View.VISIBLE);
                }

                @Override
                public void onAnimationRepeat(Animation animation) { }

                @Override
                public void onAnimationStart(Animation animation) { }
            });
        }else if (id == R.id.action_right_in) {
            LinearLayout mBox = (LinearLayout)findViewById(R.id.box);
            LayoutAnimationController controller = AnimationUtils.loadLayoutAnimation(this, R.anim.layout_right_in);
            //fab.setLayoutAnimation(controller);
            mBox.setLayoutAnimation(controller);
            mBox.startLayoutAnimation();

        }else if (id == R.id.action_zoon_out) {
            RelativeLayout mBox2 = (RelativeLayout)findViewById(R.id.box2);
            mBox2.setVisibility(View.VISIBLE);
            LayoutAnimationController controller = AnimationUtils.loadLayoutAnimation(this, R.anim.layout_zoon_out);
            //fab.setLayoutAnimation(controller);
            mBox2.setLayoutAnimation(controller);
            mBox2.startLayoutAnimation();
        }else if (id == R.id.action_zoon_in) {
            final RelativeLayout mBox2 = (RelativeLayout)findViewById(R.id.box2);
            mBox2.setVisibility(View.VISIBLE);
            LayoutAnimationController controller = AnimationUtils.loadLayoutAnimation(this, R.anim.layout_zoon_in);
            //fab.setLayoutAnimation(controller);
            mBox2.setLayoutAnimation(controller);
            mBox2.setLayoutAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });




            mBox2.startLayoutAnimation();
        }else if (id == R.id.action_zoon_out_grid) {
            RelativeLayout mBox2 = (RelativeLayout)findViewById(R.id.box2);


            Animation single=AnimationUtils.loadAnimation(this, R.anim.zoon_out);
            CustomLayoutAnimationController controller = new CustomLayoutAnimationController(single);
            controller.setOrder(CustomLayoutAnimationController.ORDER_CUSTOM);
            controller.setDelay(1.3f);

            mBox2.setLayoutAnimation(controller);
            mBox2.startLayoutAnimation();
        }else if (id == R.id.action_zoon_out_line) {
            LinearLayout mBox2 = (LinearLayout)findViewById(R.id.layout_red);

            final LinearLayout line1 = (LinearLayout)findViewById(R.id.layout_line1);
            final LinearLayout line2 = (LinearLayout)findViewById(R.id.layout_line2);
            LayoutAnimationController zoon = AnimationUtils.loadLayoutAnimation(this, R.anim.layout_zoon_out);
            //line1.setLayoutAnimation(zoon);
            //line2.setLayoutAnimation(zoon);

            Animation single=AnimationUtils.loadAnimation(this, R.anim.zoon_out);

            CustomLayoutAnimationController controller = new CustomLayoutAnimationController(single);
            controller.setOrder(CustomLayoutAnimationController.ORDER_CUSTOM);
            controller.setDelay(4.0f);
/*            controller.setOnIndexListener(new CustomLayoutAnimationController.Callback() {
                @Override
                public int onIndex(CustomLayoutAnimationController controller, int count, int index) {
                    Log.v("MainActivity", "onIndex:"+index+", cont:"+count);
                    if(index==0){
                        line1.startLayoutAnimation();

                        return 0;
                    }

                    if(index==1){
                        line2.startLayoutAnimation();

                        return 1;
                    }
                    return index;
                }
            });*/


            mBox2.setLayoutAnimation(controller);
            mBox2.startLayoutAnimation();
        }





        if(animation!=null){
            fab.startAnimation(animation);
        }

        return super.onOptionsItemSelected(item);
    }
}
