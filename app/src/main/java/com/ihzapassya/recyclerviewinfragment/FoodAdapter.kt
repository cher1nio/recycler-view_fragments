package com.ihzapassya.recyclerviewinfragment

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.ihzapassya.recyclerviewinfragment.activity.DetailFoodActivity
import kotlinx.android.synthetic.main.item_food_menu.view.*

class FoodAdapter(val activity: Activity): RecyclerView.Adapter<FoodAdapter.ViewHolder>() {
    private var listFood = arrayListOf<FoodModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_food_menu, parent, false))
    }

    override fun getItemCount(): Int {
        return listFood.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listFood[position])
    }

    fun setData(courseItems: List<FoodModel>) {
        listFood.clear()
        listFood.addAll(courseItems)
    }

    inner class ViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        fun bind(food: FoodModel) {
            with(view) {

                Glide.with(this.context)
                    .load(food.image)
                    .apply(RequestOptions().override(350, 550))
                    .into(food_image)

                food_name.text = food.name
                food_information.text = food.information

                view.btnPreview.setOnClickListener {
                    val i = Intent(activity, DetailFoodActivity::class.java)
                    i.putExtra("IMAGE_KEY", food.image)
                    i.putExtra("NAME_KEY", food.name)
                    i.putExtra("SUMMARY_KEY", food.information)
                    activity.startActivity(i)
                }
                view.btnShare.setOnClickListener{
                    val sendIntent: Intent = Intent().apply {
                        action = Intent.ACTION_SEND
                        putExtra(Intent.EXTRA_TEXT, food.name + "\n\n" + food.information)
                        type = "text/plain"
                    }

                    val shareIntent = Intent.createChooser(sendIntent, null)
                    context.startActivity(shareIntent)
                }
            }
        }
    }
}