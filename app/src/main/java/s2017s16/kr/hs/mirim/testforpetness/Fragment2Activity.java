package s2017s16.kr.hs.mirim.testforpetness;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

public class Fragment2Activity extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.activity_fragment2, container, false);
        ImageButton menubtn1 = (ImageButton) view.findViewById(R.id.menubtn1);
        ImageButton menubtn2 = (ImageButton) view.findViewById(R.id.menubtn2);
        ImageButton menubtn3 = (ImageButton) view.findViewById(R.id.menubtn3);
        ImageButton menubtn4 = (ImageButton) view.findViewById(R.id.menubtn4);

        menubtn1.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.framelayout, new StatusActivity()).commit();
            }
        });

        menubtn2.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.framelayout, new TodoActivity()).commit();
            }
        });
        menubtn3.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.framelayout, new AlarmFragmentActivity()).commit();
            }
        });/*
        menubtn4.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.framelayout, new StatusActivity()).commit();
            }
        });*/


        return view;
    }//End of onCreateView

}//End of Fragment2Activity
