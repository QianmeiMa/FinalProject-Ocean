package qianmeima.finalproject_ocean;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;

/**
 * Created by Ailee on 2016/4/17.
 */
public class DiaryActivity extends AppCompatActivity {

    private Firebase rootRef;
    private Firebase userRef;
    private Firebase.AuthStateListener authStateListener;
    private EditText titleEditText;
    private EditText articleEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);

        titleEditText = (EditText) findViewById(R.id.diaryEditText);
        articleEditText = (EditText) findViewById(R.id.diaryEditText_title);

        Firebase.setAndroidContext(this);
        rootRef = new Firebase("https://finalproject-ocean.firebaseio.com/");
        authStateListener = new Firebase.AuthStateListener() {
            @Override
            public void onAuthStateChanged(AuthData authData) {
                if (authData != null) {
                    userRef = rootRef.child("users/" + authData.getUid());

                } else {
                    Intent intent = new Intent(DiaryActivity.this, LogInActivity.class);
                    startActivity(intent);
                }
            }
        };

    }


    @Override
    protected void onResume() {
        super.onResume();
        rootRef.addAuthStateListener(authStateListener);
    }


    @Override
    protected void onPause() {
        super.onPause();
        rootRef.removeAuthStateListener(authStateListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.diary_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_diary:
                Diary diary = new Diary(titleEditText.getText().toString(), articleEditText.getText().toString());
                userRef.child("diaries").push().setValue(diary);
                Toast.makeText(this, "Congratulations! Your diary is saved.", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(DiaryActivity.this, DiaryView.class);
                startActivity(intent);

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
