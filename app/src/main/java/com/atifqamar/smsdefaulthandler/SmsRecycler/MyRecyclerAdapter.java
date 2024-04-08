package com.atifqamar.smsdefaulthandler.SmsRecycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.atifqamar.smsdefaulthandler.R;

import java.util.ArrayList;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder> {

    private ArrayList<SMSItem> mSMSList;

    @NonNull
    @Override
    public MyRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sms_recycler_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRecyclerAdapter.ViewHolder holder, int position) {
        holder.onBind(mSMSList.get(position));
    }

    public void setSMSList(ArrayList<SMSItem> list){
        this.mSMSList = list;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mSMSList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView message;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

//            profile = (ImageView) itemView.findViewById(R.id.profile);
            name = (TextView) itemView.findViewById(R.id.name);
            message = (TextView) itemView.findViewById(R.id.message);
        }

        void onBind(SMSItem item){
//            profile.setImageResource(item.getResourceId());
            name.setText(item.getName());
            message.setText(item.getMessage());
        }
    }
}