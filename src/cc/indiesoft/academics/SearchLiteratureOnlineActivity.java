package cc.indiesoft.academics;

import android.app.Activity;

import android.os.Bundle;

import android.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

import android.view.View;

import cc.indiesoft.academics.fragments.SearchResultFragment;
import cc.indiesoft.academics.fragments.SearchDatabaseFragment;

public class SearchLiteratureOnlineActivity extends FragmentActivity
{
    FragmentManager fragmentManager = null;
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.literature_search_online);

        fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        SearchDatabaseFragment searchDatabaseFragment = new SearchDatabaseFragment();
        fragmentTransaction.add(R.id.fragment_container, searchDatabaseFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void onSearch(View view)
    {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        SearchResultFragment searchResultFragment = new SearchResultFragment();
        fragmentTransaction.replace(R.id.fragment_container, searchResultFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
