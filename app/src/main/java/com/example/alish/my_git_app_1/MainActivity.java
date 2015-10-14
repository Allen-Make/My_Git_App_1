package com.example.alish.my_git_app_1;

import com.example.alish.user.User;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private ImageView[] img = new ImageView[4];//生命一个保存ImageView组件的数组
    private int[] imagePath = new int[]{
            R.drawable.img01,R.drawable.img02,R.drawable.img03,R.drawable.img04
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Log.d("Mydebug", "(1)onCreate");
        Toast.makeText(MainActivity.this, "MyToast", Toast.LENGTH_LONG).show();

        /*
        GradientDrawable drawable_button = new GradientDrawable();
        drawable_button.setShape(GradientDrawable.RECTANGLE);//画框
        drawable_button.setStroke(1, Color.BLACK);
        drawable_button.setColor(0x22fff00);

        Button button1 = (Button)findViewById(R.id.button1);
        button1.setBackgroundDrawable(drawable_button);
        Button button2 = (Button)findViewById(R.id.button2);
        button2.setBackgroundDrawable(drawable_button);
        */
        /*
        setContentView(R.layout.main);
        LinearLayout layout = (LinearLayout)findViewById(R.id.layout);//获取xml文件中定义的线性布局管理器
        for (int i = 0;i < imagePath.length;i++){
            img[i] = new ImageView(this);//创建一个ImageViem组件
            img[i].setImageResource(imagePath[i]);//为ImageView组件指定要显示的图片
            img[i].setPadding(5, 5, 5, 5);//设置ImageView组件的内边距
            ActionBar.LayoutParams params = new ActionBar.LayoutParams(253,148);//设置图片的宽度和高度
            img[i].setLayoutParams(params);//为ImageView组件设置布局参数
            layout.addView(img[i]);//将ImageView组件添加到布局管理器中
        }*/
    }


    //可视生命周期开始时被调用，对用户界面进行必要的更改
    @Override
    protected void onStart(){
        super.onStart();
        Log.e("Mydebug", "(2)onStart");
        final User person1 = new User();//定义一个person,用来存储用户的名字
        final Button button1 = (Button)findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText user = (EditText) findViewById(R.id.editText);
                person1.Name = user.getText().toString();
                if (person1.Name.equals("")){//如果输入的用户名为空
                    new AlertDialog.Builder(MainActivity.this).setTitle("请补充以下内容").setMessage("用户名不能为空，请完善").setPositiveButton("确定", null).show();
                } else {
                    Intent intent = new Intent(MainActivity.this, UserActivity.class);//从当前的activity跳转到useractivity
                    Bundle bundle = new Bundle();
                    bundle.putCharSequence("userStr", person1.Name);
                    intent.putExtras(bundle);
                    startActivity(intent);//用intent实现跳转
                }
            }
        });
    }

    //在onStart()后被调用，用于恢复onSaveInstaceState()保存的用户界面
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        Log.e("Mydebug", "(3)onRestoreInstanceState");
    }

    //在活动生命周期开始时被调用，恢复被Onpause()停止的用于界面更新的资源
    @Override
    protected void onResume(){
        super.onResume();
        Log.e("Mydebug", "(4)onResume");
    }
    //保存界面临时信息
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        Log.e("Mydebug","(5)onSaveInstanceState");
    }


    //重新进入可是生命周期前被调用，载入界面所需的更改信息
    @Override
    protected void onRestart(){
        super.onRestart();
        Log.e("Mydebug","(6)onRestart");
    }
    //在活动生命周期借宿时被调用，用来保存持久的数据或释放占用的资源
    @Override
    protected void onPause(){
        super.onPause();
        Log.e("Mydebug", "(7)onPause");
    }
    //在可视生命周期结束时被调用，用来释放占用的资源
    @Override
    protected void onStop(){
        super.onStop();
        Log.e("Mydebug","(8)onStop");
    }


    //释放资源，包括线程，数据连接等；
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.e("Mydebug","(9)onDestroy");
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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


    public void sure(View v){
        EditText editText = (EditText) findViewById(R.id.editText);
        editText.setText("");
        EditText editText2 = (EditText) findViewById(R.id.editText2);
        editText2.setText("");
        finish();
 /*        Intent intent = new Intent(this,SignActivity.class);//可以在不同的active之间传递信息
        startActivity(intent);*/


    }
}
