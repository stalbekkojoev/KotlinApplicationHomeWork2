package kg.geektech.kotlinapplicationhomework2

import android.os.Bundle
import android.webkit.URLUtil.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kg.geektech.kotlinapplicationhomework2.databinding.ActivityMainBinding
import kg.geektech.kotlinapplicationhomework2.extentions.load
import kg.geektech.kotlinapplicationhomework2.extentions.randomList
import kg.geektech.kotlinapplicationhomework2.extentions.showToast

/*Дз. Первоначально добавляем в массив 10 рандомных url картинок. ++++
     В xml вы добавляете ImageView, EditText, Button, RandomButton    ++++
     При вводе и нажатии кнопки submit в массив добавляете урл картинки ++++
     при нажатии на рандомБаттон вы рандомно через глайд выводите картинку ++++
     Сделать валидацию на правильность url  ++++ */

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val imageArray = listOf(
        R.drawable.ic_2b, R.drawable.ic_android, R.drawable.ic_c_plus, R.drawable.ic_c_sharp,
        R.drawable.ic_html, R.drawable.ic_hu_tao, R.drawable.ic_hu_tao_2, R.drawable.ic_java,
        R.drawable.ic_kotlin, R.drawable.ic_wallpaper
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setOnClickMethod()
    }

    private fun setOnClickMethod() {
        binding.apply {
            submitButton.setOnClickListener {
                if (isHttpsUrl(editText1.text.toString()) || isHttpUrl(editText1.text.toString()) && isValidUrl(
                        editText1.text.toString()
                    )
                )
                    imageView.load(editText1.text.toString())
                else showToast("Пожалуйста, правильно укажите ссылку")
            }
            Toast.makeText(this@MainActivity, "Llkjkdajslkja", Toast.LENGTH_SHORT).show()
            showToast("asdjkasjdka")

            randomButton.setOnClickListener {
                imageView.setImageResource(imageArray.randomList())
            }
        }
    }
}