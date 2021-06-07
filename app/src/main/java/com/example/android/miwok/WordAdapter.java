package com.example.android.miwok;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.android.miwok.R;
import com.example.android.miwok.Word;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter {

    private int mcolourId;

    public WordAdapter(Context context, ArrayList<Word> words, int colourId) {
        super(context, 0, words);
        mcolourId = colourId;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        Word currentWord = (Word) getItem(position);

        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        miwokTextView.setText(currentWord.getMiwokTranslation());

        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        defaultTextView.setText(currentWord.getDefaultTranslation());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image_view);
        if (currentWord.hasImage()) {
            imageView.setImageResource(currentWord.getImageResourceId());
            imageView.setVisibility(View.VISIBLE);
        } else {
            imageView.setVisibility(View.GONE);
        }

        //Set the theme color for list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        //find color by id
        int color = ContextCompat.getColor(getContext(), mcolourId);
        //Set background color
        textContainer.setBackgroundColor(color);


        return listItemView;

    }


}