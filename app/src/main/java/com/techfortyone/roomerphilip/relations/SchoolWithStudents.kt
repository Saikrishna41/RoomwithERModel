package com.techfortyone.roomerphilip.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.techfortyone.roomerphilip.School
import com.techfortyone.roomerphilip.Student

data class SchoolWithStudents(
    @Embedded val school: School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val students : List<Student>
)