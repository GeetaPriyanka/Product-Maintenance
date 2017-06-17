package product.data; 
import java.io.*; 
import java.util.*; 
import product.business.*;

public class ProductIO {     
  public static ArrayList<Product> getProducts(String filepath) {
        ArrayList<Product> products = new ArrayList<Product>();
        File file = new File(filepath);
        try {
            BufferedReader in
                    = new BufferedReader(
                            new FileReader(file));

            String line = in.readLine();
            while (line != null) {
                StringTokenizer t = new StringTokenizer(line, "|");
                String code = t.nextToken();
                String description = t.nextToken();
                String priceAsString = t.nextToken();
                double price = Double.parseDouble(priceAsString);
                Product p = new Product();
                p.setCode(code);
                p.setDescription(description);
                p.setPrice(price);
                products.add(p);
                line = in.readLine();
            }
            in.close();
            return products;
        } catch (IOException e) {
            System.err.println(e);
            return null;
        }
    }
  
    public static void insertProduct(Product product, String path) {
        
        ArrayList<Product> products = getProducts(path);
        System.out.println(product.getDescription());
        products.add(product);
        saveProducts(products, path);
        
    }
    private static void saveProducts(List<Product> products, String path) { 
    try {           
    File file = new File(path);  
    PrintWriter out = new PrintWriter(new FileWriter(file)); 
    for(Product p : products) 
    {  
     //System.out.println(p.getCode())  ; 
    out.write(p.getCode() + "|" + p.getDescription() + "|" + p.getPrice());
    out.println();
    }          
    out.close();  
    }
    catch (IOException e) 
    {             
    System.out.println(e);      
    }   
    }
    
    public static void updateProduct(Product product, String path) {
        ArrayList<Product> products = getProducts(path);
        for (int i = 0; i < products.size(); i++) {
            Product p = products.get(i);
            if (product.getCode() != null && product.getCode().equalsIgnoreCase(p.getCode())) {
               

                products.set(i, product);
            }
        }
            
        saveProducts(products, path);
    } 
    public static void deleteProduct(Product product,String path) {
        ArrayList<Product> products = getProducts(path);
        for (int i = 0; i < products.size(); i++) {
            Product p = products.get(i);
            if (product != null && product.getCode().equalsIgnoreCase(p.getCode())) {
                products.remove(i);
            }
        }
        saveProducts(products,path);
    }
}