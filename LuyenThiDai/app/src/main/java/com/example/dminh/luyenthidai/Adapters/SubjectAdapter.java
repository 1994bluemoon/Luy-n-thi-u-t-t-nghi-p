package com.example.dminh.luyenthidai.Adapters;

import android.content.Context;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dminh.luyenthidai.Activities.CategoryActivity;
import com.example.dminh.luyenthidai.Models.Subject;
import com.example.dminh.luyenthidai.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.app.PendingIntent.getActivity;

/**
 * Created by dminh on 12/1/2017.
 */

public class SubjectAdapter extends RecyclerView.Adapter<SubjectAdapter.ViewHolder>{

    List<Subject> subjects;
    Context context;


    public SubjectAdapter(List<Subject> subjects, Context context) {
        this.subjects = subjects;
        this.context = context;
    }

    private Context getContext() {
        return context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.homelayout, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Subject subject = subjects.get(position);
        holder.cvSubjectName.setText(subject.getSubname());
        Picasso.with(getContext())
                .load(subject.getSubimage())
                .resize(1280,720)
                .into(holder.cvSubjectImage);
    }


    @Override
    public int getItemCount() {
        return subjects.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        @BindView(R.id.cv_subject_image)
        ImageView cvSubjectImage;
        @BindView(R.id.cv_subject_name)
        TextView cvSubjectName;
        @BindView(R.id.cvhome)
        CardView cvhome;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
            view.setOnClickListener(this);

        }
        @Override
        public void onClick(View v) {
            Subject subject = subjects.get(getAdapterPosition());
            Intent intent = new Intent(getContext(), CategoryActivity.class);
            intent.putExtra("sub", subject.getSubname());
            getContext().startActivity(intent);

        }
    }
}
