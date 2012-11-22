package org.nucco.library.rest.bean;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import org.nucco.library.bean.Book;

@XmlRootElement(name = "")
@XmlSeeAlso(Book.class)
public class ExtJsWrapper<T> {

	public ExtJsWrapper() {}

	public ExtJsWrapper(List<T> data, String message) {
		this.data = data;
		this.count = data.size();
		this.message = message;
		this.status = true;
	}

	public ExtJsWrapper(T data, String message) {
		this.data = new ArrayList<T>();
		this.data.add(data);
		this.count = this.data.size();
		this.message = message;
		this.status = true;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@XmlAnyElement(lax = true)
	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	private int count;
	private boolean status;
	private String message;
	private List<T> data;

}
