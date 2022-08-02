package com.example.lessons

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lessons.databinding.ActivityMainBinding
import com.example.lessons.databinding.FragmentBlankMainBinding

class BlankFragment_main : Fragment() {
    interface ButtonOnClickListner{
        fun onClickButton()
    }

    private var listner: ButtonOnClickListner? = null
    lateinit var binding: FragmentBlankMainBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBlankMainBinding.inflate(inflater)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = BlankFragment_main()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is ButtonOnClickListner){
            listner = context
        }
    }

    override fun onStart() {
        super.onStart()
        binding.btnFrag.setOnClickListener(){listner?.onClickButton()}
    }

    override fun onDetach() {
        super.onDetach()
        listner = null
    }
}