package a105590015.hw11;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import a105590015.hw11.providers.FriendsContentProvider;

public class AddNewContact extends Fragment{

    private static ContentResolver mContRes;
    public EditText mEdtName, mEdtNumber;
    private Spinner mSpnType;
    private ConstraintLayout mAddNewContactLayout;
    public String type;

    public AddNewContact(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_addnewcontact, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mContRes = getActivity().getContentResolver();

        mEdtName=(EditText)getView().findViewById(R.id.edtName);
        mEdtNumber=(EditText)getView().findViewById(R.id.edtNumber);
        mSpnType=(Spinner)getView().findViewById(R.id.spnType);
        mAddNewContactLayout=(ConstraintLayout)getView().findViewById(R.id.addNewContantLayout);
        registerForContextMenu(mAddNewContactLayout);

        mSpnType.setOnItemSelectedListener(spnTypeOnItemClick);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getActivity().getMenuInflater().inflate(R.menu.menu_context, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuItemUpdate:
                ContentValues newRow = new ContentValues();
                newRow.put("name", mEdtName.getText().toString());
                newRow.put("sex", mEdtNumber.getText().toString());
                newRow.put("address", type);
                mContRes.update(FriendsContentProvider.CONTENT_URI, newRow, mEdtName.getText().toString(), null);
                Toast.makeText(getActivity(), "更新成功", Toast.LENGTH_LONG).show();
                return true;
            case R.id.menuItemDelete:
                mContRes.delete(FriendsContentProvider.CONTENT_URI, mEdtName.getText().toString(), null);
                Toast.makeText(getActivity(), "刪除成功", Toast.LENGTH_LONG).show();
        }
        return super.onContextItemSelected(item);
    }

    private AdapterView.OnItemSelectedListener spnTypeOnItemClick=new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            type=parent.getSelectedItem().toString();
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };
}
