package test;

import java.util.List;

import dao.UserDao;
import model.User;

public class TestUserDao {
	public static void main(String[] args) {
	UserDao dao = new UserDao();
//----------------------select()のテスト---------------------------------------------
	System.out.println("---------- select()のテスト ----------");
	List<User> recordList2 = dao.select("");
	for (User record : recordList2) {
		System.out.println("　id：" + record.getId());
		System.out.println("　User_image：" + record.getImage());
		System.out.println("　public：" + record.getC_public());
		System.out.println();
		}
//----------------------Insert()のテスト---------------------------------------------
	///*
	System.out.println("---------- Insert()のテスト ----------");
	if (dao.insert("username", "pass")){
		System.out.println("登録成功！");
		List<User> recordList3 = dao.select("");
		for (User record : recordList3) {
			System.out.println("　id：" + record.getId());
			System.out.println("　User_image：" + record.getImage());
			System.out.println("　public：" + record.getC_public());
			System.out.println();
			}
	}
	else {
		System.out.println("登録失敗！");
	}
	//*/
	//----------------------update()のテスト---------------------------------------------
		///*
			System.out.println("---------- update()のテスト ----------");
			if (dao.update("username", "tatataki", "pass", "no")){
			System.out.println("更新成功！");
			List<User> recordList3 = dao.select("");
			for (User record : recordList3) {
				System.out.println("　id：" + record.getId());
				System.out.println("　User_image：" + record.getImage());
				System.out.println("　public：" + record.getC_public());
				System.out.println();
				}
		}
		else {
			System.out.println("更新失敗！");
		}
		//*/
//-----------------------------------------------------------------------------------
	}
}
