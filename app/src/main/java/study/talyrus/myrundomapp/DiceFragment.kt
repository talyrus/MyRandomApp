package study.talyrus.myrundomapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import kotlin.random.Random

//константа для ключа сохранения состояния
private const val LAST_RANDOM_VALUE = "LAST_RANDOM_VALUE"
class DiceFragment : Fragment() {

    private lateinit var diceImageView: ImageView
    private lateinit var randomizeButton: Button
    private var randomValue = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_dice, container, false)
        diceImageView = view.findViewById(R.id.dice_image_view)
        randomizeButton = view.findViewById(R.id.randomize_button)

        savedInstanceState?.let { randomValue = it.getInt(LAST_RANDOM_VALUE) }
        rollDice(randomValue)

        randomizeButton.setOnClickListener {
            randomValue = Random.nextInt(1, 6)
            rollDice(randomValue)
        }

        return view
    }

    //подкидывает кубик
    private fun rollDice(randomValue: Int) {

        diceImageView.setImageResource(
            when (randomValue) {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                6 -> R.drawable.dice_6
                else -> R.drawable.dice_1
            }
        )
    }

    override fun onSaveInstanceState(outState: Bundle) {

        super.onSaveInstanceState(outState)
        outState.putInt(LAST_RANDOM_VALUE, randomValue)
    }

}