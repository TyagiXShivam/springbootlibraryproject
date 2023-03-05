package com.library.bootjpa.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.library.bootjpa.entity.Bookissue;
import com.library.bootjpa.entity.LibraryBook;
import com.library.bootjpa.repository.BookissueRepository;
import com.library.bootjpa.repository.LibraryBookRepository;
@Service("bookissueServiceImpl")
public class BookissueServiceImpl implements BookissueService {
	@Autowired
	private BookissueRepository bookissueRepository;
	@Override
	public void addissuedbook(Bookissue b) {
		bookissueRepository.save(b);
	}
	@Override
	public Long selectBookById1(Long bookId) {
		Long bid=bookissueRepository.selectBookById1(bookId);
		return bid;
	}
	@Override
	public Long selectBookByIssueId(Long issueid) {
		Long iid=bookissueRepository.selectBookByIssueId(issueid);
		return iid;
	}
	@Override
	public void updateReturnStatusById(String status, Long id) {
		bookissueRepository.updateReturnStatusById(status, id);
	}
	@Override
	public String selectReturnStatus(Long issueid, Long bookid) {
		String rstatus=bookissueRepository.selectReturnStatus(issueid, bookid);
		return rstatus;
	}
	//----------------------------------------------------------
	@Override
	public Bookissue addBookissue(Bookissue b) {
		return bookissueRepository.save(b);
	}
	@Override
	public List<Bookissue> getBookissue() {

		return bookissueRepository.findAll() ;
	}
	@Override
	public void deleteBookissue(Long id) {
		bookissueRepository.delete(id);
	}
		}
