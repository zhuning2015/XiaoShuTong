package cc.indiesoft.academics;

import android.app.Activity;
import android.os.Bundle;

import android.view.View;

import android.content.Intent;

import cc.indiesoft.academics.SearchLiteratureOnlineActivity;

public class LiteratureImportActivity extends Activity
{
    static final int RESULT_CODE = 0;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.literature_import);
    }

    public void onLoadFromLocal(View view)
    {
        Intent fileIntent = new Intent(Intent.ACTION_GET_CONTENT);
        fileIntent.setType("file/*");
        startActivityForResult(fileIntent, RESULT_CODE);
    }

    public void onSearchOnInternet(View view)
    {
        Intent intent = new Intent();
        intent.setClass(this, SearchLiteratureOnlineActivity.class);
        startActivity(intent);
    }
}
