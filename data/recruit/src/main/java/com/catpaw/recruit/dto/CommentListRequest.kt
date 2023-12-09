package com.catpaw.recruit.dto

import android.util.Log

class CommentListRequest(
    page: Int = 0,
    size: Int = 1,
    isPage: Boolean = false,
    sorted: String = "created"
) : HashMap<String, String>() {
    init {
        putAll(
            listOf(
                "page" to page.toString(),
                "size" to size.toString(),
                "isPage" to isPage.toString(),
                "sorted" to sorted,
            )
        )
        Log.d("CommentListRequest", "constructor: $this")
    }
}
