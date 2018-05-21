package com.example.android.taskcommander.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.android.taskcommander.R;
import com.example.android.taskcommander.adapters.ChatMsgAdapter;
import com.example.android.taskcommander.model.Message;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        setTitle("Android Chat App Example");

        // Get RecyclerView object.
        final RecyclerView msgRecyclerView = (RecyclerView)findViewById(R.id.chat_recycler_view);

        // Set RecyclerView layout manager.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        msgRecyclerView.setLayoutManager(linearLayoutManager);

        // Create the initial data list.
        final List<Message> msgList = new ArrayList<Message>();
        Message msg = new Message(Message.MSG_TYPE_RECEIVED, "cao");
        Message msg1 = new Message(Message.MSG_TYPE_SENT, "hello");
        Message msg2 = new Message(Message.MSG_TYPE_RECEIVED, "kakote");
        msgList.add(msg);
        msgList.add(msg1);
        msgList.add(msg2);

        // Create the data adapter with above data list.
        final ChatMsgAdapter chatMsgAdapter = new ChatMsgAdapter(msgList);

        // Set data adapter to RecyclerView.
        msgRecyclerView.setAdapter(chatMsgAdapter);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        msgRecyclerView.setLayoutManager(llm);

        final EditText msgInputText = (EditText)findViewById(R.id.chat_input_msg);

        Button msgSendButton = (Button)findViewById(R.id.chat_send_msg);

        msgSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msgContent = msgInputText.getText().toString();
                if(!TextUtils.isEmpty(msgContent))
                {
                    // Add a new sent message to the list.
                    Message msgDto = new Message(Message.MSG_TYPE_SENT, msgContent);
                    msgList.add(msgDto);

                    int newMsgPosition = msgList.size() - 1;

                    // Notify recycler view insert one new data.
                    chatMsgAdapter.notifyItemInserted(newMsgPosition);

                    // Scroll RecyclerView to the last message.
                    msgRecyclerView.scrollToPosition(newMsgPosition);

                    // Empty the input edit text box.
                    msgInputText.setText("");
                }
            }
        });
    }
}