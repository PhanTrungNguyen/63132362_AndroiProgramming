package phantrungnguyen63132362.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class    playActivity extends AppCompatActivity {
    String[] question_list = {"Cau1","Cau2","Cau3","Cau4"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
    }
}