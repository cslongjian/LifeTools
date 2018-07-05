package com.cslong.app.lifetools.lifetools_business;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.cslong.app.lifetools.BaseActivity;
import com.cslong.app.lifetools.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by chenlongjian on 2018/6/25.
 */

public class LifeToolsActivity extends BaseActivity {

    private GridView mLifeToolsGridView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_lifetools);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setDisplayShowHomeEnabled(true);


        mLifeToolsGridView = (GridView) findViewById(R.id.life_type);

        //生成动态数组，并且转入数据
        ArrayList<HashMap<String, Object>> lstImageItem = new ArrayList<HashMap<String, Object>>();
        for (int i = 0; i < 10; i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("ItemImage", R.drawable.default_network_error_icon);//添加图像资源的ID
            map.put("ItemText", "NO." + String.valueOf(i));//按序号做ItemText
            lstImageItem.add(map);
        }
        //生成适配器的ImageItem <====> 动态数组的元素，两者一一对应
        SimpleAdapter saImageItems = new SimpleAdapter(this, //没什么解释
                lstImageItem,//数据来源
                R.layout.item_lifetools_type_grid,//night_item的XML实现

                //动态数组与ImageItem对应的子项
                new String[]{"ItemImage", "ItemText"},

                //ImageItem的XML文件里面的一个ImageView,两个TextView ID
                new int[]{R.id.ItemImage, R.id.ItemText});
        //添加并且显示
        mLifeToolsGridView.setAdapter(saImageItems);
        //添加消息处理
//        gridview.setOnItemClickListener(new ItemClickListener());

    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private class LifetoolAdatper extends BaseAdapter {
        private List<String> mList;//数据源
        private LayoutInflater mInflater;//布局装载器对象

        public LifetoolAdatper(List<String> data, Context context) {

            this.mList = data;
            mInflater = LayoutInflater.from(context);
        }


        @Override
        public int getCount() {
            return mList.size();
        }


        @Override
        public long getItemId(int position) {
            return 0;
        }


        @Override
        public Object getItem(int position) {
            return mList.get(position);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //将布局文件转化为View对象
            View view = mInflater.inflate(R.layout.item_lifetools_type_grid, null);

//            这里有缓存操作。

            /**
             * 找到item布局文件中对应的控件
             */
            ImageView imageView = (ImageView) view.findViewById(R.id.ItemImage);
            TextView titleTextView = (TextView) view.findViewById(R.id.ItemText);

            //获取相应索引的ItemBean对象
            String bean = mList.get(position);

            /**
             * 设置控件的对应属性值
             */
            imageView.setImageResource(R.drawable.default_network_error_icon);
            titleTextView.setText(bean);

            return view;
        }
    }


}
