package com.example.presentation

data class PlanItem (
    val id: Int,
    val planName: String,
    val planDescription: String,
    val imageUrl: String,
    val suscribersNo: String,
    val planPrice: String,
    val isBookMarked: Boolean
)