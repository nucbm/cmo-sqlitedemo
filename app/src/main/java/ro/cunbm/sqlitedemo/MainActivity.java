package ro.cunbm.sqlitedemo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MyRvAdapter.ItemClickListener {

    MyRvAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHandler db = new DatabaseHandler(this);

        // Inserting Students
        Log.d("Insert: ", "Inserting ..");
        db.addStudent(new Student(1, "Stud Aa"));
        db.addStudent(new Student(2, "Stud Bb"));
        db.addStudent(new Student(3, "Stud Cc"));
        db.addStudent(new Student(4, "Stud Dd"));

        // Reading all Students
        Log.d("Reading: ", "Reading all students..");
        List<Student> students = db.getAllStudentList();

        students.add(new Student(1,"Stud Xx"));
        students.add(new Student(2,"Stud Yy"));

        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.rvStudents);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyRvAdapter(this, students);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
    }
}