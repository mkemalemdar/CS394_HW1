package com.example.projeleme.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.projeleme.R
import com.example.projeleme.UserDetailActivity
import com.example.projeleme.model.User

class ItemAdapter(private val data: List<User>): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    class ItemViewHolder(private val view: View): RecyclerView.ViewHolder(view){

        private lateinit var user: User

        val nameView: TextView = view.findViewById(R.id.nameTV)
        val descView: TextView = view.findViewById(R.id.descTV)
        init {
            view.setOnClickListener{
                val context = itemView.context
                val showUserIntent = Intent(context, UserDetailActivity::class.java)

                showUserIntent.putExtra(UserDetailActivity.USER_NAME, user.name)
                showUserIntent.putExtra(UserDetailActivity.USER_DESC, user.desc)
                showUserIntent.putExtra(UserDetailActivity.USER_GENDER, user.gender)
                showUserIntent.putExtra(UserDetailActivity.USER_AGE, user.age)
                showUserIntent.putExtra(UserDetailActivity.USER_PREFERENCE, user.preference)
                showUserIntent.putExtra(UserDetailActivity.USER_NUMBER, user.number)

                context.startActivity(showUserIntent)
            }
        }
        fun bind(user:User){
            this.user = user
            nameView.text = user.name
            descView.text = user.desc
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val user = data[position]
        holder.bind(user)
    }

}
