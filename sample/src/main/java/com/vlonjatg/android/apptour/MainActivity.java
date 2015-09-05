package com.vlonjatg.android.apptour;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.vlonjatg.android.apptourlibrary.AppTour;
import com.vlonjatg.android.apptourlibrary.MaterialSlide;

/**
 * @author Vlonjat Gashi (vlonjatg)
 */
public class MainActivity extends AppTour {

    @Override
    public void init(Bundle savedInstanceState) {

        int firstColor = Color.parseColor("#0097A7");
        int secondColor = Color.parseColor("#FFA000");
        int thirdColor = Color.parseColor("#FF5722");
        int forthColor = Color.parseColor("#673AB7");
        int customSlideColor = Color.parseColor("#009866");

        //Create pre-created fragments
        Fragment firstSlide = MaterialSlide.newInstance(R.drawable.cybr, "Presentations on the go",
                "Get stuff done with or without an internet connection.", Color.WHITE, Color.WHITE);

        Fragment secondSlide = MaterialSlide.newInstance(R.drawable.cybr, "Share and edit together",
                "Write on your own or invite more people to contribute.", Color.WHITE, Color.WHITE);

        Fragment thirdSlide = MaterialSlide.newInstance(R.drawable.cybr, "Automatically save to the web",
                "Never lose your progress, so you can keep working from any computer or device.", Color.WHITE, Color.WHITE);

        Fragment forthSlide = MaterialSlide.newInstance(R.drawable.cybr, "Edit PowerPoint presentations",
                "Open, edit, and save PowerPoint files - all withing Slides.", Color.WHITE, Color.WHITE);

        //Add slides
        addSlide(firstSlide, firstColor);
        addSlide(secondSlide, secondColor);
        addSlide(thirdSlide, thirdColor);
        addSlide(forthSlide, forthColor);

        //Custom slide
        addSlide(new CustomSlide(), customSlideColor);

        //Customize tour
        setSkipButtonTextColor(Color.WHITE);
        setNextButtonColorToWhite();
        setDoneButtonTextColor(Color.WHITE);
    }

    @Override
    public void onSkipPressed() {
        Toast.makeText(this, "Skip", Toast.LENGTH_SHORT).show();

        //Do something after clicking Skip button.
        //E.x: Go to the sign up slide.
        setCurrentSlide(4);
    }

    @Override
    public void onDonePressed() {
        Toast.makeText(this, "Done", Toast.LENGTH_SHORT).show();

        //Do something after clicking Done button.
        //E.x: Finish the intro.
        finish();
    }
}
