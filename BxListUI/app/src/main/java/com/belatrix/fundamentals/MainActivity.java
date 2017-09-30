package com.belatrix.fundamentals;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.belatrix.fundamentals.data.PokemonData;
import com.belatrix.fundamentals.model.Pokemon;
import com.belatrix.fundamentals.ui.adapter.OnItemClickListener;
import com.belatrix.fundamentals.ui.adapter.PokemonAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements OnItemClickListener {

    private final int DEFAULT_SPANCOUNT=3;
    private RecyclerView recyclerViewPokemon;
    private RecyclerView.LayoutManager mLayoutManager;

    private List<Pokemon> pokemonList;
    private PokemonAdapter pokemonAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ui();

        loadPokemonData();
    }

    private void gotoDetails(Pokemon pokemon){
        Intent intent= new Intent(this,PokemonDetailsActivity.class);
        startActivity(intent);
    }

    private void gotoDetailsAnimation(Pokemon pokemon,ImageView imageView){
        Intent intent= new Intent(this,PokemonDetailsActivity.class);
        intent.putExtra("POKEMON", pokemon);
        intent.putExtra("IMAGE_TRANSITION", ViewCompat.getTransitionName(imageView));

        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                this,
                imageView,
                ViewCompat.getTransitionName(imageView));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            startActivity(intent,options.toBundle());
        }
    }

    private void renderPokemons(){
        pokemonAdapter = new PokemonAdapter(this,pokemonList);
        pokemonAdapter.setOnItemClickListener(this);
        recyclerViewPokemon.setAdapter(pokemonAdapter);
    }

    private void loadPokemonData() {
        pokemonList= new PokemonData().generate();
        renderPokemons();
    }

    private void ui() {
        recyclerViewPokemon= (RecyclerView)findViewById(R.id.recyclerViewPokemon);
        mLayoutManager = new GridLayoutManager(this,DEFAULT_SPANCOUNT);
        recyclerViewPokemon.setLayoutManager(mLayoutManager);

        //events
        /*recyclerViewPokemon.addOnItemTouchListener(new RecyclerTouchListener(this, recyclerViewPokemon, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                if(pokemonList!=null){
                    Pokemon pokemon= pokemonList.get(position);
                    gotoDetails(pokemon);
                }
            }

            @Override
            public void onLongClick(View view, int position) {}
        }));*/
    }

    @Override
    public void onClikListener(int position, View container, ImageView imageView) {
        if(pokemonList!=null){
            Pokemon pokemon= pokemonList.get(position);
            gotoDetailsAnimation(pokemon,imageView);
        }
    }
}
