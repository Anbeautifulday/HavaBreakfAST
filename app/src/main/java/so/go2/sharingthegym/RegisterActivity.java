package so.go2.sharingthegym;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.avos.avoscloud.AVException;
import com.avos.avoscloud.AVUser;
import com.avos.avoscloud.SignUpCallback;

public class RegisterActivity extends AppCompatActivity {

    private EditText username,password,nickname;
    private Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        findWidgets();
        setClick();
    }

    private void setClick() {
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().length() != 0 || password.getText().toString().length() != 0 || nickname.getText().toString().length() != 0){
                    AVUser user = new AVUser();
                    user.setUsername(username.getText().toString());
                    user.setPassword(password.getText().toString());
                    user.put("nickname",nickname.getText().toString());
                    user.signUpInBackground(new SignUpCallback() {
                        @Override
                        public void done(AVException e) {
                            if(e != null){
                                e.printStackTrace();
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(RegisterActivity.this, "用户名已存在", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                            else{
                                Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                                AVUser.getCurrentUser().logOut();
                                finish();
                            }
                        }
                    });
                }
                else {
                    Toast.makeText(RegisterActivity.this, "请填写完整信息..", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void findWidgets() {
        username = (EditText)findViewById(R.id.register_username);
        password = (EditText)findViewById(R.id.register_password);
        nickname = (EditText)findViewById(R.id.register_nickname);
        register = (Button)findViewById(R.id.register_register);
    }
}
