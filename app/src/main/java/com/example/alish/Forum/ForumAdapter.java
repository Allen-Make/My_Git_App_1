package com.example.alish.Forum;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alish.my_git_app_1.MainActivity;
import com.example.alish.my_git_app_1.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alish on 2015/10/29.
 */
public class ForumAdapter extends BaseAdapter {
    private List<forum> mList = new ArrayList<forum>();
    private Context mContext;
    private LayoutInflater inflater;

    public  ForumAdapter(Context pContext,List<forum> pList){
        System.out.println();
        this.mContext = pContext;
        this.mList = pList;
        this.inflater = LayoutInflater.from(mContext);
    }
    @Override
    public int getCount() {
        return mList.size();
    }
    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        System.out.println("InstAdapter:getView"+String.valueOf(position));
        DataWrapper dataWrapper;

        final TextView text1;
        final TextView text2;
        final TextView text3;
        final TextView text4;
        final TextView text5;
        CheckBox Check_1;
        if(convertView == null)
        {
            convertView = inflater.inflate(R.layout.list_item_forum,null);
            text1    = (TextView)convertView.findViewById(R.id.listforum_tv_1);
            text2    = (TextView)convertView.findViewById(R.id.listforum_tv_2);
            text3    = (TextView)convertView.findViewById(R.id.listforum_tv_3);
            text4    = (TextView)convertView.findViewById(R.id.listforum_tv_4);
            text5    = (TextView)convertView.findViewById(R.id.listforum_tv_5);
            Check_1 = (CheckBox)convertView.findViewById(R.id.forchec1);
            CheckBox.OnClickListener checkBoxListener = new CheckBox.OnClickListener(){
                @Override
                public void onClick(View v) {
                    CheckBox curBox = (CheckBox)v;
                    String checkedText = curBox.getText().toString();
                    if(curBox.isChecked()){
                        Toast.makeText(mContext,text1.getText().toString()+checkedText+"被选中",Toast.LENGTH_LONG)
                                .show();
                    }else{
                        Toast.makeText(mContext,text1.getText().toString()+checkedText+"被取消",Toast.LENGTH_LONG)
                                .show();
                    }
                }
            };
            Check_1.setOnClickListener(checkBoxListener);

            dataWrapper = new DataWrapper(text1,text2,text3,text4,text5);
            convertView.setTag(dataWrapper);
        }else{
            dataWrapper = (DataWrapper)convertView.getTag();
            text1  = dataWrapper.text1;
            text2  = dataWrapper.text2;
            text3  = dataWrapper.text3;
            text4  = dataWrapper.text4;
            text5  = dataWrapper.text5;
        }
        text1.setText(mList.get(position).getTest1());
        text2.setText(mList.get(position).getTest2());
        text3.setText(mList.get(position).getTest3());
        text4.setText(mList.get(position).getTest4());
        text5.setText(mList.get(position).getTest5());

        text1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, text1.getText() + "被选中", Toast.LENGTH_SHORT).show();
            }
        });
        text2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,text2.getText()+"被选中",Toast.LENGTH_SHORT).show();
            }
        });
        text3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,text3.getText()+"被选中",Toast.LENGTH_SHORT).show();
            }
        });
        text4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,text4.getText()+"被选中",Toast.LENGTH_SHORT).show();
            }
        });
        text5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,text5.getText()+"被选中",Toast.LENGTH_SHORT).show();
            }
        });


        return convertView;
    }
    public final class DataWrapper{
        public TextView text1;
        public TextView text2;
        public TextView text3;
        public TextView text4;
        public TextView text5;
        public DataWrapper(TextView text1,TextView text2,TextView text3,TextView text4,TextView text5)
        {
            this.text1 = text1;
            this.text2 = text2;
            this.text3 = text3;
            this.text4 = text4;
            this.text5 = text5;

        }

    }
}
