package com.library.bootjpa.controller;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.library.bootjpa.entity.LibraryBook;
import com.library.bootjpa.entity.Student;
import com.library.bootjpa.service.LibraryBookService;
import com.library.bootjpa.service.StudentService;
@Component
@RestController
@RequestMapping(value = "/book")
public class LibraryBookController {
	@Autowired
	private LibraryBookService librarybookService;

	public String insertLibraryBook(LibraryBook l)
	{
		librarybookService.addLibrary(l);
		return "One Library Book Registered";
	}
	public void fetchAllLibraryBooks()
	{
		ArrayList<LibraryBook> al=librarybookService.fetchAll();
		for(LibraryBook l:al) {
			System.out.println(l.getBookId()+"--"+l.getBookname());
		}
	}
	public Long getBookId(Long id) {
		return librarybookService.selectBookById(id);
	}
	public void updateLibraryBook(Long id) {
		librarybookService.updateLibraryBookById(id);
	}
	public void updateLibraryBook1(Long id) {
		librarybookService.updateLibraryBookById1(id);
	}
	//-------------------------------------------------------------------------------
	@RequestMapping(value = "/add", //
			method = RequestMethod.POST, //
			produces = { MediaType.APPLICATION_JSON_VALUE, //
					MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public LibraryBook createLibraryBook(@RequestBody LibraryBook b) {
		return librarybookService.addLibraryBook(b);
	}
	@RequestMapping(value = "/display", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public List<LibraryBook> getLibraryBooks(){
		return librarybookService.getLibraryBooks();
	}
	@RequestMapping(value = "/remove/{bookid}", //
            method = RequestMethod.DELETE, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public void deleteLibraryBook(@PathVariable("bookid") Long id) {
		librarybookService.deleteLibraryBook(id);
	}
}

