package study.talyrus.myrecyclerview

import android.content.Intent
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import study.talyrus.myrundomapp.R

class UserViewHolder(itemView: View) :
    RecyclerView.ViewHolder(itemView) { // наследование от ViewHolder RecyclerView
    fun bind(userName: String) {
        val userNameTextView: TextView = itemView.findViewById(R.id.users_name_text_view)
        userNameTextView.text = userName

        val sendButton:Button = itemView.findViewById(R.id.send_button)
        sendButton.setOnClickListener{

            // реализация Intent
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, userName + ", Спасибо тебе за разработку этого приложения!!!")
            val chooser = Intent.createChooser(intent, "Благодарить разработчика!")

            sendButton.setOnClickListener {
              itemView.context.startActivity(chooser)
            }
        }
    }
}