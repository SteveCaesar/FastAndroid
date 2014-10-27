/**
 * 
 */
package com.example.demo.model.db;

import com.fusai.lib.db.annotation.DatabaseColumn;
import com.fusai.lib.db.annotation.DatabasePrimaryKey;
import com.fusai.lib.db.annotation.DatabaseTable;
import com.fusai.lib.db.entity.BaseDB;

/**
 * @author 许友爻
 * @date 2014年6月20日 上午11:33:37
 * @version 1.0
 */
@DatabaseTable(name = "Teacher")
public class Teacher extends BaseDB{
	@DatabaseColumn(name = "name")
	public String name;
	@DatabaseColumn(name = "age")
	public int age;
	@DatabaseColumn(name = "isGirl")
	public boolean isGirl;

	@Override
	public String toString(){
		String str="id:"+id+"   name:"+name+"   isGirl:"+isGirl;
		return str;
	}
}
