package cc.indiesoft.academics.fragments;

import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import java.util.ArrayList;
import cc.indiesoft.academics.R;

public class SearchResultFragment extends Fragment
{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.search_result, null);
    }

    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

        ListView listView = (ListView)getActivity().findViewById(R.id.search_result_list);
        ArrayList<String> papers = new ArrayList<String>();
        papers.add("paper1");
        papers.add("paper2");
        papers.add("paper3");
        papers.add("paper4");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
                                                                android.R.layout.simple_list_item_multiple_choice,
                                                                papers);
        listView.setAdapter(adapter);
    }
}
