package com.example.javalearningfirstcounter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textCount; //Поле вывода счетчика
    private Button button; //Кнопка счетчика
    private int count = 0;
    private String TAG = "Жизненный цикл";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inToast("0 - Создание активности");
        Log.i(TAG, "onCreate()");

        //Получаем активити
        textCount = findViewById(R.id.textCount);
        button = findViewById(R.id.button);

        //Выполняем действие при нажатии кнопки
        button.setOnClickListener(listener);

    }


    // Вывод сообщения
    private void inToast(String text){
        Toast toast = Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT); //инициализация сообщения
        toast.show(); //показ сообщения
    }


    @Override
    protected void onStart() {
        super.onStart();

        inToast("1 - Старт активности");
        Log.i(TAG, "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        inToast("2 - Возобновление активности");
        Log.i(TAG, "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        inToast("3 - Пауза активности");
        Log.i(TAG, "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        inToast("4 - Стоп активности");
        Log.i(TAG, "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        inToast("5 - Уничтожение активности");
        Log.i(TAG, "onDestroy()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        inToast("6 - Рестарт активности");
        Log.i(TAG, "onRestart()");
    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        inToast("7 - Сохранение активности");
        super.onSaveInstanceState(outState);

        //outState.putInt();
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        inToast("8 - Востановление активности");
        super.onRestoreInstanceState(savedInstanceState);
    }


    //Объект слушатеря нажатия кнопки
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            count++;
            textCount.setText(Integer.toString(count));

        }
    };

}