package qianmeima.finalproject_ocean;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Ailee on 2016/4/21.
 */
public class PhotoViewHolder extends RecyclerView.ViewHolder {

    private CardView cardView;
    private TextView photoTitleView;
    private ImageView photoInfoView;
    private Context context;

    public PhotoViewHolder(View itemView, Context context) {
        super(itemView);
        cardView = (CardView) itemView.findViewById(R.id.card_view_photo);
        photoTitleView = (TextView) itemView.findViewById(R.id.photo_title);
        photoInfoView = (ImageView) itemView.findViewById(R.id.photo_view);
        this.context = context;
    }

    public void bind(Photo photo) {
        photoTitleView.setText(photo.Ptitle);
        //photoInfoView.set(photo.Pfile);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, photoTitleView.getText(), Toast.LENGTH_SHORT).show();
            }


        });
    }
}

