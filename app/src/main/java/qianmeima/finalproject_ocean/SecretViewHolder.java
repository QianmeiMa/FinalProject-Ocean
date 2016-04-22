package qianmeima.finalproject_ocean;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Ailee on 2016/4/21.
 */
public class SecretViewHolder extends RecyclerView.ViewHolder {


    private CardView cardView;
    private TextView secretTitleView;
    private TextView secretInfoView;
    private Context context;

    public SecretViewHolder(View itemView, Context context) {
        super(itemView);
        cardView = (CardView) itemView.findViewById(R.id.card_view_secret);
        secretTitleView = (TextView) itemView.findViewById(R.id.secret_title);
        secretInfoView = (TextView) itemView.findViewById(R.id.secret_info);
        this.context = context;
    }

    public void bind(Secret secret) {
        secretTitleView.setText(secret.Stitle);
        secretInfoView.setText(secret.Sarticle);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, secretTitleView.getText(), Toast.LENGTH_SHORT).show();
            }


        });
    }
}
