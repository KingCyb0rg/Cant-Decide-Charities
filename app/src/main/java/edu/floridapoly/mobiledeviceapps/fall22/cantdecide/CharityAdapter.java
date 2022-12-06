package edu.floridapoly.mobiledeviceapps.fall22.cantdecide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class CharityAdapter extends RecyclerView.Adapter<CharityAdapter.MyViewHolder> {

    private Context context;
    private List<Charity> charityList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.charity_title);
        }
    }

    public CharityAdapter(Context context, List<Charity> charityList) {
        this.context = context;
        this.charityList = charityList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.charity_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull  MyViewHolder holder, int position) {
        Charity charity = charityList.get(position);
        holder.title.setText(charity.getName());
    }

    @Override
    public int getItemCount() {
        return charityList.size();
    }
}
