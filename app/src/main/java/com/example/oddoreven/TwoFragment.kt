package com.example.oddoreven

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import com.example.oddoreven.databinding.FragmentTwoBinding

class TwoFragment : Fragment() {

    lateinit var binding: FragmentTwoBinding
    private  val dataModel: DataModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTwoBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //Получение данных с Activity и изменение TextView
        dataModel.messageForTwoFragment.observe(activity as LifecycleOwner){
            binding.woaw.text = it
        }
        //Отправка данных в Activity
        binding.button2.setOnClickListener{
            dataModel.messageForActivityTwoFragment.value =
                arrayOf(
                    "Красный",
                    "VIOL",
                    "Голубой",
                    "Синий").random()

        }
        dataModel.messageForTwoFragmentFrom1.observe(activity as LifecycleOwner){
            binding.frg2tofrg1.text = it
        }
        binding.Frag2to1.setOnClickListener{
            dataModel.messageForFragmentFrom2.value =  arrayOf(
                "1",
                "2",
                "3",
                "4").random()
        }
    }

    companion object{
        @JvmStatic
        fun newInstance() = TwoFragment()
    }
}
