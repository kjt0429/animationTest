package com.withhive.test.animationtest;

import android.annotation.SuppressLint;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

public class MainActivity extends AppCompatActivity {
	AnimationDrawable rocketAnimation;

	AnimationDrawable rocketAnimation2;

	@SuppressLint("ClickableViewAccessibility")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		///////////////////////////////////////////
		/*final AppCompatImageView imageView = findViewById(R.id.imageView);
		imageView.setBackgroundResource(R.drawable.image_anim);


		rocketAnimation = (AnimationDrawable)imageView.getBackground();


		final Animation hyperspaceJump = AnimationUtils.loadAnimation(this, R.anim.test);


		Button button = findViewById(R.id.button);
		button.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {



				rocketAnimation.start();
				imageView.startAnimation(hyperspaceJump);


			}
		});*/
		///////////////////////////////////////////

		final Animation hyperspaceJump2 = AnimationUtils.loadAnimation(this, R.anim.test_2);
		final AppCompatImageView imageView = findViewById(R.id.imageView);



		imageView.setImageDrawable(getDrawable(R.drawable.image_anim)); // todo
		rocketAnimation = (AnimationDrawable)imageView.getDrawable();


		imageView.setOnTouchListener(new View.OnTouchListener() {
			Animation hyperspaceJump = AnimationUtils.loadAnimation(MainActivity.this, R.anim.test);
			@Override
			public boolean onTouch(View v, MotionEvent event) {

				switch (event.getAction()){

					case MotionEvent.ACTION_DOWN:
						Log.d("disker","ACTION_DOWN");
						imageView.startAnimation(hyperspaceJump);
						rocketAnimation.start();
						return true;


					case MotionEvent.ACTION_MOVE:
						if(isInside(v, event)){
							Log.d("disker","ACTION_MOVE inside");

						}else{
							Log.d("disker","ACTION_MOVE outoutoutout");
							//imageView.startAnimation(hyperspaceJump2);


						}
						return true;

					case MotionEvent.ACTION_UP:
						imageView.startAnimation(hyperspaceJump2);
						imageView.setImageDrawable(getDrawable(R.drawable.image_anim_2));
						rocketAnimation2 = (AnimationDrawable)imageView.getDrawable();
						rocketAnimation2.start();

						if(isInside(v, event)){
							Log.d("disker","up inside");
						}else{
							Log.d("disker","up outside");
						}
						return true;
				}

				return false;
			}
		});

	}

	private boolean isInside(View v, MotionEvent e) {
		return !(e.getX() < 0 || e.getY() < 0
				|| e.getX() > v.getMeasuredWidth()
				|| e.getY() > v.getMeasuredHeight());
	}

	public class ReverseInterpolator implements Interpolator {
		@Override
		public float getInterpolation(float paramFloat) {
			return Math.abs(paramFloat -1f);
		}
	}
}