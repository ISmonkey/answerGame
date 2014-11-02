package jp.co.headwaters.answer;

import android.R.color;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainLayout extends LinearLayout {

//    private final int MP = LinearLayout.LayoutParams.MATCH_PARENT;
    private final int WC = LinearLayout.LayoutParams.WRAP_CONTENT;

    public static ImageView[] itemList;
    public static TextView[] itemName; 
    
    public static Button btnOk;
    public static Button btnNg;

    public static LinearLayout listLayout;
    public TextView scoreText;
    public TextView scoreText2;
    public static TextView timer1;
    public TextView timer2;
    public  int itemImageNumber;
    public  int itemNameNumber;
    
    public static int score;
    public static int timer;
    private LinearLayout linearLayout2;
    private FrameLayout frameLayout;
    private FrameLayout itemNameLayout;
    
    // private CountDownTimer cdt;

    public MainLayout(Context context) {
        super(context);
        score = 0;
        itemImageNumber = (int) Math.floor(Math.random() * 8);
        itemNameNumber = (int) Math.floor(Math.random() * 4);

        layout();
    }

    public void layout() {

        itemList = new ImageView[8];
        itemName = new TextView[4];
        
        // 全体のレイアウト
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setBackgroundResource(R.drawable.background);
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        addView(linearLayout);
        
        LayoutParams paramsex = new LayoutParams(WC, WC);
        paramsex.gravity = Gravity.CENTER_HORIZONTAL;
        
        //タイマー・得点
        LinearLayout linearLayout1 = new LinearLayout(getContext());
        linearLayout1.setOrientation(LinearLayout.HORIZONTAL);
        linearLayout1.setHorizontalGravity(Gravity.CENTER);
        linearLayout.addView(linearLayout1);
        
        scoreText = new TextView(getContext());
        scoreText.setTypeface(StartActivity.face);
        scoreText.setTextSize(45);
        scoreText.setText(String.valueOf(score));
        linearLayout1.addView(scoreText);

        scoreText2 = new TextView(getContext());
        scoreText2.setTypeface(StartActivity.face);
        scoreText2.setTextSize(35);
        scoreText2.setText(String.valueOf("てん　　"));
        linearLayout1.addView(scoreText2);
        
        ImageView timerImage = new ImageView(getContext());
        timerImage.setImageResource(R.drawable.timer);
        linearLayout1.addView(timerImage);

        timer1 = new TextView(getContext());
        timer1.setTypeface(StartActivity.face);
        timer1.setTextSize(45);
        timer1.setText("30びょう");
        linearLayout1.addView(timer1);

        timer2 = new TextView(getContext());
        timer2.setTypeface(StartActivity.face);
        timer2.setTextSize(35);
        timer2.setText("びょう");
        linearLayout1.addView(timer2);
        
        //アイテム
        linearLayout2 = new LinearLayout(getContext());
        linearLayout2.setOrientation(LinearLayout.HORIZONTAL);
        linearLayout2.setHorizontalGravity(Gravity.CENTER);
        linearLayout.addView(linearLayout2);
        
        frameLayout = new FrameLayout(getContext());
        linearLayout2.addView(frameLayout);
        
        ImageView itemBack = new ImageView(getContext());
        itemBack.setImageResource(R.drawable.item_back_2);
        frameLayout.addView(itemBack);
        
        itemList[0] = new ImageView(getContext());
        itemList[0].setImageResource(R.drawable.banana);
        
        itemList[1] = new ImageView(getContext());
        itemList[1].setImageResource(R.drawable.applebig);
        
        itemList[2] = new ImageView(getContext());
        itemList[2].setImageResource(R.drawable.pineapple);
        
        itemList[3] = new ImageView(getContext());
        itemList[3].setImageResource(R.drawable.strawberrybig_black);
        
        itemList[4] = new ImageView(getContext());
        itemList[4].setImageResource(R.drawable.banana_black);
        
        itemList[5] = new ImageView(getContext());
        itemList[5].setImageResource(R.drawable.applebig_black);
        
        itemList[6] = new ImageView(getContext());
        itemList[6].setImageResource(R.drawable.pineapple_black);
        
        itemList[7] = new ImageView(getContext());
        itemList[7].setImageResource(R.drawable.strawberrybig_black);
        
        frameLayout.addView(itemList[itemImageNumber]);

        itemNameLayout = new FrameLayout(getContext());
        itemNameLayout.setBackgroundColor(color.darker_gray);
        linearLayout2.addView(itemNameLayout);
        
        ImageView itemNameBack = new ImageView(getContext());
        itemNameBack.setImageResource(R.drawable.item_name_back);
        itemNameLayout.addView(itemNameBack);
        
        itemName[0] = new TextView(getContext());
        itemName[0].setText("ばなな");
        
        itemName[1] = new TextView(getContext());
        itemName[1].setText("りんご");
        
        itemName[2] = new TextView(getContext());
        itemName[2].setText("ぱいなっぷる");
        
        itemName[3] = new TextView(getContext());
        itemName[3].setText("いちご");
        
        itemName[itemNameNumber].setTypeface(StartActivity.face);
        itemName[itemNameNumber].setTextSize(35);
        itemName[itemNameNumber].setGravity(Gravity.CENTER);
        itemNameLayout.addView(itemName[itemNameNumber]);

        //ボタン
        LinearLayout linearLayout3 = new LinearLayout(getContext());
        linearLayout3.setOrientation(LinearLayout.HORIZONTAL);
        linearLayout3.setHorizontalGravity(Gravity.CENTER);
        linearLayout.addView(linearLayout3);

        ImageView btnOk = new ImageView(getContext());
        btnOk.setImageResource(R.drawable.btn_ok2);
        btnOk.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(itemImageNumber == itemNameNumber || itemImageNumber == itemNameNumber+4){
                    frameLayout.removeView(itemList[itemImageNumber]);
                    itemNameLayout.removeView(itemName[itemNameNumber]);

                    itemImageNumber = (int) Math.floor(Math.random() * 8);
                    itemNameNumber = (int) Math.floor(Math.random() * 4);

                    itemName[itemNameNumber].setTypeface(StartActivity.face);
                    itemName[itemNameNumber].setTextSize(35);
                    itemName[itemNameNumber].setGravity(Gravity.CENTER);
                    frameLayout.addView(itemList[itemImageNumber]);
                    itemNameLayout.addView(itemName[itemNameNumber]);
                    score = score+10;
                    scoreText.setText(String.valueOf(score));
                }else{
                    score = score-10;
                    scoreText.setText(String.valueOf(score));
                }
            }
        });
        linearLayout3.addView(btnOk);

        ImageView btnNg = new ImageView(getContext());
        btnNg.setImageResource(R.drawable.btn_ng2);
        btnNg.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(itemImageNumber == itemNameNumber || itemImageNumber == itemNameNumber+4){
                    score = score-10;
                    scoreText.setText(String.valueOf(score));
                }else{
                    frameLayout.removeView(itemList[itemImageNumber]);
                    itemNameLayout.removeView(itemName[itemNameNumber]);
                    
                    itemImageNumber = (int) Math.floor(Math.random() * 8);
                    itemNameNumber = (int) Math.floor(Math.random() * 4);

                    itemName[itemNameNumber].setTypeface(StartActivity.face);
                    itemName[itemNameNumber].setTextSize(35);
                    itemName[itemNameNumber].setGravity(Gravity.CENTER);
                    frameLayout.addView(itemList[itemImageNumber]);
                    itemNameLayout.addView(itemName[itemNameNumber]);
                    score = score+10;
                    scoreText.setText(String.valueOf(score));
                }
            }
        });
        linearLayout3.addView(btnNg);
    }
    
}
