package jp.co.headwaters.answer;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;


public class MainActivity extends Activity {

    private CountDownTimer cdt;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MainLayout mainLayout = new MainLayout(this);

        setContentView(mainLayout);
        setTimer();
    }
    
    public void setTimer() {
        if (null != cdt) {
            cdt.cancel();
        }
        cdt = new CountDownTimer(15000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                MainLayout.timer1.setText(String.valueOf(millisUntilFinished / 1000));
            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(MainActivity.this, EndActivity.class);
                startActivity(intent);
                finish();
            }
        };
        cdt.start();
    }
    
}
