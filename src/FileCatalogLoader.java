import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class FileCatalogLoader {
			Catalog c;
			private Product readProduct(String line) throws DataFormatException {
				StringTokenizer st=new StringTokenizer(line,"_");
				if(st.countTokens()!=4) {
					throw new DataFormatException();
				}
				st.nextToken();
				Product product=new Product(st.nextToken(),st.nextToken(),Double.valueOf(st.nextToken()));
				return product;
			}

			private Coffee readCoffee(String line) throws DataFormatException {
				StringTokenizer st=new StringTokenizer(line,"_");
				if(st.countTokens()!=10) {
					throw new DataFormatException();
				}
				st.nextToken();
				Coffee coffee=new Coffee(st.nextToken(),st.nextToken(),Double.valueOf(st.nextToken()),st.nextToken(),st.nextToken(),st.nextToken(),st.nextToken(),st.nextToken(),st.nextToken());
				return coffee;
			}

			private CoffeeBrewer readCoffeeBrewer(String line) throws DataFormatException {
				StringTokenizer st=new StringTokenizer(line,"_");
				if(st.countTokens()!=7) {
					throw new DataFormatException();
				}
				st.nextToken();
				CoffeeBrewer brewer=new CoffeeBrewer(st.nextToken(),st.nextToken(),Double.valueOf(st.nextToken()),st.nextToken(),st.nextToken(),Integer.valueOf(st.nextToken()));
				return brewer;
			}

		public Catalog loadCatalog(String fileName)throws FileNotFoundException, IOException, DataFormatException{
			c=new Catalog();
			BufferedReader br=new BufferedReader(new FileReader(fileName));
			String line;
			try {
				while((line=br.readLine())!=null) {
					if(line.startsWith("Product")){
						c.addProduct(this.readProduct(line));
						
					}else if(line.startsWith("Coffee")) {
						c.addProduct(this.readCoffee(line));
						
					}else if(line.startsWith("CoffeeBrewer")) {
						c.addProduct(this.readCoffeeBrewer(line));
						
					}
				}
				
			}catch(IOException e) {
				e.printStackTrace();
			}
			return c;
		}
	

}
