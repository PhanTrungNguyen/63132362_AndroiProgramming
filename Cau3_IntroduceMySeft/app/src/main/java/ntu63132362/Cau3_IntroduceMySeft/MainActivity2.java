package ntu63132362.Cau3_IntroduceMySeft;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {
    EditText username, password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        username = findViewById(R.id.edUserName);
        password = findViewById(R.id.edPassword);
        login = findViewById(R.id.Loginbtn);


    }
    public void loginHandle (View v){
        if (username.getText().toString().equals("root") && password.getText().toString().equals("123456")){
            Intent intent = new Intent(MainActivity2.this,MainActivity.class);
            startActivity(intent);
        }
    }
}