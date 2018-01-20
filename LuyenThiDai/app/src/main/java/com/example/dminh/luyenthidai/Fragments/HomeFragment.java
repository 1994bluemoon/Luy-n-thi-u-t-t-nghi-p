package com.example.dminh.luyenthidai.Fragments;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.example.dminh.luyenthidai.Activities.MainActivity;
import com.example.dminh.luyenthidai.Adapters.SubjectAdapter;
import com.example.dminh.luyenthidai.Models.Subject;
import com.example.dminh.luyenthidai.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.example.dminh.luyenthidai.Adapters.SubjectAdapter.*;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    @BindView(R.id.rvhome)
    RecyclerView rvhome;
    Unbinder unbinder;
    public static List<Subject> subjects;
    Configuration configuration;

    public HomeFragment() {
        // Required empty public constructor
    }



//    @Override
//    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        mListener.onItemClick(position);
//    }

    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        configuration =  newConfig;
        setView();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        configuration = new Configuration();
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        unbinder = ButterKnife.bind(this, view);

        initializeData();

        Configuration configuration = new Configuration();

        setView();

        SubjectAdapter adapter = new SubjectAdapter(subjects, this.getContext());

        rvhome.setAdapter(adapter);

        return view;

    }

    private void setView() {
        if (configuration.orientation == Configuration.ORIENTATION_LANDSCAPE)
        {
            GridLayoutManager gridLayoutManager =
                    new GridLayoutManager(this.getContext(), 2);
            rvhome.setHasFixedSize(true);
            rvhome.setLayoutManager(gridLayoutManager);
        }
        else {
            LinearLayoutManager lln = new LinearLayoutManager(this.getContext());
            rvhome.setHasFixedSize(true);
            rvhome.setLayoutManager(lln);
        }
    }

    private void initializeData() {
        subjects = new ArrayList<>();
        subjects.add(new Subject("TOÁN", R.drawable.toan));
        subjects.add(new Subject("LÝ", R.drawable.vatly));
        subjects.add(new Subject("HOÁ", R.drawable.hoa));
        subjects.add(new Subject("SINH", R.drawable.sinh));
        subjects.add(new Subject("VĂN", R.drawable.toan));
        subjects.add(new Subject("TIẾNG ANH", R.drawable.vatly));
        subjects.add(new Subject("LỊCH SỬ", R.drawable.lichsu));
        subjects.add(new Subject("ĐỊA LÝ", R.drawable.lichsu));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


}
