package cucumberbdd.customtype;

import cucumberbdd.domainobjects.Product;
import io.cucumber.java.ParameterType;

public class CustomParameterType {

    @ParameterType(".*")
    public Product product(String name){
        return new Product(name.replace("\"","")); // ignore the double quotes
    }
}
