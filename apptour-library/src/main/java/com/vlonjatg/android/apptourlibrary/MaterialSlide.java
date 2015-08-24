package com.vlonjatg.android.apptourlibrary;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by star on 8/24/15.
 */
public class MaterialSlide extends Fragment {

    private static final String ARG_DRAWABLE = "drawable";
    private static final String ARG_TITLE = "title";
    private static final String ARG_CONTENT = "content";
    private static final String ARG_BACKGROUND_COLOR = "backgroundColor";
    private static final String ARG_TITLE_TEXT_COLOR = "titleTextColor";
    private static final String ARG_CONTENT_TEXT_COLOR = "contentTextColor";

    int drawable;
    String title;
    String content;
    int backgroundColor;
    int titleTextColor;
    int contentTextColor;

    RelativeLayout slideRelativeLayout;
    ImageView slideImageView;
    TextView slideTitleTextView;
    TextView slideContentTextView;

    public MaterialSlide() {
    }

    public static MaterialSlide newInstance(int imageDrawable, String title, String content,
                                            int backgroundColor, int titleTextColor, int contentTextColor) {

        MaterialSlide materialSlide = new MaterialSlide();

        Bundle args = new Bundle();
        args.putInt(ARG_DRAWABLE, imageDrawable);
        args.putString(ARG_TITLE, title);
        args.putString(ARG_CONTENT, content);
        args.putInt(ARG_BACKGROUND_COLOR, backgroundColor);
        args.putInt(ARG_TITLE_TEXT_COLOR, titleTextColor);
        args.putInt(ARG_CONTENT_TEXT_COLOR, contentTextColor);
        materialSlide.setArguments(args);

        return materialSlide;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null && getArguments().size() != 0) {
            drawable = getArguments().getInt(ARG_DRAWABLE);
            title = getArguments().getString(ARG_TITLE);
            content = getArguments().getString(ARG_CONTENT);
            backgroundColor = getArguments().getInt(ARG_BACKGROUND_COLOR);
            titleTextColor = getArguments().getInt(ARG_TITLE_TEXT_COLOR);
            contentTextColor = getArguments().getInt(ARG_CONTENT_TEXT_COLOR);

            ((AppTour) getActivity()).addBackgroundColor(backgroundColor);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_material_slide, container, false);

        slideRelativeLayout = (RelativeLayout) rootView.findViewById(R.id.slideRelativeLayout);
        slideImageView = (ImageView) rootView.findViewById(R.id.slideImageView);
        slideTitleTextView = (TextView) rootView.findViewById(R.id.slideTitleTextView);
        slideContentTextView = (TextView) rootView.findViewById(R.id.slideContentTextView);

        slideImageView.setImageResource(drawable);
        slideTitleTextView.setText(title);
        slideContentTextView.setText(content);

        if (titleTextColor != 0) {
            slideTitleTextView.setTextColor(titleTextColor);
        }

        if (contentTextColor != 0) {
            slideContentTextView.setTextColor(contentTextColor);
        }


        //slideRelativeLayout.setBackgroundColor(backgroundColor);

        return rootView;
    }
}
