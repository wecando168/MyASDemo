package www.winnietaobao.myasdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MylintenerActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mylistener);

        Button btn_left = (Button)findViewById(R.id.btn_left);
        btn_left.setOnClickListener(new MyOnClickListener());
        btn_left.setOnLongClickListener(new MyOnLongClickListener());

        Button btn_right = (Button)findViewById(R.id.btn_right);
        btn_right.setOnClickListener(new MyOnClickListener());
        btn_right.setOnLongClickListener(new MyOnLongClickListener());
    }

    private class MyOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            if(v.getId() == R.id.btn_left | v.getId() == R.id.btn_right ){
                Toast.makeText(MylintenerActivity.this,"您点击了控件：" + ((TextView)v).getText(),Toast.LENGTH_SHORT).show();
                //Toast.makeText("监听提示","您点击了控件：" + ((TextView)v).getText(),Toast.LENGTH_SHORT,@in).show();
            }
        }
    }

    private class MyOnLongClickListener implements View.OnLongClickListener {
        @Override
        public boolean onLongClick(View v) {
            if(v.getId() == R.id.btn_left | v.getId() == R.id.btn_right ){
                Toast.makeText(MylintenerActivity.this,"您点击了控件：" + ((TextView)v).getText(),Toast.LENGTH_SHORT).show();
            }
            return true;
        }
    }
}
