package com.example.oddoreven

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import com.example.oddoreven.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val dataModel: DataModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Открытие Fragment и обновление данных в реальном времени благодаря
        //
        // companion object{
        //        @JvmStatic
        //        fun newInstance() = TwoFragment()
        //    }
        openFrag(OneFragment.newInstance(), R.id.OneFrame)
        openFrag(TwoFragment.newInstance(), R.id.TwoFrame)

        dataModel.messageForActivityOneFragment.observe(this) {
            binding.Top.text = it
        }
        //Получение данных с Fragment и изменение TextView
        dataModel.messageForActivityTwoFragment.observe(this) {
            binding.Down.text = it
        }
        //Отправка данных в Fragment
        binding.FragmentId.setOnClickListener{
            dataModel.messageForOneFragment.value = arrayOf(
                "Баран Эээйбаля",
                "Казаки",
                "Городки",
                "Дурачки",
                "Чижик",
                "Пыжик",
                "Лапта").random()
            dataModel.messageForTwoFragment.value = arrayOf(
                "Иуууу",
                "BattleDroids",
                "Desrtoyer",
                "Counter-Strike",
                "Diablo 3",
                "globale offensive",
                "crash").random()
        }
    }
   private fun openFrag(f: Fragment, idHolder: Int){
        supportFragmentManager
            .beginTransaction()
            .replace(idHolder, f)
            .commit()
    }
}
