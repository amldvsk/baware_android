package io.baware.baware.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;

import java.util.ArrayList;

import io.baware.baware.POJO.ChatMessage;
import io.baware.baware.R;

/**
 * Created by adimoldavski on 27/02/16.
 */
public class ChatMessagesRvAdapter extends RecyclerView.Adapter<ChatMessagesRvAdapter.ChatMessagesViewHolder>{

    private ArrayList<ChatMessage> chatMessages;
    private boolean lessThenOneSecond = false;
    private Context context;

    public ChatMessagesRvAdapter(ArrayList<ChatMessage> chatMessages, Context context) {
        this.chatMessages = chatMessages;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        if( chatMessages.get(position).isItMe()) {
            return 1;
        } else {
            return 2;
        }
    }

    @Override
    public ChatMessagesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_message_me, parent, false);
        View v;

        if( viewType == 1 )
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_message_me, parent, false);
        else
            v = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_message_other, parent, false);

        ChatMessagesViewHolder chatMessagesViewHolder = new ChatMessagesViewHolder(v);
        return chatMessagesViewHolder;
    }

    @Override
    public void onBindViewHolder(ChatMessagesViewHolder holder, int position) {
        holder.username.setText(chatMessages.get(position).getUser().getUsername());
        holder.message.setText(chatMessages.get(position).getMessage());






        DateTime now = new DateTime();
        Period period = new Period(chatMessages.get(position).getDataEnterd(), now);


        PeriodFormatter formatter = null;
        if( period.getYears() == 0 ) {

            if( period.getMonths() == 0 ) {

                if(period.getWeeks() == 0) {

                    if( period.getHours() == 0 ) {

                        if(period.getMinutes() == 0) {

                            if( period.getSeconds() <= 0 ) {
                                formatter = null;
                            } else {
                                formatter = new PeriodFormatterBuilder().appendSeconds().appendSuffix("s").printZeroNever().toFormatter();
                            }

                        } else {
                            formatter = new PeriodFormatterBuilder().appendMinutes().appendSuffix("m").printZeroNever().toFormatter();
                        }

                    } else {
                        formatter = new PeriodFormatterBuilder().appendHours().appendSuffix("h").printZeroNever().toFormatter();
                    }

                } else {
                    formatter = new PeriodFormatterBuilder().appendWeeks().appendSuffix("w").printZeroNever().toFormatter();
                }

            } else {
                formatter = new PeriodFormatterBuilder().appendMonths().appendSuffix("m").printZeroNever().toFormatter();
            }

        } else {
            formatter = new PeriodFormatterBuilder().appendYears().appendSuffix("y").printZeroNever().toFormatter();
        }

        try {
            holder.date.setText(formatter.print(period));
        } catch (NullPointerException e) {
            e.printStackTrace();
            holder.date.setVisibility(View.GONE);
        }



        //Log.d("Chat messages adapter", "|                    message " + chatMessages.get(position).getMessage());

    }


    @Override
    public int getItemCount() {
        return this.chatMessages.size();
    }

    public class ChatMessagesViewHolder extends RecyclerView.ViewHolder {
        TextView username;
        TextView message, date;


        ChatMessagesViewHolder(View itemView) {
            super(itemView);
            username                = (TextView)itemView.findViewById(R.id.username);
            date                    = (TextView)itemView.findViewById(R.id.date);
            message                 = (TextView)itemView.findViewById(R.id.message);

        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }


    public void clear() {
        this.chatMessages.clear();
        this.notifyDataSetChanged();
    }


}
