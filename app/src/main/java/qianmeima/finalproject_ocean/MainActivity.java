package qianmeima.finalproject_ocean;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;

public class MainActivity extends AppCompatActivity {

    private Firebase rootRef;
    private Firebase userRef;
    private Firebase.AuthStateListener authStateListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Firebase.setAndroidContext(this);
//        Firebase myFirebaseRef = new Firebase("https://finalproject-ocean.firebaseio.com/");


        rootRef = new Firebase("https://finalproject-ocean.firebaseio.com/");
        authStateListener = new Firebase.AuthStateListener() {
            @Override
            public void onAuthStateChanged(AuthData authData) {
                if (authData != null) {
                    Log.d("authdata", authData.toString());
                    userRef = rootRef.child("users/" + authData.getUid());
                } else {
                    Intent intent = new Intent(MainActivity.this, LogInActivity.class);
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


    public void diaryButton(View view) {
        Intent intent = new Intent(MainActivity.this, DiaryActivity.class);
        startActivity(intent);
    }

    public void photoButton(View view) {

        Intent intent = new Intent(MainActivity.this, PhotoActivity.class);
        startActivity(intent);
    }

//    public void planButton(View view) {
//        Intent intent = new Intent(MainActivity.this, PlanActivity.class);
//        startActivity(intent);
//    }

//    public void secretButton(View view) {
//        Intent intent = new Intent(MainActivity.this, SecretActivity.class);
//        startActivity(intent);
//    }

    public void secretButton(View view) {
        Intent intent = new Intent(MainActivity.this, SecretActivity.class);
        startActivity(intent);
    }


//    public void mailButton(View view) {
//        Intent intent = new Intent(MainActivity.this, MailActivity.class);
//        startActivity(intent);
//    }
//
//    public void findButton(View view) {
//        Intent intent = new Intent(MainActivity.this, FindActivity.class);
//        startActivity(intent);
//    }
//
//    public void friendButton(View view) {
//        Intent intent = new Intent(MainActivity.this, FriendActivity.class);
//        startActivity(intent);
//    }

}


