package com.example.dminh.luyenthidai.Adapters;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.dminh.luyenthidai.Models.Category;
import com.example.dminh.luyenthidai.Models.ListDocument;
import com.example.dminh.luyenthidai.R;

import java.util.ArrayList;

import static com.example.dminh.luyenthidai.R.*;

/**
 * Created by dminh on 12/8/2017.
 */

public class ExpandableAdapter extends BaseExpandableListAdapter {

    Context nContext;
    ArrayList<Category> categoryArrayList;
    LayoutInflater layoutInflater;

    public ExpandableAdapter(Context nContext, ArrayList<Category> categoryArrayList) {
        this.nContext = nContext;
        this.categoryArrayList = categoryArrayList;
        layoutInflater = layoutInflater.from(nContext);
    }

    @Override
    public int getGroupCount() {
        return categoryArrayList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return categoryArrayList.get(groupPosition).getLstdoc().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return categoryArrayList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return categoryArrayList.get(groupPosition).getLstdoc().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        ViewHolderGroup viewHolderGroup;
        if (convertView == null){
            viewHolderGroup = new ViewHolderGroup();
            convertView = layoutInflater.inflate(R.layout.gv_category_item, parent, false);
            viewHolderGroup.tvGroup = (TextView) convertView.findViewById(id.tv_category);
            viewHolderGroup.ivArrow = (ImageView) convertView.findViewById(R.id.iv_arrow);
            convertView.setTag(viewHolderGroup);
        } else viewHolderGroup = (ViewHolderGroup) convertView.getTag();

        if (isExpanded){
            viewHolderGroup.ivArrow.setImageResource(R.drawable.ic_arrow_up);
        } else {
            viewHolderGroup.ivArrow.setImageResource(R.drawable.ic_arrow_down);
        }

        Category category = categoryArrayList.get(groupPosition);
        viewHolderGroup.tvGroup.setText(category.getCat());

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        ViewHolderChild viewHolderChild;

        if (convertView == null){
            viewHolderChild = new ViewHolderChild();
            convertView = layoutInflater.inflate(layout.lv_lisview_item, parent,false);
            viewHolderChild.tvChild = convertView.findViewById(id.tv_docfile);
            convertView.setTag(viewHolderChild);
        } else viewHolderChild = (ViewHolderChild) convertView.getTag();

        Category category = categoryArrayList.get(groupPosition);
        ListDocument listDocument = category.getLstdoc().get(childPosition);
        viewHolderChild.tvChild.setText(listDocument.getTitle());

        return convertView;
    }

    // Cho phép click vào child item hay không
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    // ViewHolder giúp listview scroll mượt hơn
    public static class ViewHolderGroup {
        TextView tvGroup;
        ImageView ivArrow;
    }

    // ViewHolder giúp listview scroll mượt hơn
    public static class ViewHolderChild {
        TextView tvChild;
    }
}
