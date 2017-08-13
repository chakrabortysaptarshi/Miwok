package com.example.ssapt.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 *
 * create an instance of this fragment.
 */
public class NumberFragment extends Fragment {


    private MediaPlayer mediaPlayer;

    private AudioManager audioManager;

    AudioManager.OnAudioFocusChangeListener audioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if(focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
            } else if(focusChange == AudioManager.AUDIOFOCUS_GAIN)
                mediaPlayer.start();
            else if(focusChange == AudioManager.AUDIOFOCUS_LOSS)
                releaseMediaPlayer();
        }
    };

    private void releaseMediaPlayer() {
        if(mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;

            audioManager.abandonAudioFocus(audioFocusChangeListener);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.activity_numbers, container, false);

        audioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

        final List<Word> numbers = new ArrayList<Word>();

        numbers.add(new Word("one","lutti", R.drawable.number_one, R.raw.number_one));
        numbers.add(new Word("two","oṭiiko", R.drawable.number_two, R.raw.number_two));
        numbers.add(new Word("three","tolookosu", R.drawable.number_three, R.raw.number_three));
        numbers.add(new Word("four","oyyiisa", R.drawable.number_four, R.raw.number_four));
        numbers.add(new Word("five","massokka", R.drawable.number_five, R.raw.number_five));
        numbers.add(new Word("six","temmokka", R.drawable.number_six, R.raw.number_six));
        numbers.add(new Word("seven","kenekaku", R.drawable.number_seven, R.raw.number_seven));
        numbers.add(new Word("eight","kawinṭa", R.drawable.number_eight, R.raw.number_eight));
        numbers.add(new Word("nine","wo'e", R.drawable.number_nine, R.raw.number_nine));
        numbers.add(new Word("ten","na'aacha", R.drawable.number_ten, R.raw.number_ten));

        WordAdapter wordAdapter = new WordAdapter(getActivity(), numbers, R.color.numberColor);
        ListView listView = (ListView) rootView.findViewById(R.id.numbersView);
        listView.setAdapter(wordAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                releaseMediaPlayer();

                int result = audioManager.requestAudioFocus(audioFocusChangeListener, AudioManager.STREAM_MUSIC,
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                mediaPlayer = MediaPlayer.create(getActivity(), numbers.get(position).getmAudioResourceId());
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        releaseMediaPlayer();
                    }
                });

            }
        });

        return rootView;
    }


    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
}
