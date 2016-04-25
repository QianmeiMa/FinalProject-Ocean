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

public class SecretActivity2 extends AppCompatActivity {

    private Firebase rootRef;
    private Firebase userRef;
    private Firebase.AuthStateListener authStateListener;
    private EditText stitleEditText;
    private EditText sarticleEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secret);

        stitleEditText = (EditText) findViewById(R.id.secretEditText);
        sarticleEditText = (EditText) findViewById(R.id.secretEditText_title);

        Firebase.setAndroidContext(this);
        rootRef = new Firebase("https://finalproject-ocean.firebaseio.com/");
        authStateListener = new Firebase.AuthStateListener() {
            @Override
            public void onAuthStateChanged(AuthData authData) {
                if (authData != null) {
                    userRef = rootRef.child("users/" + authData.getUid());

                } else {
                    Intent intent = new Intent(SecretActivity2.this, LogInActivity.class);
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
                Secret secret = new Secret(stitleEditText.getText().toString(), sarticleEditText.getText().toString());
                userRef.child("secret").push().setValue(secret);
                Toast.makeText(this, "Congratulations! Your secret is saved.", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(SecretActivity2.this, SecretView.class);
                startActivity(intent);

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
