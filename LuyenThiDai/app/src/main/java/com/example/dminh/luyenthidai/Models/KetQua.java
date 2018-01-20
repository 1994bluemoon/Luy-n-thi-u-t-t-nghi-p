package com.example.dminh.luyenthidai.Models;

/**
 * Created by dminh on 12/27/2017.
 */

public class KetQua {
    int sttCau;
    String CauTraLoi;

    public int getSttCau() {
        return sttCau;
    }

    public void setSttCau(int sttCau) {
        this.sttCau = sttCau;
    }

    public String getCauTraLoi() {
        return CauTraLoi;
    }

    public void setCauTraLoi(String cauTraLoi) {
        CauTraLoi = cauTraLoi;
    }

    public KetQua(int sttCau, String cauTraLoi) {
        this.sttCau = sttCau;
        CauTraLoi = cauTraLoi;
    }
}
