package ha.captaincode;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button LogOut = (Button)findViewById(R.id.logout) ;
        LogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPrefs.saveSharedSetting(MainActivity.this, "CaptainCode", "true");
                //And when you click on Logout button, You will set the value to True AGAIN
                Intent LogOut = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(LogOut);
                finish();
            }
        });

        CekSession();
    }

    public void CekSession(){

        Boolean Check = Boolean.valueOf(SharedPrefs.readSharedSetting(MainActivity.this, "CaptainCode", "true"));

        Intent introIntent = new Intent(MainActivity.this, LoginActivity.class);
        introIntent.putExtra("CaptainCode", Check);

        //The Value if you click on Login Activity and Set the value is FALSE and whe false the activity will be visible
        if (Check) {
            startActivity(introIntent);
            finish();
        } //If no the Main Activity not Do Anything
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
