package com.example.android.musicalstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ArrayList of Song objects
        final ArrayList<Song> songs = new ArrayList<Song>();
        songs.add(new Song("Song 1", "Amanda Farrell"));
        songs.add(new Song("Song 2", "Amanda Farrell"));
        songs.add(new Song("Song 3", "Amanda Farrell"));
        songs.add(new Song("Song 4", "Amanda Farrell"));
        songs.add(new Song("Song 5", "Amanda Farrell"));
        songs.add(new Song("Song 6", "Amanda Farrell"));
        songs.add(new Song("Song 7", "Amanda Farrell"));

        //Create adapter
        SongAdapter songAdapter = new SongAdapter(this, songs);

        //Find the ListView
        ListView listView = (ListView) findViewById(R.id.list);

        //Attach the adapter
        listView.setAdapter(songAdapter);

        //Set click listener to launch play activity when list item is clicked
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                //Get the {@link Song object at the given position the user clicked on
                Song song = songs.get(i);

                //Create new intent to open the {@link PlayActivity}
                Intent intent = new Intent(MainActivity.this, PlayActivity.class);

                //Put the song and artist as extras on the intent
                intent.putExtra("song", song.getSongTitle());
                intent.putExtra("artist", song.getArtistName());

                //Start the activity
                startActivity(intent);
            }
        });
    }
}
