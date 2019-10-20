package com.example.egci428a10028

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.*
import com.egci428.a10028.R
import com.example.comegci428a10028.City
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.course_item.view.*
import kotlin.collections.ArrayList



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val data= DataProvider.getData()
        val cityArrayAdapter =
            CityArrayAdapter(this, data!!)
        list.setAdapter(cityArrayAdapter)
        list.setOnItemClickListener{ adapterView, View, position, l ->
            val course = data[position]
            displayDetail(course,position)
        }
        //add random but suppose to be on menu bar
        imageView2.setOnClickListener {
            DataProvider.randomCity()
            cityArrayAdapter.notifyDataSetChanged()
        }

    }
    private fun displayDetail(city: City, position: Int){
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("region", city.part)
        intent.putExtra("desc", city.description)
        intent.putExtra("name",city.name)
        intent.putExtra("image", city.image)
        startActivity(intent)
    }

    private class CityArrayAdapter(var context: Context, var objects: ArrayList<City>): BaseAdapter(){
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val city=objects[position]
            val view:View
            if(convertView==null){
                val layoutInflater=LayoutInflater.from(parent!!.context)
                view = layoutInflater.inflate(R.layout.course_item,parent,false)
                val viewHolder= ViewHolder(view.titleText, view.titleText2, view.imgCourse)
                view.tag = viewHolder
            }else{
                view=convertView
            }
            val viewHolder=view.tag as ViewHolder
            viewHolder.titleText.text=city.name
            viewHolder.titleText2.text= "Location: " + city.part
            //change image according to city
            val res=context.resources.getIdentifier(city.image,"drawable",context.packageName)
            viewHolder.imageCourse.setImageResource(res)
            return view
        }
        private class ViewHolder(val titleText: TextView, val titleText2: TextView, val imageCourse: ImageView)

        override fun getItem(position: Int): Any {
            return objects[position]
        }
        override fun getItemId(position: Int): Long {
            return position.toLong()
        }
        override fun getCount(): Int {
            return objects.size
        }
    }
    /*
    override fun onCreateOptionsMenu(menu: Menu?):Boolean{
        menuInflater.inflate(R.menu.menu_detail,menu)
        return super.onCreateOptionsMenu(menu)
    }

     */

    ///not working
    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item?.itemId
        if(id==R.id.randomcity){
                DataProvider.randomCity()
        }
        return super.onOptionsItemSelected(item)
    }

}