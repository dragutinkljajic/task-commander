package com.example.android.taskcommander.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.taskcommander.R;
import com.example.android.taskcommander.model.Task;

import org.w3c.dom.Text;

public class TaskDetailsActivity extends AppCompatActivity {

    TextView mCaptionTextView;
    TextView mDesctriptionTextView;
    Button mCompleteButton;
    Toast mToastyText;
    ProgressBar mSpinningLoader;
    Task task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_details);
        Intent intent = getIntent();
        task = (Task)intent.getSerializableExtra("task");

        mCaptionTextView = (TextView) findViewById(R.id.task_details_caption_tv);
        mDesctriptionTextView = (TextView) findViewById(R.id.task_details_description_tv);
        mCompleteButton = (Button) findViewById(R.id.complete_btn);
        mSpinningLoader = (ProgressBar) findViewById(R.id.complete_progress_spinning_loader);

        mCaptionTextView.setText(task.getCaption());
        mDesctriptionTextView.setText(task.getDescription());

    }

    public void completeButtonClicked(final View view) {
        mSpinningLoader.setVisibility(View.VISIBLE);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mSpinningLoader.setVisibility(View.INVISIBLE);
                Toast.makeText(getBaseContext(), getResources().getString(R.string.completion_message),
                        Toast.LENGTH_SHORT).show();

                Context context = view.getContext();
                Intent intent = new Intent(context, HomeActivity.class);
                intent.putExtra("task", task);
                context.startActivity(intent);
            }
        }, 2000);


    }

}
