package com.sinosoft.midplanetextsort;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Person> data;
    private SortAdapter adapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        listView = findViewById(R.id.listview);
        adapter = new SortAdapter(data, this);
        listView.setAdapter(adapter);

        SideBar sideBar = findViewById(R.id.sidebar);
        TextView text = findViewById(R.id.show);
        sideBar.setTextView(text);
        sideBar.setOnTouchingLetterChangedListener(new SideBar.OnTouchingLetterChangedListener() {
            @Override
            public void onTouchingLetterChanged(String s) {
                int position = adapter.getPositionFromSection(s);
                if (position != -1) {
                    listView.setSelection(position);
                }

            }
        });
    }


    //𠀀𠀀𠀁𠀃㐋㐏𠀛𠀊𠀐  02平面字
    //񢎣,񢍨   06平面字
    private void initData() {
        data = new ArrayList<>();
        //下面中间字对应的读音为假数据，随便写的，目的是测试排序
        data.add(new Person("㐋", "cai"));
        data.add(new Person("蔡", "cai"));
        data.add(new Person("\uD840\uDC00", "ba"));
        data.add(new Person("\uD840\uDC01", "fang"));
        data.add(new Person("\uD840\uDC03", "kai"));
        data.add(new Person("㐏", "meng"));
        data.add(new Person("\uD840\uDC0A", "deng"));
        data.add(new Person("邓", "deng"));
        data.add(new Person("\uD840\uDC1B", "jia"));
        data.add(new Person("江", "jiang"));
        data.add(new Person("姜", "jiang"));
        data.add(new Person("\uD840\uDC10", "wang"));
        data.add(new Person("\uD948\uDFA3", "song"));
        data.add(new Person("宋", "song"));
        data.add(new Person("\uD948\uDF68", "huang"));
        data.add(new Person("张", "zhang"));
        data.add(new Person("杨", "yang"));
        data.add(new Person("李", "li"));

        Collections.sort(data);

    }
}
