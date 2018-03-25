package a105590015.hw2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText mEdtSex, mEdtAge;
    private TextView mTxtR;
    private Button mBtnOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEdtSex=(EditText)findViewById(R.id.edtSex);
        mEdtAge=(EditText)findViewById(R.id.edtAge);
        mTxtR=(TextView)findViewById(R.id.txtR);
        mBtnOK=(Button)findViewById(R.id.btnOK);

        mBtnOK.setOnClickListener(btnOKOnClick);
    }

    private View.OnClickListener btnOKOnClick=new View.OnClickListener(){
        @Override
        public void onClick(View v){
            String strSex=mEdtSex.getText().toString();
            int iAge=Integer.parseInt(mEdtAge.getText().toString());
            String strSug=getString(R.string.suggest);
            if(strSex.equals("male")){
                if(iAge<30)
                    strSug+="Not hurry";
                else if(iAge<=35)
                    strSug+="Get marry";
                else
                    strSug+="Find couple";
            }
            else if(strSex.equals("female")){
                if(iAge<28)
                    strSug+="Not hurry";
                else if(iAge<=32)
                    strSug+="Get marry";
                else
                    strSug+="Find couple";
            }
            mTxtR.setText(strSug);
        }
    };
}