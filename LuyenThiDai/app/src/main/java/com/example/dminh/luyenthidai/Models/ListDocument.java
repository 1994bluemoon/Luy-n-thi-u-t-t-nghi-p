package com.example.dminh.luyenthidai.Models;

import android.app.Application;

import com.example.dminh.luyenthidai.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by dminh on 12/4/2017.
 */

public class ListDocument{
    String mon;
    String cat;
    String title;
    String duongdanfile;
    String dapan;

    public String getDapan() {
        return dapan;
    }

    public void setDapan(String dapan) {
        this.dapan = dapan;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ListDocument(String mon, String cat, String title, String duongdanfile, String dapan) {
        this.mon = mon;
        this.cat = cat;
        this.title = title;
        this.duongdanfile = duongdanfile;
        this.dapan= dapan;
    }

    public String getMon() {
        return mon;
    }

    public void setMon(String mon) {
        this.mon = mon;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public String getDuongdanfile() {
        return duongdanfile;
    }

    public void setDuongdanfile(String duongdanfile) {
        this.duongdanfile = duongdanfile;
    }

    public static List<ListDocument> createListDoc(){
        List<ListDocument> listDocuments = new ArrayList<ListDocument>();
        listDocuments.add(new ListDocument("TIẾNG ANH","Mẹo", "5 mẹo học từ vựng hiệu quả","http://dvqchoangdang.000webhostapp.com/txt.txt", ""));
        listDocuments.add(new ListDocument("TIẾNG ANH","Công Thức", "Demo", "http://dvqchoangdang.000webhostapp.com/txt.txt", ""));
        listDocuments.add(new ListDocument("TIẾNG ANH","Đề Thi", "Demo", "http://dvqchoangdang.000webhostapp.com/txt.txt", ""));

        listDocuments.add(new ListDocument("TOÁN","Mẹo", "Demo", "http://dvqchoangdang.000webhostapp.com/txt.txt", ""));
        listDocuments.add(new ListDocument("TOÁN","Công Thức", "Demo", "http://dvqchoangdang.000webhostapp.com/txt.txt", ""));
        listDocuments.add(new ListDocument("TOÁN","Đề Thi", "Demo", "http://dvqchoangdang.000webhostapp.com/txt.txt", ""));

        listDocuments.add(new ListDocument("LÝ","Mẹo", "Demo", "http://dvqchoangdang.000webhostapp.com/txt.txt", ""));
        listDocuments.add(new ListDocument("LÝ","Công Thức", "Demo", "http://dvqchoangdang.000webhostapp.com/txt.txt", ""));
        listDocuments.add(new ListDocument("LÝ","Đề Thi", "Demo", "http://dvqchoangdang.000webhostapp.com/txt.txt", ""));

        listDocuments.add(new ListDocument("HOÁ","Mẹo", "Demo", "http://dvqchoangdang.000webhostapp.com/txt.txt", ""));
        listDocuments.add(new ListDocument("HOÁ","Công Thức", "Demo", "http://dvqchoangdang.000webhostapp.com/txt.txt", ""));
        listDocuments.add(new ListDocument("HOÁ","Đề Thi", "Demo", "http://dvqchoangdang.000webhostapp.com/txt.txt", ""));

        listDocuments.add(new ListDocument("VĂN","Mẹo", "Demo", "http://dvqchoangdang.000webhostapp.com/txt.txt", ""));
        listDocuments.add(new ListDocument("VĂN","Công Thức", "Demo", "http://dvqchoangdang.000webhostapp.com/txt.txt", ""));
        listDocuments.add(new ListDocument("VĂN","Đề Thi", "Demo", "http://dvqchoangdang.000webhostapp.com/txt.txt", ""));

        listDocuments.add(new ListDocument("LỊCH SỬ","Mẹo", "Demo", "http://dvqchoangdang.000webhostapp.com/txt.txt", ""));
        listDocuments.add(new ListDocument("LỊCH SỬ","Công Thức", "Demo", "http://dvqchoangdang.000webhostapp.com/txt.txt", ""));
        listDocuments.add(new ListDocument("LỊCH SỬ","Đề Thi", "Demo", "http://dvqchoangdang.000webhostapp.com/txt.txt", ""));

        listDocuments.add(new ListDocument("ĐỊA LÝ","Mẹo", "Demo", "http://dvqchoangdang.000webhostapp.com/txt.txt", ""));
        listDocuments.add(new ListDocument("ĐỊA LÝ","Công Thức", "Demo", "http://dvqchoangdang.000webhostapp.com/txt.txt", ""));
        listDocuments.add(new ListDocument("ĐỊA LÝ","Đề Thi", "Demo", "http://dvqchoangdang.000webhostapp.com/txt.txt", ""));

        listDocuments.add(new ListDocument("SINH","Mẹo", "Demo", "http://dvqchoangdang.000webhostapp.com/txt.txt", ""));
        listDocuments.add(new ListDocument("SINH","Công Thức", "Demo", "http://dvqchoangdang.000webhostapp.com/txt.txt", ""));
        listDocuments.add(new ListDocument("SINH","Đề Thi", "Demo", "http://dvqchoangdang.000webhostapp.com/txt.txt", ""));

        return listDocuments;
    }
}
