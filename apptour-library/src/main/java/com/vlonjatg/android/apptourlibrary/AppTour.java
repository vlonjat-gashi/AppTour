package com.vlonjatg.android.apptourlibrary;

import android.animation.ArgbEvaluator;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
public abstract class AppTour extends AppCompatActivity {

    ViewPager introViewPager;
    RelativeLayout backgroundRelativeLayout;
    Button skipIntroButton;
    Button nextSlideButton;
    Button doneSlideButton;
    View separatorView;
    LinearLayout dotsLayout;
    TextView[] dots;

    PagerAdapter pagerAdapter;

    private List<Fragment> fragments = new Vector<>();

    int currentPosition;
    int activeDotColor;
    int inactiveDocsColor;
    int numberOfSlides;

    ArgbEvaluator argbEvaluator = new ArgbEvaluator();
    ArrayList<Integer> colors = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        if (Build.VERSION.SDK_INT >= 19) {
            //Set status bar to semi-transparent
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_app_tour);

        introViewPager = (ViewPager) findViewById(R.id.introViewPager);
        backgroundRelativeLayout = (RelativeLayout) findViewById(R.id.backgroundRelativeLayout);
        skipIntroButton = (Button) findViewById(R.id.skipIntroButton);
        nextSlideButton = (Button) findViewById(R.id.nextSlideButton);
        doneSlideButton = (Button) findViewById(R.id.doneSlideButton);
        separatorView = (View) findViewById(R.id.separatorView);
        dotsLayout = (LinearLayout) findViewById(R.id.viewPagerCountDots);

        activeDotColor = Color.RED;
        inactiveDocsColor = Color.WHITE;

        //Instantiate the PagerAdapter.
        pagerAdapter = new PagerAdapter(getSupportFragmentManager(), fragments);
        introViewPager.setAdapter(pagerAdapter);

        init(savedInstanceState);

        numberOfSlides = fragments.size();

        //Instantiate the indicator dots if there are more than one slide
        if (numberOfSlides > 1) {
            setViewPagerDots();
            skipIntroButton.setVisibility(View.VISIBLE);
        } else {
            skipIntroButton.setVisibility(View.INVISIBLE);
            nextSlideButton.setVisibility(View.INVISIBLE);
            doneSlideButton.setVisibility(View.VISIBLE);
        }

        setListeners();
    }

    private void setListeners() {
        introViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position < (pagerAdapter.getCount() - 1) && position < (colors.size() - 1)) {
                    introViewPager.setBackgroundColor((Integer)
                            argbEvaluator.evaluate(positionOffset, colors.get(position), colors.get(position + 1)));
                } else {
                    introViewPager.setBackgroundColor(colors.get(colors.size() - 1));
                }
            }

            @Override
            public void onPageSelected(int position) {
                currentPosition = position;

                //Hide SKIP button if last slide item, visible if not
                if (position == numberOfSlides - 1) {
                    skipIntroButton.setVisibility(View.INVISIBLE);
                } else {
                    skipIntroButton.setVisibility(View.VISIBLE);
                }

                //Hide NEXT button if last slide item and set DONE button
                //visible, otherwise hide Done button and set NEXT button visible
                if (position == numberOfSlides - 1) {
                    nextSlideButton.setVisibility(View.INVISIBLE);
                    doneSlideButton.setVisibility(View.VISIBLE);
                } else {
                    nextSlideButton.setVisibility(View.VISIBLE);
                    doneSlideButton.setVisibility(View.INVISIBLE);
                }

                //Set dots
                if (numberOfSlides > 1) {
                    //Set current inactive dots color
                    for (int i = 0; i < numberOfSlides; i++) {
                        dots[i].setTextColor(inactiveDocsColor);
                    }

                    //Set current active dot color
                    dots[position].setTextColor(activeDotColor);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        skipIntroButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(@NonNull View v) {
                onSkipPressed();
            }
        });

        nextSlideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                introViewPager.setCurrentItem(currentPosition + 1);
            }
        });

        doneSlideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(@NonNull View v) {
                onDonePressed();
            }
        });
    }

    public abstract void init(@Nullable Bundle savedInstanceState);

    public abstract void onSkipPressed();

    public abstract void onDonePressed();

    public void addSlide(@NonNull Fragment fragment) {
        fragments.add(fragment);
        pagerAdapter.notifyDataSetChanged();
    }

    public void setSkipText(@NonNull String text) {
        skipIntroButton.setText(text);
    }

    public void setNextText(@NonNull String text) {
        nextSlideButton.setText(text);
    }

    public void setDoneText(@NonNull String text) {
        doneSlideButton.setText(text);
    }

    public void setSkipButtonTextColor(@ColorInt int color) {
        skipIntroButton.setTextColor(color);
    }

    public void setNextButtonTextColor(@ColorInt int color) {
        nextSlideButton.setTextColor(color);
    }

    public void setDoneButtonTextColor(@ColorInt int color) {
        doneSlideButton.setTextColor(color);
    }

    public void setSeparatorColor(@ColorInt int color) {
        separatorView.setBackgroundColor(color);
    }

    public void setActiveDotColor(@ColorInt int color) {
        activeDotColor = color;
    }

    public void setInactiveDocsColor(@ColorInt int color) {
        inactiveDocsColor = color;
    }

    public void showSkip() {
        skipIntroButton.setVisibility(View.VISIBLE);
    }

    public void hideSkip() {
        skipIntroButton.setVisibility(View.INVISIBLE);
    }

    public void showNext() {
        nextSlideButton.setVisibility(View.VISIBLE);
    }

    public void hideNext() {
        nextSlideButton.setVisibility(View.INVISIBLE);
    }

    public void showDone() {
        doneSlideButton.setVisibility(View.VISIBLE);
    }

    public void hideDone() {
        doneSlideButton.setVisibility(View.INVISIBLE);
    }

    public void showIndicatorDots() {
        dotsLayout.setVisibility(View.VISIBLE);
    }

    public void hideIndicatorDots() {
        dotsLayout.setVisibility(View.INVISIBLE);
    }

    public void addBackgroundColor(@ColorInt int color) {
        colors.add(color);
    }

    private void setViewPagerDots() {
        dots = new TextView[numberOfSlides];

        //Set first inactive dots color
        for (int i = 0; i < numberOfSlides; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(30);
            dots[i].setTextColor(inactiveDocsColor);
            dotsLayout.addView(dots[i]);
        }

        //Set first active dot color
        dots[0].setTextColor(activeDotColor);
    }
}
