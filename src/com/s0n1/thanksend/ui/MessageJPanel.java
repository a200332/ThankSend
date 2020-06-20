package com.s0n1.thanksend.ui;

import com.s0n1.thanksend.tcp.Message;
import com.s0n1.thanksend.widget.message.MessageAdapter;
import com.s0n1.thanksend.widget.view.RCBorder;
import com.s0n1.thanksend.widget.view.list.RCListView;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Edsuns@qq.com on 2020/6/16
 */
public class MessageJPanel extends JPanel {
    RCListView listView;
    private final List<Message> messages = new ArrayList<>();

    public MessageJPanel() {
        setLayout(new GridLayout(1, 1));

        listView = new RCListView(0, 15);
        listView.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        MessageAdapter adapter = new MessageAdapter(messages);
        listView.setAdapter(adapter);
        add(listView);

        setBorder(new RCBorder(RCBorder.BOTTOM, Colors.LIGHT_GRAY));
    }

    public void receive(Message message) {
        messages.add(message);
        listView.notifyItemInserted(messages.size() - 1, true);
    }

    public void send(Message message) {
        messages.add(message);
        listView.notifyItemInserted(messages.size() - 1, true);
        listView.setAutoScrollToBottom();
    }
}
