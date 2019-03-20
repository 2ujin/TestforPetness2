package s2017s16.kr.hs.mirim.testforpetness;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;


public class TodoActivity extends Fragment {

    Button save;
    TextView dateNow;
    CheckBox check1, check2, check3;
    Boolean bool1, bool2, bool3;
    ProgressBar mainprogress, progress1, progress2, progress3;

    public TodoActivity(){}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Start of 매일 날짜 바꿔주기
        String weekday=null;
        switch(Calendar.getInstance().get(Calendar.DAY_OF_WEEK)){
            case Calendar.MONDAY: weekday="월"; break;
            case Calendar.TUESDAY: weekday="화"; break;
            case Calendar.WEDNESDAY: weekday="수"; break;
            case Calendar.THURSDAY: weekday="목"; break;
            case Calendar.FRIDAY: weekday="금"; break;
            case Calendar.SATURDAY: weekday="토"; break;
            case Calendar.SUNDAY: weekday="일"; break;
        }
        dateNow = getActivity(). findViewById(R.id.dateNow);
        dateNow.setText( Calendar.getInstance().get(Calendar.MONTH)+1 + "월 " +
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)+"일 "+
                weekday+"요일");
        //End of 매일 날짜 바꿔주기

        //Start of 저장하기 버튼
//        save=getActivity().findViewById(R.id.save);
//        save.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getActivity(), "저장되었습니다 :)", Toast.LENGTH_SHORT).show();
//            }
//        });
//        //End of 저장하기 버튼

        //Start of 체크박스+프로그레스바
        check1.setOnClickListener(checkhandler);
        check2.setOnClickListener(checkhandler);
        check3.setOnClickListener(checkhandler);
        mainprogress.setMax(100);
        //End of 체크박스+프로그레스바
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Start of View 전달
        View view = inflater.inflate(R.layout.activity_todo, container, false);
        return view;
        //End of View 전달
    }//OnCreateView



    View.OnClickListener checkhandler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(!(check1.isChecked() && check2.isChecked() && check3.isChecked())) {
                mainprogress.setProgress(0);
                bool1=false; bool2=false; bool3=false;
            }
            if(check1.isChecked() && check2.isChecked()){
                mainprogress.setProgress(70);
                progress1.setProgress(100);
                progress2.setProgress(100);
                bool1=true; bool2=true; bool3=false;
            }
            if(check1.isChecked() && check3.isChecked()){
                mainprogress.setProgress(70);
                progress1.setProgress(100);
                progress2.setProgress(100);
                bool1=true; bool2=false; bool3=true;
            }
            if(check2.isChecked() && check3.isChecked()){
                mainprogress.setProgress(70);
                progress1.setProgress(100);
                progress2.setProgress(100);
                bool1=false; bool2=true; bool3=true;
            }
            if(check1.isChecked() && check2.isChecked() && check3.isChecked()) {
                mainprogress.setProgress(100);
                progress1.setProgress(100);
                progress2.setProgress(100);
                progress3.setProgress(100);
                bool1=true; bool2=true; bool3=true;
            }
            if(check1.isChecked()&&!(check2.isChecked())&&!(check3.isChecked())) {
                mainprogress.setProgress(35);
                progress1.setProgress(100);
                bool1=true; bool2=false; bool3=false;
            }
            if(check2.isChecked()&&!(check1.isChecked())&&!(check3.isChecked())) {
                mainprogress.setProgress(35);
                progress1.setProgress(100);
                bool1=false; bool2=true; bool3=false;
            }
            if(check3.isChecked()&&!(check2.isChecked())&&!(check1.isChecked())) {
                mainprogress.setProgress(35);
                progress1.setProgress(100);
                bool1=false; bool2=false; bool3=true;
            }

        }
    };
}//End
