package com.example.thuchanhservice;

import java.io.Serializable;

public class LeNhuTran_GiaoVien implements Serializable {
    private int idGV;
    private String TenGV;
    private String GT;
    private String Diachi;
    private String SDT;

    public LeNhuTran_GiaoVien(int idGV, String tenGV, String GT, String diachi, String SDT) {
        this.idGV = idGV;
        TenGV = tenGV;
        this.GT = GT;
        Diachi = diachi;
        this.SDT = SDT;
    }

    public int getIdGV() {
        return idGV;
    }

    public void setIdGV(int idGV) {
        this.idGV = idGV;
    }

    public String getTenGV() {
        return TenGV;
    }

    public void setTenGV(String tenGV) {
        TenGV = tenGV;
    }

    public String getGT() {
        return GT;
    }

    public void setGT(String GT) {
        this.GT = GT;
    }

    public String getDiachi() {
        return Diachi;
    }

    public void setDiachi(String diachi) {
        Diachi = diachi;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }
}
