package com.example.dminh.luyenthidai.Models;

import java.util.List;

/**
 * Created by dminh on 12/4/2017.
 */

public class Category{
    String cat;
    List<ListDocument> lstdoc;

    public List<ListDocument> getLstdoc() {
        return lstdoc;
    }

    public void setLstdoc(List<ListDocument> lstdoc) {
        this.lstdoc = lstdoc;
    }

    public Category(String cat, List<ListDocument> lstdoc) {
        this.cat = cat;
        this.lstdoc = lstdoc;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }
}
