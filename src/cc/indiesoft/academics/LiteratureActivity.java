package cc.indiesoft.academics;

import android.app.Activity;

import android.os.Bundle;

import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;

import android.widget.GridView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.AdapterView;

import android.content.Context;
import android.content.Intent;

public class LiteratureActivity extends Activity
{
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.literature_grid);

        GridView gridView = (GridView)findViewById(R.id.gridview);
        gridView.setAdapter(new LiteratureAdapter(this));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
            {
                if (position == 8)
                {
                    Intent intent = new Intent();
                    intent.setClass(LiteratureActivity.this, LiteratureImportActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    public void onReturn(View v)
    {
        finish();
    }

    public class LiteratureAdapter extends BaseAdapter
    {
        private Context mContext;

        public LiteratureAdapter(Context c)
        {
            mContext = c;
        }

        public int getCount()
        {
            return mThrumbIds.length;
        }

        public Object getItem(int position)
        {
            return mThrumbIds[position];
        }

        public long getItemId(int position)
        {
            return 0;
        }

        public View getView(int position, View convertView, ViewGroup parent)
        {
            LinearLayout linearLayout = new LinearLayout(mContext);
            String inflaterId = Context.LAYOUT_INFLATER_SERVICE;
            LayoutInflater layoutInflater = (LayoutInflater)mContext.getSystemService(inflaterId);
            layoutInflater.inflate(R.layout.literature_show, linearLayout, true);

            ImageView imageView = (ImageView)linearLayout.findViewById(R.id.literature_image);
            //imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8,8,8,8);
            imageView.setImageResource(mThrumbIds[position]);

            if (position != 8)
            {
                TextView textView = (TextView)linearLayout.findViewById(R.id.literature_name);
                textView.setText("论文第"+(position+1)+"篇");
            }

            return linearLayout;
        }

        private Integer[] mThrumbIds = {
            R.drawable.sample_0,
            R.drawable.sample_1,
            R.drawable.sample_2,
            R.drawable.sample_3,
            R.drawable.sample_4,
            R.drawable.sample_5,
            R.drawable.sample_6,
            R.drawable.sample_7,
            R.drawable.sample_8
        };
    }
}
