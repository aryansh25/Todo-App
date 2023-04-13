package com.example.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var todoList = mutableListOf(
            Todos("sleep", false),
            Todos("Phone",false),

            )
        val rvTodos= findViewById<androidx.recyclerview.widget.RecyclerView>(R.id.rvTodos)
        val addTodo=findViewById<Button>(R.id.addTodo)
        val etTodos=findViewById<EditText>(R.id.etTodos)
        val adapter= TodoAdapters(todoList)

        rvTodos.adapter=adapter
        rvTodos.layoutManager= LinearLayoutManager(this)

        addTodo.setOnClickListener {
            val Title = etTodos.text.toString()
            val todo= Todos(Title,false)
            todoList.add(todo)
            adapter.notifyItemInserted(todoList.size-1)
        }
    }
}