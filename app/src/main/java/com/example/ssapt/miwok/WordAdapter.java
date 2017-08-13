package com.example.ssapt.miwok;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ssapt on 7/17/2017.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    private int mColorResourceId;

    public WordAdapter(@NonNull Context context, @NonNull List objects, int colorResourceId) {
        super(context, 0, objects);
        mColorResourceId = colorResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null)
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent, false);

        Word currentWord = getItem(position);

        TextView miwokView = (TextView) listItemView.findViewById(R.id.meowk_text);
        TextView englishView = (TextView) listItemView.findViewById(R.id.english_text);
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.miwokImageView);

        miwokView.setText(currentWord.getmMiwokTranslation());
        englishView.setText(currentWord.getmDefaultTranslation());

        if(currentWord.getImageResourceId() != -1)
            imageView.setImageResource(currentWord.getImageResourceId());
        else
            imageView.setVisibility(View.GONE);

        LinearLayout linearLayout = (LinearLayout) listItemView.findViewById(R.id.layoutView);

        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        linearLayout.setBackgroundColor(color);



        return listItemView;
    }
}
