package com.karepin.homework_027;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText editText;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Создаем и инициализируем
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                String string = editText.toString();
                char result = string.charAt(1);
                // Задаем начальные координаты
        if (Character.isLetter(result)) {
                Uri uri = Uri.parse("geo:" + editText.getText());
            // Передаем uri
            intent.setData(uri);
        } else {
            Uri uri = Uri.parse("geo:?q=" + editText.getText().toString());
            // Передаем uri
            intent.setData(uri);
        }

                // Запускаем приложения
                startActivity(intent);
            }
        });


    }
}
