package com.example.alish.my_git_app_1;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.alish.Forum.ForumAdapter;
import com.example.alish.Forum.forum;

import java.util.ArrayList;
import java.util.List;

public class ForumActivity extends AppCompatActivity {

    TextView textContext;
    ListView lv1;
    final static int MENU_00 = Menu.FIRST;
    final static int MENU_01 = Menu.FIRST+1;
    final static int MENU_02 = Menu.FIRST+2;
    final static int MENU_03 = Menu.FIRST+3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum);

        ListView listView  = (ListView)findViewById(R.id.listV1);
        final List<forum> listForum = new ArrayList<forum>();
        listForum.add(new forum("论坛1", "aaa", "290", "2014-9-15", "2015-10-28"));
        listForum.add(new forum("论坛2", "aaa", "290", "2014-9-15", "2015-10-28"));
        listForum.add(new forum("论坛3", "aaa", "290", "2014-9-15", "2015-10-28"));
        listForum.add(new forum("论坛4", "aaa", "290", "2014-9-15", "2015-10-28"));
        listForum.add(new forum("论坛5", "aaa", "290", "2014-9-15", "2015-10-28"));

        ForumAdapter forumAdapter = new ForumAdapter(this,listForum);
        listView.setAdapter(forumAdapter);
       listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ForumActivity.this,"Item被选中", Toast.LENGTH_SHORT).show();

            }
        });
        lv1 = (ListView)findViewById(R.id.listV1);//如果注册list_item_forum中的Textview的话就不行，会出现空指针异常
        registerForContextMenu(lv1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_forum, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch(id)
        {
            case R.id.action_settings:
                Toast.makeText(this,"menu1",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_settings2:
                Toast.makeText(this,"menu2",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.sub_1:
                Toast.makeText(this,"选中所有的",Toast.LENGTH_SHORT).show();
                return true;

            default:
                return false;
        }

    }
    @Override
    public boolean onContextItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case MENU_00:
                textContext.setText("复制");
                return true;
            case MENU_01:
                textContext.setText("赞");
                return true;
            case MENU_02:
                textContext.setText("参与");
                return true;
            case MENU_03:
                textContext.setText("举报");
                return true;
        }
        return false;
    }
    @Override
        public void onCreateContextMenu(ContextMenu menu,View v,ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu,v,menuInfo);
        menu.setHeaderTitle("快捷菜单");
        menu.add(0, MENU_00, 0, "复制");
        menu.add(0,MENU_01,1,"赞");
        menu.add(0,MENU_02,2,"参与");
        menu.add(0,MENU_03,3,"举报");
        }

}
