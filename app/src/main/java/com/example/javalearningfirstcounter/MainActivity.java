package com.example.javalearningfirstcounter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textCount; //Поле вывода счетчика
    private Button button; //Кнопка счетчика
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Получаем активити
        textCount = findViewById(R.id.textCount);
        button = findViewById(R.id.button);

        //Выполняем действие при нажатии кнопки
        button.setOnClickListener(listener);

    }

    //Объект слушатеря нажатия кнопки
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            count++;
            textCount.setText(Integer.toString(count));

        }
    };

    // Вывод сообщения
    // Gravity.LEFT = 3
    // Gravity.RIGHT = 5
    // Gravity.TOP = 48
    // Gravity.BOTTOM = 80

    private void inToast(String text, int gravity){
        int gravity1 = Gravity.BOTTOM; //3
        Toast toast = Toast.makeText(this, "text", Toast.LENGTH_SHORT); //инициализация сообщения
        toast.setGravity(gravity, 0, 0); //задание позиции на экране
        toast.show(); //показ сообщения
    }

    @Override
    protected void onStart() {
        inToast("Старт активности", 0);
        super.onStart();
    }

    @Override
    protected void onStop() {
        inToast("Стоп активности", 3);
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        inToast("Уничтожение активности", 80);
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        inToast("Пауза активности", 48);
        super.onPause();
    }

    @Override
    protected void onResume() {
        inToast("Возобновление активности", 0);
        super.onResume();
    }
}