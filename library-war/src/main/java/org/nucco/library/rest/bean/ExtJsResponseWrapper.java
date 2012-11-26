package org.nucco.library.rest.bean;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import org.nucco.library.bean.Book;
import org.nucco.library.bean.User;

@XmlRootElement(name = "")
@XmlSeeAlso({Book.class, User.class})
public class ExtJsResponseWrapper<T> {

	public ExtJsResponseWrapper() {}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
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

	public void setData(T data) {
		this.data = new ArrayList<T>();
		this.data.add(data);
	}

	private long count;
	private boolean status;
	private String message;
	private List<T> data;

}
