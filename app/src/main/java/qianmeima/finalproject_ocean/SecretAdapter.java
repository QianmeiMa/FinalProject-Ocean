package qianmeima.finalproject_ocean;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ailee on 2016/4/21.
 */
public class SecretAdapter extends RecyclerView.Adapter<SecretViewHolder> {

    private List<Secret> secrets;
    private Context context;

    public SecretAdapter(Firebase secretsRef, Context context) {
        this.context = context;
        secrets = new ArrayList<>();
        secretsRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Secret secret = dataSnapshot.getValue(Secret.class);
                secrets.add(secret);
                notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                Secret secret = dataSnapshot.getValue(Secret.class);
                secrets.remove(secret);
                notifyDataSetChanged();

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }

    @Override
    public SecretViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_secret, parent, false);
        return new SecretViewHolder(view, context);
    }


    @Override
    public void onBindViewHolder(SecretViewHolder holder, int position) {
        Secret essay = secrets.get(position);
        holder.bind(essay);

    }

    @Override
    public int getItemCount() {
        return secrets.size();
    }
}
