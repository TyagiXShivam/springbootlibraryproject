package com.library.bootjpa.service;
import java.util.List;
import com.library.bootjpa.entity.Bookissue;
public interface BookissueService {
	public void addissuedbook(Bookissue b);
	public Long selectBookById1(Long bookId);
	public Long selectBookByIssueId(Long issueid);
	public void updateReturnStatusById(String status,Long id);
	public String selectReturnStatus(Long issueid, Long bookid);
	//----------------------------------------------------
	public Bookissue addBookissue(Bookissue b);
	public List <Bookissue> getBookissue();
	public void deleteBookissue(Long id);
}

