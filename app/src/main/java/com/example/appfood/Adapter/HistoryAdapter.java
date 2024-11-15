package com.example.appfood.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appfood.Activity.HistoryActivity;
import com.example.appfood.Domain.Order;
import com.example.appfood.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {
    private ArrayList<Order> list;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm",  Locale.forLanguageTag("vi-VN"));

    public HistoryAdapter(ArrayList<Order> list, HistoryActivity historyActivity) {
        this.list = list;
    }
    @NonNull
    @Override
    public HistoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_cart, parent, false);
        return new ViewHolder(view);
    }
    // Định dạng ngày và giờ thành "yyyy-MM-dd HH:mm"

    @Override
    public void onBindViewHolder(@NonNull HistoryAdapter.ViewHolder holder, int position) {
        Order order = list.get(position);

        holder.title.setText(order.getNameHotel());
        holder.feeEachItem.setText("$" + order.getTotalPrice());
        holder.totalEachItem.setText("Total: $" + order.getTotalPrice());
        holder.num.setText(order.getQuantity());
        String formattedDate = dateFormat.format(order.getDate());
        holder.date.setText("Date: " + formattedDate);

        // Sử dụng Glide để tải ảnh với hiệu ứng bo góc
//        Glide.with(holder.itemView.getContext())
//                .load(order.getImagePath()) // Đảm bảo `Order` có phương thức `getImagePath()`
//                .transform(new CenterCrop(), new RoundedCorners(15))
//                .into(holder.pic);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, feeEachItem, totalEachItem, num, date;
        ImageView pic;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.txtTitle);
            feeEachItem = itemView.findViewById(R.id.txtFeeEachItem);
            totalEachItem = itemView.findViewById(R.id.txtTotalEachItem);
            num = itemView.findViewById(R.id.txtNumberItem);
            pic = itemView.findViewById(R.id.imgItemHistory);
            date = itemView.findViewById(R.id.txtDate);
        }
    }
}
