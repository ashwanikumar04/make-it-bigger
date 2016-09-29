package in.ashwanik.jokeui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    TextView txtJoke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        txtJoke = (TextView) findViewById(R.id.txtJoke);
        txtJoke.setText(getIntent().getExtras().getString("joke"));
    }
}
