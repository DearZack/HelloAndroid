package io.github.dearzack.helloandroid.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import io.github.dearzack.helloandroid.R;
import io.github.dearzack.helloandroid.bean.Person;

/**
 * Created by Zack on 2017/5/28.
 */

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {

    private Context context;
    private List<Person> persons;
    private Callback callback;

    public PersonAdapter(Context context, List<Person> persons, Callback callback) {
        this.context = context;
        this.persons = persons;
        this.callback = callback;
    }

    @Override
    public PersonAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_person_info, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PersonAdapter.ViewHolder holder, final int position) {
        holder.head.setImageResource(persons.get(position).getHead());
        holder.name.setText(persons.get(position).getName());
        holder.root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onClick(v, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return persons == null ? 0 : persons.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout root;
        ImageView head;
        TextView name;

        public ViewHolder(View itemView) {
            super(itemView);
            root = (RelativeLayout) itemView.findViewById(R.id.root);
            head = (ImageView) itemView.findViewById(R.id.head);
            name = (TextView) itemView.findViewById(R.id.name);
        }
    }

    public interface Callback {
        void onClick(View view, int position);
    }

}
