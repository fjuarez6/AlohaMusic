package edu.orangecoastcollege.cs273.fjuarez6.alohamusic;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import static edu.orangecoastcollege.cs273.fjuarez6.alohamusic.R.raw.hula;

public class MediaActivity extends AppCompatActivity {

    private MediaPlayer ukuleleMP;
    private MediaPlayer ipuMP;

    private Button ukuleleButton;
    private Button ipuButton;
    private Button hulaButton;

    private VideoView hulaVideoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);

        ukuleleButton = (Button) findViewById(R.id.ukuleleButton);
        ipuButton = (Button) findViewById(R.id.ipuButton);
        hulaButton = (Button) findViewById(R.id.hulaButton);

        hulaVideoView = (VideoView) findViewById(R.id.hulaVideoView);
        hulaVideoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + hula));
        hulaVideoView.setMediaController(new MediaController(this));

        // Associate the media player object with the raw files;
        ukuleleMP = MediaPlayer.create(this, R.raw.ukulele);
        ipuMP = MediaPlayer.create(this, R.raw.ipu);

        // Associate the media Player object with the hula video
    }

    public void playMedia(View view) {
        switch (view.getId()) {
            case R.id.ukuleleButton:
                if (ukuleleMP.isPlaying()) {
                    ukuleleMP.pause();
                    ukuleleButton.setText(R.string.ukulele_button_play_text);
                    // Show the other two buttons (ipu and hula)
                    ipuButton.setVisibility(view.VISIBLE);
                    hulaButton.setVisibility(view.VISIBLE);
                } else {
                    ukuleleMP.start();
                    ukuleleButton.setText(R.string.ukulele_button_pause_text);
                    // Show the other two buttons (ipu and hula)
                    ipuButton.setVisibility(view.INVISIBLE);
                    hulaButton.setVisibility(view.INVISIBLE);
                }
                break;
            case R.id.ipuButton:
                if (ipuMP.isPlaying()) {
                    ukuleleMP.pause();
                    ipuButton.setText(R.string.ipu_button_play_text);
                    // Show the other two buttons (ipu and hula)
                    ukuleleButton.setVisibility(view.VISIBLE);
                    hulaButton.setVisibility(view.VISIBLE);
                } else {
                    ipuMP.start();
                    ipuButton.setText(R.string.ipu_button_pause_text);
                    // Show the other two buttons (ipu and hula)
                    ukuleleButton.setVisibility(view.INVISIBLE);
                    hulaButton.setVisibility(view.INVISIBLE);
                }
                break;
            case R.id.hulaButton:
                if (hulaVideoView.isPlaying()) {
                    hulaVideoView.pause();
                    hulaButton.setText(R.string.hula_button_watch_text);
                    // Show the other two buttons (ipu and hula)
                    ukuleleButton.setVisibility(view.VISIBLE);
                    ipuButton.setVisibility(view.VISIBLE);
                } else {
                    hulaVideoView.start();
                    hulaButton.setText(R.string.ukulele_button_pause_text);
                    // Show the other two buttons (ipu and hula)
                    ukuleleButton.setVisibility(view.INVISIBLE);
                    ipuButton.setVisibility(view.INVISIBLE);
                }
                break;
        }
    }
}
