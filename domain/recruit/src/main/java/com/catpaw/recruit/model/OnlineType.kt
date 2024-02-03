package com.catpaw.recruit.model

enum class OnlineType(
    val korean: String,
) {
    ONLINE("온라인"), OFFLINE("오프라인"), COMPOSITE("온오프라인 병행");

    val query get() = this.name.lowercase()
}
