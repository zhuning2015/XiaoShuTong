package cc.indiesoft.academics;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;
import android.text.Editable;
import android.widget.RadioButton;
import android.widget.Toast;
import android.graphics.Color;

public class RegisterActivity extends Activity
{
    private EditText registeredUserName_EditText;
    private EditText registeredPassword_EditText;
    private EditText repeatPassword_EditText;
    private TextView passwordErrorMsg_TextView;
    private EditText organization_EditText;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        registeredUserName_EditText = (EditText)findViewById(R.id.userName_register);
        registeredPassword_EditText = (EditText)findViewById(R.id.password_register);
        repeatPassword_EditText = (EditText)findViewById(R.id.password_repeat);
        passwordErrorMsg_TextView = (TextView)findViewById(R.id.errorMessage_password);
        organization_EditText = (EditText)findViewById(R.id.organization);
    }

    public void onRegisterFinishedButtonClicked(View view)
    {
        String registeredUserName = registeredUserName_EditText.getText().toString();
        if (registeredUserName.trim().equals(""))
        {
            registeredUserName_EditText.setHint("用户名不能为空");
            registeredUserName_EditText.setHintTextColor(Color.RED);
            return;
        }else if(AccountManager.contains(registeredUserName))
        {
            registeredUserName_EditText.setHint("用户名已存在");
            registeredUserName_EditText.setHintTextColor(Color.RED);
            return;
        }

        RadioButton male_radioButton = (RadioButton)findViewById(R.id.male);
        boolean isMale = false;
        if (male_radioButton.isChecked())
        {
            isMale = true;
        }

        String registeredPassword = registeredPassword_EditText.getText().toString();
        String repeatedPassword = repeatPassword_EditText.getText().toString();
        if (!registeredPassword.equals(repeatedPassword))
        {
            passwordErrorMsg_TextView.setText("两次密码设置不一致");
            return;
        }else
        {
            passwordErrorMsg_TextView.setText("");
        }

        String organization = organization_EditText.getText().toString();

        AccountManager.addAccount(registeredUserName, registeredPassword);

        Toast.makeText(this,"注册成功",Toast.LENGTH_LONG).show();
        finish();
    }
}
