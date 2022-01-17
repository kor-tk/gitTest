package kim.score_kim;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class StartActivity extends AppCompatActivity {

    Handler handler;
    private static String TAG = "startActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        handler = new Handler() {    // 수 초후 작동하게
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                Intent selectIntent = new Intent(StartActivity.this, SelectActivity.class);  // 5초 후 로그인 화면으로...
                StartActivity.this.startActivity(selectIntent);


                // 2019.11.15 수정 부드럽게 화면 전환 관련  startActivity()나 finish() 메소드 뒤에 넣어줘야 동작한다.
                overridePendingTransition(R.anim.fadein, R.anim.fadeout);
            }
        };

        handler.sendEmptyMessageDelayed(0, 1000);

    }

    @Override
    public void onPause()
    {
        super.onPause();
        Log.i(TAG, "onPause() 호출");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy() 호출");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG, "onDestroy() 호출");
    }

    @Override
    public void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart() 호출");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG, "onStart() 호출");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG, "onStop() 호출");
    }
}