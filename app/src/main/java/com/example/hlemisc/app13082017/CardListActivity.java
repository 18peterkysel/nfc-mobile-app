package com.example.hlemisc.app13082017;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class CardListActivity extends Activity implements AdapterView.OnItemClickListener {
    private static final String[] _typesCards = new String[] {"ISIC","PLATOBNA KARTA", "ISIC"};
    private static final String[] _ownerCards = new String[] {"Peter Kysel","Peter Kysel 2", "Peter Kysel 3"};
    private ListView _listView;
    private ArrayList<ListItem> _rowItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_list);

        int[] _images;
        double density = getResources().getDisplayMetrics().density;
        if (density == 0.75) {
            _images =  new int[] {R.drawable.ldpi_isic_card_image, R.drawable.ldpi_tb_card_image,  R.drawable.ldpi_isic_card_image};
        } else if (density == 1.0) {
            _images =  new int[] {R.drawable.mdpi_isic_card_image, R.drawable.mdpi_tb_card_image,  R.drawable.mdpi_isic_card_image};
        } else if (density == 1.5) {
            _images =  new int[] {R.drawable.hdpi_isic_card_image, R.drawable.hdpi_tb_card_image,  R.drawable.hdpi_isic_card_image};
        } else if (density == 2.0) {
            _images =  new int[] {R.drawable.xhdpi_isic_card_image, R.drawable.xhdpi_tb_card_image,  R.drawable.xhdpi_isic_card_image};
        } else if (density == 3.0) {
            _images =  new int[] {R.drawable.xxhdpi_isic_card_image, R.drawable.xxhdpi_tb_card_image,  R.drawable.xxhdpi_isic_card_image};
        } else if (density == 4.0) {
            _images =  new int[] {R.drawable.xxxhdpi_isic_card_image, R.drawable.xxxhdpi_tb_card_image,  R.drawable.xxxhdpi_isic_card_image};
        } else {
            _images =  new int[] {R.drawable.isic_card_image, R.drawable.tb_card_image,  R.drawable.isic_card_image};
        }


        _rowItems = new ArrayList<>();
        for (int i = 0; i < _typesCards.length; i++) {
            ListItem listItem = new ListItem(_images[i], _typesCards[i], _ownerCards[i]);
            _rowItems.add(listItem);
        }

        _listView = (ListView) findViewById(R.id.card_list_view);
        Adapter adapter = new Adapter(this, _rowItems);
        _listView.setAdapter(adapter);
        _listView.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, CardDetailActivity.class);
        intent.putExtra(CardDetailFragment.ARG_ITEM_ID, "Card " + String.valueOf(position + 1));
        startActivity(intent);
    }
}
