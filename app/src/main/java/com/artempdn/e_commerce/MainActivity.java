package com.artempdn.e_commerce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.artempdn.e_commerce.adapter.CategoryAdapter;
import com.artempdn.e_commerce.adapter.CourseAdapter;
import com.artempdn.e_commerce.model.Category;
import com.artempdn.e_commerce.model.Course;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView categoryRecycler, courseRecycler;
    CategoryAdapter categoryAdapter;
    static CourseAdapter courseAdapter;
    static List<Course> courseList = new ArrayList<>();
    static List<Course> fullCourseList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Category> categoryList = new ArrayList<>();
        categoryList.add(new Category(1,"Игры"));
        categoryList.add(new Category(2,"Сайты"));
        categoryList.add(new Category(3,"Языки"));
        categoryList.add(new Category(4,"Прочее"));
        categoryList.add(new Category(5,"От себя добавил"));
        
        setCategoryRecycler(categoryList);


        courseList.add(new Course(1,"java","Профессия Java\nразработчик","1 января","начальный","#424345","Text01",1));
        courseList.add(new Course(2,"python","Профессия Python\nразработчик","3 января","начальный","#9FA52D","Text02",2));
        courseList.add(new Course(3,"course2","Профессия Java\nразработчик","10 января","средний","#EC5252","Text03",3));
        courseList.add(new Course(4,"course3","Профессия Java\nразработчик","15 января","Продвинутый","#2CBF93","Text04",3));

        fullCourseList.addAll(courseList);

        setCourseRecycler(courseList);

        //test
        ImageView imageView = findViewById(R.id.imageView2);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCourseAllCategory();
            }
        });


    }
    public void openShoppingCart(View view){
        Intent intent = new Intent(this,OtherPage.class);
        startActivity(intent);
    }
    private void setCourseRecycler(List<Course> courseList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        courseRecycler = findViewById(R.id.courseRecycler);
        courseRecycler.setLayoutManager(layoutManager);
        courseAdapter = new CourseAdapter(this,courseList);
        courseRecycler.setAdapter(courseAdapter);
    }

    private void setCategoryRecycler(List<Category> categoryList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        categoryRecycler = findViewById(R.id.categoryRecycler);
        categoryRecycler.setLayoutManager(layoutManager);
        categoryAdapter = new CategoryAdapter(this,categoryList);
        categoryRecycler.setAdapter(categoryAdapter);
    }

    public static void showCourseByCategory(int category){

        courseList.clear();
        courseList.addAll(fullCourseList);
        List<Course> filterCourse = new ArrayList<>();
        for(Course c:courseList){
            if(c.getCategory()==category){
                filterCourse.add(c);
            }
        }
        courseList.clear();
        courseList.addAll(filterCourse);

        courseAdapter.notifyDataSetChanged();
    }
    public static void showCourseAllCategory(){

        courseList.clear();
        courseList.addAll(fullCourseList);
        courseAdapter.notifyDataSetChanged();
    }

}