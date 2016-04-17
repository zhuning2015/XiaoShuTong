package cc.indiesoft.academics.fragments;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.Button;
import android.widget.TextView;

import android.content.Context;

import android.content.Intent;

import java.util.List;
import java.util.ArrayList;

import cc.indiesoft.academics.R;
import cc.indiesoft.academics.Paper;
import cc.indiesoft.academics.SubmissionActivity;

public class PaperFragment extends ListFragment
{
    private ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.paper_fragment, null);
    }

    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        Paper paper1 = new Paper("A DM2-based Architecture Modeling and Simulation Method",
                                 "Journal of System and Software",
                                 1,
                                 "2016-01-10",
                                 1);
        Paper paper2 = new Paper("Transforming SMP2 to Statecharts for Complex System Simulation",
                                 "ICCSE 2012",
                                 1,
                                 "2012-01-11",
                                 2);
        ArrayList<Paper> paperList = new ArrayList<Paper>();
        paperList.add(paper1);
        paperList.add(paper2);
        PaperListAdapter thePaperListAdpter = new PaperListAdapter(getContext(),
                                                                   R.layout.paper_list_view,
                                                                   paperList);
        setListAdapter(thePaperListAdpter);
        Button submissionBtn = (Button)getActivity().findViewById(R.id.submission_button);
        submissionBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent();
                intent.setClass(getActivity(), SubmissionActivity.class);
                startActivity(intent);
            }
        });
    }

    class PaperListAdapter extends ArrayAdapter<Paper>
    {
        private int resourceId;

        public PaperListAdapter(Context context, int resourceId, List<Paper> paperList)
        {
            super(context, resourceId, paperList);
            this.resourceId = resourceId;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            Paper paper = getItem(position);
            LinearLayout linearLayout = new LinearLayout(getContext());
            String inflaterId = Context.LAYOUT_INFLATER_SERVICE;
            LayoutInflater layoutInflater = (LayoutInflater)
                getContext().getSystemService(inflaterId);
            layoutInflater.inflate(resourceId, linearLayout, true);

            TextView paperName_TextView = (TextView)linearLayout.findViewById(R.id.paper_name);
            paperName_TextView.setText(paper.getName());

            TextView journal_TextView = (TextView)linearLayout.findViewById(R.id.journal_name);
            journal_TextView.setText(paper.getJournalName());

            TextView publishedTime_TextView = (TextView)linearLayout.findViewById(R.id.published_time);
            publishedTime_TextView.setText(paper.getPublishedTime());

            String type = "";
            if (paper.isSCI())
                type = "SCI";
            else if(paper.isEI())
                type = "EI";
            else if(paper.isChineseCore())
                type = "中文核心";

            TextView paperClassification_TextView = (TextView)linearLayout.findViewById(R.id.paper_classification);
            paperClassification_TextView.setText(type);

            return linearLayout;
        }
    }
}
