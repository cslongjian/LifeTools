package com.cslong.app.lifetools;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.cslong.app.lifetools.annotationDemo.AnnotationDemoActivity;
import com.cslong.app.lifetools.datastructures_algorithms.simple_series.DataStructuresAndAlgorithmsActivity;
import com.cslong.app.lifetools.lifetools_business.LifeToolsActivity;

public class MainActivity extends BaseActivity {


    private ListItem[] mListItems = {
            new ListItem(DataStructuresAndAlgorithmsActivity.class, "数据结构与算法"),
            new ListItem(LifeToolsActivity.class, "lifetools"),
            new ListItem(AnnotationDemoActivity.class, "注解样例"),

    };


    private static class ListItem {
        Class<? extends Activity> cls;
        String title;

        public ListItem(Class<? extends Activity> cls, String title) {
            this.cls = cls;
            this.title = title;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main);


        ListView listView = (ListView) findViewById(R.id.list);
        ListAdapter adapter = new MAdapter(mListItems);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ListItem listItem = mListItems[position];
                Intent intent = new Intent(MainActivity.this, listItem.cls);
                startActivity(intent);

//                路由使用样例
//                AppRooterSimple.get().getmLifeToolsRoadMap().LifeToolsHere().start(MainActivity.this);

            }
        });

    }


    private static class MAdapter extends BaseAdapter {
        private ListItem[] mListItems;

        public MAdapter(ListItem[] listItems) {
            mListItems = listItems;
        }

        @Override
        public int getCount() {
            return mListItems != null ? mListItems.length : 0;
        }

        @Override
        public ListItem getItem(int position) {
            return mListItems[position];
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(parent.getContext())
                        .inflate(android.R.layout.simple_list_item_1, parent, false);
            }
            TextView textView = (TextView) convertView.findViewById(android.R.id.text1);
            ListItem listItem = mListItems[position];
            textView.setText(listItem.title);
            return convertView;
        }
    }
}
