package com.example.ithome


import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.*

class ItAdapter(private val itList:List<HomePage>):RecyclerView.Adapter<ItAdapter.ViewHolder>() {
    inner class ViewHolder(view: View):RecyclerView.ViewHolder(view){
        val itImageView:ImageView = view.findViewById(R.id.it_imageView)
        val itTitle:TextView = view.findViewById(R.id.it_title)
        val itTime:TextView = view.findViewById(R.id.it_time)
        val itEvaluateNumber:TextView = view.findViewById(R.id.it_evaluateNumber)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.home_page, parent, false)
        val viewHolder = ViewHolder(view)
        viewHolder.itemView.setOnClickListener {
            val intent = Intent(parent.context,ItContent::class.java)
            parent.context.startActivity(intent)
        }
        return ViewHolder(view)
    }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val homePage = itList[position]
        holder.itImageView.setImageResource(homePage.it_imageView)
        holder.itTitle.text = homePage.it_title
        holder.itTime.text = getTime()
        holder.itEvaluateNumber.text = homePage.it_evaluateNumber
    }

    override fun getItemCount()=itList.size


    fun getTime(): String {
        val date = Date()
        val dateFormat = SimpleDateFormat("HH:mm:ss", Locale.CHINA)
        return dateFormat.format(date)
    }

}