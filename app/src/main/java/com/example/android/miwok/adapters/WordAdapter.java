package com.example.android.miwok.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.miwok.R;
import com.example.android.miwok.entities.Word;

import java.util.List;

public class WordAdapter extends ArrayAdapter<Word> {
    private final int backgroundResourceId;

    public WordAdapter(final Context context, final List<Word> objects, final int backgroundResourceId) {
        super(context, 0, objects);
        this.backgroundResourceId = backgroundResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        final Word word = getItem(position);

        listItemView.findViewById(R.id.parent_text_view).setBackgroundResource(backgroundResourceId);

        ((TextView) listItemView.findViewById(R.id.miwok_text_view)).setText(word.getMiwokTranslation());

        ((TextView) listItemView.findViewById(R.id.default_text_view)).setText(word.getDefaultTranslation());

        ImageView imageView = ((ImageView) listItemView.findViewById(R.id.miwok_image_view));
        if (word.getImageResourceId() > 0) {
            imageView.setImageResource(word.getImageResourceId());
        } else {
            imageView.setVisibility(View.GONE);
        }

        return listItemView;
    }
}
