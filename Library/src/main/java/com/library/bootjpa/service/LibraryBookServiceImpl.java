package com.library.bootjpa.service;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.text.html.HTMLDocument.Iterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.library.bootjpa.entity.LibraryBook;
import com.library.bootjpa.repository.LibraryBookRepository;
@Service("libraryServiceImpl")
public class LibraryBookServiceImpl implements LibraryBookService {
	@Autowired
	private LibraryBookRepository librarybookRepository;
	@Override
	public void addLibrary(LibraryBook l) {
		librarybookRepository.save(l);
	}
	@Override
	public ArrayList<LibraryBook> fetchAll() {
		ArrayList<LibraryBook> al=librarybookRepository.fetchAll();
		return al;
	}
	public Long selectBookById(Long bookId) {
		Long bid=librarybookRepository.selectBookById(bookId);
		return bid;
	}
	@Override
	public void updateLibraryBookById(Long lid) {
		librarybookRepository.updateLibraryBookById(lid);
	}
	@Override
	public void updateLibraryBookById1(Long lid1) {
		librarybookRepository.updateLibraryBookById1(lid1);
	}
	//-----------------------------------------------------------
	@Override
	public LibraryBook addLibraryBook(LibraryBook b) {
		return librarybookRepository.save(b);
	}
	@Override
	public List<LibraryBook> getLibraryBooks() {
		return librarybookRepository.findAll();
	}
	public void deleteLibraryBook(Long id) {
		librarybookRepository.delete(id);
	}
}

