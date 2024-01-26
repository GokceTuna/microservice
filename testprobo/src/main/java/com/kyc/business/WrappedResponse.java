package com.kyc.business;

import java.util.List;

public class WrappedResponse<T> {

	private List<T> list;


	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

}
