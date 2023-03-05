package com.library.bootjpa.controller;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.library.bootjpa.entity.Bookissue;
import com.library.bootjpa.entity.Student;
import com.library.bootjpa.service.BookissueService;
@Component
@RestController
@RequestMapping(value = "/bookissue")
public class BookissueController {
	@Autowired
	private BookissueService bookissueService;
	public String issueLibraryBook(Bookissue b)
	{
		bookissueService.addissuedbook(b);
		return "One Library Book Issued";
	}
	public Long getBookId1(Long id) {
		return bookissueService.selectBookById1(id);
	}
	public Long getIssueId(Long id) {
		return bookissueService.selectBookByIssueId(id);
	}
	public void updateBookissue(String status, Long id) {
		bookissueService.updateReturnStatusById(status, id);
	}
	public String getReturnStatus(Long iid, Long bid) {
		return bookissueService.selectReturnStatus(iid, bid);
	}
	//---------------------------------------------------------
	@RequestMapping(value = "/add", //
			method = RequestMethod.POST, //
			produces = { MediaType.APPLICATION_JSON_VALUE, //
					MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public Bookissue createBookissue(@RequestBody Bookissue b) {
		return bookissueService.addBookissue(b);
	}
	@RequestMapping(value = "/display", //
			method = RequestMethod.GET, //
			produces = { MediaType.APPLICATION_JSON_VALUE, //
					MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public List<Bookissue> getBookissue(){
		return bookissueService.getBookissue();
	}
	@RequestMapping(value = "/remove/{bookId}", //
			method = RequestMethod.DELETE, //
			produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public void deleteStudent(@PathVariable("bookId") Long id) {
		bookissueService.deleteBookissue(id);
	}
}
