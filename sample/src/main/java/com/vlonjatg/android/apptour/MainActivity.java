package com.vlonjatg.android.apptour;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import com.vlonjatg.android.apptourlibrary.AppTour;
import com.vlonjatg.android.apptourlibrary.MaterialSlide;

public class MainActivity extends AppTour {

    @Override
    public void init(Bundle savedInstanceState) {

        int firstColor = Color.parseColor("#0097A7");
        int secondColor = Color.parseColor("#FFA000");
        int thirdColor = Color.parseColor("#FF5722");
        int forthColor = Color.parseColor("#673AB7");

        addSlide(MaterialSlide.newInstance(R.drawable.cybr, "Presentations on the go",
                "Get stuff done with or without an internet connection.", firstColor, Color.WHITE, Color.WHITE));

        addSlide(MaterialSlide.newInstance(R.drawable.cybr, "Share and edit together",
                "Write on your own or invite more people to contribute.", secondColor, Color.WHITE, Color.WHITE));

        addSlide(MaterialSlide.newInstance(R.drawable.cybr, "Automatically save to the web",
                "Never lose your progress, so you can keep working from any computer or device.", thirdColor, Color.WHITE, Color.WHITE));

        addSlide(MaterialSlide.newInstance(R.drawable.cybr, "Edit PowerPoint presentations",
                "Open, edit, and save PowerPoint files - all withing Slides.", forthColor, Color.WHITE, Color.WHITE));

        setSkipButtonTextColor(Color.WHITE);
        setNextButtonTextColor(Color.WHITE);
        setDoneButtonTextColor(Color.WHITE);
    }

    @Override
    public void onSkipPressed() {
        Toast.makeText(this, "Skip", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDonePressed() {
        Toast.makeText(this, "Done", Toast.LENGTH_SHORT).show();
    }
}
