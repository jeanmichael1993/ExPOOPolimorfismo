import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import model.entities.*;
import java.text.ParseException;

class Main {
  public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		List <Product> list = new ArrayList<>();

		System.out.print("Enter the number of products :");
		int n = sc.nextInt();
		for(int i=1;i<=n;i++){
			System.out.println("Product #"+i+" data: ");
			System.out.print("Common, used or imported (c/u/i) ?");
			char a = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Price: ");
			double price = sc.nextDouble();
			if(a == 'c'){
				list.add(new Product(name, price));
			}
			else if(a == 'u'){
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date date = sdf.parse(sc.next());
				list.add(new UsedProduct(name, price, date));
			}
			else if(a == 'i'){
				System.out.print("Customs fee: ");
				double customsFee = sc.nextDouble();
				list.add(new ImportedProduct(name, price, customsFee));
			}
		}

		System.out.println("PRICE TAGS: ");
		for(Product x : list){
				System.out.println(x.priceTag());
		}

		sc.close();
  }
}