package a105590015.hw4_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private RadioGroup mRadGrp;
    private RadioButton mRadBtnMale;
    private RadioButton mRadBtnFemale;
    private Spinner mSpnAge;
    private CheckBox mChe1;
    private CheckBox mChe2;
    private CheckBox mChe3;
    private CheckBox mChe4;
    private CheckBox mChe5;
    private CheckBox mChe6;
    private CheckBox mChe7;
    private CheckBox mChe8;
    private CheckBox mChe9;
    private CheckBox mChe10;
    private Button mBtnOK;
    private TextView mTxtSug;
    private TextView mTxtHob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRadGrp=(RadioGroup)findViewById(R.id.radGrp);
        mRadBtnMale=(RadioButton)findViewById(R.id.radBtnMale);
        mRadBtnFemale=(RadioButton)findViewById(R.id.radBtnFemale);
        mSpnAge=(Spinner)findViewById(R.id.spnAge);
        mChe1=(CheckBox)findViewById(R.id.che1);
        mChe2=(CheckBox)findViewById(R.id.che2);
        mChe3=(CheckBox)findViewById(R.id.che3);
        mChe4=(CheckBox)findViewById(R.id.che4);
        mChe5=(CheckBox)findViewById(R.id.che5);
        mChe6=(CheckBox)findViewById(R.id.che6);
        mChe7=(CheckBox)findViewById(R.id.che7);
        mChe8=(CheckBox)findViewById(R.id.che8);
        mChe9=(CheckBox)findViewById(R.id.che9);
        mChe10=(CheckBox)findViewById(R.id.che10);
        mBtnOK=(Button)findViewById(R.id.btnOK);
        mTxtSug=(TextView)findViewById(R.id.txtSug);
        mTxtHob=(TextView)findViewById(R.id.txtHob);

        mBtnOK.setOnClickListener(btnOKOnClick);
    }

    private View.OnClickListener btnOKOnClick=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            MarrySuggestion ms=new MarrySuggestion();
            String ageRange=mSpnAge.getSelectedItem().toString();
            String hobby="你的興趣:";
            int sexType=0;
            switch (mRadGrp.getCheckedRadioButtonId()) {
                case R.id.radBtnMale:
                    sexType = 1;
                    break;
                case R.id.radBtnFemale:
                    sexType = 2;
                    break;
            }
            mTxtSug.setText(ms.getMarrySuggestion(sexType, ageRange));

            if(mChe1.isChecked())
                hobby+= mChe1.getText().toString()+" ";
            if(mChe2.isChecked())
                hobby+= mChe2.getText().toString()+" ";
            if(mChe3.isChecked())
                hobby+= mChe3.getText().toString()+" ";
            if(mChe4.isChecked())
                hobby+= mChe4.getText().toString()+" ";
            if(mChe5.isChecked())
                hobby+= mChe5.getText().toString()+" ";
            if(mChe6.isChecked())
                hobby+= mChe6.getText().toString()+" ";
            if(mChe7.isChecked())
                hobby+= mChe7.getText().toString()+" ";
            if(mChe8.isChecked())
                hobby+= mChe8.getText().toString()+" ";
            if(mChe9.isChecked())
                hobby+= mChe9.getText().toString()+" ";
            if(mChe10.isChecked())
                hobby+= mChe10.getText().toString()+" ";
            mTxtHob.setText(hobby);
        }
    };
}
