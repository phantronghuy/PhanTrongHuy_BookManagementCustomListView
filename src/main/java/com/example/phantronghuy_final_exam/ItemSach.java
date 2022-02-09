package com.example.phantronghuy_final_exam;

public class ItemSach {
    private String maSach;
    private String tenSach;
    private String tacGia;
    private int namXb;
    private int soLuong;

    public ItemSach(){

    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public int getNamXb() {
        return namXb;
    }

    public void setNamXb(int namXb) {
        this.namXb = namXb;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public ItemSach(String maSach, String tenSach, String tacGia, int namXb, int soLuong) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.namXb = namXb;
        this.soLuong = soLuong;
    }

    @Override
    public String toString() {
        return "ItemSach{" +
                "maSach='" + maSach + '\'' +
                ", tenSach='" + tenSach + '\'' +
                ", tacGia='" + tacGia + '\'' +
                ", namXb=" + namXb +
                ", soLuong=" + soLuong +
                '}';
    }
}
