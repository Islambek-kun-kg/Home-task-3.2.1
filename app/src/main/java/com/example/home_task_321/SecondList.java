package com.example.home_task_321;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URI;

public class SecondList extends AppCompatActivity {

    public final static String IMAGE_KEY = "Img";
    public static final int PICK_IMAGE = 1;
    private ImageView imageView;
    private Uri imageVie;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_list);
        init();
    }

    public void setClick() {
        Intent intent = getIntent();
            intent.putExtra("text", editText.getText().toString());
            intent.putExtra(IMAGE_KEY, imageVie);
            setResult(RESULT_OK, intent);
            finish();

    }

    public void init() {
        imageView = findViewById(R.id.image2);
        editText = findViewById(R.id.Edt1);
    }

    public void onClick(View view) {
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent, PICK_IMAGE);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case PICK_IMAGE:
                if (resultCode == RESULT_OK) {
                    try {
                        imageVie = data.getData();
                        final InputStream imageStream = getContentResolver().openInputStream(imageVie);
                        final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                        imageView.setImageBitmap(selectedImage);


                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
        }
    }

    public void setClick(View view) {

            Intent intent = getIntent();
            intent.putExtra("text", editText.getText().toString());
            intent.putExtra(IMAGE_KEY, imageVie);
            setResult(RESULT_OK, intent);
            finish();

        
    }
}

