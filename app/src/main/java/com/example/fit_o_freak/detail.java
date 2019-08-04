package com.example.fit_o_freak;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class detail extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {
TextView t,t1;
    MyDB1 myDB1;
String videoId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        t = findViewById(R.id.textView2);
        t1 = findViewById(R.id.tv);
        myDB1 = new MyDB1(getApplicationContext());
        final Intent intent = getIntent();
        String e = intent.getExtras().getString("Ename");
        t.setText(e);
        Button buttonPlay = findViewById(R.id.buttonPlay);
        final YouTubePlayerView youtubePlayerView = (YouTubePlayerView) findViewById(R.id.youtubePlayerView);
        if(e.equalsIgnoreCase("crunches")){
            videoId = "Xyd_fa5zoEU";
        }
        if(e.equalsIgnoreCase("plank")){
            videoId = "DHvSGdCIZyQ";
            t1.setText("1 min x 3");
        }
        if(e.equalsIgnoreCase("lying leg raise")){
            videoId = "JB2oyawG9KI";
            t1.setText("15 x 3");
        }
        if(e.equalsIgnoreCase("seated toe touch")){
            videoId = "y6Bv_0Shhc8";
            t1.setText("1 min x 3");
        }
        if(e.equalsIgnoreCase("laid cycle")){
            videoId = "P2W2_OK_1Ss";
            t1.setText("1 min x 3");
        }if(e.equalsIgnoreCase("inclined dumbbell press")){
            videoId = "0G2_XV7slIg";
            t1.setText("1 min x 3");
        }if(e.equalsIgnoreCase("Flat dumbbell press")){
            videoId = "VmB1G1K7v94";
            t1.setText("1 min x 3");
        }if(e.equalsIgnoreCase("declined dumbbell press")){
            videoId = "0xRvl4Qv3ZY";
            t1.setText("1 min x 3");
        }if(e.equalsIgnoreCase("dumbbell flyes")){
            videoId = "eozdVDA78K0";
            t1.setText("1 min x 3");
        }if(e.equalsIgnoreCase("pushups")){
            videoId = "IODxDxX7oi4";
            t1.setText("1 min x 3");
        }if(e.equalsIgnoreCase("squats")){
            videoId = "aclHkVaku9U";
            t1.setText("1 min x 3");
        }if(e.equalsIgnoreCase("backward lunge")){
            videoId = "K3vgNL2OFI8";
            t1.setText("1 min x 3");
        }if(e.equalsIgnoreCase("calf raise")){
            videoId = "gwLzBJYoWlI";
            t1.setText("1 min x 3");
        }if(e.equalsIgnoreCase("leg press")){
            videoId = "GvRgijoJ2xY";
            t1.setText("1 min x 3");
        }if(e.equalsIgnoreCase("leg curls")){
            videoId = "ELOCsoDSmrg";
            t1.setText("1 min x 3");
        }if(e.equalsIgnoreCase("curls")){
            videoId = "yTWO2th-RIY";
            t1.setText("1 min x 3");
        }if(e.equalsIgnoreCase("hammer curls")){
            videoId = "zC3nLlEvin4";
            t1.setText("1 min x 3");
        }if(e.equalsIgnoreCase("tricep pull down")){
            videoId = "2-LAMcpzODU";
            t1.setText("1 min x 3");
        }if(e.equalsIgnoreCase("bend over curls")){
            videoId = "Jvj2wV0vOYU";
            t1.setText("1 min x 3");
        }if(e.equalsIgnoreCase("dead lift")){
            videoId = "1uDiW5--rAE";
            t1.setText("1 min x 3");
        }if(e.equalsIgnoreCase("latch pull down")){
            videoId = "CAwf7n6Luuc";
            t1.setText("1 min x 3");
        }if(e.equalsIgnoreCase("bend over rows")){
            videoId = "vT2GjY_Umpw";
            t1.setText("1 min x 3");
        }if(e.equalsIgnoreCase("dumbbell shrugs")){
            videoId = "cJRVVxmytaM";
            t1.setText("1 min x 3");
        }
        Cursor data = myDB1.getDataexer();
        while(data.moveToNext()){
            if(e.equalsIgnoreCase(data.getString(1)))
                videoId = data.getString(2);
        }

        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//intent.getExtras().getString("Ename");
              playVideo(videoId, youtubePlayerView);
            }
        });
        //AIzaSyC1zmOJzKIa2vwIYnIoHNXtW9ijN58hnAY
    }
    public void playVideo(final String videoId, YouTubePlayerView youTubePlayerView) {
        //initialize youtube player view
        youTubePlayerView.initialize("AIzaSyC1zmOJzKIa2vwIYnIoHNXtW9ijN58hnAY",
                new YouTubePlayer.OnInitializedListener() {
                    @Override
                    public void onInitializationSuccess(YouTubePlayer.Provider provider,
                                                        YouTubePlayer youTubePlayer, boolean b) {
                        youTubePlayer.cueVideo(videoId);
                    }

                    @Override
                    public void onInitializationFailure(YouTubePlayer.Provider provider,
                                                        YouTubeInitializationResult youTubeInitializationResult) {

                    }
                });
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

    }
}
