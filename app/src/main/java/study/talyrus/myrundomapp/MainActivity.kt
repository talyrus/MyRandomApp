package study.talyrus.myrundomapp
/*
* Для создания нижнего меню
* 1. В res создается androidResourceFile - menu
* 2. В activity_main.xml создается BottomNavigationView
* 3. Создаются три фрагмента в Layout
* 4. Создаются три иконки для фрагментов в drawable
* 5. BottomNavigationView подключается menu
* 6. В activity_main.xml создается FragmentContainerView
* 7. Создаются три фрагмента (удаляем все. кроме класса и onCreateView)
* 8. в MainActivity создаем переменную bottomNavigationView и инициализируем
* 9. реализуем функции сохранения состояния и замены фрагмента
* 10. во fragments_number устанавливаем кнопку и текст
* 11. созадем общий стиль в themes
*
*
* */
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

private const val LAST_SELECTED_ITEM = "LAST_SELECTED_ITEM" // создаем константу для сохранения состояния activity/фрагмента
class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView:BottomNavigationView //создаем переменную

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNavigationView = findViewById(R.id.bottom_navigation_view) // инициализируем
        //подключаем слушатель
        bottomNavigationView.setOnItemSelectedListener { item->
            var fragment:Fragment? = null
            when(item.itemId){ //определяем действия в зависимости от нажатия
                R.id.number->{
                    fragment = NumberFragment() // создаем соответствующие фрагменты
                }
                R.id.dice->{
                    fragment = DiceFragment()
                }
                R.id.coin->{
                    fragment = CoinFragment()
                }

            }
                replaceFragment(fragment!!) //вызываем функцию замены
                true
        }
        //восстановление состояния нижнего навигационного меню
        // если не сохранено, то по умолчанию выбрать R.id.number
        bottomNavigationView.selectedItemId = savedInstanceState?.getInt(LAST_SELECTED_ITEM)?:R.id.number
    }

    // переопределим функцию сохранения состояния (восстановления) activity/фрагмента
    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(LAST_SELECTED_ITEM, bottomNavigationView.selectedItemId)
        super.onSaveInstanceState(outState)
    }

    // реализуем функцию замены фрагмента
    private fun replaceFragment(fragment: Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }
}