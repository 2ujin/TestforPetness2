package s2017s16.kr.hs.mirim.testforpetness;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends FragmentActivity {
   // private FragmentManager fragmentManager;
   // FragmentTransaction transaction;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton menubtn1 = (ImageButton)findViewById(R.id.menubtn1);
        ImageButton menubtn2 = (ImageButton)findViewById(R.id.menubtn2);
        ImageButton menubtn3 = (ImageButton)findViewById(R.id.menubtn3);
        ImageButton menubtn4 = (ImageButton)findViewById(R.id.menubtn4);

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
        });
    }

}
