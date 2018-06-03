package com.example.sergiomoral.appcitas.presentation.ui.view.ListAppointmentsActivity.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.sergiomoral.appcitas.R;
import com.example.sergiomoral.appcitas.domain.entities.Appointment;
import com.example.sergiomoral.appcitas.presentation.utils.Utils;
import com.example.sergiomoral.appcitas.presentation.utils.constants.BuildData;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sergiomoral on 16/2/18.
 */

public class AppointmentListAdapter extends RecyclerView.Adapter<AppointmentListAdapter.ViewHolder> {

    private ArrayList<Appointment> mAppointments;
    private Context mContext;
    private onItemClickListener itemListener;
    View itemView;

    public AppointmentListAdapter(Context context, ArrayList<Appointment> appointments, onItemClickListener itemClickListener) {
        this.mAppointments = appointments;
        this.mContext = context;
        this.itemListener = itemClickListener;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        itemView = inflater.inflate(R.layout.item_appointment, parent, false);

        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.mItemDate.setText(mAppointments.get(position).getFechacita());
        holder.mItemHour.setText(mAppointments.get(position).getHoracita());
        holder.mItemTitle.setText(mAppointments.get(position).getOficina().getNombrelocal());
        String url = mAppointments.get(position).getOficina().getLogo();
        byte[] imageByteArray = Base64.decode(url, Base64.DEFAULT);
        holder.mItemPicture.setImageBitmap(Utils.getBitmapFromBase64(imageByteArray));
        holder.bind(mAppointments.get(position), itemListener);

    }

    @Override
    public int getItemCount() {
        return mAppointments.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_item_imageview)
        ImageView mItemPicture;

        @BindView(R.id.tv_item_title)
        TextView mItemTitle;

        @BindView(R.id.tv_item_date)
        TextView mItemDate;

        @BindView(R.id.tv_item_hour)
        TextView mItemHour;

        private Context context;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            context = itemView.getContext();
        }

        public void bind(final Appointment item, final onItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(item);
                }
            });
        }
    }
}
