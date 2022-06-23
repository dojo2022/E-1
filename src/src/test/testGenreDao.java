package test;

import java.util.List;

import dao.GenreDao;
import model.Genre;

public class testGenreDao {
	public static void main(String[] args) {
		GenreDao gDao = new GenreDao();
		System.out.println("---------- select()のテスト ----------");
		List<Genre> genreList = gDao.select();
		for(Genre rev : genreList) {
			System.out.println("genre_id:"+rev.getGenre_id());
			System.out.println("genre_name:"+rev.getGenre_name());
		}
	}
}
