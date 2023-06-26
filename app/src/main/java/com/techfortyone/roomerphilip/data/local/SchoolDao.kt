package com.techfortyone.roomerphilip.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.techfortyone.roomerphilip.Director
import com.techfortyone.roomerphilip.School
import com.techfortyone.roomerphilip.Student
import com.techfortyone.roomerphilip.Subject
import com.techfortyone.roomerphilip.relations.SchoolAndDirector
import com.techfortyone.roomerphilip.relations.SchoolWithStudents
import com.techfortyone.roomerphilip.relations.StudentSubjectCrossRef


@Dao
interface SchoolDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchool(school: School)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDirector(director: Director)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun studentSubjectCrossRef(studentSubjectCrossRef: StudentSubjectCrossRef)

    @Transaction
    @Query("SELECT * FROM school WHERE schoolName = :schoolName")
    suspend fun getSchoolAndDirectorWithSchoolName(schoolName: String): List<SchoolAndDirector>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudent(student: Student)

    @Transaction
    @Query("SELECT * FROM school WHERE schoolName = :schooName")
    suspend fun getSchoolWithStudents(schooName : String) : List<SchoolWithStudents>


    @Transaction
    @Query("SELECT * FROM subject WHERE subjectName = :subjectName")
    suspend fun getStudentsOfSubject(subjectName : String) : List<Student>


    @Transaction
    @Query("SELECT * FROM student WHERE studentName = :studentName")
    suspend fun getSubjectsOfStudent(studentName : String) : List<Subject>



}