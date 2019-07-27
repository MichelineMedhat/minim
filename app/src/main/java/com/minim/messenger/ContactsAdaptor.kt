package com.minim.messenger

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactsAdaptor(private val context: Context, private val users: ArrayList<User>) :
    RecyclerView.Adapter<ContactsAdaptor.ContactHolder>() {

    override fun getItemCount() = users.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ContactHolder(LayoutInflater.from(parent.context).inflate(R.layout.contact_item, parent, false))

    override fun onBindViewHolder(holder: ContactHolder, position: Int) {
        holder.contactUsername.text = users[position].username
        holder.parentLayout.setOnClickListener {
            val intent = Intent(context, MainActivity::class.java)
            context.startActivity(intent)
        }
    }

    inner class ContactHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var contactUsername: TextView = itemView.findViewById(R.id.contactUsername)
        internal var parentLayout: LinearLayout = itemView.findViewById(R.id.contactLinearLayout)
    }

}