package qianmeima.finalproject_ocean;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;

/**
 * Created by Ailee on 2016/4/21.
 */
public class PhotoView extends AppCompatActivity {

    private Firebase rootRef;
    private Firebase userRef;
    private RecyclerView recyclerView;
    private PhotoAdapter photoAdapter;
    private Firebase.AuthStateListener authStateListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photo_view);


        Firebase.setAndroidContext(this);
        rootRef = new Firebase("https://finalproject-ocean.firebaseio.com/");

        authStateListener = new Firebase.AuthStateListener() {
            @Override
            public void onAuthStateChanged(AuthData authData) {
                if (authData != null) {
                    userRef = rootRef.child("users/" + authData.getUid());
                    photoAdapter = new PhotoAdapter(userRef.child("photos"), PhotoView.this);
                    recyclerView.setAdapter(photoAdapter);
                } else {
                    Intent intent = new Intent(PhotoView.this, LogInActivity.class);
                    startActivity(intent);
                }
            }
        };


        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_photo);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
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

        getMenuInflater().inflate(R.menu.second_menu, menu);
        return true;

    }
}
