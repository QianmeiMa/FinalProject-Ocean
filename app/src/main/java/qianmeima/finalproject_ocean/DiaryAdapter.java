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
 * Created by Ailee on 2016/4/20.
 */
public class DiaryAdapter extends RecyclerView.Adapter<DiaryViewHolder> {

    private List<Diary> diaries;
    private Context context;

    public DiaryAdapter(Firebase diariesRef, Context context) {
        this.context = context;
        diaries = new ArrayList<>();
        diariesRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Diary diary = dataSnapshot.getValue(Diary.class);
                diaries.add(diary);
                notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                Diary diary = dataSnapshot.getValue(Diary.class);
                diaries.remove(diary);
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
    public DiaryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_diary, parent, false);
        return new DiaryViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(DiaryViewHolder holder, int position) {
        Diary person = diaries.get(position);
        holder.bind(person);

    }

    @Override
    public int getItemCount() {
        return diaries.size();
    }

}
