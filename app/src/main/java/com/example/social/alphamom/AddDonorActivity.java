package com.example.social.alphamom;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.example.social.alphamom.DTO.DonorInfoDto;

/**
 * Created by wee on 2017. 11. 20..
 */

public class AddDonorActivity extends AppCompatActivity{

    private DonorInfoDto donorInfoDto;
    private FirebaseAuth mAuth;
    private String uid;
    private double latitude;
    private double longitude;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_donor);

        Intent intent = getIntent();
        mAuth=FirebaseAuth.getInstance();
        uid=mAuth.getCurrentUser().getUid();

        latitude = intent.getExtras().getDouble("latitude");
        longitude = intent.getExtras().getDouble("longitude");
        final String feedingRoom = intent.getExtras().getString("feedingRoomTitle");

        final EditText donorName= findViewById(R.id.addDonor_layout_editText_name);
        final EditText donorAddress= findViewById(R.id.addDonor_layout_editText_residence);
        final EditText donorDeliveryDate= findViewById(R.id.addDonor_layout_editText_calving_date);
        final EditText donorEmail=findViewById(R.id.addDonor_layout_editText_email);
        final EditText donorPhoneNumber=findViewById(R.id.addDonor_layout_editText_phoneNumber);
        final Button addDonorNextButton=findViewById(R.id.addDonor_layout_button_nextButton);

        donorInfoDto = new DonorInfoDto();

        addDonorNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                donorInfoDto.setDonorName(donorName.getText().toString());
                donorInfoDto.setDonorAddress(donorAddress.getText().toString());
                donorInfoDto.setDonorDeliveryDate(donorDeliveryDate.getText().toString());
                donorInfoDto.setDonorEmail(donorEmail.getText().toString());
                donorInfoDto.setDonorPhoneNumber(Integer.parseInt(donorPhoneNumber.getText().toString()));
                donorInfoDto.setDonorUid(uid);
                Log.d("dto", String.valueOf(donorInfoDto));

                Intent intent= new Intent(getApplicationContext(),BoardActivity.class);
                intent.putExtra("donorInfoDto",donorInfoDto);
                intent.putExtra("feedingRoomTitle",feedingRoom);
                intent.putExtra("latitude", latitude);
                intent.putExtra("longitude", longitude);
                startActivity(intent);
            }
        });


    }
}
