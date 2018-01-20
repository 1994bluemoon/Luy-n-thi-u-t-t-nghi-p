package com.example.dminh.luyenthidai.Models;

import com.example.dminh.luyenthidai.R;

import java.io.Serializable;

/**
 * Created by dminh on 12/1/2017.
 */

public class Subject implements Serializable{
    String subname;
    int subimage;

    public Subject(String subname, int subimage) {
        this.subname = subname;
        this.subimage = subimage;
    }

    public String getSubname() {
        return subname;
    }

    public void setSubname(String subname) {
        this.subname = subname;
    }

    public int getSubimage() {

        return subimage;
    }

    public void setSubimage(int subimage) {
        this.subimage = subimage;
    }
}
