package com.example.android.musicalstructure;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PlayActivity extends AppCompatActivity {

    private String mSong;
    private String mArtist;
    private Button mPlayButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        //Get the song and artist from the intent extras
        mSong = getIntent().getStringExtra("song");
        mArtist = getIntent().getStringExtra("artist");

        //find and set the song and artist text
        TextView songTextView = (TextView) findViewById(R.id.activity_play_song);
        songTextView.setText(mSong);

        TextView artistTextView = (TextView) findViewById(R.id.activity_play_artist);
        artistTextView.setText(mArtist);

        //find the button and set onClickListener to switch between play and pause
        mPlayButton = findViewById(R.id.activity_play_button);
        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mPlayButton.getText().equals(getString(R.string.button_play))) {
                    mPlayButton.setText(getString(R.string.button_pause));
                } else {
                    mPlayButton.setText(getString(R.string.button_play));
                }
            }
        });
    }
}
