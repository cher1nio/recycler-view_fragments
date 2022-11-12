package com.ihzapassya.recyclerviewinfragment.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ihzapassya.recyclerviewinfragment.FoodAdapter
import com.ihzapassya.recyclerviewinfragment.FoodData
import com.ihzapassya.recyclerviewinfragment.FoodModel
import com.ihzapassya.recyclerviewinfragment.R
import kotlinx.android.synthetic.main.fragment_food.*

class FoodFragment : Fragment() {
    private val rvFood: RecyclerView
        get() = rv_food_list

    private lateinit var foodAdapter: FoodAdapter

    private fun getFood(): List<FoodModel> {
        return FoodData.generateFood()
    }

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_food, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.title = "List Food"

        foodAdapter = FoodAdapter(requireActivity())
        foodAdapter.setData(getFood())

        rvFood.layoutManager = LinearLayoutManager(requireContext())
        rvFood.setHasFixedSize(true)
        rvFood.adapter = foodAdapter
    }
}