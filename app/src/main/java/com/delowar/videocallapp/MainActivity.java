package com.delowar.videocallapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.delowar.videocallapp.databinding.ActivityMainBinding;

import org.jitsi.meet.sdk.JitsiMeetActivity;
import org.jitsi.meet.sdk.JitsiMeetConferenceOptions;

import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        binding=ActivityMainBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);


        try {
            JitsiMeetConferenceOptions options = new JitsiMeetConferenceOptions.Builder()
                    .setServerURL(new URL(""))
                    .setRoom("test123")
                    .setAudioMuted(false)
                    .setVideoMuted(false)
                    .setAudioOnly(false)
                    .setWelcomePageEnabled(false)
                    .build();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }



        binding.joinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.codeBox.getText().toString().length()>0)
                {
                    JitsiMeetConferenceOptions options=new JitsiMeetConferenceOptions.Builder()
                                                .setRoom(binding.codeBox.getText().toString())
                                                 .build();
                    JitsiMeetActivity.launch(MainActivity.this,options);
                }else
                {
                    Toast.makeText(MainActivity.this, "Please enter your secrete code", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}