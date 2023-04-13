package com.example.todoapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TodoAdapters(
    var todos: List<Todos>
): RecyclerView.Adapter<TodoAdapters.TodoViewHolders>()
{
    inner class TodoViewHolders(itemView: View):RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolders {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_todos, parent,false)
        return TodoViewHolders(view)
    }

    override fun onBindViewHolder(holder: TodoViewHolders, position: Int) {
        holder.itemView.apply {
            val tvTitle=findViewById<TextView>(R.id.tvTitle)
            val cbDone=findViewById<CheckBox>(R.id.cbDone)
            tvTitle.text=todos[position].Title
            cbDone.isChecked=todos[position].isChecked
        }
    }

    override fun getItemCount(): Int {
        return todos.size
    }
}