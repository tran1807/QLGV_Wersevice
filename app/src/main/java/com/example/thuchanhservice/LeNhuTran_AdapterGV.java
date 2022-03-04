package com.example.thuchanhservice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class LeNhuTran_AdapterGV extends BaseAdapter {
    private MainActivity context;
    private int layout;
    private List<LeNhuTran_GiaoVien> nhanVienList;

    public LeNhuTran_AdapterGV(MainActivity context, int layout, List<LeNhuTran_GiaoVien> nhanVienList) {
        this.context = context;
        this.layout = layout;
        this.nhanVienList = nhanVienList;
    }

    @Override
    public int getCount() {
        return nhanVienList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


    private class ViewHolder {
        TextView txtMaNV, txtTenNV, txtGT, txtDiachi, txtSDT;
    }
    // Tim kiem
    public void filterSP(ArrayList<LeNhuTran_GiaoVien> filterList){
        nhanVienList = filterList;
        notifyDataSetChanged();
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);

            holder.txtMaNV = (TextView) view.findViewById(R.id.textViewMagv);
            holder.txtTenNV = (TextView) view.findViewById(R.id.textViewTengv);
            holder.txtGT = (TextView) view.findViewById(R.id.textViewGioitinh);
            holder.txtDiachi = (TextView) view.findViewById(R.id.textViewDiachi);
            holder.txtSDT = (TextView) view.findViewById(R.id.textViewSdt);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();

        }

        LeNhuTran_GiaoVien giaoVien = nhanVienList.get(i);
        holder.txtMaNV.setText("ID:" + giaoVien.getIdGV());
        holder.txtTenNV.setText(giaoVien.getTenGV());
        holder.txtGT.setText(giaoVien.getGT());
        holder.txtDiachi.setText(giaoVien.getDiachi());
        holder.txtSDT.setText(giaoVien.getSDT());
        return view;
    }
}