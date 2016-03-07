package oleg.hubal.com.tm_homework07;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RelativeLayout item1, item2, item3;
    private Button btnSettings1, btnSettings2, btnSettings3;
    private TextView tvTittle1, tvTittle2, tvTittle3;
    private TextView tvText1, tvText2, tvText3;
    private String tittle, text;

    public static int whatItemEnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        setListeners();
        disableAllItems();
//        Проверяем было ли активно одно из полей
        checkEnableItem();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1_menu:
                enableItem1();
                whatItemEnable = 1;
                item.setIcon(R.drawable.ic_checked);
                return true;
            case R.id.item2_menu:
                enableItem2();
                whatItemEnable = 2;
                item.setIcon(R.drawable.ic_checked);
                return true;
            case R.id.item3_menu:
                enableItem3();
                whatItemEnable = 3;
                item.setIcon(R.drawable.ic_checked);
                return true;
            default: return false;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.first_item_button:
                tittle = tvTittle1.getText().toString();
                text = tvText1.getText().toString();
                break;
            case R.id.second_item_button:
                tittle = tvTittle2.getText().toString();
                text = tvText2.getText().toString();
                break;
            case R.id.third_item_button:
                tittle = tvTittle3.getText().toString();
                text = tvText3.getText().toString();
                break;
        }
//        Создаем попап
        PopupMenu popupMenu = new PopupMenu(this, v);
        popupMenu.inflate(R.menu.popup_menu);
//        Обрабатываем нажатие на попап меню
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.open_new_window:
                        openNewWindow();
                        return true;
                    case R.id.show_toast:
                        showToast();
                        return true;
                    case R.id.close_app:
                        finish();
                        return true;
                    default:
                        return false;
                }
            }
        });
        popupMenu.show();
    }

    private void openNewWindow() {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("tittle", tittle);
        intent.putExtra("text", text);
        startActivity(intent);
    }

    private void showToast() {
        Toast.makeText(this, tittle + "\n" + text, Toast.LENGTH_LONG).show();
    }

    private void checkEnableItem() {
        switch (whatItemEnable) {
            case 1:
                setAbleItem1(true);
                break;
            case 2:
                setAbleItem2(true);
                break;
            case 3:
                setAbleItem3(true);
                break;
        }
    }

    private void disableAllItems() {
        setAbleItem1(false);
        setAbleItem2(false);
        setAbleItem3(false);
    }

    private void setAbleItem1(boolean b) {
        item1.setEnabled(b);
        btnSettings1.setEnabled(b);
        tvText1.setEnabled(b);
        tvTittle1.setEnabled(b);
    }


    private void setAbleItem2(boolean b) {
        item2.setEnabled(b);
        btnSettings2.setEnabled(b);
        tvText2.setEnabled(b);
        tvTittle2.setEnabled(b);
    }


    private void setAbleItem3(boolean b) {
        item3.setEnabled(b);
        btnSettings3.setEnabled(b);
        tvText3.setEnabled(b);
        tvTittle3.setEnabled(b);
    }

    private void enableItem1() {
        disableAllItems();
        setAbleItem1(true);
    }


    private void enableItem2() {
        disableAllItems();
        setAbleItem2(true);
    }


    private void enableItem3() {
        disableAllItems();
        setAbleItem3(true);
    }


    private void findViews() {

        item1 = (RelativeLayout) findViewById(R.id.first_item_field);
        item2 = (RelativeLayout) findViewById(R.id.second_item_field);
        item3 = (RelativeLayout) findViewById(R.id.third_item_field);

        btnSettings1 = (Button) findViewById(R.id.first_item_button);
        btnSettings2 = (Button) findViewById(R.id.second_item_button);
        btnSettings3 = (Button) findViewById(R.id.third_item_button);

        tvTittle1 = (TextView) findViewById(R.id.first_item_tittle);
        tvTittle2 = (TextView) findViewById(R.id.second_item_tittle);
        tvTittle3 = (TextView) findViewById(R.id.third_item_tittle);

        tvText1 = (TextView) findViewById(R.id.first_item_text);
        tvText2 = (TextView) findViewById(R.id.second_item_text);
        tvText3 = (TextView) findViewById(R.id.third_item_text);
    }

    private void setListeners() {
        btnSettings1.setOnClickListener(this);
        btnSettings2.setOnClickListener(this);
        btnSettings3.setOnClickListener(this);
    }


}
