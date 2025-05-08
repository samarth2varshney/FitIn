package com.example.fitin.ui

import android.app.Activity
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.bumptech.glide.Glide
import com.example.fitin.R
import com.example.fitin.databinding.FragmentPurchaseBinding
import com.razorpay.Checkout
import com.razorpay.PaymentResultListener
import org.json.JSONObject
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import kotlin.math.roundToInt

class PurchaseFragment : Fragment(), PaymentResultListener {

    var location:String = ""
    var type:String = ""
    var startDate:String =""
    var endDate:String =""
    var originalCost = 0;
    var cost = 0
    var discount = 0.25
    var couponDiscount = 0.15
    var chechFlag = true
    var coupon = ""
    var courseImage = ""
    var courseName = ""
    private var _binding: FragmentPurchaseBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentPurchaseBinding.inflate(inflater,container,false)

        originalCost = 1000
        cost = (originalCost*(1-discount)).roundToInt()

        courseImage = ""
        courseName = "Ultimate Body"
        location = ""
        type = ""
        startDate = ""
        endDate = ""

//        Glide.with(this).load(courseImage).fitCenter().into(binding.imageView5)
        binding.courseName.text = courseName
        binding.endDate.text = endDate
        binding.cost.text = originalCost.toString()
        binding.discount.text = (originalCost*discount).roundToInt().toString()
        binding.couponDiscount.text = 0.toString()
        binding.total.text = cost.toString()

        binding.apply.setOnClickListener {
            coupon = binding.coupon.text.toString()
            if(coupon.length>=3&&coupon[0]=='T'&&coupon[1]=='H'&&coupon[2]=='E'&&chechFlag){
                binding.couponDiscount.text = (originalCost*couponDiscount).roundToInt().toString()
                cost-= (originalCost*couponDiscount).roundToInt()
                binding.total.text = cost.toString()
                chechFlag = false
            }else if(chechFlag){
                Toast.makeText(requireContext(),"Invalid Coupon Code", Toast.LENGTH_SHORT).show()
            }
        }

        Checkout.preload(requireContext())

        binding.btnPayNow.setOnClickListener {
            payNow(cost, courseName)
        }

        return binding.root
    }

    fun payNow(amount: Int, courseName: String?){
        val checkout = Checkout()
        checkout.setKeyID("rzp_test_z4hn27x6bb4cZV")

        try {
            val options = JSONObject()
            options.put("name", "all THE Classes")
            options.put("description", courseName)
            options.put("currency", "INR")
            options.put("amount", amount*100)

            val retryObj = JSONObject()
            retryObj.put("enable", true)
            retryObj.put("max_count", 4)
            options.put("retry", retryObj)

            checkout.open(requireContext() as Activity?, options)
        } catch (e: Exception) {
//            Toast.makeText(requireContext(),"Error in Payment: " + e.message, Toast.LENGTH_SHORT ).show()
            e.printStackTrace()
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onPaymentSuccess(p0: String?) {
        Toast.makeText(requireContext(),"Payment Complete", Toast.LENGTH_SHORT ).show()
    }

    override fun onPaymentError(p0: Int, p1: String?) {

    }

}