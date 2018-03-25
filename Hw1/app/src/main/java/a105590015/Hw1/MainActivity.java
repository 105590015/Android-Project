package a105590015.Hw1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText mEdtSex, mEdtAge;
    private Button mBtnOK;
    private TextView mTxtR;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEdtSex = (EditText) findViewById(R.id.edtSex);
        mEdtAge = (EditText) findViewById(R.id.edtAge);
        mBtnOK = (Button) findViewById(R.id.btnOK);
        mTxtR = (TextView) findViewById(R.id.txtR);
        mBtnOK.setOnClickListener(btnOKOnClick);
    }

    private View.OnClickListener btnOKOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String stSex=mEdtSex.getText().toString();
            int iAge=Integer.parseInt(mEdtAge.getText().toString());
            String stSug=getString(R.string.suggest);

            if(stSex.equals(getString(R.string.male)))
            {
                if(iAge<30)
                    stSug+=getString(R.string.sug_not_hurry);
                else if(iAge<=35)
                    stSug+=getString(R.string.sug_get_marry);
                else
                    stSug+=getString(R.string.sug_find_couple);
            }
            else if(stSex.equals(getString(R.string.female)))
            {
                if(iAge<28)
                    stSug+=getString(R.string.sug_not_hurry);
                else if(iAge<=32)
                    stSug+=getString(R.string.sug_get_marry);
                else
                    stSug+=getString(R.string.sug_find_couple);
            }
            mTxtR.setText(stSug);
        }
    };
}

