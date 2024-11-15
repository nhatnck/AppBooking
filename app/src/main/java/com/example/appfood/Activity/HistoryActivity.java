
package com.example.appfood.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.appfood.Adapter.CartAdapter;
import com.example.appfood.Adapter.HistoryAdapter;
import com.example.appfood.Domain.Hotels;
import com.example.appfood.Domain.Order;
import com.example.appfood.Helper.ManagmentCart;
import com.example.appfood.R;
import com.example.appfood.databinding.ActivityCartBinding;
import com.example.appfood.databinding.ActivityHistoryBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Date;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class HistoryActivity extends BaseActivity {
    private ActivityHistoryBinding binding;
    private RecyclerView.Adapter adapter;
    private ArrayList<Order> ordersList = new ArrayList<>();
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHistoryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databaseReference = FirebaseDatabase.getInstance().getReference("orders"); // Tham chiếu đến node "orders" trong Firebase

        fetchOrdersFromFirebase();
    }

    // Lấy dữ liệu Order từ Firebase và cập nhật RecyclerView
    private void fetchOrdersFromFirebase() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ordersList.clear(); // Xóa danh sách cũ

                // Lặp qua các order trong Firebase và thêm vào danh sách
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Order order = snapshot.getValue(Order.class);
                    if (order != null) {
                        ordersList.add(order);
                    }
                }

                if (ordersList.isEmpty()) {
                    binding.viewEmpty.setVisibility(View.VISIBLE);
                    binding.scrollViewHistory.setVisibility(View.GONE);
                } else {
                    binding.viewEmpty.setVisibility(View.GONE);
                    binding.scrollViewHistory.setVisibility(View.VISIBLE);
                }

                updateRecyclerView();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(HistoryActivity.this, "Error loading data", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Cập nhật RecyclerView với dữ liệu từ Firebase
    private void updateRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        binding.historyView.setLayoutManager(linearLayoutManager);

        // Set the adapter for RecyclerView
        HistoryAdapter adapter = new HistoryAdapter(ordersList, this);
        binding.historyView.setAdapter(adapter);
    }


}