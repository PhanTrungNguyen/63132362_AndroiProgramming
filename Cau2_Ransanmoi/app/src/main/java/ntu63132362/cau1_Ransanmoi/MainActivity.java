package ntu63132362.cau1_Ransanmoi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;

import android.content.DialogInterface;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements SurfaceHolder.Callback {

    private final List<SnakesPoints> snakesPointsList = new ArrayList<>();

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
    //Set tốc độ cho rắn
    private static final int snakeMovingSpeed = 800;
    //Tọa độ random của điểm
    private Timer timer;
    //Canvas để vẽ rắn lên màn hình
    private Canvas canvas = null;
    private int positionX, positionY;
    //timer chuyển hướng di chuyển cho rắn
    private Paint pointColor = null;

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
        snakesPointsList.clear();
        //Đặt lại điểm
        scoreTV.setText("0");
        //Điểm = 0
        score = 0;
        //Hướng mặc định là bên phải
        movingPosition = "right";
        //Hướng mặc định của rắn trên màn hình
        int startPositionX = (pointSize) * defaultTalePoints;


        for (int i = 0; i < defaultTalePoints; i++){
            //Thêm độ dài cho rắn khi cộng điểm
            SnakesPoints snakesPoints = new SnakesPoints(startPositionX, pointSize);
            snakesPointsList.add(snakesPoints);

            startPositionX = startPositionX - (pointSize * 2);

        }

        //Tạo điểm random trên màn hình
        addPoint();
        moveSnake();
    }
    private void addPoint(){
        //
        int surfaceWidth = surfaceView.getWidth() - (pointSize * 2);
        int surfaceHeight = surfaceView.getHeight() - (pointSize * 2);
        int randomXPosition = new Random().nextInt(surfaceWidth / pointSize);
        int randomYPosition = new Random().nextInt(surfaceHeight / pointSize);

        if (randomXPosition % 2 != 0 ) randomXPosition = randomXPosition + 1;
        if (randomYPosition % 2 != 0 ) randomYPosition = randomYPosition + 1;
        positionX = (pointSize * randomXPosition) + pointSize;
        positionY = (pointSize * randomYPosition) + pointSize;
    }
    private void moveSnake(){
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                int headPositionX = snakesPointsList.get(0).getPositionX();
                int headPositionY = snakesPointsList.get(0).getPositionY();
                //kiểm tra rắn đã ăn điểm chưa
                if(headPositionX == positionX && positionY == headPositionY){
                    //nếu ăn rồi thì rắn dài ra
                    growSnake();
                    //tạo một điểm ngẫu nhiên khác trên màn hình
                    addPoint();
                }
                //kiểm tra hướng di chuyển của rắn
                switch (movingPosition){
                    case "right":
                        //khi đầu rắn di chuyển về hướng nào thì phần thân di chuyển theo
                        snakesPointsList.get(0).setPositionX(headPositionX + (pointSize *2));
                        snakesPointsList.get(0).setPositionY(headPositionY);
                        break;
                    case "left":
                        snakesPointsList.get(0).setPositionX(headPositionX - (pointSize *2));
                        snakesPointsList.get(0).setPositionY(headPositionY);
                        break;
                    case "top":
                        snakesPointsList.get(0).setPositionX(headPositionX);
                        snakesPointsList.get(0).setPositionY(headPositionY + (pointSize *2));
                        break;
                    case "bottom":
                        snakesPointsList.get(0).setPositionX(headPositionX );
                        snakesPointsList.get(0).setPositionY(headPositionY + (pointSize *2));
                        break;

                }
                //kiểm tra va chạm của rắn
                if (checkGameOver(headPositionX, headPositionY)){
                    //dừng timer, dừng di chuyển của rắn khi game kết thúc
                    timer.purge();
                    timer.cancel();
                    //hiển thị thông báo game over
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("Score: "+score);
                    builder.setTitle("Game Over");
                    builder.setCancelable(false);
                    builder.setPositiveButton("Play Again", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            init();
                        }
                    });
                    //timer của background
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            builder.show();
                        }
                    });
                }

                else {
                    canvas = surfaceHolder.lockCanvas();
                    canvas.drawColor(Color.WHITE, PorterDuff.Mode.CLEAR);
                    //chuyển hướng đầu rắn thì phần thân vẫn đi theo
                    canvas.drawCircle(snakesPointsList.get(0).getPositionX(), snakesPointsList.get(0).getPositionY(), pointSize,  cratePointColor() );
                    //vẽ điểm ngẫu nhiên để rắn ăn
                    canvas.drawCircle(positionX, positionY, pointSize, cratePointColor());
                    //các điểm đã ăn sẽ đi theo đầu của rắn
                    for (int i = 1; i < snakesPointsList.size(); i++){
                        int getTempPositionX = snakesPointsList.get(i).getPositionX();
                        int getTempPositionY = snakesPointsList.get(i).getPositionY();

                        snakesPointsList.get(i).getPositionX(headPositionX);
                        snakesPointsList.get(i).getPositionY(headPositionY);
                        canvas.drawCircle(snakesPointsList.get(i).getPositionX(),snakesPointsList.get(i).getPositionY(),pointSize, cratePointColor());
                        headPositionX = getTempPositionX;
                        headPositionY = getTempPositionY;
                    }

                }
            }
        }, 1000-snakeMovingSpeed, 1000- snakeMovingSpeed);
    }

    //Hàm làm rắn dài ra
    private void growSnake(){

    }
    private boolean checkGameOver(int headPositionX, int PositionY){
        boolean gameOver = false;
        return gameOver;
    }
    private Paint cratePointColor(){
        //check màu rắn
        if (pointColor == null){
            pointColor = new Paint();
            pointColor.setColor(snakeColor);
            pointColor.setStyle(Paint.Style.FILL);
            //Làm mượt rắn
            pointColor.setAntiAlias(true);
        }

        return pointColor;
    }
}