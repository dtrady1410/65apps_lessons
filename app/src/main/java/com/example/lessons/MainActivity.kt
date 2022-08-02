package com.example.lessons

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Switch
import androidx.fragment.app.Fragment
import com.example.lessons.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),
    BlankFragment_main.ButtonOnClickListner {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction().replace(R.id.cont_holder, BlankFragment_main.newInstance()).commit()
    }

    override fun onClickButton() {
        addFragment(BlankFragment_cont_2.newInstance(), R.id.cont_holder)
    }

    fun addFragment(f: Fragment, IdHolder: Int){
        val trans = supportFragmentManager.beginTransaction()
        trans.replace(IdHolder, f).addToBackStack(null).commit()
    }
}