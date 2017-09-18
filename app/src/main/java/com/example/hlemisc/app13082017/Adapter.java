package com.example.hlemisc.app13082017;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hlemisc.app13082017.Animation.Rotation3dAnimation;
import com.example.hlemisc.app13082017.CardList.ListItem;

import java.util.ArrayList;
import java.util.Random;

public class Adapter extends ArrayAdapter<ListItem> {
    private Context _context;
    private ArrayList<ListItem> _rowItems;

    public Adapter(Context context, ArrayList<ListItem> items) {
        super(context, -1, items);
        this._context = context;
        this._rowItems = items;
    }

    @Override
    public int getCount() {
        return _rowItems.size();
    }

    @Override
    public ListItem getItem(int position) {
        return _rowItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return _rowItems.indexOf(getItem(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) _context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View rowView = layoutInflater.inflate(R.layout.list_item, parent, false);

        ImageView imageView = (ImageView) rowView.findViewById(R.id.card_image);
        TextView typeCard = (TextView) rowView.findViewById(R.id.card_type);
        TextView ownerCard = (TextView) rowView.findViewById(R.id.card_owner);

        imageView.setImageResource(_rowItems.get(position).get_idImage());
        set3DAnimation(imageView);
        typeCard.setText(_rowItems.get(position).get_typeCard());
        ownerCard.setText(_rowItems.get(position).get_ownerCard());

        return rowView;
    }

    private void set3DAnimation(ImageView imageView) {
        Random r = new Random();
        Animation animation = new Rotation3dAnimation(-45, 45, 0, 0, 0, 0);

        int durationTime = r.nextInt(3000 - 1000) + 1000;
        animation.setRepeatCount(Animation.INFINITE);
        animation.setRepeatMode(Animation.REVERSE);
        animation.setDuration(durationTime);
        imageView.setAnimation(animation);
    }
}
