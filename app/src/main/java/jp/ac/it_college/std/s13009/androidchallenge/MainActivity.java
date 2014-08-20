package jp.ac.it_college.std.s13009.androidchallenge;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public static class PlaceholderFragment extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.start_fragment, container, false);

            final TextView startText = (TextView) rootView.findViewById(R.id.start1);
            startText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DifficultyFragment fragment = DifficultyFragment.newInstance();
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.start_fragment , fragment);
                    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                    ft.commit();
                    startText.setVisibility(View.INVISIBLE);
                }
            });
            return rootView;
        }
    }

    public static class DifficultyFragment extends Fragment implements View.OnClickListener{
        public static DifficultyFragment newInstance() {
            DifficultyFragment fragment = new DifficultyFragment();
            return fragment;
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.easy_button:
                    difficultySelect("EASY");
                    break;
                case R.id.normal_button:
                    difficultySelect("NORMAL");
                    break;
                case R.id.hard_button:
                    difficultySelect("HARD");
                    break;
            }

        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.difficulity, container, false);

            rootView.findViewById(R.id.easy_button).setOnClickListener(this);
            rootView.findViewById(R.id.normal_button).setOnClickListener(this);
            rootView.findViewById(R.id.hard_button).setOnClickListener(this);

            return rootView;
        }

        private void difficultySelect(String difficulty) {
            Intent intent = new Intent(getActivity(), TetrisActivity.class);
            intent.putExtra("Difficulty", difficulty);
            startActivity(intent);

        }
    }

}
