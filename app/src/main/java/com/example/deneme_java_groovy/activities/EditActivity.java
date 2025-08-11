package com.example.deneme_java_groovy.activities;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.deneme_java_groovy.R;

public class EditActivity extends AppCompatActivity {


    Uri selectedImageUri;
    ImageView selectedImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.edit);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.edit), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        selectedImage = findViewById(R.id.selectedImage);
        selectedImageUri = getIntent().getData();

        selectedImage.setImageURI(selectedImageUri);


    }


    public void btnBrightnessClicked(View v) {
        System.out.println("Brightness button clicked!");
    }

    public void btnZoomClicked(View v) {
        System.out.println("Zoom button clicked!");
    }

    public void btnCropClicked(View v) {
        System.out.println("Crop button clicked!");
    }

    public void btnCutClicked(View v) {
        System.out.println("Cut button clicked!");
    }

    public void btnEditClicked(View v) {
        System.out.println("Edit button clicked!");
    }

    public void btnEffectClicked(View v) {
        System.out.println("Effect button clicked!");
    }

}



