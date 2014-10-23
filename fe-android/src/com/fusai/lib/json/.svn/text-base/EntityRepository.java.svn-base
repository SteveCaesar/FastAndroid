package com.fusai.lib.json;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;

import com.fusai.annotation.Transient;
/**
 * @description 实体仓库
 * @author 许友爻
 * @date 2014年6月19日 下午2:40:46
 * @version 1.0
 */
public class EntityRepository {
	private static EntityRepository instance;
	// 字段元数据实体集合
	private HashMap<String, EntityFieldMetadata[]> fieldList;

	public EntityRepository() {
		fieldList = new HashMap<String, EntityFieldMetadata[]>();
	}

	public static EntityRepository getInstance() {
		if (instance == null)
			instance = new EntityRepository();
		return instance;
	}

	/**
	 * 销毁实体
	 * */
	public void destroyInstance() {
		fieldList.clear();
		fieldList = null;
		instance = null;
	}

	/**
	 * 根据class获取字段元数据实体数组
	 * 
	 * @type class对象
	 * @return 字段元数据实体
	 * */
	public EntityFieldMetadata[] getJsonFieldsForType(Class<?> type) {
		if (!fieldList.containsKey(type.getName())) {
			fieldList.put(type.getName(), getJsonFields(type));
		}
		return fieldList.get(type.getName());
	}
	
	private EntityFieldMetadata[] getJsonFields(Class<?> type) {
		ArrayList<EntityFieldMetadata> fields = new ArrayList<EntityFieldMetadata>();
		for (Field field : type.getFields()) {
			//此字段不对外提供
			if(field.getAnnotation(Transient.class)!=null)
				continue;
			EntityFieldMetadata fieldMetdata = new EntityFieldMetadata();
			if (field.getAnnotation(JsonField.class) != null) {//如果使用了此注解
				String jsonFieldName = ((JsonField) field
						.getAnnotation(JsonField.class)).name();

				Class<?> fieldType = ((JsonField) field
						.getAnnotation(JsonField.class)).type();
				if (fieldType.equals(Void.class)) {
					fieldType = field.getType();
				}
				fieldMetdata.jsonFieldName = jsonFieldName;
				fieldMetdata.type = fieldType;

			}else{
				fieldMetdata.jsonFieldName = field.getName();
				fieldMetdata.type =field.getType();
			}
			fieldMetdata.field = field;
			fields.add(fieldMetdata);
		}

		EntityFieldMetadata[] list = new EntityFieldMetadata[fields.size()];
		fields.toArray(list);
		return list;
	}
}
