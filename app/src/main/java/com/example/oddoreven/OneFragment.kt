package com.example.oddoreven

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.example.oddoreven.databinding.FragmentOne2Binding

class OneFragment : Fragment() {

    lateinit var binding: FragmentOne2Binding
    private  val dataModel: DataModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOne2Binding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        dataModel.messageForOneFragment.observe(activity as LifecycleOwner){
            binding.Text.text = it
        }
        binding.button.setOnClickListener{
            dataModel.messageForActivityOneFragment.value =
                arrayOf(
                    "Красный",
                    "VIOL",
                    "Голубой",
                    "Синий").random()

        }
        dataModel.messageForFragmentFrom2.observe(activity as LifecycleOwner){
            binding.frgtofrg.text = it
        }
        binding.Frag1to2.setOnClickListener{
            dataModel.messageForTwoFragmentFrom1.value =  arrayOf(
                "1",
                "2",
                "3",
                "4").random()
        }
    }

    companion object{
        @JvmStatic
        fun newInstance() = OneFragment()
    }
}
