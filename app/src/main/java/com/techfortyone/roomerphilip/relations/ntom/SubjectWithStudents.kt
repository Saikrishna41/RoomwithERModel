package com.techfortyone.roomerphilip.relations.ntom

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.techfortyone.roomerphilip.Student
import com.techfortyone.roomerphilip.Subject
import com.techfortyone.roomerphilip.relations.StudentSubjectCrossRef

data class SubjectWithStudents(
    @Embedded val subject: Subject,
    @Relation(
        parentColumn = "subjectName",
        entityColumn = "studentName",
        associateBy = Junction(StudentSubjectCrossRef::class)
    )
    val student: List<Student>
)