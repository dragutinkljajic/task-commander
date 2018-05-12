package com.example.android.taskcommander.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SyncStatusObserver;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.example.android.taskcommander.R;
import com.example.android.taskcommander.adapters.GroupsAdapter;
import com.example.android.taskcommander.adapters.TasksAdapter;
import com.example.android.taskcommander.model.Task;
import com.example.android.taskcommander.util.HttpUtils;
import com.example.android.taskcommander.util.JsonToClassMapper;
import com.example.android.taskcommander.util.SessionHandler;

import org.json.JSONArray;
import org.json.JSONObject;
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

        //if(!SessionHandler.loggedEmail().equals(task.getAsigneeMail())){
        if(!task.getAssigneeMail().equals("dad@mail.com")){
            mCompleteButton.setVisibility(View.INVISIBLE);
        }

        mSpinningLoader = (ProgressBar) findViewById(R.id.complete_progress_spinning_loader);
        mCaptionTextView.setText(task.getCaption());
        mDesctriptionTextView.setText(task.getDescription()+"\n\n"+ task.getDeadline()+ "\n\n"+ task.getAssigneeMail());
    }

    public void completeButtonClicked(final View view) {
        mSpinningLoader.setVisibility(View.VISIBLE);
        Handler handler = new Handler();
        AndroidNetworking.put(HttpUtils.WEB_SERVICE_BASE+"/task/complete/"+task.getUid()+"/dad@mail.com")
                .build()
                .getAsJSONArray(new JSONArrayRequestListener() {
                    @Override
                    public void onResponse(JSONArray response) {
                        System.out.println(response);
                        JsonToClassMapper jsonToClassMapper = new JsonToClassMapper();

                        mSpinningLoader.setVisibility(View.INVISIBLE);
                        Toast.makeText(getBaseContext(), getResources().getString(R.string.completion_message),
                                Toast.LENGTH_SHORT).show();

                        Context context = view.getContext();
                        Intent intent = new Intent(context, MainActivity.class);
                        intent.putExtra("task", task);
                        context.startActivity(intent);
                    }
                    @Override
                    public void onError(ANError error) {
                        // handle error
                    }
                });
    }

}
