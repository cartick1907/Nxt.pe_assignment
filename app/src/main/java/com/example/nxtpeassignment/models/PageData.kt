package com.example.nxtpeassignment.models

data class PageData(
    val cancel_text: String,
    val page_items: List<PageItem>,
    val page_title: String,
    val proceed_txt: String,
    val status_check: StatusCheck
)