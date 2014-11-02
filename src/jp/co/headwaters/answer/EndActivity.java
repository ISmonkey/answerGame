package jp.co.headwaters.answer;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;


public class EndActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EndLayout endLayout = new EndLayout(this);

        setContentView(endLayout);
        
        EndLayout.btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EndActivity.this, StartActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
