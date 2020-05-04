package www.winnietaobao.myasdemo;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class TestProcedureActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView ivScale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_procedure);

        ivScale = (ImageView) findViewById(R.id.iv_scale);
    }


    @Override
    public void onClick(View v) {

    }
}
