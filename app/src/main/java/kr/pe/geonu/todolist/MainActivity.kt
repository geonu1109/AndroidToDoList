package kr.pe.geonu.todolist

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.main_list_item.view.*

class MainActivity : AppCompatActivity() {
    var items: Array<ToDoItem> = arrayOf(ToDoItem("할일1", "내용1"), ToDoItem("할일2", "내용2"))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.adapter = MyAdapter()
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    inner class MyViewHolder(item: View): RecyclerView.ViewHolder(item) {

    }

    inner class MyAdapter: RecyclerView.Adapter<MyViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.main_list_item, parent, false)
            return MyViewHolder(view)
        }

        override fun getItemCount(): Int {
            return items.count()
        }

        override fun onBindViewHolder(holder: MyViewHolder, i: Int) {
            holder.itemView.titleTextView.text = items[i].title
            holder.itemView.contentTextView.text = items[i].content
        }

    }
}
