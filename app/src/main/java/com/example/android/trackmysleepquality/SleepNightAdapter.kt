package com.example.android.trackmysleepquality

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android.trackmysleepquality.database.SleepNight

class SleepNightAdapter: RecyclerView.Adapter<TextItemViewHolder>() {

    var data =  listOf<SleepNight>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    //when the RecyclerView needs a view holder to represent an item.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TextItemViewHolder {
        //create an instance of LayoutInflater.
        val layoutInflater = LayoutInflater.from(parent.context)
        val view =layoutInflater.inflate(R.layout.text_item_view,parent,false) as TextView

        return TextItemViewHolder(view)
    }
    // to display the data for one list item at the specified position.
    override fun onBindViewHolder(holder: TextItemViewHolder, position: Int) {
        //create a variable for one item at a given position in the data.
        val item = data[position]
        //set the text of the textView to the sleep-quality number
        holder.textView.text = item.sleepQuality.toString()

        if (item.sleepQuality <= 1) {
            holder.textView.setTextColor(Color.RED) // red
        } else {
            // reset
            holder.textView.setTextColor(Color.GREEN) // black
        }
    }

    //to return the size of the list of sleep nights in data
    override fun getItemCount() = data.size

}