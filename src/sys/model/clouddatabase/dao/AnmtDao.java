package sys.model.clouddatabase.dao;

import java.util.ArrayList;

import sys.model.objects.Announcement;

public interface AnmtDao {

	/**
	 * 插入一个公告
	 * @author 邓
	 * @param objects:保存了公告的时间，标题，内容
	 * @return boolean true:插入成功， false:插入失败
	 */
	public boolean insert(Object[] objects);
	
	/**
	 * 获取所有公告
	 * @author 张
	 * @return list:公告集合
	 */
	public ArrayList<Announcement> queryAll();
}
