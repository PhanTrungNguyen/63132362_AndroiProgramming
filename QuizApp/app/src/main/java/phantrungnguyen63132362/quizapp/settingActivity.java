package phantrungnguyen63132362.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


public class settingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        findViewById(R.id.image_back).setOnClickListener(
                a-> finish()
        );
    }

}