package com.neosoft.neostore.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.neosoft.neostore.R;
import com.neosoft.neostore.model.Product.DataModel;
import com.neosoft.neostore.ui.TableFragment;

import java.util.List;

import static com.neosoft.neostore.R.id.imgTables;

public class TableAdapter extends BaseAdapter implements View.OnClickListener {
    Context mContext;
    private List<DataModel> mData;
    private static LayoutInflater inflater=null;
    public Resources res;
    DataModel tempValues=null;
    int i=0;
    public TableAdapter(Context context, List<DataModel> data, Resources resLocal) {
        mContext = context;
        mData=data;
        res = resLocal;
        inflater = ( LayoutInflater )context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }@Override
    public void onClick(View v) {
        Log.v("TableAdapter", "=====Row button clicked=====");
    }

    @Override
    public int getCount() {
        if(mData.size()<=0)
            return 1;
        return mData.size();
    }
    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public static class ViewHolder{
         TextView tableName;
         TextView tableStoreName;
         TextView tableRs;
         TextView tablePrice;
         RatingBar tableRatingBar;
         ImageView tableImage;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        ViewHolder holder;
        if(convertView==null){
            vi = inflater.inflate(R.layout.row_tablelist, null);
            holder = new ViewHolder();
            holder.tableName = (TextView) vi.findViewById(R.id.textTableName);
            holder.tableStoreName=(TextView)vi.findViewById(R.id.textTableStoreName);
            holder.tablePrice = (TextView) vi.findViewById(R.id.textTablePrice);
            holder.tableRs=(TextView)vi.findViewById(R.id.textTableRs);
            holder.tableRatingBar=(RatingBar) vi.findViewById(R.id.tableRatingBar);
            holder.tableImage=(ImageView)vi.findViewById(imgTables);
            vi.setTag( holder );
        }
        else
            holder=(ViewHolder)vi.getTag();

        if(mData.size()<=0)
        {
            holder.tableName.setText("No Data");

        }
        else
        {
            tempValues=null;
            tempValues = (DataModel) mData.get( position );
            Log.e("Table Title",mData.get(position).getTableTitle());
            holder.tableName.setText( tempValues.getTableTitle() );
            holder.tableStoreName.setText( tempValues.getTableShop() );
            holder.tablePrice.setText( tempValues.getTablePrice() );
            Glide.with(mContext)
                    .load(tempValues.getTableImage())
                    .into(holder.tableImage);
            vi.setOnClickListener(new OnItemClickListener(position));
        }
        return vi;
    }
    private class OnItemClickListener  implements View.OnClickListener {
        private int mPosition;
        OnItemClickListener(int position){
            mPosition = position;
        }
        @Override
        public void onClick(View arg0) {
            TableFragment fragment = new TableFragment();
            fragment.onItemClick(mPosition);
        }
    }
}

