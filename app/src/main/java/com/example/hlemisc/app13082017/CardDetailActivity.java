package com.example.hlemisc.app13082017;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class CardDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if (savedInstanceState == null) {
            Bundle arguments = new Bundle();
            arguments.putString(CardDetailFragment.ARG_ITEM_ID, getIntent().getStringExtra(CardDetailFragment.ARG_ITEM_ID));
            CardDetailFragment cardDetailFragment = new CardDetailFragment();
            cardDetailFragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction().add(R.id.cardDetailContainer, cardDetailFragment).commit();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            NavUtils.navigateUpTo(this, new Intent(this, CardListActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
