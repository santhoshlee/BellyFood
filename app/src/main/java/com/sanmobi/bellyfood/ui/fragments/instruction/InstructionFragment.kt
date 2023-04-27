package com.sanmobi.bellyfood.ui.fragments.instruction

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import com.sanmobi.bellyfood.R
import com.sanmobi.bellyfood.models.Result
import com.sanmobi.bellyfood.util.Constants
import kotlinx.android.synthetic.main.fragment_instruction.view.*

class InstructionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       val view = inflater.inflate(R.layout.fragment_instruction, container, false)

        val args = arguments
        val myBundle: Result? = args?.getParcelable(Constants.RECIPE_RESULT_KEY)

        view.instructions_webView.webViewClient = object : WebViewClient() {}
        val websiteUrl: String = myBundle!!.sourceUrl
        view.instructions_webView.loadUrl(websiteUrl)

       return  view
    }

}