package com.example.alish.my_git_app_1;

import com.example.alish.user.User;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UserActivity extends AppCompatActivity {
    User person2 = new User();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        Log.d("Mydebug", "(1_User)onCreate_User");



        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        person2.Name = bundle.getString("userStr");
        if(person2.Name .equals(""))
        {
            person2.Name  = "请问你是无名氏吗?";
        }


        TextView TextView_User_Name = (TextView)findViewById(R.id.textView_Username_1);
        TextView_User_Name.setText(person2.Name);
    }



    //可视生命周期开始时被调用，对用户界面进行必要的更改
    @Override
    protected void onStart(){
        super.onStart();
        Log.e("Mydebug", "(2_User)onStart_User");
        //监听返回按钮
        final Button button_back = (Button)findViewById(R.id.button_Back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();

            }
        });
        //监听取消按钮
//        final  Button button_cancel = (Button)findViewById(R.id.button_Cancel);
//        button_cancel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                android.os.Process.killProcess(android.os.Process.myPid());
////                System.exit(0);
//                finish();
//            }
//        });
    }

    //在onStart()后被调用，用于恢复onSaveInstaceState()保存的用户界面
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        Log.e("Mydebug", "(3_User)onRestoreInstanceState");
    }

    //在活动生命周期开始时被调用，恢复被Onpause()停止的用于界面更新的资源
    @Override
    protected void onResume(){
        super.onResume();
        Log.e("Mydebug", "(4_User)onResume_User");
    }
    //保存界面临时信息
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        Log.e("Mydebug","(5_User)onSaveInstanceState_User");
    }


    //重新进入可是生命周期前被调用，载入界面所需的更改信息
    @Override
    protected void onRestart(){
        super.onRestart();
        Log.e("Mydebug","(6_User)onRestart_User");
    }
    //在活动生命周期借宿时被调用，用来保存持久的数据或释放占用的资源
    @Override
    protected void onPause(){
        super.onPause();
        Log.e("Mydebug","(7_User)onPause_User");
    }
    //在可视生命周期结束时被调用，用来释放占用的资源
    @Override
    protected void onStop(){
        super.onStop();
        Log.e("Mydebug","(8_User)onStop_User");
    }


    //释放资源，包括线程，数据连接等；
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.e("Mydebug", "(9_User)onDestroy_User");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_user, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
