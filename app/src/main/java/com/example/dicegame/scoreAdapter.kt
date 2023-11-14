package com.example.dicegame

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class scoreAdapter(
    var scoreItems: List<scoreItem>
): RecyclerView.Adapter<scoreAdapter.score_itemViewHolder>() {

    inner class score_itemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): score_itemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.score_item, parent, false)
        return score_itemViewHolder(view)
    }

    override fun onBindViewHolder(holder: score_itemViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.tvScoreName).text = scoreItems[position].name
        var pointsTV = holder.itemView.findViewById<TextView>(R.id.tvPoints)
        pointsTV.text = scoreItems[position].points.toString()
        if (!scoreItems[position].isSet){
            pointsTV.setTextColor(Color.parseColor("#008000"))
        }

    }

    override fun getItemCount(): Int {
        return scoreItems.size
    }
}