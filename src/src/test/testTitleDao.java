package test;

import java.text.ParseException;

import dao.TitleDao;
import model.Title;

public class testTitleDao
{
	public static void main(String[] args) throws ParseException
	{
		TitleDao Tdao = new TitleDao();
	//----------------------select()のテスト---------------------------------------------
		//
		/*
		System.out.println("---------- select()のテスト ----------");
		Title title = Tdao.select( 10 );
		System.out.println("　Total_good：" + title.getTotal_good());
		System.out.println("　Image：" + title.getImage());
		System.out.println("　name：" + title.getName());
		System.out.println();
		//*/

	//----------------------totalgood()のテスト---------------------------------------------
	int totalgood = Tdao.totalgood( "tanaka" );
	System.out.println("totalgood= " + totalgood);

	System.out.println("---------- select()のテスト ----------");
	Title title = Tdao.select( totalgood );
	System.out.println("　Total_good：" + title.getTotal_good());
	System.out.println("　Image：" + title.getImage());
	System.out.println("　name：" + title.getName());
	System.out.println();



//--end class---------------------------------------------------------------------------------
	}
}

