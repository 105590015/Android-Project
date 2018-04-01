package a105590015.hw4_2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTxtComPlay, mTxtResult;
    private Button mBtnScissors, mBtnStone, mBtnPaper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTxtComPlay = (TextView)findViewById(R.id.txtComPlay);
        mTxtResult = (TextView)findViewById(R.id.txtResult);
        mBtnScissors = (Button)findViewById(R.id.btnScissors);
        mBtnStone = (Button)findViewById(R.id.btnStone);
        mBtnPaper = (Button)findViewById(R.id.btnPaper);

        mBtnScissors.setOnClickListener(btnScissorsOnClick);
        mBtnStone.setOnClickListener(btnStoneOnClick);
        mBtnPaper.setOnClickListener(btnPaperOnClick);
    }

    private View.OnClickListener btnScissorsOnClick = new View.OnClickListener() {
        public void onClick(View v) {
            ComputerPlay result=new ComputerPlay();
            int iComPlay = (int)(Math.random()*3 + 1);
            String play=result.getPlay(1, iComPlay);
            if (play=="贏") {
                mTxtComPlay.setText(R.string.play_paper);
                mTxtResult.setText(getString(R.string.result) + getString(R.string.player_win));
            }
            else if (play=="輸") {
                mTxtComPlay.setText(R.string.play_stone);
                mTxtResult.setText(getString(R.string.result) + getString(R.string.player_lose));
            }
            else {
                mTxtComPlay.setText(R.string.play_scissors);
                mTxtResult.setText(getString(R.string.result) + getString(R.string.player_draw));
            }
        }
    };

    private View.OnClickListener btnStoneOnClick = new View.OnClickListener() {
        public void onClick(View v) {
            ComputerPlay result=new ComputerPlay();
            int iComPlay = (int)(Math.random()*3 + 1);
            String play=result.getPlay(2, iComPlay);
            if (play=="贏") {
                mTxtComPlay.setText(R.string.play_scissors);
                mTxtResult.setText(getString(R.string.result) + getString(R.string.player_win));
            }
            else if (play=="輸") {
                mTxtComPlay.setText(R.string.play_paper);
                mTxtResult.setText(getString(R.string.result) + getString(R.string.player_lose));
            }
            else {
                mTxtComPlay.setText(R.string.play_stone);
                mTxtResult.setText(getString(R.string.result) + getString(R.string.player_draw));
            }
        }
    };

    private View.OnClickListener btnPaperOnClick = new View.OnClickListener() {
        public void onClick(View v) {
            ComputerPlay result=new ComputerPlay();
            int iComPlay = (int)(Math.random()*3 + 1);
            String play=result.getPlay(3, iComPlay);
            if (play=="贏") {
                mTxtComPlay.setText(R.string.play_stone);
                mTxtResult.setText(getString(R.string.result) + getString(R.string.player_win));
            }
            else if (play=="輸") {
                mTxtComPlay.setText(R.string.play_scissors);
                mTxtResult.setText(getString(R.string.result) + getString(R.string.player_lose));
            }
            else {
                mTxtComPlay.setText(R.string.play_paper);
                mTxtResult.setText(getString(R.string.result) + getString(R.string.player_draw));
            }
        }
    };
}
