package com.library.bootjpa.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.library.bootjpa.entity.Bookissue;
@Repository
public interface BookissueRepository extends JpaRepository<Bookissue, Long>{
	@Transactional
	@Modifying
	@Query("update Bookissue b set b.returnStatus= :bstatus where b.bookId= :bid")
	void updateReturnStatusById(@Param("bstatus") String status,@Param("bid")Long id);
	@Transactional
	@Query("select b.bookId from Bookissue b where b.bookId= :bookId")
	Long selectBookById1(@Param("bookId") Long id);
	@Transactional
	@Query("select b.issueId from Bookissue b where b.issueId= :issueid")
	Long selectBookByIssueId(@Param("issueid") Long id);
	@Transactional
	@Query("select b.returnStatus from Bookissue b where b.issueId= :issueid and b.bookId= :bookid")
	String selectReturnStatus(@Param("issueid") Long iid, @Param("bookid") Long bid);
}
