package com.neosoft.neostore.ui;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.neosoft.neostore.R;
import com.daimajia.swipe.SwipeLayout;

import java.util.List;

/**
 * Created by webwerks on 5/12/16.
 */

public class ProdList extends ArrayAdapter<String> {


//    private final Activity context;
//    private final String[] web;
//    private final Integer[] imageId;
//
//    public ProdList(Activity context, String[] web, Integer[] imageId) {
//        super(context, R.layout.list_single, web);
//        this.context = context;
//        this.web = web;
//        this.imageId = imageId;
//
//    }
//    @Override
//    public View getView(int position, View view, ViewGroup parent) {
//        LayoutInflater inflater = context.getLayoutInflater();
//        View rowView= inflater.inflate(R.layout.list_single, null, true);
//        TextView txtTitle = (TextView) rowView.findViewById(R.id.txt);
//
//        ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
//        txtTitle.setText(web[position]);
//        imageView.setImageResource(imageId[position]);
//        return rowView;
//    }

    private MyCartFragment activity;
    private List<String> friends;


    public ProdList(MyCartFragment context, int resource, List<String> objects) {
        super(context, resource, objects);
        this.activity = context;
        this.friends = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        LayoutInflater inflater = (LayoutInflater) activity
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        // If holder not exist then locate all view from UI file.
        if (convertView == null) {
            // inflate UI from XML file
            convertView = inflater.inflate(R.layout.list_single, parent, false);
            // get all UI view
            holder = new ViewHolder(convertView);
            // set tag for holder
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.name.setText(getItem(position));
        holder.type.setText("(products)");
        holder.btnDelete.setOnClickListener(onDeleteListener(position, holder));
        return convertView;
    }

    private View.OnClickListener onDeleteListener(final int position, final ViewHolder holder) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                friends.remove(position);
                holder.swipeLayout.close();
                activity.updateAdapter();
            }
        };
    }

    private class ViewHolder {
        private TextView name;
        private TextView type;
        private View btnDelete;
        private SwipeLayout swipeLayout;

        public ViewHolder(View v) {
            swipeLayout = (SwipeLayout)v.findViewById(R.id.swipe_layout);
            btnDelete = v.findViewById(R.id.delete);
            name = (TextView) v.findViewById(R.id.name);
            type = (TextView) v.findViewById(R.id.prod_type);
            swipeLayout.setShowMode(SwipeLayout.ShowMode.LayDown);
        }
    }
}
