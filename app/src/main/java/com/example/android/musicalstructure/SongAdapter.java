package com.example.android.musicalstructure;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter {

    /**
     * This is a custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context The current context. Used to inflate the layout file.
     * @param songs   A List of Song objects to display in a list
     */
    public SongAdapter(@NonNull Context context, ArrayList<Song> songs) {
        super(context, 0, songs);
    }


    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position    The position in the list of data that should be displayed in the
     *                    list item view.
     * @param convertView The recycled view to populate.
     * @param parent      The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Song} object located at this position in the list
        Song currentSong = (Song) getItem(position);

        //Find and set the song TextView in the list_item.xml layout
        TextView songTextView = (TextView) listItemView.findViewById(R.id.song);
        songTextView.setText(currentSong.getSongTitle());

        //Find and set the artist TextView in the list_item.xml layout
        TextView artistTextView = (TextView) listItemView.findViewById(R.id.artist);
        artistTextView.setText(currentSong.getArtistName());

        // Return the whole list item layout so that it can be shown in the ListView
        return listItemView;
    }
}
