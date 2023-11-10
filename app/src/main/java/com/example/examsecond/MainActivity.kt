package com.example.examsecond

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.examsecond.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private  var startCondition = mutableSetOf<String>()
    private lateinit var grouped: Collection<List<String>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSave.setOnClickListener {
            if(binding.etEnterAnagram.text.toString().isEmpty()){
                Toast.makeText(this, "Empty Field!!", Toast.LENGTH_SHORT).show()

            }else{
            startCondition.add(binding.etEnterAnagram.text.toString())
            clearField()}
        }

        binding.btnOutput.setOnClickListener {
            grouped = startCondition.groupBy { it.toCharArray().sorted().joinToString("") }.values
            binding.tvAnagramsCount.text = grouped.size.toString()
            clearField()
        }

    }
    private fun clearField(){
        binding.etEnterAnagram.setText("")
    }

}