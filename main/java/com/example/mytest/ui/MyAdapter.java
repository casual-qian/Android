package com.example.mytest.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mytest.data.model.Item;
import com.example.mytest.R;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.myViewHodler>{
    private Context context;
    private ArrayList<Item> ItemList;

    //创建构造函数
    public MyAdapter(Context context, ArrayList<Item> ItemList) {
        //将传递过来的数据，赋值给本地变量
        this.context = context;//上下文
        this.ItemList = ItemList;//实体类数据ArrayList
    }

    /**
     * 创建viewhodler，相当于listview中getview中的创建view和viewhodler
     *
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public myViewHodler onCreateViewHolder(ViewGroup parent, int viewType) {
        //创建自定义布局
        View itemView = View.inflate(context, R.layout.list, null);
        return new myViewHodler(itemView);
    }

    /**
     * 绑定数据，数据与view绑定
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(myViewHodler holder, int position) {
        //根据点击位置绑定数据
        Item data = ItemList.get(position);
        holder.mItemName.setText(data.Name);//获取实体类中的name字段并设置
        holder.mItemId.setText(data.Id);//获取实体类中的price字段并设置
        switch (position%4){
            case 0:holder.mItemId.setBackgroundResource(R.drawable.exercises_bg_1);break;
            case 1:holder.mItemId.setBackgroundResource(R.drawable.exercises_bg_2);break;
            case 2:holder.mItemId.setBackgroundResource(R.drawable.exercises_bg_3);break;
            case 3:holder.mItemId.setBackgroundResource(R.drawable.exercises_bg_4);break;
        }
    }

    /**
     * 获取项目总数
     *
     * @return
     */
    @Override
    public int getItemCount() {
        return ItemList.size();
    }

    //自定义viewhodler
    class myViewHodler extends RecyclerView.ViewHolder {
        private ImageView mItemImg;
        private TextView mItemName;
        private TextView mItemId;

        public myViewHodler(View itemView) {
            super(itemView);
            mItemName = (TextView) itemView.findViewById(R.id.exercise_name);
            mItemId = (TextView) itemView.findViewById(R.id.exercise_id);
            //点击事件放在adapter中使用，也可以写个接口在activity中调用
            //方法一：在adapter中设置点击事件
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //可以选择直接在本位置直接写业务处理
                    //Toast.makeText(context,"点击了xxx",Toast.LENGTH_SHORT).show();
                    //此处回传点击监听事件
                    if(onItemClickListener!=null){
                        onItemClickListener.OnItemClick(v, ItemList.get(getLayoutPosition()));
                    }
                }
            });

        }
    }

    /**
     * 设置item的监听事件的接口
     */
    public interface OnItemClickListener {
        /**
         *
         * @param view 点击的item的视图
         * @param data 点击的item的数据
         */
        public void OnItemClick(View view, Item data);
    }

    //需要外部访问，所以需要设置set方法，方便调用
    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
    
}
