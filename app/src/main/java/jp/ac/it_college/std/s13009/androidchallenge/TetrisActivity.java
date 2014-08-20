package jp.ac.it_college.std.s13009.androidchallenge;

import android.app.Activity;
import android.os.Bundle;
import android.widget.FrameLayout;

/**
 * Created by s13009 on 14/08/14.
 */
public class TetrisActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FrameLayout layout = new FrameLayout(this);
        layout.setId(R.id.start1);
        setContentView(layout);

    }
}
