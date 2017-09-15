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

import java.util.ArrayList;

class Adapter extends ArrayAdapter<ListItem> {
    private Context _context;
    private ArrayList<ListItem> _rowItems;

    Adapter(Context context, ArrayList<ListItem> items) {
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
        Animation animation = new Rotation3dAnimation(0, 0, 360, 0, 0, 0);
        animation.setRepeatCount(Animation.INFINITE);
        animation.setRepeatMode(Animation.RESTART);
        animation.setDuration(2000);
        imageView.setAnimation(animation);
    }
}
