package com.library.bootjpa.service;
import java.util.ArrayList;
import java.util.List;
import com.library.bootjpa.entity.LibraryBook;
public interface LibraryBookService {
	public void addLibrary(LibraryBook st);
	ArrayList<LibraryBook> fetchAll();
	public Long selectBookById(Long bookId);
	public void updateLibraryBookById(Long lid);
	public void updateLibraryBookById1(Long lid1);
	//-------------------------------------------------------
	public LibraryBook addLibraryBook(LibraryBook b);
	public List <LibraryBook> getLibraryBooks();
    public void deleteLibraryBook(Long id);
}
