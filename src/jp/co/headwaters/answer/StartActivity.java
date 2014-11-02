package jp.co.headwaters.answer;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;



public class StartActivity extends Activity {
    
    public static Typeface face;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //font
        face = Typeface.createFromAsset(getBaseContext().getAssets(),
                "font/hanazome.ttf");
        StartLayout startLayout = new StartLayout(this);
        setContentView(startLayout);
        
        StartLayout.btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
