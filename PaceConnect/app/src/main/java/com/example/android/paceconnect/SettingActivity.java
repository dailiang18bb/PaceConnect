package com.example.android.paceconnect;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class SettingActivity extends AppCompatActivity{

    EditText mUserName;
    EditText mUserEmail;
    ImageView mEditNameImageView;
    ImageView mEditEmailImageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_page);

        mUserName =findViewById(R.id.name_edit_text);
        mUserEmail = findViewById(R.id.email_edit_text);
        mEditNameImageView = findViewById(R.id.edit_name_button);
        mEditEmailImageView = findViewById(R.id.edit_email_button);

        Intent intent = getIntent();
        mUserName.setText(intent.getStringExtra("UserName"));
        mUserEmail.setText(intent.getStringExtra("UserEmail"));
        mUserName.setEnabled(false);
        mUserEmail.setEnabled(false);

        mEditNameImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUserName.setEnabled(true);
                mEditNameImageView.setImageResource(R.drawable.ic_save_white_24dp);
            }
        });

        mEditEmailImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUserEmail.setEnabled(true);
                mEditEmailImageView.setImageResource(R.drawable.ic_save_white_24dp);
            }
        });
    }
}
