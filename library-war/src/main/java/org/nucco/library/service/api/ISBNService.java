package org.nucco.library.service.api;

import org.nucco.library.bean.Book;

public interface ISBNService {

	Book getBook(String isbn);

}
