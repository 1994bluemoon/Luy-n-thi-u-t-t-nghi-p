package com.example.dminh.luyenthidai.Activities;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.dminh.luyenthidai.Models.DapAn;
import com.example.dminh.luyenthidai.Models.DataDe;
import com.example.dminh.luyenthidai.Models.KetQua;
import com.example.dminh.luyenthidai.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.github.kexanie.library.MathView;

public class SlideDeThiActivity extends AppCompatActivity {

    ArrayList<DataDe> dataDes;
    @BindView(R.id.mv_cauhoi)
    MathView mvCauhoi;
    @BindView(R.id.im_cauhoi)
    ImageView imCauhoi;
    @BindView(R.id.rb_dapanA)
    RadioButton rbDapanA;
    @BindView(R.id.mv_dapanA)
    MathView mvDapanA;
    @BindView(R.id.rb_dapanB)
    RadioButton rbDapanB;
    @BindView(R.id.mv_dapanB)
    MathView mvDapanB;
    @BindView(R.id.rb_dapanC)
    RadioButton rbDapanC;
    @BindView(R.id.mv_dapanC)
    MathView mvDapanC;
    @BindView(R.id.rb_dapanD)
    RadioButton rbDapanD;
    @BindView(R.id.mv_dapanD)
    MathView mvDapanD;
    @BindView(R.id.ib_back)
    ImageButton ibBack;
    @BindView(R.id.tv_socau)
    TextView tvSocau;
    @BindView(R.id.ib_forward)
    ImageButton ibForward;

    int SoCau = 0;
    ArrayList<KetQua> ketQuas;
    @BindView(R.id.bt_showdapan)
    Button btShowdapan;
    @BindView(R.id.bt_showketqua)
    Button btShowketqua;
    @BindView(R.id.tl_header)
    TableLayout tlHeader;

    String ulr = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide_de_thi);
        ButterKnife.bind(this);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            ulr = extras.getString("show");
            this.setTitle(extras.getString("title"));
        }
        dataDes = new ArrayList<DataDe>();
        ketQuas = new ArrayList<KetQua>();

        if (ulr != null){
            DownloadFilesTask downloadFilesTask = new DownloadFilesTask();
            downloadFilesTask.execute();
        }


        ibBack.setVisibility(View.INVISIBLE);
        List<DataDe> c = dataDes;

    }

    private void nhapKetqua(String nhap) {
        if (ketQuas.size() > 0) {
            boolean ck = false;
            for (int i = 0; i < ketQuas.size(); i++) {
                if (SoCau == (ketQuas.get(i).getSttCau())) {
                    KetQua kq = new KetQua(SoCau, nhap);
                    ketQuas.set(i, kq);
                    ck = true;
                }
            }
            if (!ck) {
                ketQuas.add(new KetQua(SoCau, nhap));
            }
        }else if (ketQuas.size() == 0) ketQuas.add(new KetQua(SoCau, nhap));
    }

    public void setDe(int socau) {
        mvCauhoi.setText(dataDes.get(socau).getDe());
        tvSocau.setText("Câu " + (socau + 1));
        mvDapanA.setText(dataDes.get(socau).getDapAnA());
        mvDapanB.setText(dataDes.get(socau).getDapAnB());
        mvDapanC.setText(dataDes.get(socau).getDapAnC());
        mvDapanD.setText(dataDes.get(socau).getDapAnD());
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.rb_dapanA:
                unCheckAll();
                rbDapanA.setChecked(true);
                nhapKetqua("A");
                break;
            case R.id.rb_dapanB:
                unCheckAll();
                rbDapanB.setChecked(true);
                nhapKetqua("B");
                break;
            case R.id.rb_dapanC:
                unCheckAll();
                rbDapanC.setChecked(true);
                nhapKetqua("C");
                break;
            case R.id.rb_dapanD:
                unCheckAll();
                rbDapanD.setChecked(true);
                nhapKetqua("D");
                break;
        }
    }

    private void unCheckAll() {
        rbDapanA.setChecked(false);
        rbDapanB.setChecked(false);
        rbDapanC.setChecked(false);
        rbDapanD.setChecked(false);
    }

    @OnClick({R.id.bt_showdapan, R.id.bt_showketqua, R.id.ib_back, R.id.ib_forward})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bt_showdapan:
                tvSocau.setText(dataDes.get(SoCau).getDapAnDung());
                waits();

                break;
            case R.id.bt_showketqua:
                tvSocau.setText(calcuPoint() + "/" + ketQuas.size() + "/" + dataDes.size());
                waits();
                break;
            case R.id.ib_back:
                SoCau--;
                if (SoCau == 0){
                    ibBack.setVisibility(View.INVISIBLE);
                }
                setDe(SoCau);
                ibForward.setVisibility(View.VISIBLE);
                whenNavigate();
                break;
            case R.id.ib_forward:
                SoCau++;
                if(SoCau == (dataDes.size() - 1)){
                    ibForward.setVisibility(View.INVISIBLE);
                }
                ibBack.setVisibility(View.VISIBLE);
                setDe(SoCau);
                whenNavigate();
                break;
        }
    }

    private void waits() {
        new CountDownTimer(3000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
            }
            public void onFinish() {
                tvSocau.setText("Câu "+ (SoCau +1));
            }
        }.start();
    }

    private void whenNavigate(){
        unCheckAll();
        if (ketQuas.size() > 0) {
            for (KetQua q : ketQuas
                    ) {
                if (SoCau == q.getSttCau()) {
                    switch (q.getCauTraLoi()) {
                        case "A":
                            rbDapanA.setChecked(true);
                            break;
                        case "B":
                            rbDapanB.setChecked(true);
                            break;
                        case "C":
                            rbDapanC.setChecked(true);
                            break;
                        case "D":
                            rbDapanD.setChecked(true);
                            break;
                    }
                }
            }
        }
    }


    private int calcuPoint(){
        int point= 0;
        for (KetQua cautraloi: ketQuas
             ) {
                if (dataDes.get(Integer.valueOf(cautraloi.getSttCau())).getDapAnDung().equals(cautraloi.getCauTraLoi())){
                    point++;
                }

        }
        return point;
    }

    private class DownloadFilesTask extends AsyncTask<URL, Void, String> {
        protected String doInBackground(URL... urls) {
            return downloadRemoteTextFileContent();
        }

        protected void onPostExecute(String result) {
            if (!TextUtils.isEmpty(result)) {
                String a = result;
                JSONArray jsonArray = null;

                try {
                    jsonArray = new JSONArray(a);
                    JSONObject object;
                    for (int i = 0; i < jsonArray.length(); i++) {
                        ArrayList<DapAn> dapAns = new ArrayList<DapAn>();
                        object = jsonArray.getJSONObject(i);
                        dataDes.add(new DataDe(object.getString("De"), object.getString("Hinh"), object.getString("DapAnA"), object.getString("DapAnB"), object.getString("DapAnC"), object.getString("DapAnD"), object.getString("DapAnDung")));

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                /*ListViewAdapter adapter = new ListViewAdapter(MainActivity.this,tests);
                lvTest.setAdapter(adapter);*/
                setDe(SoCau);

            }
        }
    }

    private String downloadRemoteTextFileContent() {
        URL mUrl = null;
        String content = "";
        try {
            mUrl = new URL(ulr);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            assert mUrl != null;
            URLConnection connection = mUrl.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line = "";
            while ((line = br.readLine()) != null) {
                content += line;
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return content;
    }

}
