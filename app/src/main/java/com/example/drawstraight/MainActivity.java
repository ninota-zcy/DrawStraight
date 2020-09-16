package com.example.drawstraight;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;


public class MainActivity extends AppCompatActivity {
    private ImageView iv;
    private Bitmap baseBitmap;
    private Canvas canvas;
    private Paint paint;

    private int mov_x;//声明起点坐标，画直线
    private int mov_y;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.iv = this.findViewById(R.id.iv);

        baseBitmap = Bitmap.createBitmap(1200, 1800, Bitmap.Config.ARGB_8888);

        canvas = new Canvas(baseBitmap);

        canvas.drawColor(Color.GRAY);

        paint = new Paint();

        paint.setColor(Color.RED);

        paint.setStrokeWidth(5);

        canvas.drawBitmap(baseBitmap, new Matrix(), paint);
        iv.setImageBitmap(baseBitmap);

        iv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    mov_x = (int) event.getX();
                    mov_y = (int) event.getY();
                }
                if(event.getAction() == MotionEvent.ACTION_UP){
                    int stopx = (int)event.getX();
                    int stopy = (int)event.getY();
                    canvas.drawLine(mov_x,mov_y,stopx,stopy,paint);
                    iv.invalidate();
                }
                return true;
            }


//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                if (event.getAction() == MotionEvent.ACTION_MOVE) {//如果拖动
//                    canvas.drawLine(mov_x, mov_y, event.getX(), event.getY(), paint);//画线
//                    iv.invalidate();
//                }
//                if (event.getAction() == MotionEvent.ACTION_DOWN) {//如果点击
//                    mov_x = (int) event.getX();
//                    mov_y = (int) event.getY();
//                    canvas.drawPoint(mov_x, mov_y, paint);//画点
//                    iv.invalidate();
//
//                }
//                mov_x = (int) event.getX();
//                mov_y = (int) event.getY();
//                return true;
//            }



//            int startX;
//            int startY;
//
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                switch (event.getAction()){
//                    case MotionEvent.ACTION_DOWN:
//                        startX = (int)event.getX();
//                        startY = (int)event.getY();
//                        break;
//                    case MotionEvent.ACTION_MOVE:
//                        int stopX  = (int)event.getX();
//                        int stopY = (int)event.getY();
//
//                        canvas.drawLine(startX,startY,stopX,stopY,paint);
//
//                        startX = (int)event.getX();
//                        startY = (int)event.getY();
//                        iv.setImageBitmap(baseBitmap);
//                        break;
//
//                }
//                return true;
//            }
//        });


//    @SuppressLint("WrongConstant")
//    public void save(View view) {
//        try {
//            File file = new File(Environment.getExternalStorageDirectory(),
//                    System.currentTimeMillis() + ".jpg");
//            OutputStream stream = new FileOutputStream(file);
//            baseBitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
//            stream.close();
//            // 模拟一个广播，通知系统sdcard被挂载
//            Intent intent = new Intent();
//            intent.setAction(Intent.ACTION_MEDIA_MOUNTED);
//            intent.setData(Uri.fromFile(Environment
//                    .getExternalStorageDirectory()));
//            sendBroadcast(intent);
//
//            Toast.makeText(this, "保存图片成功", Toast.LENGTH_LONG).show();
//        } catch (Exception e) {
//            Toast.makeText(this, "保存图片失败", Toast.LENGTH_LONG).show();
//            e.printStackTrace();
//        }
//}

        });
    }
}