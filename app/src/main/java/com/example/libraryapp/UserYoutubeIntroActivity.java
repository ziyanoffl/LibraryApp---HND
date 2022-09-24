package com.example.libraryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class UserYoutubeIntroActivity extends YouTubeBaseActivity {

    Button ytBtn;
    YouTubePlayerView ypv;
    YouTubePlayer.OnInitializedListener onInitializedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_youtube_intro);

        ytBtn = findViewById(R.id.ytPlay);
        ypv = findViewById(R.id.YouTubePlayerView);
//
        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("RaWupqzwImo");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };
        ytBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ypv.initialize("AIzaSyCDDORzHZZGRNaTndtpnazkODO9CY1Am6Y", onInitializedListener);
            }
        });
    }
}

