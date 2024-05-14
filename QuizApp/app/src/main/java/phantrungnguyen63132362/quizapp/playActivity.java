package phantrungnguyen63132362.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class    playActivity extends AppCompatActivity {
    String[] question_list = {"Kết quả của phép tính 23+17 là bao nhiêu?"
            ,"Kết quả của phép tính 58-24 là bao nhiêu?"
            ,"Kết quả của phép tính 76+29 là bao nhiêu?"
            ,"Kết quả của phép tính 90-45 là bao nhiêu?"
            ,"Kết quả của phép tính 33+22 là bao nhiêu?"
    };
    String[] choose_list = {"39","40","41","42",
            "32","34","36","38",
            "103","104","105","106",
            "40","43","45","50",
            "54","55","56","57"
    };
    String[] correct_list = {"40","34","105","45","55"};
    TextView cpt_question , text_question;
    Button btn_choose1 , btn_choose2 , btn_choose3 , btn_choose4 , btn_next;
    int currentQuestion =  0  ;
    boolean isclickBtn = false;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        cpt_question = findViewById(R.id.cpt_question);
        text_question = findViewById(R.id.text_question);

        btn_choose1 = findViewById(R.id.btn_choose1);
        btn_choose2 = findViewById(R.id.btn_choose2);
        btn_choose3 = findViewById(R.id.btn_choose3);
        btn_choose4 = findViewById(R.id.btn_choose4);
        btn_next = findViewById(R.id.btn_next);

        btn_next.setOnClickListener(
                v -> {
                    if (isclickBtn){

                    }
                }
        );
        remplirData();
    }
    void remplirData(){
        cpt_question.setText((currentQuestion+1) + "/" + question_list.length);
        text_question.setText(question_list[currentQuestion]);

        btn_choose1.setText(choose_list[4 * currentQuestion]);
        btn_choose2.setText(choose_list[4 * currentQuestion+1]);
        btn_choose3.setText(choose_list[4 * currentQuestion+2]);
        btn_choose4.setText(choose_list[4 * currentQuestion+3]);
    }

    public void ClickChoose(View view) {
        if (!isclickBtn){
            Button btn_click = (Button)view;
            btn_click.setBackgroundResource(R.drawable.background_btn_choose_color);
            isclickBtn = true;
        }

    }
}