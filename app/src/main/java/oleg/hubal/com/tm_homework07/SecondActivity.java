package oleg.hubal.com.tm_homework07;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by User on 07.03.2016.
 */
public class SecondActivity extends AppCompatActivity {

    TextView tvTittle, tvText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvTittle = (TextView) findViewById(R.id.as_tv_tittle);
        tvText = (TextView) findViewById(R.id.as_tv_text);

        tvTittle.setText(getIntent().getStringExtra("tittle"));
        tvText.setText(getIntent().getStringExtra("text"));
    }
}
