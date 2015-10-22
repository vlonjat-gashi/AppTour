package com.vlonjatg.android.apptourlibrary;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * @author Vlonjat Gashi (vlonjatg)
 */
public class MaterialIconSlide extends Fragment {

    private static final String ARG_DRAWABLE = "drawable";
    private static final String ARG_TITLE = "title";
    private static final String ARG_CONTENT = "content";
    private static final String ARG_TITLE_TEXT_COLOR = "titleTextColor";
    private static final String ARG_CONTENT_TEXT_COLOR = "contentTextColor";

    String drawable;
    String title;
    String content;
    int titleTextColor;
    int contentTextColor;

    RelativeLayout slideRelativeLayout;
    TextView iconTextView;
    TextView slideTitleTextView;
    TextView slideContentTextView;

    public MaterialIconSlide() {
    }

    /**
     * Create Material Slide
     * @param imageDrawable Image resource for the slide
     * @param title String value of the slide title
     * @param content String value of the slide content
     * @param titleTextColor Color value of the title text color
     * @param contentTextColor Color value of the content text color
     * @return Returned the created slide
     */
    public static MaterialIconSlide newInstance(String imageDrawable, String title, String content, int titleTextColor, int contentTextColor) {

        MaterialIconSlide materialSlide = new MaterialIconSlide();

        Bundle args = new Bundle();
        args.putString(ARG_DRAWABLE, imageDrawable);
        args.putString(ARG_TITLE, title);
        args.putString(ARG_CONTENT, content);
        args.putInt(ARG_TITLE_TEXT_COLOR, titleTextColor);
        args.putInt(ARG_CONTENT_TEXT_COLOR, contentTextColor);
        materialSlide.setArguments(args);

        return materialSlide;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null && getArguments().size() != 0) {
            drawable = getArguments().getString(ARG_DRAWABLE);
            title = getArguments().getString(ARG_TITLE);
            content = getArguments().getString(ARG_CONTENT);
            titleTextColor = getArguments().getInt(ARG_TITLE_TEXT_COLOR);
            contentTextColor = getArguments().getInt(ARG_CONTENT_TEXT_COLOR);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_material_icon_slide, container, false);

        slideRelativeLayout = (RelativeLayout) rootView.findViewById(R.id.slideRelativeLayout);
        iconTextView = (TextView) rootView.findViewById(R.id.iconTextView);
        slideTitleTextView = (TextView) rootView.findViewById(R.id.slideTitleTextView);
        slideContentTextView = (TextView) rootView.findViewById(R.id.slideContentTextView);

        iconTextView.setText(drawable);
        slideTitleTextView.setText(title);
        slideContentTextView.setText(content);

        if (titleTextColor != 0) {
            slideTitleTextView.setTextColor(titleTextColor);
        }

        if (contentTextColor != 0) {
            slideContentTextView.setTextColor(contentTextColor);
        }

        return rootView;
    }
}
