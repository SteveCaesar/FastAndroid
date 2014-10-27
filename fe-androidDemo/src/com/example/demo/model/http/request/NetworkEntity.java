package com.example.demo.model.http.request;

import java.util.ArrayList;



import com.fusai.annotation.Transient;
import com.fusai.lib.json.JsonField;
/**
 * 如果没有指定注解则自动获取字段名及字段的类型。
 * */
public class NetworkEntity {
	public String totalRows;
	public String totalPages;
	@JsonField(name = "data", type = AddressEntity.class)
	public ArrayList<AddressEntity> data;
	@JsonField(name = "currentPage")
	public String currentPage;
	@Transient
	public String test;
}
