package com.techfortyone.roomerphilip.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.techfortyone.roomerphilip.Director
import com.techfortyone.roomerphilip.School

//1 to 1 relationship
data class SchoolAndDirector(
    @Embedded val school: School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val director: Director
)