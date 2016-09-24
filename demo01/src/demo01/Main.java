package demo01;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class Main {

	public static void main(String[] args) throws Exception {

		String caminho =  "http://www.mocky.io/v2/5185415ba171ea3a00704eed";
		URL url = new URL(caminho);
		InputStream inputStream = url.openConnection().getInputStream();
		BufferedReader bf = new BufferedReader(new InputStreamReader(inputStream));
		String linha = null;
		while((linha = bf.readLine()) != null){
			System.out.println(linha);
		}
		
	}

}
