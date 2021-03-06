/**
 * 
 */
package com.example.demo.model.db;

import com.fastandroid.lib.db.annotation.DatabaseColumn;
import com.fastandroid.lib.db.annotation.DatabaseForeignKey;
import com.fastandroid.lib.db.annotation.DatabaseTable;
import com.fastandroid.lib.db.entity.BaseDB;


/**
 * @author 许友爻
 * @date 2014年6月20日 下午1:33:34
 * @version 1.0
 */
@DatabaseTable(name = "Student")
public class Student extends BaseDB{
	@DatabaseColumn(name = "name")
	public String name;
	@DatabaseColumn(name = "age")
	public int age;
	@DatabaseColumn(name = "isGirl")
	public boolean isGirl;
	@DatabaseForeignKey(table = Teacher.class, tableFieldName = "_id")
	@DatabaseColumn(name = "teID")
	public int teID;
}
