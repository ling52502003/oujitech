package jp.co.oujitech.work.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;

import jp.co.oujitech.work.mapper.UserMapper;
import jp.co.oujitech.work.model.UserInfo;
import jp.co.oujitech.work.service.UserService;
import jp.co.oujitech.work.util.MD5Util;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	public List<UserInfo> getUserInfo() {

		return userMapper.findUserInfo();
	}

	//@Transactional
	@Transactional
	public void insert(UserInfo user) {
		userMapper.addUserInfo(user);

	}

	/**
	 *
	 *checkLoginUser
	 *
	 *
	 */

	@Override
	public boolean checkLoginUser(UserInfo user) {

		// success Flag
		boolean resulFlag = false;

		// Db user info search

		UserInfo userDb = userMapper.getUserInfoById(user.getMailId());

		// if user are data
		if (userDb != null) {

			// password of DB
			String passwordDb = userDb.getPassword();

			// password of page
			String passwordPage = user.getPassword();

			// MD5
			String passwordMd5 = MD5Util.encode(passwordPage);

			// password equals
			if (StringUtils.equals(passwordDb, passwordMd5)) {
				resulFlag = true;
			}

			// DB name
			user.setName(userDb.getName());

		}

		return resulFlag;
	}
}
