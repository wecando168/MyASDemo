package www.winnietaobao.myasdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_marquee).setOnClickListener(this);
        findViewById(R.id.btn_bbs).setOnClickListener(this);
        findViewById(R.id.btn_mylintener).setOnClickListener(this);
        findViewById(R.id.btn_scale).setOnClickListener(this);
        findViewById(R.id.btn_show_capture).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
        findViewById(R.id.btn_test_procedure).setOnClickListener(this);

        /*findViewById(R.id.btn_px).setOnClickListener(this);
        findViewById(R.id.btn_color).setOnClickListener(this);
        findViewById(R.id.btn_screen).setOnClickListener(this);
        findViewById(R.id.btn_margin).setOnClickListener(this);
        findViewById(R.id.btn_gravity).setOnClickListener(this);
        findViewById(R.id.btn_scroll).setOnClickListener(this);
        findViewById(R.id.btn_click).setOnClickListener(this);
        findViewById(R.id.btn_capture).setOnClickListener(this);
        findViewById(R.id.btn_icon).setOnClickListener(this);
        findViewById(R.id.btn_state).setOnClickListener(this);
        findViewById(R.id.btn_shape).setOnClickListener(this);
        findViewById(R.id.btn_nine).setOnClickListener(this);
        findViewById(R.id.btn_calculator).setOnClickListener(this);*/
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch (view.getId()) {
            case R.id.btn_marquee:
                intent = new Intent(this, MarqueeActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_bbs:
                intent = new Intent(this, BbsActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_mylintener:
                intent = new Intent(this, MylintenerActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_scale:
                intent = new Intent(this, ScaleActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_show_capture:
                intent = new Intent(this, CaptureActivity.class);
                startActivity(intent);
                break;
            case R.id.button3:
                intent = new Intent(this, ScaleActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_test_procedure:
                intent = new Intent(this, TestProcedureActivity.class);
                startActivity(intent);
                break;

        }
    }
}
