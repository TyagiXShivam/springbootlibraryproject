package com.library.bootjpa.repository;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.library.bootjpa.entity.LibraryBook;
@Repository
public interface LibraryBookRepository extends JpaRepository<LibraryBook, Long>{
	@Transactional
	@Query("from LibraryBook l")
	ArrayList<LibraryBook> fetchAll();
	@Transactional
	@Query("select l.bookId from LibraryBook l where l.bookId= :bookId")
	Long selectBookById(@Param("bookId") Long id);
	@Transactional
	@Modifying
	@Query("update LibraryBook l set l.quantity= l.quantity-1 where l.id= :lid")
	void updateLibraryBookById(@Param("lid") Long id);
	@Transactional
	@Modifying
	@Query("update LibraryBook l1 set l1.quantity= l1.quantity+1 where l1.id= :lid1")
	void updateLibraryBookById1(@Param("lid1") Long id);
}
