package qianmeima.finalproject_ocean;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void writeButton(View view) {
        Intent intent = new Intent(MainActivity.this, WrittingPage.class);
        startActivity(intent);

    }

    public void diaryButton(View view) {
        Intent intent = new Intent(MainActivity.this, Diary.class);
        startActivity(intent);

    }

    public void inboxButton(View view) {
        Intent intent = new Intent(MainActivity.this, ReadingPage.class);
        startActivity(intent);

    }
}


