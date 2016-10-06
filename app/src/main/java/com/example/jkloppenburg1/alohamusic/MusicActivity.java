package com.example.jkloppenburg1.alohamusic;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import static com.example.jkloppenburg1.alohamusic.R.raw.hula;

public class MusicActivity extends AppCompatActivity {

    private Button ukuleleButton;
    private Button ipuButton;
    private VideoView hulaVideoView;
    private Button hulaButton;

    private MediaPlayer ukuleleMP;
    private MediaPlayer ipuMP;
    private MediaPlayer hulaMP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        ukuleleButton = (Button) findViewById(R.id.ukuleleButton);
        ipuButton = (Button)findViewById(R.id.ipuButton);
        hulaButton = (Button) findViewById(R.id.hulaButton);


        hulaVideoView = (VideoView) findViewById(R.id.hulaVideoView);
        hulaVideoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + hula));
        hulaVideoView.setMediaController(new MediaController(this));

        //Associate media player object with the raw files
        ukuleleMP = MediaPlayer.create(this, R.raw.ukulele);
        ipuMP = MediaPlayer.create(this, R.raw.ukulele);

        // Associate media player object with the video

    }

    public void playMedia(View view)
    {
        // Determine which button is clicked
        switch (view.getId())
        {
            case R.id.ukuleleButton:
                if (ukuleleMP.isPlaying())
                {
                    ukuleleMP.pause();
                    // Show the other two buttons (ipu and hula)
                    ipuButton.setVisibility(View.VISIBLE);
                    hulaButton.setVisibility(View.VISIBLE);

                    ukuleleButton.setText(R.string.ukulele_button_play_text);
                }
                else
                {
                    ukuleleMP.start();
                    ukuleleButton.setText(R.string.ukulele_button_pause_text);
                    // Hide the other two buttons
                    ipuButton.setVisibility(View.INVISIBLE);
                    ipuButton.setVisibility(View.INVISIBLE);
                }

                break;
            case R.id.ipuButton:
                if (ukuleleMP.isPlaying())
                {
                    ipuMP.pause();
                    // Show the other two buttons (ipu and hula)
                    ukuleleButton.setVisibility(View.VISIBLE);
                    hulaButton.setVisibility(View.VISIBLE);

                    ipuButton.setText(R.string.ipu_button_play_text);
                }
                else
                {
                    ipuMP.start();
                    ipuButton.setText(R.string.ipu_button_pause_text);
                    // Hide the other two buttons
                    ukuleleButton.setVisibility(View.INVISIBLE);
                    hulaButton.setVisibility(View.INVISIBLE);
                }
                break;

            case R.id.hulaButton:
                if (hulaVideoView.isPlaying())
                {
                    hulaVideoView.pause();
                    hulaButton.setText(R.string.hula_button_watch_text);

                    ukuleleButton.setVisibility(View.VISIBLE);
                    ipuButton.setVisibility(View.VISIBLE);
                }
                else
                {
                    hulaVideoView.start();
                    hulaButton.setText(R.string.hula_button_pause_text);
                    ukuleleButton.setVisibility(View.INVISIBLE);
                    ipuButton.setVisibility(View.INVISIBLE);
                }


        }

    }
}
