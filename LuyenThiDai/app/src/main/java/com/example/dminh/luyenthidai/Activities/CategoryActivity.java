package com.example.dminh.luyenthidai.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.example.dminh.luyenthidai.Adapters.ExpandableAdapter;
import com.example.dminh.luyenthidai.Models.Category;
import com.example.dminh.luyenthidai.Models.ListDocument;
import com.example.dminh.luyenthidai.Models.Subject;
import com.example.dminh.luyenthidai.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static br.com.zbra.androidlinq.Linq.stream;

public class CategoryActivity extends AppCompatActivity {

    /*@BindView(R.id.meo)
    Button meo;
    @BindView(R.id.congthuc)
    Button congthuc;
    @BindView(R.id.dethi)
    Button dethi;*/

    String mon;
    String cat;
    String subject;
    List<ListDocument> listmeo;
    List<ListDocument> listcongthuc;
    List<ListDocument> listdethi;
    @BindView(R.id.el_category)
    ExpandableListView elCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        ButterKnife.bind(this);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            mon = extras.getString("sub");
            this.setTitle(mon);
        }

        List<ListDocument> list = null;
        list = ListDocument.createListDoc();

        listmeo = stream(stream(list).where(c -> c.getMon().equals( mon)).toList())
                 .where(b -> b.getCat().equals("Mẹo"))
                .toList();
        listcongthuc = stream(stream(list).where(c -> c.getMon().equals(mon)).toList())
                .where(b -> b.getCat().equals("Công Thức"))
                .toList();
        listdethi = stream(stream(list).where(c -> c.getMon().equals(mon)).toList())
                .where(b -> b.getCat().equals("Đề Thi"))
                .toList();

        final ArrayList<Category> categories = new ArrayList<Category>();
        categories.add(new Category("Mẹo", listmeo));
        categories.add(new Category("Công Thức", listcongthuc));
        categories.add(new Category("Đề Thi", listdethi));

        ExpandableAdapter adapter = new ExpandableAdapter(CategoryActivity.this, categories);
        elCategory.setAdapter(adapter);

        elCategory.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                return false;
            }
        });

        elCategory.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Intent intent = new Intent(CategoryActivity.this, SlideDeThiActivity.class);
                String extra = categories.get(groupPosition).getLstdoc().get(childPosition).getDuongdanfile();
                intent.putExtra("show", extra);
                intent.putExtra("title", categories.get(groupPosition).getLstdoc().get(childPosition).getTitle());
                intent.putExtra("filedapan", categories.get(groupPosition).getLstdoc().get(childPosition).getDapan());

                startActivity(intent);
                return false;
            }
        });
    }


    @Override
    protected void onStop() {

        super.onStop();
    }

    /*@OnClick({R.id.meo, R.id.congthuc, R.id.dethi})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.meo:
                cat = "Mẹo";
                break;
            case R.id.congthuc:
                cat = "Công Thức";
                break;
            case R.id.dethi:
                cat = "Đề Thi";
                break;
        }
        Category category = new Category(cat,mon);
        Intent intent = new Intent(this, ListSubjectActivity.class);
        intent.putExtra("category", category);
        startActivity(intent);
    }*/
}
