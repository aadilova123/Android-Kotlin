package ha.captaincode;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Captain Code on 04/10/2017.
 */

public class LoginActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle a){
        super.onCreate(a);
        setContentView(R.layout.login);

        Button Login = (Button)findViewById(R.id.login);
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPrefs.saveSharedSetting(LoginActivity.this, "CaptainCode", "false");
                Intent ImLoggedIn = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(ImLoggedIn);
                finish();
            }
        });
    }
}
