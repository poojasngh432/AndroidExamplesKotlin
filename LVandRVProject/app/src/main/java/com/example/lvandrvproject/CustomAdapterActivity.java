package com.example.lvandrvproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapterActivity extends AppCompatActivity {

    ArrayList<Teacher> teachers = Teacher.get10RandomTeachers();
    ListView lvTeachers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_adapter);
        lvTeachers = findViewById(R.id.lvTeachers);
        TeacherAdapter teacherAdapter = new TeacherAdapter();
        lvTeachers.setAdapter(teacherAdapter);
    }

    class TeacherAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return teachers.size();
        }

        @Override
        public Teacher getItem(int i) {
            return teachers.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View itemView = getLayoutInflater().inflate(R.layout.list_item_teacher, viewGroup, false);
            TextView tvName = itemView.findViewById(R.id.tvName);
            TextView tvCourse = itemView.findViewById(R.id.tvCourse);
            tvName.setText(getItem(i).getName());
            tvCourse.setText(getItem(i).getCourse());
            return itemView;
        }
    }
}
