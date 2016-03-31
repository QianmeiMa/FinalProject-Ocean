package qianmeima.finalproject_ocean;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;

public class MainActivity extends AppCompatActivity {
    private Firebase rootRef;
    private Firebase userRef;
    private Firebase.AuthStateListener authStateListener;

    private EditText keyEditText;
    private EditText valueEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        keyEditText = (EditText) findViewById(R.id.edit_text_key);
        valueEditText = (EditText) findViewById(R.id.edit_text_value);

        Firebase.setAndroidContext(this);
        rootRef = new Firebase("https://useraccount-yijunl.firebaseio.com/");
        authStateListener = new Firebase.AuthStateListener() {
            @Override
            public void onAuthStateChanged(AuthData authData) {
                if (authData != null) {
                    userRef = rootRef.child("users/" + authData.getUid());
                } else {
                    Intent intent = new Intent(MainActivity.this, LogIn.class);
                    startActivity(intent);
                }
            }
        };
    }

    //    public void writeToCloud(View view) {
//        if (userRef != null)
//            userRef.child(keyEditText.getText().toString()).setValue(valueEditText.getText().toString());
//    }
//    public void readFromCloud(View view) {
//        if (userRef == null) return;
//        userRef.child(keyEditText.getText().toString()).addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot snapshot) {
//                if (snapshot.getValue() != null) {
//                    valueEditText.setText(snapshot.getValue().toString());
//                } else {
//                    valueEditText.setText("");
//                    Toast.makeText(MainActivity.this, "key not found:" + keyEditText.getText(), Toast.LENGTH_SHORT).show();
//                }
//            }
//            @Override
//            public void onCancelled(FirebaseError error) {
//                Toast.makeText(MainActivity.this, "Error:" + error.toString(), Toast.LENGTH_SHORT).show();
//            }
//
//        });
    //}
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
        getMenuInflater().inflate(R.menu.second_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Log_out:
                keyEditText.setText("");
                valueEditText.setText("");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}


