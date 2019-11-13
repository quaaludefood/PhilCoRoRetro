package com.example.philcororetro.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.philcororetro.R
import com.example.philcororetro.model.Action
import org.jetbrains.anko.find

/*

* */
class ActionAdaptor (val list: List<Action>, val context : Context) : RecyclerView.Adapter<ActionAdaptor.ItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(
            LayoutInflater.from(context)
                .inflate(R.layout.item_action, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val action = list[position]
        holder.bind(action)
    }

    //Title = Identifier
    //Text = Name

    class ItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val identifierTextView = itemView.find<TextView>(R.id.tv_identifier)
        private val nameTextView = itemView.find<TextView>(R.id.tv_name)

        fun bind(action: Action) {
            identifierTextView.text = action.identifier
            nameTextView.text =  action.name
        }
    }
}