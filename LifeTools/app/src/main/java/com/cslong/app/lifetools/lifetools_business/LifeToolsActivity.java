package com.cslong.app.lifetools.lifetools_business;

import android.app.LauncherActivity;
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
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.cslong.app.lifetools.BaseActivity;
import com.cslong.app.lifetools.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by chenlongjian on 2018/6/25.
 */

public class LifeToolsActivity extends BaseActivity {

    private GridView mLifeToolsGridView;

    private Context mContext;

    private ListItem[] mListItems = {
            new ListItem("笑话"),
            new ListItem("娱乐"),
            new ListItem("预留位置"),
            new ListItem("预留位置"),
            new ListItem("预留位置"),
    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_lifetools);
        mContext = this;

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setDisplayShowHomeEnabled(true);

        mLifeToolsGridView = (GridView) findViewById(R.id.life_type);
        ListAdapter gridAdapter = new LifetoolAdatper(null, this, mListItems);
        mLifeToolsGridView.setAdapter(gridAdapter);
        mLifeToolsGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                }
                Toast.makeText(mContext, position + "当前位置", Toast.LENGTH_SHORT).show();
            }

        });


    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private static class ListItem {
        String title;

        public ListItem(String title) {
            this.title = title;
        }
    }


    private class LifetoolAdatper extends BaseAdapter {
        private List<String> mList;//数据源
        private ListItem[] mListItems;
        private LayoutInflater mInflater;//布局装载器对象

        public LifetoolAdatper(List<String> data, Context context, ListItem[] mListItems) {
            this.mListItems = mListItems;
            this.mList = data;
            mInflater = LayoutInflater.from(context);
        }


        @Override
        public int getCount() {
            return mListItems.length;
        }


        @Override
        public long getItemId(int position) {
            return 0;
        }


        @Override
        public Object getItem(int position) {
            return mListItems[position];
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder viewHolder;
            //如果view未被实例化过，缓存池中没有对应的缓存
            if (convertView == null) {
                viewHolder = new ViewHolder();
                // 由于我们只需要将XML转化为View，并不涉及到具体的布局，所以第二个参数通常设置为null
                convertView = mInflater.inflate(R.layout.item_lifetools_type_grid, null);

                //对viewHolder的属性进行赋值
                viewHolder.imageView = (ImageView) convertView.findViewById(R.id.ItemImage);
                viewHolder.title = (TextView) convertView.findViewById(R.id.ItemText);

                //通过setTag将convertView与viewHolder关联
                convertView.setTag(viewHolder);
            } else {//如果缓存池中有对应的view缓存，则直接通过getTag取出viewHolder
                viewHolder = (ViewHolder) convertView.getTag();
            }


            //获取相应索引的ItemBean对象
            String bean = mListItems[position].title;

            /**
             * 设置控件的对应属性值
             */
            viewHolder.imageView.setImageResource(R.drawable.default_network_error_icon);
            viewHolder.title.setText(bean);

            return convertView;
        }


        // ViewHolder用于缓存控件
        class ViewHolder {
            public ImageView imageView;
            public TextView title;

        }

    }


}
