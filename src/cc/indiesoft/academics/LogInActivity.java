package cc.indiesoft.academics;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.text.Editable;

public class LogInActivity extends Activity
{
    private EditText userName_EditText;
    private EditText password_EditText;
    private TextView errorMessage_TextView;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        userName_EditText = (EditText)findViewById(R.id.userName);
        password_EditText = (EditText)findViewById(R.id.password);
        errorMessage_TextView = (TextView)findViewById(R.id.errorMessage);
    }

    public void onLogInButtonClicked(View view)
    {
        String userName = userName_EditText.getText().toString();
        if (userName.trim().equals(""))
        {
            errorMessage_TextView.setText("用户名不能为空");
            return;
        }

        String password = password_EditText.getText().toString();
        if (AccountManager.isValid(userName, password))
        {
            //StartActivity
            errorMessage_TextView.setText("");
        }else
        {
            errorMessage_TextView.setText("用户名或密码错误");
        }
    }
}
