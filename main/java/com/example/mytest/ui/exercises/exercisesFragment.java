package com.example.mytest.ui.exercises;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mytest.data.model.Item;
import com.example.mytest.R;
import com.example.mytest.ui.MyAdapter;

import java.util.ArrayList;

public class exercisesFragment extends Fragment {

    private View view;//定义view用来设置fragment的layout
    private String[] titles = {"第1章 Android基础入门","第2章 Android常见界面布局","第3章 Android常见界面控件","第4章 程序活动单元Activity",
            "第5章 数据存储","第6章 内容提供者","第7章 广播机制","第8章 服务","第9章 网络编程","第10章 综合项目"};
    public RecyclerView mMyRecyclerView;//定义RecyclerView
    private ArrayList<Item> ItemList = new ArrayList<Item>();
    //自定义recyclerveiw的适配器
    private MyAdapter mMyRecyclerAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //获取练习fragment的layout
        view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        //对recycleview进行初始化配置
        initRecyclerView();
        //初始化数据
        initData();
        return view;
    }

    /**
     * TODO 初始化数据
     */
    private void initData() {
        for (int i=0;i<10;i++){
            Item Item=new Item();
            Item.Id=i+1+"";
            Item.Name=titles[i];
            ItemList.add(Item);
        }
    }

    /**
     * TODO 对recycleview进行初始化配置
     */

    private void initRecyclerView() {
        //获取RecyclerView
        mMyRecyclerView=(RecyclerView)view.findViewById(R.id.RecyclerView);
        //创建adapter
        mMyRecyclerAdapter = new MyAdapter(getActivity(), ItemList);
        //给RecyclerView设置adapter
        mMyRecyclerView.setAdapter(mMyRecyclerAdapter);
        //设置layoutManager,可以设置显示效果，是线性布局、grid布局，还是瀑布流布局
        //参数是：上下文、列表方向（横向还是纵向）、是否倒叙
        mMyRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        //设置item的分割线
        mMyRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
    }

}