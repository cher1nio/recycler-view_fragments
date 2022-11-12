package com.ihzapassya.recyclerviewinfragment.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout
import com.ihzapassya.recyclerviewinfragment.R
import kotlinx.android.synthetic.main.fragment_call.*

class CallFragment : Fragment() {
    private val numberPhone: TextInputLayout?
        get() = number_phone

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_call, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.title = "Dial Number Phone"

        btnDial.setOnClickListener{
            val intent = Intent(
                Intent.ACTION_DIAL,
                Uri.parse("tel:" + Uri.encode(numberPhone?.editText?.editableText.toString())))
            startActivity(intent)
        }
    }
}