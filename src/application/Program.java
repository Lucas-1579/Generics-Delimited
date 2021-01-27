package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import entitie.Product;
import service.CalculationService;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		List<Product> products = new ArrayList<>();
		
		String path = "C:\\Temp\\nn.txt";
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			String line = br.readLine();
			while(line != null) {
				String[] vect = line.split(",");
				products.add(new Product(vect[0], Double.parseDouble(vect[1])));
				line = br.readLine();
			}
			
			Product x = CalculationService.max(products);
			System.out.println("Most Expensive:");
			System.out.println(x);
			
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
		}

	}

}
