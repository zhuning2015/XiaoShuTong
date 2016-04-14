package cc.indiesoft.academics;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.os.Bundle;
import android.widget.TabHost.TabSpec;

import cc.indiesoft.academics.fragments.PaperFragment;
import cc.indiesoft.academics.fragments.TeamFragment;
import cc.indiesoft.academics.fragments.MessageFragment;
import cc.indiesoft.academics.fragments.MeFragment;

public class MainActivity extends FragmentActivity
{
    private FragmentTabHost tabHost;
    private Class fragmentArray[] = {PaperFragment.class, TeamFragment.class,
                                     MessageFragment.class, MeFragment.class};
    private String textArray[] = {"论文","团队","动态","我"};

    public void onCreate(Bundle savedInstance)
    {
        super.onCreate(savedInstance);
        setContentView(R.layout.main);

        tabHost = (FragmentTabHost)findViewById(android.R.id.tabhost);
        tabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);

        int count = fragmentArray.length;
        for (int i = 0; i < count; i++)
        {
            TabSpec tabSpec = tabHost.newTabSpec(textArray[i]).setIndicator(textArray[i]);
            tabHost.addTab(tabSpec, fragmentArray[i], null);
        }
    }
}
