package s2017s16.kr.hs.mirim.testforpetness;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import static android.content.ContentValues.TAG;


public class TodoActivity extends Fragment {

    String currentdate;

    Button save;
    TextView dateNow;
    Boolean bool1, bool2, bool3;
    ProgressBar mainprogress, progress1, progress2, progress3;
    EditText edit1, edit2, edit3,diary;
    CheckBox check1, check2, check3;

    //firebase
    // Write a message to the database
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("todo");




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_todo, container, false);

        //Start of findViewbyId
        edit1=view.findViewById(R.id.todo_edit1);
        edit2=view.findViewById(R.id.todo_edit2);
        edit3=view.findViewById(R.id.todo_edit3);
        check1=view.findViewById(R.id.todo_check1);
        check1=view.findViewById(R.id.todo_check1);
        check1=view.findViewById(R.id.todo_check1);
        diary=view.findViewById(R.id.diary);
        save=view.findViewById(R.id.save);
        dateNow = view.findViewById(R.id.dateNow);
        check1=view.findViewById(R.id.todo_check1);
        check2=view.findViewById(R.id.todo_check2);
        check3=view.findViewById(R.id.todo_check3);
        mainprogress=view.findViewById(R.id.progress);
        progress1=view.findViewById(R.id.progressdot1);
        progress2=view.findViewById(R.id.progressdot2);
        progress3=view.findViewById(R.id.progressdot3);
        //End of findViewbyId

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

        currentdate=Calendar.getInstance().get(Calendar.MONTH)+1 + "월 " +
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)+"일 "+
                weekday+"요일";
        dateNow.setText(currentdate);

        //Start of 저장하기 버튼
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "저장되었습니다 :)", Toast.LENGTH_SHORT).show();
                //myRef.child("date").push().setValue(currentdate);
                if(myRef.child("date").child(currentdate)==null) {
                    myRef.child("date").child(currentdate).child("todo1").push().setValue(edit1.getText().toString());
                    myRef.child("date").child(currentdate).child("todo2").push().setValue(edit2.getText().toString());
                    myRef.child("date").child(currentdate).child("todo3").push().setValue(edit3.getText().toString());
                    myRef.child("date").child(currentdate).child("diary").push().setValue(diary.getText().toString());
                    myRef.child("date").child(currentdate).child("todocheck1").push().setValue(bool1);
                    myRef.child("date").child(currentdate).child("todocheck2").push().setValue(bool2);
                    myRef.child("date").child(currentdate).child("todocheck3").push().setValue(bool3);
                }
                else{

                }
            }
        });
//        //End of 저장하기 버튼

        //Start of 체크박스+프로그레스바
        check1.setOnClickListener(checkhandler);
        check2.setOnClickListener(checkhandler);
        check3.setOnClickListener(checkhandler);
        mainprogress.setMax(100);
        progress1.setMax(100);
        progress2.setMax(100);
        progress3.setMax(100);
        //End of 체크박스+프로그레스바


        return view;
    }//End of OnCreateView



    View.OnClickListener checkhandler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(!(check1.isChecked()) && !(check2.isChecked()) && !(check3.isChecked())) {
                mainprogress.setProgress(0);
                progress1.setProgress(0);
                progress2.setProgress(0);
                progress3.setProgress(0);
                bool1=false; bool2=false; bool3=false;
            }
            if(check1.isChecked() && check2.isChecked()&&!(check3.isChecked())){
                mainprogress.setProgress(70);
                progress1.setProgress(100);
                progress2.setProgress(100);
                progress3.setProgress(0);
                bool1=true; bool2=true; bool3=false;
            }
            if(check1.isChecked() && check3.isChecked()&&!(check2.isChecked())){
                mainprogress.setProgress(70);
                progress1.setProgress(100);
                progress2.setProgress(100);
                progress3.setProgress(0);
                bool1=true; bool2=false; bool3=true;
            }
            if(check2.isChecked() && check3.isChecked()&&!(check1.isChecked())){
                mainprogress.setProgress(70);
                progress1.setProgress(100);
                progress2.setProgress(100);
                progress3.setProgress(0);
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
                progress2.setProgress(0);
                progress3.setProgress(0);
                bool1=true; bool2=false; bool3=false;
            }
            if(check2.isChecked()&&!(check1.isChecked())&&!(check3.isChecked())) {
                mainprogress.setProgress(35);
                progress1.setProgress(100);
                progress2.setProgress(0);
                progress3.setProgress(0);
                bool1=false; bool2=true; bool3=false;
            }
            if(check3.isChecked()&&!(check2.isChecked())&&!(check1.isChecked())) {
                mainprogress.setProgress(35);
                progress1.setProgress(100);
                progress2.setProgress(0);
                progress3.setProgress(0);
                bool1=false; bool2=false; bool3=true;
            }

        }
    };
}//End
