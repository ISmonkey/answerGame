package jp.co.headwaters.answer;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class StartLayout extends LinearLayout {


    
//    private final int MP = LinearLayout.LayoutParams.MATCH_PARENT;
    private final int WC = LinearLayout.LayoutParams.WRAP_CONTENT;

    public static Button btn;
    
    public StartLayout(Context context) {
        super(context);

        layout();
    }

    public void layout() {

        // 全体のレイアウト
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setBackgroundResource(R.drawable.background);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        addView(linearLayout);
        
        LayoutParams params = new LayoutParams(WC, WC);
        params.gravity = Gravity.CENTER_HORIZONTAL;
        
        TextView textView1 = new TextView(getContext());
        textView1.setTextSize(50);
        textView1.setTextColor(Color.BLACK);
        textView1.setText("あぷりのなまえ");
        textView1.setTypeface(StartActivity.face);
        linearLayout.addView(textView1, params);
        
        FrameLayout frameLayout = new FrameLayout(getContext());
        linearLayout.addView(frameLayout);
        
        ImageView imageView = new ImageView(getContext());
        imageView.setImageResource(R.drawable.item_name_back2);
        frameLayout.addView(imageView);
        
        TextView textView2 = new TextView(getContext());
        textView2.setGravity(Gravity.CENTER);
        textView2.setTextSize(30);
        textView2.setText("あそびかた\n正しかったら○　間違っていたら×");
        textView2.setTypeface(StartActivity.face);
        frameLayout.addView(textView2);
        
        btn = new Button(getContext());
        btn.setBackgroundResource(R.drawable.maru2);
        btn.setTypeface(StartActivity.face);
        btn.setText("すたーと");
        linearLayout.addView(btn, params);

        
        
    }
    
}
