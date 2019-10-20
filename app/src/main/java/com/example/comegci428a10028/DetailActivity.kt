package com.example.egci428a10028

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.egci428.a10028.R


import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val bundle = intent.extras
        val cityName:String?
        val cityDetail:String?
        val cityRegion:String?
        val cityImg:String?

        if(bundle!=null){
            cityName=bundle.getString("name")
            cityDetail=bundle.getString("desc")
            cityRegion=bundle.getString("region")
            cityImg=bundle.getString("image")
            titleText.text = cityName
            descriptionText.text = cityDetail
            courseNumber.text = "Location: " + cityRegion
            val res=this.resources.getIdentifier(cityImg,"drawable",this.packageName)
            imgCourse.setImageResource(res)
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail,menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.getItemId()
        if (id == android.R.id.home){
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
