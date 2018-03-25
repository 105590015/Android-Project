package a105590015.hw3;

import android.app.Instrumentation;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {
    private MainActivity mMainAct;
    private Spinner mSpnSex;
    private RadioGroup mRadGrp;
    private RadioButton mRadAge1;
    private RadioButton mRadAge2;
    private RadioButton mRadAge3;
    private TextView mTxtFamilyNum;
    private NumberPicker mNumPicFamily;
    private Button mBtnOK;
    private TextView mTxtSug;

    public MainActivityTest(){
        super(MainActivity.class);
    }

    @Before
    public void setUp() throws Exception{
        super.setUp();
        //initialize
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());

        mMainAct=(MainActivity)getActivity();
        mSpnSex = (Spinner) mMainAct.findViewById(R.id.spnSex);
        mRadGrp = (RadioGroup) mMainAct.findViewById(R.id.radGrp);
        mRadAge1 = (RadioButton) mMainAct.findViewById(R.id.radAge1);
        mRadAge2 = (RadioButton) mMainAct.findViewById(R.id.radAge2);
        mRadAge3 = (RadioButton) mMainAct.findViewById(R.id.radAge3);
        mTxtFamilyNum = (TextView) mMainAct.findViewById(R.id.txtFamilyNum);
        mNumPicFamily = (NumberPicker) mMainAct.findViewById(R.id.numPicFamily);
        mBtnOK = (Button) mMainAct.findViewById(R.id.btnOK);
        mTxtSug = (TextView) mMainAct.findViewById(R.id.txtSug);
    }
    @After
    public void tearDown() throws Exception{
        super.tearDown();
    }
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("a105590015.hw3", appContext.getPackageName());
    }
    @Test
    public void maleAgeRange1Family12() {
        //create and execute UI thread (in order to perform GUI interactions)
        mMainAct.runOnUiThread(new Runnable() {
            @Override
            public void run() {      // provide inputs
                mSpnSex.setSelection(0);
                mRadAge1.setChecked(true);
                mNumPicFamily.setValue(12);
                mBtnOK.performClick();
            }
        });
        try {
            Thread.sleep(2000);   // wait for 2 second
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals("建議:還不急", mTxtSug.getText().toString());
    }
    @Test
    public void maleAgeRange2Family5() {
        //create and execute UI thread (in order to perform GUI interactions)
        mMainAct.runOnUiThread(new Runnable() {
            @Override
            public void run() {      // provide inputs
                mSpnSex.setSelection(0);
                mRadAge2.setChecked(true);
                mNumPicFamily.setValue(5);
                mBtnOK.performClick();
            }
        });
        try {
            Thread.sleep(2000);   // wait for 2 second
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals("建議:開始找對象", mTxtSug.getText().toString());
    }
    @Test
    public void maleAgeRange3Family3() {
        //create and execute UI thread (in order to perform GUI interactions)
        mMainAct.runOnUiThread(new Runnable() {
            @Override
            public void run() {      // provide inputs
                mSpnSex.setSelection(0);
                mRadAge3.setChecked(true);
                mNumPicFamily.setValue(3);
                mBtnOK.performClick();
            }
        });
        try {
            Thread.sleep(2000);   // wait for 2 second
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals("建議:開始找對象", mTxtSug.getText().toString());
    }
    @Test
    public void femaleAgeRange1Family3() {
        //create and execute UI thread (in order to perform GUI interactions)
        mMainAct.runOnUiThread(new Runnable() {
            @Override
            public void run() {      // provide inputs
                mSpnSex.setSelection(1);
                mRadAge1.setChecked(true);
                mNumPicFamily.setValue(3);
                mBtnOK.performClick();
            }
        });
        try {
            Thread.sleep(2000);   // wait for 2 second
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals("建議:趕快結婚", mTxtSug.getText().toString());
    }
    @Test
    public void femaleAgeRange2Family5() {
        //create and execute UI thread (in order to perform GUI interactions)
        mMainAct.runOnUiThread(new Runnable() {
            @Override
            public void run() {      // provide inputs
                mSpnSex.setSelection(1);
                mRadAge2.setChecked(true);
                mNumPicFamily.setValue(5);
                mBtnOK.performClick();
            }
        });
        try {
            Thread.sleep(2000);   // wait for 2 second
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals("建議:開始找對象", mTxtSug.getText().toString());
    }
    @Test
    public void femaleAgeRange3Family8() {
        //create and execute UI thread (in order to perform GUI interactions)
        mMainAct.runOnUiThread(new Runnable() {
            @Override
            public void run() {      // provide inputs
                mSpnSex.setSelection(1);
                mRadAge3.setChecked(true);
                mNumPicFamily.setValue(8);
                mBtnOK.performClick();
            }
        });
        try {
            Thread.sleep(2000);   // wait for 2 second
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals("建議:趕快結婚", mTxtSug.getText().toString());
    }
}