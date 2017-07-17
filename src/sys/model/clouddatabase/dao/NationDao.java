package sys.model.clouddatabase.dao;

import java.util.ArrayList;

import sys.model.objects.Nationality;

public interface NationDao {

	
	/**
	 * 查询所有国籍
	 * @return list:国籍列表
	 */
	public ArrayList<Nationality> getAll();
	
	/**
	 * 不用写
	 * 根据国籍名称查询国籍id
	 * @param objects:名称
	 * @return int：国籍ID 
	 */
	public int getId(Object[] objects);
}
