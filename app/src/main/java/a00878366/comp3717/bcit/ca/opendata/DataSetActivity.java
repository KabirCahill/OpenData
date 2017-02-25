package a00878366.comp3717.bcit.ca.opendata;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DataSetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_set);

        Bundle bundle = getIntent().getExtras();
        long categoryId = bundle.getLong("category_id");

        TextView accountTextView = (TextView) findViewById(R.id.textView);
        accountTextView.setText("Category: " + categoryId);
    }
}
