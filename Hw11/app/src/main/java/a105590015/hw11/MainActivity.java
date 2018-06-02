package a105590015.hw11;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.SearchView;
import android.widget.Toast;

import a105590015.hw11.providers.FriendsContentProvider;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private static ContentResolver mContRes;

    SectionsPagerAdapter mSectionsPagerAdapter;
    ViewPager mViewPager;

    private  String name, number, type;
    private ArrayList contact=new ArrayList(), searchContact=new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContRes = getContentResolver();

        ActionBar actBar = getSupportActionBar();
        actBar.setDisplayShowTitleEnabled(true);
        actBar.setDisplayShowHomeEnabled(true);

        mSectionsPagerAdapter = new SectionsPagerAdapter(
                getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(mViewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        SearchView searchView = (SearchView)menu.findItem(R.id.menuItemSearch).getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                contact.clear();
                searchContact.clear();
                String[] projection={"name", "sex", "address"};
                Cursor c = mContRes.query(FriendsContentProvider.CONTENT_URI, projection, null, null, null);
                Cursor s = mContRes.query(FriendsContentProvider.CONTENT_URI, projection, "name="+"\""+query+"\"", null, null);
                if (c == null)
                    Toast.makeText(MainActivity.this, "讀取失敗", Toast.LENGTH_LONG).show();
                else if (c.getCount() == 0)
                    Toast.makeText(MainActivity.this, "沒有資料", Toast.LENGTH_LONG).show();
                else {
                    c.moveToFirst();
                    contact.add(c.getString(0) + c.getString(1)  + c.getString(2));
                    while (c.moveToNext())
                        contact.add(c.getString(0) + c.getString(1)  + c.getString(2));
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, contact);
                    ((SearchContact) getSupportFragmentManager().getFragments().get(1)).mlistView.setAdapter(arrayAdapter);

                    if (s.getCount() == 0)
                        Toast.makeText(MainActivity.this, "沒有找到聯絡人", Toast.LENGTH_LONG).show();
                    else {
                        s.moveToFirst();
                        searchContact.add(s.getString(0) + s.getString(1) + s.getString(2));
                        while (s.moveToNext())
                            searchContact.add(s.getString(0) + s.getString(1) + s.getString(2));
                        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, searchContact);
                        ((SearchContact) getSupportFragmentManager().getFragments().get(1)).mlistView2.setAdapter(arrayAdapter2);
                    }
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                contact.clear();
                searchContact.clear();
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuItemAdd:
                name=((AddNewContact) getSupportFragmentManager().getFragments().get(0)).mEdtName.getText().toString();
                number=((AddNewContact) getSupportFragmentManager().getFragments().get(0)).mEdtNumber.getText().toString();
                type=((AddNewContact) getSupportFragmentManager().getFragments().get(0)).type;
                ContentValues newRow = new ContentValues();
                newRow.put("name", name);
                newRow.put("sex", number);
                newRow.put("address", type);
                mContRes.insert(FriendsContentProvider.CONTENT_URI, newRow);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment = null;

            switch (position) {
                case 0:
                    fragment = new AddNewContact();
                    break;
                case 1:
                    fragment = new SearchContact();
                    break;
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Add";
                case 1:
                    return "Search";
                default:
                    return null;
            }
        }
    }
}
