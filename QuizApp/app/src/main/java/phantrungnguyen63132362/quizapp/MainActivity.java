package phantrungnguyen63132362.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void main_btn(View view) {
        startActivity(new Intent(MainActivity.this, playActivity.class));
    }

    public void open_Settings(View view) {
        startActivity(new Intent(MainActivity.this, settingActivity.class));
    }

    public void exit_App(View view) {
        this.finishAffinity();
    }
}