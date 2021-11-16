package study.talyrus.myrundomapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import study.talyrus.myrecyclerview.UserAdapter


class AboutFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_about, container, false)

        //создаем список для RecyclerView
        val userNameList: List<String> =
            listOf("Иван Иванов",
                "Петр Петров",
                "Сидор Сидоров",
                "Евгений Онегин",
                "Вениамин Золотов",
                "Елена Ивановна",
                "Сергей Петров",
                "Иоан Златоуст",
                "Марфа Петровна",
                "Преображенский",
                "Григорий Распутин")
        val userRecyclerView: RecyclerView = view.findViewById(R.id.users_recycler_view)
        userRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        //Установим декоратор для разделения холдеров
        userRecyclerView.addItemDecoration(
            DividerItemDecoration(
                context,
                DividerItemDecoration.VERTICAL
            )
        )
        userRecyclerView.adapter = UserAdapter(userNameList)

        return view
    }


}