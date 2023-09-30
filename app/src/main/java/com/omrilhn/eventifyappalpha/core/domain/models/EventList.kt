package com.omrilhn.eventifyappalpha.core.domain.models

data class EventList (
    val activity:String?,
    val organizer:String?,
    val artist :String?
){
    val matchingCombinations = listOf<String>(
        "$activity",
        "$organizer",
        "$artist",
        "$activity $organizer",
        "$activity $artist"
    )
    fun doesMatchSearchQuery(query:String):Boolean{
        if(activity !=null || organizer != null || artist != null){
            return matchingCombinations.any{
                it.contains(query,ignoreCase = true)
            }
        }
        return true
    }
}

