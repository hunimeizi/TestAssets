package xlistviewtest.lyb.com.testassets;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;


public class TestAssets extends ActionBarActivity {

    private Button butt, button, button2, button3, button4;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_assets);
        initView();
    }

    private void initView() {
        butt = (Button) findViewById(R.id.butt);
        butt.setOnClickListener(new myOnclick());
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new myOnclick());
        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new myOnclick());
        tv = (TextView) findViewById(R.id.tv);
    }

    private void assetsGet(String muLu) {
        try {
            String[] files = getAssets().list(muLu);
            StringBuffer sb = new StringBuffer();
            for (String s : files) {
                sb.append(s + "，");
            }
                tv.setText(sb);
        } catch (IOException e) {
            Log.e("tag", e.getMessage());
        }
    }

    private class myOnclick implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.butt://点击获取子文件为空时进行遍历
                    //获取得到的值为  guobi,images , model, sounds,te,webkit 除te外其他为默认目录
                    assetsGet("");
                    break;
                case R.id.button://子目录下添加 包 图片 以及 。bat文件等 进行遍历
                    //获取得到的为 11.jpg, homeData.dat, tt
                    assetsGet("te");
                    break;
                case R.id.button2://（tt为te的子目录）子目录下添加的文件夹中添加 图片 。data 进行遍历
                    //获取得到的为 11.jpg, ab.jpg, homeData.dat
                    assetsGet("te/tt");
                    break;
            }
        }
    }

}
