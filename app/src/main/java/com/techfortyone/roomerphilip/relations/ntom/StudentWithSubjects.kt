package com.techfortyone.roomerphilip.relations.ntom

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.techfortyone.roomerphilip.Student
import com.techfortyone.roomerphilip.Subject
import com.techfortyone.roomerphilip.relations.StudentSubjectCrossRef

data class StudentWithSubjects(
    @Embedded val student: Student,
    @Relation(
        parentColumn = "studentName",
        entityColumn = "subjectName",
        associateBy = Junction(StudentSubjectCrossRef::class)
    )
    val subjects : List<Subject>
)