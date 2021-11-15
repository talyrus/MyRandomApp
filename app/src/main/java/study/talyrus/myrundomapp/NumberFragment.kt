package study.talyrus.myrundomapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

//константа для ключа сохранения состояния
private const val LAST_RANDOMIZED_VALUE = "LAST_RANDOMIZED_VALUE"

class NumberFragment : Fragment() {
    private lateinit var resultTextView: TextView
    private lateinit var randomizeButton: Button  //создадим переменные
    private var randomValue:Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_number, container, false)
        //инициализируем переменные
        // во фрагментах findViewById вызывается только из view
        resultTextView = view.findViewById(R.id.result_text_view)
        randomizeButton = view.findViewById(R.id.randomize_button)
        //если состояние сохранено, то применить его значение к текстовому полю результата
        randomValue = savedInstanceState?.getInt(LAST_RANDOMIZED_VALUE) ?: 0
        resultTextView.text = randomValue.toString()


        //рандомить новое число при нажатии на кнопку
        randomizeButton.setOnClickListener { randomize() }

        return view
    }
//сохраняем состояние приложенения
    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(LAST_RANDOMIZED_VALUE, randomValue) // кладем последнее значение
        super.onSaveInstanceState(outState)
    }

    // функция для генерации чисел от 0 до 100
    private fun randomize() {
        randomValue = Random.nextInt(100)
        resultTextView.text = randomValue.toString()
    }

}