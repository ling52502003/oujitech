package jp.co.oujitech.work.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import jp.co.oujitech.work.model.UserInfo;

@Mapper
public interface UserMapper {

	public List<UserInfo> findUserInfo();

	public int addUserInfo(UserInfo user);

	public int delUserInfo(int id);

	public UserInfo getUserInfoById(String id);
}
