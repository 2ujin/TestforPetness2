package s2017s16.kr.hs.mirim.testforpetness;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import s2017s16.kr.hs.mirim.testforpetness.Fragment1Activity;
import s2017s16.kr.hs.mirim.testforpetness.Fragment2Activity;
import s2017s16.kr.hs.mirim.testforpetness.R;


public class MyFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_my, container, false);
        ImageButton tab1 = (ImageButton) view.findViewById(R.id.tab1);
        ImageButton tab2 = (ImageButton) view.findViewById(R.id.tab2);
        ImageButton tab3 = (ImageButton) view.findViewById(R.id.tab3);

        tab1.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.framelayout, new Fragment1Activity());
                transaction.commit();
            }
        });

        tab2.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.framelayout, new Fragment2Activity());
                transaction.commit();
            }
        });
        tab3.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.framelayout, new Fragment3Activity());
                transaction.commit();
            }
        });
        return view;
    }

}
