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
public class PhotoAdapter extends RecyclerView.Adapter<PhotoViewHolder> {


    private List<Photo> photos;
    private Context context;

    public PhotoAdapter(Firebase photosRef, Context context) {
        this.context = context;
        photos = new ArrayList<>();
        photosRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Photo photo = dataSnapshot.getValue(Photo.class);
                photos.add(photo);
                notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                Photo photo = dataSnapshot.getValue(Photo.class);
                photos.remove(photo);
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
    public PhotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_photo, parent, false);
        return new PhotoViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(PhotoViewHolder holder, int position) {
        Photo image = photos.get(position);
        holder.bind(image);

    }

    @Override
    public int getItemCount() {
        return photos.size();
    }
}
