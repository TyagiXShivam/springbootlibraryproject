package com.library.bootjpa.repository;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.library.bootjpa.entity.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	@Transactional
	@Query("select s.stpassword from Student s where s.id= :sid")
	String selectStudentById(@Param("sid") Long id);
}
