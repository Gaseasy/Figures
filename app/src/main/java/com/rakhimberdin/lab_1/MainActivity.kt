package com.rakhimberdin.lab_1

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.GsonBuilder
import java.io.File


class MainActivity : AppCompatActivity() {

    private var viewsList: ArrayList<DrawView> = arrayListOf()
    private var index = 0
    private var emotions: ArrayList<String> = arrayListOf("WOW", "AMAZING", "INCREDIBLE")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val builder = GsonBuilder()
        val gson = builder.create()

        val content = File(getFileStreamPath("figures.json"), "").readText()

        val list = gson.fromJson(content, Array<Root>::class.java)

        list.forEach {
            viewsList += DrawView(this, it)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu):Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.mainmenu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem):Boolean {
        val id = item.itemId
        if (id == R.id.action_plus)
        {
            if (viewsList.isNotEmpty()) {
                if (index == viewsList.size)
                    index = 0
                setContentView(viewsList[index++])
            }
        }
        Toast.makeText(this, emotions.random(), Toast.LENGTH_SHORT).show()
        return super.onOptionsItemSelected(item)
    }

    @SuppressLint("ViewConstructor")
    class DrawView(context: Context?, private val figure: Root) : View(context) {

        private val paint: Paint = Paint()

        @SuppressLint("DrawAllocation", "SetTextI18n")
        override fun onDraw(canvas: Canvas?) {
            canvas?.drawARGB(80,255,255,255)
            paint.color = Color.argb(255,255,255,255)
            canvas?.drawRect(0f,0f,1100f,2400f, paint)
            figure.draw(canvas!!)
        }
    }
}