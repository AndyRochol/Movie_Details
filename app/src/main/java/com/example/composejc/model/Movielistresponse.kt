package com.example.composejc.model

data class Movielistresponse(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)