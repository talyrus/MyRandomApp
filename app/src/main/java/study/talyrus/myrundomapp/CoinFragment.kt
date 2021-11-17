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
class CoinFragment : Fragment() {

  private lateinit var coinImageView: ImageView
  private lateinit var randomizeButton: Button
  private var randomValue = 1
  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                            savedInstanceState: Bundle?): View? {
    // Inflate the layout for this fragment
    val view = inflater.inflate(R.layout.fragment_coin, container, false)
    coinImageView = view.findViewById(R.id.coin_image_view)
    randomizeButton = view.findViewById(R.id.randomize_button)

    savedInstanceState?.let { randomValue = it.getInt(LAST_RANDOM_VALUE) }
    rollCoin(randomValue)

    randomizeButton.setOnClickListener {
      randomValue = Random.nextInt(1, 6)
      rollCoin(randomValue)
    }

    return view
  }

  //подкидывает монетку
  private fun rollCoin(randomValue: Int) {

    coinImageView.setImageResource(
      when (randomValue) {
        1 -> R.drawable.one
        2 -> R.drawable.two
        else -> R.drawable.one
      }
    )
  }

  override fun onSaveInstanceState(outState: Bundle) {

    super.onSaveInstanceState(outState)
    outState.putInt(LAST_RANDOM_VALUE, randomValue)
  }
}