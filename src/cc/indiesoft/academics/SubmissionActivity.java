package cc.indiesoft.academics;

import android.os.Bundle;
import android.app.ListActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.content.Context;
import android.view.ViewGroup;
import android.graphics.Color;
import android.widget.TextView;

import java.util.List;
import java.util.ArrayList;

public class SubmissionActivity extends ListActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.submissions);

        Paper paper1 = new Paper("This is my new submitted paper 1",
                                 "System Modeling and Simulation",
                                 1);
        Paper paper2 = new Paper("This is my second submitted paper 2",
                                 "IEECS 2016",
                                 2);
        ArrayList<Paper> paperList = new ArrayList<Paper>();
        paperList.add(paper1);
        paperList.add(paper2);
        SubmissionPaperAdapter spa = new SubmissionPaperAdapter(this,
                                                                R.layout.submitted_paper_list_view,
                                                                paperList);
        getListView().setAdapter(spa);
    }

    public void onReturn(View view)
    {
        finish();
    }

    public class SubmissionPaperAdapter extends ArrayAdapter<Paper>
    {
        private int resourceId;

        public SubmissionPaperAdapter(Context context, int resourceId, List<Paper> submittedPaperList)
        {
            super(context, resourceId, submittedPaperList);
            this.resourceId = resourceId;
        }

        public View getView(int position, View convertView, ViewGroup parent)
        {
            Paper paper = getItem(position);
            LinearLayout linearLayout = new LinearLayout(getContext());
            String inflaterId = Context.LAYOUT_INFLATER_SERVICE;
            LayoutInflater layoutInflater = (LayoutInflater)getContext().getSystemService(inflaterId);
            layoutInflater.inflate(resourceId, linearLayout, true);

            TextView paperName_TextView = (TextView)linearLayout.findViewById(R.id.paper_name);
            paperName_TextView.setText(paper.getName());
            TextView journalName_TextView = (TextView)linearLayout.findViewById(R.id.journal_name);
            journalName_TextView.setText(paper.getJournalName());
            TextView paperStep_TextView = (TextView)linearLayout.findViewById(R.id.paper_step);
            if (paper.getStep() == 1)
            {
                paperStep_TextView.setText("提交");
                paperStep_TextView.setTextColor(Color.BLACK);
                paperStep_TextView.setBackgroundColor(Color.parseColor("#04BFBF"));
            }else if (paper.getStep() == 2)
            {
                paperStep_TextView.setText("送审");
                paperStep_TextView.setTextColor(Color.BLACK);
                paperStep_TextView.setBackgroundColor(Color.parseColor("#CAFCD8"));
            }
            return linearLayout;
        }
    }
}
