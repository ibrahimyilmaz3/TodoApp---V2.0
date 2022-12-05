package com.iyilmaz.todoapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.getSystemService
import androidx.viewpager.widget.PagerAdapter
import com.iyilmaz.todoapp.R

class ViewPagerAdapter(val context: Context) : PagerAdapter() {

    var layoutInflater: LayoutInflater? = null

    val imgArrayList = arrayListOf(
        R.drawable.document,
        R.drawable.flowchart,
        R.drawable.ic_baseline_view_list_24,
        R.drawable.assessment
    )

    val headArrayList = arrayListOf(
        "Always keep up!",
        "Organize your chores!",
        "Never forget again!",
        "Let your phone do the thinking!"
    )

    val descriptionArrayList = arrayListOf(
        "App Description sadhsajhkjal shfjkashfkjlashf kjlahfkljsahfashf askhfaksjl",
        "Category Description ajdlhaskjh askfhaskjlsk fhjhfgfgah gfjhagfhjagdas jkdhgask",
        "Assignment Description asjajhbfsah bfhskdfjkad bfhdsbfjsad kbfhadksbfhb dsfjkbsdjkafbdsaj",
        "App-inn Screenshot Description fhds kjfnhsdk jhkdjsghjks dhgjkhgj kdsghjkds"
    )


    override fun getCount(): Int {
        return headArrayList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object` as ConstraintLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = layoutInflater!!.inflate(R.layout.slider, container, false)


        // TODO: IMPROVE TO VIEW BINDING HERE!
        val img = view.findViewById<ImageView>(R.id.image)
        val tvHead = view.findViewById<TextView>(R.id.tvHeader)
        val tvDescription = view.findViewById<TextView>(R.id.tvDescription)

        img.setImageResource(imgArrayList[position])
        tvHead.text = headArrayList[position]
        tvDescription.text = descriptionArrayList[position]

        container.addView(view)

        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as ConstraintLayout)
    }
}