package wasu.com.eventbustest;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        EventBus.getDefault().register(this);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventBus.getDefault().post(new MessageEvent("SecondActivity setOnClickListener!!!"));
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.POSTING)
    public void onEventMainThread(MessageEvent event) {
        String msg = event.getMsg();
        Log.e("SecondActivity", msg);
    }
}
