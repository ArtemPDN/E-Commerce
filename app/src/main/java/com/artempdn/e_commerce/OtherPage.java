package com.artempdn.e_commerce;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.artempdn.e_commerce.model.Course;
import com.artempdn.e_commerce.model.Other;

import java.util.ArrayList;
import java.util.List;

public class OtherPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_page);

        ListView others_list = findViewById(R.id.other_list);

        List<String> coursesTitle = new ArrayList<>();

        for(Course c:MainActivity.fullCourseList){
            if(Other.items_id.contains(c.getId()))
                coursesTitle.add(c.getTitle());
        }

        others_list.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, coursesTitle ));
    }
}