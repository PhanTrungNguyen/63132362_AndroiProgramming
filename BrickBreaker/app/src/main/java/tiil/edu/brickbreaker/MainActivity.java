package tiil.edu.brickbreaker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.core.view.DragAndDropPermissionsCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.TextView;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements SurfaceHolder.Callback {
    private final List<SneakPoints> sneakPointsList = new ArrayList<>();
    private SurfaceView surfaceView;
    private TextView scoreTV;
    private SurfaceHolder surfaceHolder;

    private String movingPosition = "right";

    private int score =0;
    private static final int pointSize = 28;
    private static final int defaultTalePoints = 3;
    private static final int snakeColor = Color.YELLOW;
    private static final int snakeMovingSpeed = 800;
    private int positionX, positionY;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        surfaceView  = findViewById(R.id.surfaceView);
        scoreTV = findViewById(R.id.scoreTV);

        final AppCompatImageButton topButton = findViewById(R.id.topButton);
        final AppCompatImageButton leftButton = findViewById(R.id.leftButton);
        final AppCompatImageButton rightButton = findViewById(R.id.rightButton);
        final AppCompatImageButton bottonButton = findViewById(R.id.bottomButton);

        surfaceView.getHolder().addCallback(this);

        topButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
        bottonButton.setOnClickListener(new View.OnClickListener() {
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
        sneakPointsList.clear();
        scoreTV.setText("0");
        score =0;
        movingPosition = "right";
        int starPositionX = (pointSize) * defaultTalePoints;
        for(int i = 0; i < defaultTalePoints; i++){
            SneakPoints sneakPoints = new SneakPoints(starPositionX, pointSize);
            sneakPointsList.add(sneakPoints);

            starPositionX = starPositionX - (pointSize * 2);

        }
        addPoint();
        movesnake();
    }
    private void addPoint(){
        int surfaceWidth = surfaceView.getWidth() - (pointSize * 2);
        int surfaceHeight = surfaceView.getHeight() - (pointSize * 2);
        int randomXPosition = new Random().nextInt(surfaceWidth / pointSize);
        int randomYPosition = new Random().nextInt(surfaceHeight / pointSize);
        if (randomXPosition % 2 != 0){
            randomXPosition = randomXPosition +1;
        }
        if (randomYPosition % 2 != 0){
            randomYPosition = randomYPosition +1;
        }
        positionX = (pointSize * randomXPosition) + pointSize;
        positionY = (pointSize * randomYPosition) + pointSize;

    }
    private void movesnake(){

    }
}