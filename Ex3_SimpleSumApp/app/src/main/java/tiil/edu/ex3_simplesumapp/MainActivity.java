package tiil.edu.ex3_simplesumapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void handleCong(View view) {
        EditText txtA = findViewById(R.id.nguyen5);
        EditText txtB = findViewById(R.id.nguyen1);
        EditText txtResult = findViewById(R.id.nguyen6);
        txtResult.setText(String.valueOf(Integer.parseInt(txtA.getText().toString()) + Integer.parseInt(txtB.getText().toString())));
    }
}
