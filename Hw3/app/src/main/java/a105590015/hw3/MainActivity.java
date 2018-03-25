package a105590015.hw3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Spinner mSpnSex;
    private RadioGroup mRadGrp;
    private RadioButton mRadAge1;
    private RadioButton mRadAge2;
    private RadioButton mRadAge3;
    private TextView mTxtFamilyNum;
    private NumberPicker mNumPicFamily;
    private Button mBtnOK;
    private TextView mTxtSug;
    private String selectSex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSpnSex=(Spinner)findViewById(R.id.spnSex);
        mRadGrp=(RadioGroup)findViewById(R.id.radGrp);
        mRadAge1=(RadioButton)findViewById(R.id.radAge1);
        mRadAge2=(RadioButton)findViewById(R.id.radAge2);
        mRadAge3=(RadioButton)findViewById(R.id.radAge3);
        mTxtFamilyNum=(TextView)findViewById(R.id.txtFamilyNum);
        mNumPicFamily=(NumberPicker)findViewById(R.id.numPicFamily);
        mNumPicFamily.setMaxValue(20);
        mNumPicFamily.setMinValue(0);
        mNumPicFamily.setValue(3);
        mBtnOK=(Button)findViewById(R.id.btnOK);
        mTxtSug=(TextView)findViewById(R.id.txtSug);

        mSpnSex.setOnItemSelectedListener(spnOnItemSelect);
        mNumPicFamily.setOnValueChangedListener(numPicFamilyOnValueChange);
        mBtnOK.setOnClickListener(btnOKOnClick);
    }

    private AdapterView.OnItemSelectedListener spnOnItemSelect=new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            selectSex=adapterView.getSelectedItem().toString();
            switch(selectSex)
            {
                case "male":
                    mRadAge1.setText("age<30");
                    mRadAge2.setText("30<=age<=40");
                    mRadAge3.setText("40<age");
                    break;
                case "female":
                    mRadAge1.setText("age<28");
                    mRadAge2.setText("28<=age<=35");
                    mRadAge3.setText("35<age");
                    break;
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };

    private NumberPicker.OnValueChangeListener numPicFamilyOnValueChange=new NumberPicker.OnValueChangeListener() {
        @Override
        public void onValueChange(NumberPicker numberPicker, int oldVal, int newVal) {
            mTxtFamilyNum.setText(String.valueOf(newVal));
        }
    };

    private View.OnClickListener btnOKOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            MarrySuggestion ms=new MarrySuggestion();
            String strSex = mSpnSex.getSelectedItem().toString();
            int iAgeRange = 0;
            switch (mRadGrp.getCheckedRadioButtonId()) {
                case R.id.radAge1:
                    iAgeRange = 1;
                    break;
                case R.id.radAge2:
                    iAgeRange = 2;
                    break;
                case R.id.radAge3:
                    iAgeRange = 3;
                    break;
            }

            mTxtSug.setText(ms.getMarrySuggestion(strSex, iAgeRange, mNumPicFamily.getValue()));
        }
    };
}
