package qianmeima.finalproject_ocean;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Ailee on 2016/4/20.
 */
public class DiaryViewHolder extends RecyclerView.ViewHolder {

    private CardView cardView;
    private TextView diaryTitleView;
    private TextView diaryInfoView;
    private Context context;

    public DiaryViewHolder(View itemView, Context context) {
        super(itemView);
        cardView = (CardView) itemView.findViewById(R.id.card_view_diary);
        diaryTitleView = (TextView) itemView.findViewById(R.id.diary_title);
        diaryInfoView = (TextView) itemView.findViewById(R.id.diary_info);
        this.context = context;
    }

    public void bind(Diary diary) {
        diaryTitleView.setText(diary.title);
        diaryInfoView.setText(diary.article);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, diaryTitleView.getText(), Toast.LENGTH_SHORT).show();
            }


        });
    }
}
