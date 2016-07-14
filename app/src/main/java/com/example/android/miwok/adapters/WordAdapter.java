package com.example.android.miwok.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.android.miwok.R;
import com.example.android.miwok.entities.Word;

import java.util.List;

/**
 * Created by HUT on 7/14/2016.
 */
public class WordAdapter extends ArrayAdapter<Word> {
    public WordAdapter(Context context, List<Word> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        final Word word = getItem(position);

        ((TextView)listItemView.findViewById(R.id.miwok_text_view)).setText(word.getMiwokTranslation());

        ((TextView)listItemView.findViewById(R.id.default_text_view)).setText(word.getDefaultTranslation());

        return listItemView;
    }
}
