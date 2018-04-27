package com.sinosoft.midplanetextsort;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sinosoft.midplanetexthelper.MidPlaneTextTool;

import java.util.List;

/**
 * Created by Mars on 2018/4/27.
 */

public class SortAdapter extends BaseAdapter {

    private List<Person> data;
    private Context context;

    public SortAdapter(List<Person> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.sortlist_item, null);
            holder = new ViewHolder();
            holder.header = convertView.findViewById(R.id.tv_lv_item_tag);
            holder.name = convertView.findViewById(R.id.tv_lv_item_name);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        String section = data.get(position).getFirstLetter();
        //通过判断当前item的position是否等于第一个出现item对应的中文首字母的索引。
        //如果相等，则说明是第一次出现，便需要显示字母，否则不显示字母。
        if (position == getPositionFromSection(section)) {
            holder.header.setVisibility(View.VISIBLE);
            holder.header.setText(section);
        } else {
            holder.header.setVisibility(View.GONE);
        }

        MidPlaneTextTool tool = new MidPlaneTextTool(context, holder.name, data.get(position).getName());
        tool.handleFont();
        return convertView;
    }

    //比如AABBCCC，这里第一个数据的首字母为A，遍历(AABBCCC),找到第一个与A相等的索引index
    //然后在绘制的时候，只绘制该index位置的header
    public int getPositionFromSection(String section) {
        for (int i = 0; i < getCount(); i++) {
            String header = data.get(i).getFirstLetter();
            if (header.equals(section)) {
                return i;
            }
        }
        return -1;
    }


    class ViewHolder {
        TextView header;
        TextView name;
    }


}
