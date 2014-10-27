/**
 * 
 */
package com.example.demo.controller;

import java.util.ArrayList;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

import com.example.demo.BaseActivity;
import com.example.demo.model.db.Student;
import com.example.demo.model.db.Teacher;
import com.example.fastandroiddemo.R;
import com.fastandroid.exception.TADBException;
import com.fastandroid.exception.TADBNotOpenException;
import com.fastandroid.lib.db.EntityRepository;
import com.fastandroid.lib.db.TASQLiteDatabase;
import com.fastandroid.lib.db.TASQLiteDatabasePool;
import com.fastandroid.lib.log.TALogger;

/**
 * @author 许友爻
 * @date 2014年6月20日 上午11:18:25
 * @version 1.0
 */
public class DatabaseDemoActivity extends BaseActivity {
	@InjectView(R.id.btn_createDatabase)
	Button btn_createDatabase;
	@InjectView(R.id.btn_insert)
	Button btn_insert;
	@InjectView(R.id.btn_delete)
	Button btn_delete;
	@InjectView(R.id.btn_update)
	Button btn_update;
	@InjectView(R.id.btn_query)
	Button btn_query;
	EntityRepository entityRepository;
	private TASQLiteDatabasePool sqliteDatabasePool;
	private TASQLiteDatabase sqliteDatabase;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_database);
		ButterKnife.inject(this);
		//获取数据库连接池
		sqliteDatabasePool=application.getSQLiteDatabasePool();
		// 获取数据库连接
		sqliteDatabase =sqliteDatabasePool.getSQLiteDatabase();
		// 打开数据库
		sqliteDatabase.openDatabase(null,true);
	}

	@OnClick({ R.id.btn_createDatabase, R.id.btn_insert, R.id.btn_delete,
			R.id.btn_update, R.id.btn_query })
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.btn_createDatabase:
			entityRepository = EntityRepository.getInstance();
			entityRepository.register(Teacher.class, Student.class);
			entityRepository.createTables(false,sqliteDatabase);
			String command = "PRAGMA foreign_keys = ON";// 启用数据库的外键约束
			try {
				sqliteDatabase.execute(command, null);
			} catch (TADBNotOpenException e) {
				e.printStackTrace();
			}
			break;
		case R.id.btn_insert:
			Teacher teacher = new Teacher();
			teacher.name="王老师";
			teacher.age=20;
			teacher.isGirl=true;
			if (sqliteDatabase.insert(teacher)!=-1) {
				Toast.makeText(this, "insert成功", Toast.LENGTH_SHORT).show();
			} else {
				Toast.makeText(this, "insert失败", Toast.LENGTH_SHORT).show();
			}
			break;
		case R.id.btn_delete:
			if (sqliteDatabase.delete(Teacher.class, "name=?",
					new String[] { "王老师" })) {
				Toast.makeText(this, "delete成功", Toast.LENGTH_SHORT).show();
			} else {
				Toast.makeText(this, "delete失败", Toast.LENGTH_SHORT).show();
			}
			break;
		case R.id.btn_update:
			Teacher entity=new Teacher();
			entity.name="小王";
			if (sqliteDatabase.update(Teacher.class, entity, "name=?",
					new String[] { "王老师" })) {
				Toast.makeText(this, "update成功", Toast.LENGTH_SHORT).show();
			} else {
				Toast.makeText(this, "update失败", Toast.LENGTH_SHORT).show();
			}
			break;
		case R.id.btn_query:
			try {
				ArrayList<Teacher> arry = sqliteDatabase.query(false,
						Teacher.class, null, null, null, null, null, null,
						null, null);
				StringBuffer sb = new StringBuffer("表数据{");
				int i = 0;
				for (Teacher stu : arry) {
					sb.append("[");
					sb.append(stu.toString());
					sb.append(i == arry.size() - 1 ? "]" : "],");
					i++;
				}
				sb.append("}");
				Toast.makeText(this, "详细信息已打印到控制台，请在控制台查看", Toast.LENGTH_SHORT).show();
				TALogger.v(DatabaseDemoActivity.this, sb.toString());
			} catch (TADBException e) {
				TALogger.e(DatabaseDemoActivity.this, e.getMessage());
			}
			break;
		}
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		//将数据库连接返回连接池
		sqliteDatabasePool.releaseSQLiteDatabase(sqliteDatabase);
		ButterKnife.reset(this);
	}
}
