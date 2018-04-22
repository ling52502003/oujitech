package jp.co.oujitech.work.service;

import java.util.List;

import jp.co.oujitech.work.model.UserInfo;

public interface UserService {
	public List<UserInfo> getUserInfo();
	public void insert(UserInfo user);
	public boolean checkLoginUser(UserInfo user);
}
