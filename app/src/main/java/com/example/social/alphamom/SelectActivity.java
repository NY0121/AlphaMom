package com.example.social.alphamom;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by wee on 2017. 11. 5..
 */

public class SelectActivity extends AppCompatActivity {

    private FirebaseAuth auth;
    private FirebaseDatabase database;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selelct);

        //FireBase auth&database
        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        //button
        ImageButton findFeedingRoomButton = findViewById(R.id.select_layout_findFeedingRoom_imgButton);
        ImageButton guiedGoButton= findViewById(R.id.select_layout_guide_imgButton);
        Button myPageGoButton = findViewById(R.id.select_layout_myInfo_button);


        //firebase_get
        String uid = auth.getCurrentUser().getUid();

        //clickEvent
        findFeedingRoomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("눌림");
                Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
                startActivity(intent);
            }
        });

        myPageGoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AddDonorActivity.class);
                startActivity(intent);
            }
        });
        guiedGoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //커뮤니티 게시판을 넣어주세요
                Intent intent = new Intent(getApplicationContext(), BoardActivity.class);
                startActivity(intent);
            }
        });

    }


}
