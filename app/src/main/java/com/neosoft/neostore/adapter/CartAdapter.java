package com.neosoft.neostore.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.neosoft.neostore.R;
import com.neosoft.neostore.model.mycart.Datum;
import com.neosoft.neostore.model.mycart.Product;
import com.neosoft.neostore.ui.MyCartFragment;

import java.util.List;

import static com.neosoft.neostore.R.id.imgCartItems;

public class CartAdapter extends BaseAdapter implements View.OnClickListener{
    Context mContext;
    private List<Datum> mData;
    private static LayoutInflater inflater=null;
    public Resources res;
    Datum product=null;
    public CartAdapter(Context context, List<Datum> data, Resources resLocal) {
        mContext = context;
        mData=data;
        res = resLocal;
        inflater = ( LayoutInflater )context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }@Override
    public void onClick(View v) {}

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
        TextView name,type;
        ImageView prodImg;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder holder;
        if(convertView==null){
            view = inflater.inflate(R.layout.row_cart, null);
            holder = new ViewHolder();
            holder.name = (TextView) view.findViewById(R.id.txtName);
            holder.type=(TextView)view.findViewById(R.id.txtType);
            holder.prodImg=(ImageView)view.findViewById(imgCartItems);
            view.setTag( holder );
        }
        else
            holder=(CartAdapter.ViewHolder)view.getTag();

        if(mData.size()<=0)
        {
            holder.name.setText("No Data");
        }
        else
        {
            product=null;
            product = (Datum) mData.get( position );
            Product prd = product.getProduct();
            holder.name.setText(prd.getName());
            holder.type.setText(prd.getProductCategory());
            holder.prodImg.setImageResource(res.getIdentifier(
                    ""+prd.getProductImages()
                    ,null,null));
            view.setOnClickListener(new CartAdapter.OnItemClickListener(position));
            Glide.with(mContext)
                    .load(prd.getProductImages())
                    .into(holder.prodImg);
        }
        return view;
    }
    private class OnItemClickListener implements View.OnClickListener {
        private int mPosition;
        OnItemClickListener(int position){
            mPosition = position;
        }
        @Override
        public void onClick(View arg0) {
            MyCartFragment fragment = new MyCartFragment();
            fragment.onItemClick(mPosition);
        }
    }
}
