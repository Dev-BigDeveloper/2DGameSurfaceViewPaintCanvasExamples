//package com.example.myapplication.threadText;
//
//import android.annotation.SuppressLint;
//import android.content.Context;
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//import android.graphics.Canvas;
//import android.graphics.Color;
//import android.graphics.Paint;
//import android.os.Bundle;
//import android.view.MotionEvent;
//import android.view.SurfaceHolder;
//import android.view.SurfaceView;
//import android.view.View;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.appcompat.widget.AppCompatImageButton;
//
//import com.example.myapplication.Asteroid;
//import com.example.myapplication.MainActivity2;
//import com.example.myapplication.R;
//import com.example.myapplication.Ship;
//import com.example.myapplication.databinding.ActivityMain2Binding;
//
//import java.util.ArrayList;
//
//public class MainAct2CodingCash {
//    package com.example.myapplication;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.appcompat.widget.AppCompatImageButton;
//import android.annotation.SuppressLint;
//import android.content.Context;
//import android.graphics.Bitmap;
//import android.graphics.BitmapFactory;
//import android.graphics.Canvas;
//import android.graphics.Color;
//import android.graphics.Paint;
//import android.os.Bundle;
//import android.view.MotionEvent;
//import android.view.SurfaceHolder;
//import android.view.SurfaceView;
//import android.view.View;
//
//import com.example.myapplication.databinding.ActivityMain2Binding;
//
//import java.util.ArrayList;
//
//    public class MainActivity2 extends AppCompatActivity implements View.OnTouchListener {
//
//        private ActivityMain2Binding binding;
//
//        private boolean isLeftPressed = false;
//        private boolean isRightPressed = false;
//        private boolean isTopPressed = false;
//        private boolean isBottomPressed = false;
//
//        @SuppressLint("ClickableViewAccessibility")
//        @Override
//        protected void onCreate(Bundle savedInstanceState) {
//            super.onCreate(savedInstanceState);
//            binding = ActivityMain2Binding.inflate(getLayoutInflater());
//            setContentView(binding.getRoot());
//
//            AppCompatImageButton buttonTop = findViewById(R.id.topBtn);
//            AppCompatImageButton buttonBottom = findViewById(R.id.bottomBtn);
//            AppCompatImageButton buttonRight = findViewById(R.id.rightBtn);
//            AppCompatImageButton buttonLeft = findViewById(R.id.leftBtn);
//
//            buttonTop.setOnTouchListener(this);
//            buttonBottom.setOnTouchListener(this);
//            buttonRight.setOnTouchListener(this);
//            buttonLeft.setOnTouchListener(this);
//
//        }
//
//        @SuppressLint({"NonConstantResourceId", "ClickableViewAccessibility"})
//        @Override
//        public boolean onTouch(View button, MotionEvent motion) {
//            switch (button.getId()) {
//                case R.id.leftBtn:
//                    switch (motion.getAction()) { // определяем нажата или отпущена
//                        case MotionEvent.ACTION_DOWN:
//                            isLeftPressed = true;
//                            break;
//                        case MotionEvent.ACTION_UP:
//                            isLeftPressed = false;
//                            break;
//                    }
//                    break;
//                case R.id.rightBtn:
//                    switch (motion.getAction()) {
//                        case MotionEvent.ACTION_DOWN:
//                            isRightPressed = true;
//                            break;
//                        case MotionEvent.ACTION_UP:
//                            isRightPressed = false;
//                            break;
//                    }
//                    break;
//                case R.id.topBtn:
//                    switch (motion.getAction()) {
//                        case MotionEvent.ACTION_DOWN:
//                            isTopPressed = true;
//                            break;
//                        case MotionEvent.ACTION_UP:
//                            isTopPressed = false;
//                            break;
//                    }
//                    break;
//                case R.id.bottomBtn:
//                    switch (motion.getAction()) {
//                        case MotionEvent.ACTION_DOWN:
//                            isBottomPressed = true;
//                            break;
//                        case MotionEvent.ACTION_UP:
//                            isBottomPressed = false;
//                            break;
//                    }
//                    break;
//            }
//            return true;
//        }
//
//        @Override
//        public void onPointerCaptureChanged(boolean hasCapture) {
//            super.onPointerCaptureChanged(hasCapture);
//
//        }
//
//        static class SpaceBody {
//
//            protected float x; // координаты
//            protected float y;
//            protected float size; // размер
//            protected float speed; // скорость
//            protected int bitmapId; // id картинки
//            protected Bitmap bitmap; // картинка
//
//            void init(Context context) { // сжимаем картинку до нужных размеров
//                Bitmap cBitmap = BitmapFactory.decodeResource(context.getResources(), bitmapId);
//                bitmap = Bitmap.createScaledBitmap(
//                        cBitmap, (int)(size * com.example.myapplication.MainActivity2.GameView.unitW), (int)(size * com.example.myapplication.MainActivity2.GameView.unitH), false);
//                cBitmap.recycle();
//            }
//
//            void update(){ // тут будут вычисляться новые координаты
//
//            }
//
//            void drow(Paint paint, Canvas canvas){ // рисуем картинку
//                canvas.drawBitmap(bitmap, x* com.example.myapplication.MainActivity2.GameView.unitW, y* com.example.myapplication.MainActivity2.GameView.unitH, paint);
//            }
//        }
//
//        static class RunObject implements Runnable {
//            @Override
//            public void run() {
//
//            }
//        }
//
//        static class GameView extends SurfaceView implements Runnable {
//
//            public static int maxX = 20; // размер по горизонтали
//            public static int maxY = 28; // размер по вертикали
//            public static float unitW = 0; // пикселей в юните по горизонтали
//            public static float unitH = 0; // пикселей в юните по вертикали
//            private boolean firstTime = true;
//            private boolean gameRunning = true;
//            private Ship ship;
//            final private Thread gameThread;
//            final private Paint paint;
//            private Canvas canvas;
//            final private SurfaceHolder surfaceHolder;
//
//            public GameView(Context context) {
//                // surfaceView va Paint larni konstruktorda initsializatsiya qilish yaxshi praktika v ko`pchilik shunday qiladi
//                super(context);
//                //инициализируем обьекты для рисования
//                surfaceHolder = getHolder();
//                paint = new Paint();
//                // инициализируем поток
//                gameThread = new Thread(this);
//                gameThread.start();
//            }
//
//            private final ArrayList<Asteroid> asteroids = new ArrayList<>(); // тут будут харанится астероиды
//            private final int ASTEROID_INTERVAL = 50; // время через которое появляются астероиды (в итерациях)
//            private int currentTime = 0;
//
//            @Override
//            public void run() {
//                while (gameRunning) {
//                    update();
//                    draw();
//                    checkCollision();
//                    checkIfNewAsteroid();
//                    control();
//                }
//            }
//
//            private void update() {
//
//                if(!firstTime) {
//                    ship.update();
//                    for (Asteroid asteroid : asteroids) {
//                        asteroid.update();
//                    }
//                }
//            }
//
//            private void draw() {
//                if (surfaceHolder.getSurface().isValid()) {  //проверяем валидный ли surface
//
//                    if(firstTime){ // инициализация при первом запуске
//                        firstTime = false;
//                        unitW = surfaceHolder.getSurfaceFrame().width()/maxX; // вычисляем число пикселей в юните
//                        unitH = surfaceHolder.getSurfaceFrame().height()/maxY;
//
//                        ship = new Ship(getContext()); // добавляем корабль
//                    }
//
//                    canvas = surfaceHolder.lockCanvas(); // закрываем canvas
//                    canvas.drawColor(Color.BLACK); // заполняем фон чёрным
//
//                    ship.drow(paint, canvas); // рисуем корабль
//
//                    for(Asteroid asteroid: asteroids){ // рисуем астероиды
//                        asteroid.drow(paint, canvas);
//                    }
//
//                    surfaceHolder.unlockCanvasAndPost(canvas); // открываем canvas
//                }
//            }
//
//            private void control() { // пауза на 17 миллисекунд
//                try {
//                    gameThread.sleep(17);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            private void checkCollision(){ // перебираем все астероиды и проверяем не касается ли один из них корабля
//                for (Asteroid asteroid : asteroids) {
//                    if(asteroid.isCollision(ship.x, ship.y, ship.size)){
//                        // игрок проиграл
//                        gameRunning = false; // останавливаем игру
//                        // TODO добавить анимацию взрыва
//                    }
//                }
//            }
//
//            private void checkIfNewAsteroid(){ // каждые 50 итераций добавляем новый астероид
//                if(currentTime >= ASTEROID_INTERVAL){
//                    Asteroid asteroid = new Asteroid(getContext());
//                    asteroids.add(asteroid);
//                    currentTime = 0;
//                }else{
//                    currentTime ++;
//                }
//            }
//        }
//
//
//    }
//}
