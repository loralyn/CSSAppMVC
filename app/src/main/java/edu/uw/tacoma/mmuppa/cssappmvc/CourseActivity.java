package edu.uw.tacoma.mmuppa.cssappmvc;

import edu.uw.tacoma.mmuppa.cssappmvc.model.*;

import android.os.PersistableBundle;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;


public class CourseActivity extends ActionBarActivity {

    private Course mCourse;

    private EditText mCourseIdEditText;
    private EditText mCourseShortDescriptionEditText;
    private EditText mCourseLongDescriptionEditText;
    private EditText mCoursePrereqsEditText;
    private Button mAddButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);


        mCourseIdEditText = (EditText) findViewById(R.id.course_id_edit_text);
        mCourseShortDescriptionEditText = (EditText) findViewById(R.id.course_short_desc_edit_text);
        mCourseLongDescriptionEditText = (EditText) findViewById(R.id.course_long_desc_edit_text);
        mCoursePrereqsEditText  = (EditText) findViewById(R.id.course_prereqs_edit_text);
        mAddButton = (Button) findViewById(R.id.course_add_button);

        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String courseId = mCourseIdEditText.getText().toString();
                String shortDesc = mCourseShortDescriptionEditText.getText().toString();
                String longDesc = mCourseLongDescriptionEditText.getText().toString();
                String prereqs = mCoursePrereqsEditText.getText().toString();

                if (courseId.length() == 0 || shortDesc.length() == 0
                        || longDesc.length() == 0) {
                    Toast.makeText(v.getContext(), "Please enter all fields except for prereqs"
                         , Toast.LENGTH_SHORT)
                        .show();
                    return;
                }
                if (prereqs.length() == 0) prereqs = null;
                mCourse = new Course(courseId, shortDesc, longDesc, prereqs);
                Toast.makeText(v.getContext(), "Course added successfully!", Toast.LENGTH_SHORT)
                        .show();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_course, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);

        outState.putSerializable("course", mCourse);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        mCourse = (Course) savedInstanceState.getSerializable("course");
    }
}
