package jp.co.headwaters.answer;

import android.content.Context;
import android.view.Gravity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class EndLayout extends LinearLayout {


    
//    private final int MP = LinearLayout.LayoutParams.MATCH_PARENT;
    private final int WC = LinearLayout.LayoutParams.WRAP_CONTENT;

    public static Button btn;
    
    public EndLayout(Context context) {
        super(context);

        layout();
    }

    public void layout() {

        // 全体のレイアウト
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setBackgroundResource(R.drawable.background);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        addView(linearLayout);
        
        LayoutParams param = new LayoutParams(WC, WC);
        param.gravity = Gravity.CENTER_HORIZONTAL;
        
        TextView textView = new TextView(getContext());
        textView.setTextSize(40);
        textView.setTypeface(StartActivity.face);
        textView.setText(String.valueOf(MainLayout.score) + "てん");
        linearLayout.addView(textView);
        
        btn = new Button(getContext());
        btn.setTypeface(StartActivity.face);
        btn.setText("とっぷぺーじ");
        linearLayout.addView(btn, param);

        
    }
    
}
