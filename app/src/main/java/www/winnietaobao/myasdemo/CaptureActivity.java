package www.winnietaobao.myasdemo;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.app.Activity;
import android.os.Handler;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import www.winnietaobao.myasdemo.util.DateUtil;
import www.winnietaobao.myasdemo.util.Utils;


public class CaptureActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener{

    private TextView tv_capture;
    private ImageView iv_capture;
    private String[] mChatStr = {"你吃饭了吗？", "今天天气真好呀。",
            "我中奖啦！", "我们去看电影吧。", "晚上干什么好呢？"};
    private Handler mHandler = new Handler(); // 声明一个任务处理器

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capture);

        tv_capture = (TextView) findViewById(R.id.tv_capture);
//        tv_capture.setMaxWidth(Utils.getScreenWidth(this)/2);
//        tv_capture.setMinWidth(Utils.getScreenWidth(this)/2);
//        tv_capture.setMaxHeight(Utils.getScreenHeight(this)/2);
//        tv_capture.setMinHeight(Utils.getScreenHeight(this)/2);
        tv_capture.getLayoutParams().width = Utils.getScreenWidth(this)/2;
        tv_capture.getLayoutParams().height = Utils.getScreenHeight(this)/2;

        iv_capture = (ImageView) findViewById(R.id.iv_capture);
//        iv_capture.setMaxWidth(Utils.getScreenWidth(this)/2);
//        iv_capture.setMinimumWidth(Utils.getScreenWidth(this)/2);
//        iv_capture.setMaxHeight(Utils.getScreenHeight(this)/2);
//        iv_capture.setMinimumHeight(Utils.getScreenHeight(this)/2);
        iv_capture.getLayoutParams().width = Utils.getScreenWidth(this)/2;
        iv_capture.getLayoutParams().height = Utils.getScreenHeight(this)/2;

        findViewById(R.id.btn_chat).setOnClickListener(this);
        findViewById(R.id.btn_chat).setOnLongClickListener(this);
        findViewById(R.id.btn_capture).setOnClickListener(this);
    }

    @Override
    public boolean onLongClick(View view) {
        boolean b_return = false;
        switch (view.getId()) {
            case R.id.btn_chat:
                tv_capture.setText("");
                b_return = true;
                break;
            case R.id.btn_capture:
                b_return = false;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + view.getId());
        }
        return b_return;
    }

    @Override
    // 一旦监听到点击动作，就触发监听器的onClick方法
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_chat:         // 点击了聊天按钮，则给文本视图添加聊天文字
                int random = (int) (Math.random() * 10) % 5;
                // 下面的DateUtil参见本书附录源码中的DateUtil.java
                String newStr = String.format("%s\n%s %s",
                        tv_capture.getText().toString(), DateUtil.getNowTime(), mChatStr[random]);
                tv_capture.setText(newStr);
                break;
            case R.id.btn_capture:      // 点击了截图按钮，则将截图信息显示在图像视图上
                // 从文本视图tv_capture的绘图缓存中获取位图对象
                tv_capture.destroyDrawingCache();
                tv_capture.setDrawingCacheEnabled(true);
                Bitmap bitmap = tv_capture.getDrawingCache();
                // 给图像视图iv_capture设置位图对象
                iv_capture.setImageBitmap(bitmap);
                // 注意这里在截图完毕后不能马上关闭绘图缓存，因为画面渲染需要时间，
                // 如果立即关闭缓存，渲染画面就会找不到位图对象，会报错：
                // “java.lang.IllegalArgumentException: Cannot draw recycled bitmaps”。
                // 所以要等界面渲染完成后再关闭绘图缓存，下面的做法是延迟200毫秒再关闭
                mHandler.postDelayed(mResetCache, 200);
                break;
        }
    }

    private Runnable mResetCache = new Runnable() {
        @Override
        public void run() {
            // 关闭文本视图tv_capture的绘图缓存
            tv_capture.setDrawingCacheEnabled(false);
            // 开启文本视图tv_capture的绘图缓存
            tv_capture.setDrawingCacheEnabled(true);
        }
    };


}
