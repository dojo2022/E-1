package test;

import java.util.ArrayList;

import dao.Favorite_GenreDao;

public class testFGenreDao {
	public static void main(String[] args) {
	Favorite_GenreDao dao = new Favorite_GenreDao();
//----------------------select()のテスト---------------------------------------------
	System.out.println("---------- select()のテスト ----------");
	ArrayList<String> FgenreList2 = dao.select("DOJO");
	for (String Fgenre : FgenreList2) {
		System.out.println("Fgenre：" + Fgenre);
		}
//-----------------------------------------------------------------------------------
	}
}
