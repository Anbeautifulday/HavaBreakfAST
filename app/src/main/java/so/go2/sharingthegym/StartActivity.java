package so.go2.sharingthegym;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.avos.avoscloud.AVOSCloud;
import com.avos.avoscloud.AVUser;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AVOSCloud.initialize(this,"PR8VFnsYGwePu2cw9P6418yK-gzGzoHsz","nJGNb75sfB0oavDI4Qav9ELV");
        if(AVUser.getCurrentUser() == null){
            Intent intent = new Intent(this,LoginActivity.class);
            startActivity(intent);
        }
        else{
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }
    }
}
