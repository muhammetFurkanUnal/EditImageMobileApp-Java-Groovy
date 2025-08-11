package com.example.deneme_java_groovy.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.deneme_java_groovy.R;

import static com.example.deneme_java_groovy.Constants.IMAGE_SELECT_CODE;

public class SelectImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.select_image);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }



    public void btnSelectImage(View v) {
        System.out.println("Select image button clicked!");

        // start image picking intent
        Intent selectImageIntent = new Intent(Intent.ACTION_PICK);
        selectImageIntent.setType("image/*");
        startActivityForResult(selectImageIntent, IMAGE_SELECT_CODE);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == IMAGE_SELECT_CODE && data != null) {
            Uri selectedImageUri = data.getData();

            Intent editImageActivityIntent = new Intent(getApplicationContext(), EditActivity.class);
            editImageActivityIntent.setData(selectedImageUri);
            startActivity(editImageActivityIntent);

        }

    }
}