package com.ubayadev.adv160421017week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.ubayadev.adv160421017week2.databinding.FragmentMainBinding
import kotlin.random.Random

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    var number1=0
    var number2=0
    var point=0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(
            inflater,
            container, false
        )
        return binding.root
    }
    fun UpdateQuestion(){
        number1= Random.nextInt(100)
        number2= Random.nextInt(100)
        binding.txtQuestion.text= number1.toString() + " + " + number2.toString()
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        binding.btnStart.setOnClickListener {
//            val playerName = binding.txtName.text.toString()
//            val action = MainFragmentDirections.actionGameFragment(playerName)
//            Navigation.findNavController(it).navigate(action)
//        }
        UpdateQuestion()
        binding.btnAnswer.setOnClickListener{
            if (number1+number2==binding.txtAnswer.text.toString().toInt()){
                Toast.makeText(requireContext(), "Correct!", Toast.LENGTH_SHORT).show()
                point++
                UpdateQuestion()
                binding.txtAnswer.setText("")
            }
            else{
                val action = MainFragmentDirections.actionMainFragmentToResultFragment(point)
                Navigation.findNavController(it).navigate(action)
            }
        }

    }
}