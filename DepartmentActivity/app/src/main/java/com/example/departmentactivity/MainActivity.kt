package com.example.departmentactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var departmentAdapter: DepartmentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
        addDataSet()

        val resultView = findViewById<TextView>(R.id.result)
        val latoBlack = ResourcesCompat.getFont(this, R.font.lato_black)
        val lato = ResourcesCompat.getFont(this, R.font.lato)
        val spanText = SpannableStringBuilder("48 results found")
        spanText.setSpan(latoBlack?.let { CustomTypefaceSpan("", it) }, 0, 2, Spanned.SPAN_EXCLUSIVE_INCLUSIVE)
        spanText.setSpan(lato?.let { CustomTypefaceSpan("", it) }, 2, 15, Spanned.SPAN_EXCLUSIVE_INCLUSIVE)
        resultView.text = spanText
    }

    private fun addDataSet(){
        val data = DataSource.createDataSet()
        departmentAdapter.submitList(data)
    }

    private fun initRecyclerView(){

        recycler_view.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            departmentAdapter = DepartmentAdapter()
            adapter = departmentAdapter
        }
    }
}