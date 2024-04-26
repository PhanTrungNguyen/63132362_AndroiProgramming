package phantrungnguyen.pt63132362;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    TextView pass, username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        pass = findViewById(R.id.edtPass);
        username = findViewById(R.id.edtUserName);
    }

    public String checkLogin() {
        String error = "";
        if (!username.getText().toString().equals("phantrungnguyen")) {
            error += "Tên người dùng không đúng \n";
        }
        if (!pass.getText().toString().equals("123456")) {
            error += "Mật khẩu không đúng";
        }
        return error;
    }

    public void login(View v) {
        String errorMessage = checkLogin();
        if (!errorMessage.isEmpty()) {
            Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
        } else {
            Intent iQuiz = new Intent(this, HomeActivity.class);
            iQuiz.putExtra("USERNAME", username.getText().toString());
            startActivity(iQuiz);
        }
    }
}
