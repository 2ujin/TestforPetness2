package s2017s16.kr.hs.mirim.testforpetness;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class AlarmFragmentActivity extends Fragment {
    public AlarmFragmentActivity(){}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_alarm_fragment, container, false);
        return view;
    }
}
