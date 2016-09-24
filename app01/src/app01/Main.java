package app01;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class Main {

	public static void main(String[] args) throws Exception {

		String caminho = "http://www.mocky.io/v2/57e679c9100000ba1ee1d515";
		URL url = new URL(caminho);
		InputStream in =  url.openConnection().getInputStream();
		BufferedReader bf = new BufferedReader(new InputStreamReader(in));
		String linha = null;
		while((linha = bf.readLine()) != null){
			System.out.println(linha);
		}
		
	}

}
