package ntu63132362.cau1_Ransanmoi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;

import android.graphics.Color;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SurfaceHolder.Callback {

    private final List<SnakesPoints> snakesPoints = new ArrayList<>();

    private SurfaceView surfaceView;
    private TextView scoreTV;
    //hàm vẽ giao diện cho rắn
    private SurfaceHolder surfaceHolder;
    //hướng di chuyển mặc định của rắn
    private String movingPosition = "right";
    //hàm điểm
    private int score = 0;
    //kích thước của rắn
    private static final int pointSize = 28;
    //kích thước mặc định của rắn
    private static final int defaultTalePoints = 3;
    //Set màu cho rắn
    private static final int snakeColor = Color.YELLOW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        surfaceView = findViewById(R.id.surfaceView);
        scoreTV = findViewById(R.id.scoreTV);

        final AppCompatImageButton topButton = findViewById(R.id.topButton);
        final AppCompatImageButton leftButton = findViewById(R.id.leftButton);
        final AppCompatImageButton rightButton = findViewById(R.id.rightButton);
        final AppCompatImageButton bottomButton = findViewById(R.id.bottomButton);

        surfaceView.getHolder().addCallback(this);
        topButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Kiểm tra nếu rắn đang hướng xuống thì không thẻ đi thẳng lên chỉ có thể đi sang trái hoặc phải
                if (!movingPosition.equals("bottom")){
                    movingPosition = "top";
                }
            }
        });
        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!movingPosition.equals("right")){
                    movingPosition = "left";
                }
            }
        });
        rightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!movingPosition.equals("left")){
                    movingPosition = "right";
                }
            }
        });
        bottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!movingPosition.equals("top")){
                    movingPosition = "bottom";
                }
            }
        });



    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder holder) {
        this.surfaceHolder = surfaceHolder;

        init();
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {

    }
    private void init(){
        //Xóa rắn
        snakesPoints.clear();
        //Đặt lại điểm
        scoreTV.setText("0");
        //Điểm = 0
        score = 0;
        //Hướng mặc định là bên phải
        movingPosition = "right";
        int starPositionX =

    }
}