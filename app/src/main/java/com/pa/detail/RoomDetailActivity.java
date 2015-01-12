package com.pa.detail;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.pa.R;
import com.pa.detail.controller.RoomDetailController;

/**
 * @author : wallace leung
 * @email  : wallaceleung@163.com
 * @date   : 2015/1/12
 * @desc   :
 */
public class RoomDetailActivity extends Activity {
    private RoomDetailController roomDetailController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_detail);

        roomDetailController = new RoomDetailController(this);

        roomDetailController.setLayout(findViewById(R.id.detail_room_list));
        roomDetailController.bindAction();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
