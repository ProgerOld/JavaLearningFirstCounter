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

    static final String  STATE_COUNT = null; //Ключ состояния

    private String TAG = "Жизненный цикл";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inToast("0 - Создание активности");
        Log.i(TAG, "onCreate()");//В Logcat

        //Получаем активити
        textCount = findViewById(R.id.textCount);
        button = findViewById(R.id.button);

        //Выполняем действие при нажатии кнопки
        button.setOnClickListener(listener);

        //Восстанавливаем состояние
        String text = "";
        if (savedInstanceState != null && savedInstanceState.containsKey(STATE_COUNT))
            count = savedInstanceState.getInt(STATE_COUNT);
        textCount.setText(Integer.toString(count));

        Log.i(TAG, Integer.toString(count)); //В Logcat
    }

    // Вызывается в начале "видимого" состояния.
    @Override
    protected void onStart() {
        super.onStart();
        // Примените к UI все необходимые изменения, так как
        // Активность теперь видна на экране.
        inToast("1 - Старт активности");
        Log.i(TAG, "onStart()");//В Logcat
    }

    // Вызывается в начале "активного" состояния.
    @Override
    protected void onResume() {
        super.onResume();
        // Возобновите все приостановленные обновления UI,
        // потоки или процессы, которые были "заморожены",
        // когда данный объект был неактивным.

        inToast("2 - Возобновление активности");
        Log.i(TAG, "onResume()");//В Logcat
    }

    // Вызывается перед выходом из "активного" состояния
    @Override
    protected void onPause() {
        // "Замораживает" пользовательский интерфейс, потоки
        // или трудоемкие процессы, которые могут не обновляться,
        // пока Активность не находится на переднем плане.
        super.onPause();
        inToast("3 - Пауза активности");
        Log.i(TAG, "onPause()");//В Logcat
    }

    // Вызывается перед тем, как Активность перестает быть "видимой".
    @Override
    protected void onStop() {
        // "Замораживает" пользовательский интерфейс, потоки
        // или операции, которые могут подождать, пока Активность
        // не отображается на экране. Сохраняйте все введенные
        // данные и изменения в UI так, как будто после вызова
        // этого метода процесс должен быть закрыт.
        super.onStop();
        inToast("4 - Стоп активности");
        Log.i(TAG, "onStop()");//В Logcat
    }

    // Вызывается перед выходом из "полноценного" состояния.
    @Override
    protected void onDestroy() {
        // Очистите все ресурсы. Это касается завершения работы
        // потоков, закрытия соединений с базой данных и т. д.
        super.onDestroy();
        inToast("5 - Уничтожение активности");
        Log.i(TAG, "onDestroy()");//В Logcat
    }

    // Вызывается перед тем, как Активность становится "видимой".
    @Override
    protected void onRestart() {
        super.onRestart();
        // Загрузите изменения, учитывая то, что Активность
        // уже стала "видимой" в рамках данного процесса.

        inToast("6 - Рестарт активности");
        Log.i(TAG, "onRestart()");//В Logcat
    }

    // Вызывается для того, чтобы сохранить пользовательский интерфейс
    // перед выходом из "активного" состояния.
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        // Сохраните состояние UI в переменную outState.
        // Она будет передана в метод onCreate при закрытии и
        // повторном запуске процесса.

        inToast("7 - Сохранение активности");
        Log.i(TAG, "onSaveInstanceState()");//В Logcat

        outState.putInt(STATE_COUNT, count); // Сохраняем состояние счетчика

        super.onSaveInstanceState(outState);

    }

    // Вызывается, когда метод onCreate завершил свою работу,
    // и используется для восстановления состояния пользовательского
    // интерфейса
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // Восстановите состояние UI из переменной savedInstanceState.
        // Этот объект типа Bundle также был передан в метод onCreate.

        inToast("8 - Востановление активности");
        Log.i(TAG, "onRestoreInstanceState()");//В Logcat
    }


    // Вывод сообщения
    private void inToast(String text){
        Toast toast = Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT); //инициализация сообщения
        toast.show(); //показ сообщения
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