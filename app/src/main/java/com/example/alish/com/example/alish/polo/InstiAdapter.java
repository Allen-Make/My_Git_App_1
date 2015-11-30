package com.example.alish.com.example.alish.polo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.alish.com.examps.Instituton;
import com.example.alish.my_git_app_1.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alish on 2015/10/23.
 */
public class InstiAdapter extends BaseAdapter{


    private List<Instituton> mList = new ArrayList<Instituton>();
    private Context mContext;
    private LayoutInflater inflater;



    public  InstiAdapter(Context pContext,List<Instituton> pList){
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

        TextView university;
        TextView school;
        TextView major;
        if(convertView == null)
        {
            convertView = inflater.inflate(R.layout.spin2_item,null);
            university = (TextView)convertView.findViewById(R.id.spin2_tv_1);
            school     = (TextView)convertView.findViewById(R.id.spin2_tv_2);
            major      = (TextView)convertView.findViewById(R.id.spin2_tv_3);

            dataWrapper = new DataWrapper(university,major,school);
            convertView.setTag(dataWrapper);
        }else{
            dataWrapper = (DataWrapper)convertView.getTag();
            university  = dataWrapper.university;
            school      = dataWrapper.school;
            major       = dataWrapper.major;
        }
        university.setText(mList.get(position).getUniversioty());
        school.setText(mList.get(position).getSchool());
        major.setText(mList.get(position).getMajor());
        return convertView;
    }
    public final class DataWrapper{
        public TextView university;
        public TextView school;
        public TextView major;
        public DataWrapper(TextView university,TextView school,TextView major)
        {
            this.university = university;
            this.school = school;
            this.major = major;
        }

    }
}
