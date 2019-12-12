package com.karol.biopedia.Activity;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import com.karol.biopedia.Activity.TabsDatas.TabAbr;
import com.karol.biopedia.Activity.TabsDatas.TabAgo;
import com.karol.biopedia.Activity.TabsDatas.TabDez;
import com.karol.biopedia.Activity.TabsDatas.TabFev;
import com.karol.biopedia.Activity.TabsDatas.TabJan;
import com.karol.biopedia.Activity.TabsDatas.TabJul;
import com.karol.biopedia.Activity.TabsDatas.TabJun;
import com.karol.biopedia.Activity.TabsDatas.TabMai;
import com.karol.biopedia.Activity.TabsDatas.TabMar;
import com.karol.biopedia.Activity.TabsDatas.TabNov;
import com.karol.biopedia.Activity.TabsDatas.TabOut;
import com.karol.biopedia.Activity.TabsDatas.TabSet;
import com.karol.biopedia.R;

public class DatasImportantes extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datas_importantes);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_datas_importantes, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        return super.onOptionsItemSelected(item);
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
           // retorna as tabs
            switch (position){
                case 0:
                    TabJan tab1 = new TabJan();
                    return tab1;
                case 1:
                    TabFev tab2 = new TabFev();
                    return tab2;
                case 2:
                    TabMar tab3 = new TabMar();
                    return tab3;
                case 3:
                    TabAbr tab4 = new TabAbr();
                    return tab4;
                case 4:
                    TabMai tab5 = new TabMai();
                    return tab5;
                case 5:
                    TabJun tab6 = new TabJun();
                    return tab6;
                case 6:
                    TabJul tab7 = new TabJul();
                    return tab7;
                case 7:
                    TabAgo tab8 = new TabAgo();
                    return tab8;
                case 8:
                    TabSet tab9 = new TabSet();
                    return tab9;
                case 9:
                    TabOut tab10 = new TabOut();
                    return tab10;
                case 10:
                    TabNov tab11 = new TabNov();
                    return tab11;
                case 11:
                    TabDez tab12 = new TabDez();
                    return tab12;
                 default:
                     return null;
            }
        }

        @Override
        public int getCount() {
            // Show 12 total pages.
            return 12;
        }

        @Override
        public CharSequence getPageTitle(int position){
            switch (position){
                case 0:
                    return "JANEIRO";
                case 1:
                    return "FEVEREIRO";
                case 2:
                    return "MARÇO";
                case 3:
                    return "ABRIL";
                case 4:
                    return "MAIO";
                case 5:
                    return "JUNHO";
                case 6:
                    return "JULHO";
                case 7:
                    return "AGOSTO";
                case 8:
                    return "SETEMBRO";
                case 9:
                    return "OUTUBRO";
                case 10:
                    return "NOVEMBRO";
                case 11:
                    return "DEZEMBRO";
            }
            return null;
        }
    }
}
