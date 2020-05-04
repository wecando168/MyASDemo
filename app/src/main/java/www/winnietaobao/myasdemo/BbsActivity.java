package www.winnietaobao.myasdemo;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import www.winnietaobao.myasdemo.util.DateUtil;

public class BbsActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener{
    private TextView tv_bbs_title; // 声明一个文本视图对象
    private TextView tv_bbs; // 声明一个文本视图对象

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bbs);
        // 从布局文件中获取名叫tv_bbs_title的文本视图
        tv_bbs_title = findViewById(R.id.tv_bbs);
        // 给tv_bbs_title设置点击监听器
        tv_bbs_title.setOnClickListener(this);
        // 给tv_bbs_title设置长按监听器
        tv_bbs_title.setOnLongClickListener(this);

        // 从布局文件中获取名叫tv_bbs的文本视图
        tv_bbs = findViewById(R.id.tv_bbs);
        // 给tv_bbs设置点击监听器
        tv_bbs.setOnClickListener(this);
        // 给tv_bbs设置长按监听器
        tv_bbs.setOnLongClickListener(this);

        tv_bbs.setText("");
        tv_bbs.setLines(20);                                         // 设置tv_bbs高度为八行文字那么高
        tv_bbs.setMaxLines(20);                                      // 设置tv_bbs最多显示八行文字
        tv_bbs.setGravity(Gravity.LEFT | Gravity.BOTTOM);           // 设置tv_bbs内部文字的对齐方式为靠左且靠下
        tv_bbs.setMovementMethod(new ScrollingMovementMethod());    // 设置tv_bbs内部文本的移动方式为滚动形式
    }

    private String[] mChatStr = {"你吃饭了吗？", "今天天气真好呀。",
            "我中奖啦！", "我们去看电影吧", "晚上干什么好呢？",};

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.tv_bbs_title || v.getId() == R.id.tv_bbs) {
            // 生成一个0到4之间的随机数
            int random = (int) (Math.random() * 10) % 5;
            // 拼接聊天的文本内容
            String newStr = String.format("%s\n%s %s",
                    tv_bbs.getText().toString(), DateUtil.getNowTime(), mChatStr[random]);
            // 设置文本视图tv_bbs的文本内容
            tv_bbs.setText(newStr);
        }
    }

    @Override
    public boolean onLongClick(View v) {
        if (v.getId() == R.id.tv_bbs_title || v.getId() == R.id.tv_bbs) {
            tv_bbs.setText("");
        }
        return true;
    }
}
