package com.ihzapassya.recyclerviewinfragment.activity

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.ihzapassya.recyclerviewinfragment.R

class DetailFoodActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_food)

        if (supportActionBar != null)
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        var img: ImageView = findViewById(R.id.food_image)
        var nameTxt: TextView = findViewById(R.id.food_name)
        var summaryTxt: TextView = findViewById(R.id.food_information)

        val i = this.intent

        val images  = i.extras!!.getString("IMAGE_KEY")
        val name    = i.extras!!.getString("NAME_KEY")
        val summary = i.extras!!.getString("SUMMARY_KEY")

        title = "Detail $name"

        img.setImageURI(Uri.parse(images))
        nameTxt.text = name
        summaryTxt.text = summary

        Glide.with(this)
            .load(images)
            .into(img)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home)
            finish()
        return super.onOptionsItemSelected(item)
    }
    override fun onBackPressed() {
        finish()
    }
}