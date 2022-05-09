package cucumberbdd.stepdefinitions;

import cucumberbdd.domainobjects.Customer;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.DataTableType;
import io.cucumber.java.Transpose;
import io.cucumber.java.en.Given;


import java.util.List;
import java.util.Map;

public class DataTableStepDefinitions {

    /*@DataTableType
    public Customer customerEntry(List<String> entry){
        return new Customer(entry.get(0), entry.get(1)); // (0=username,1=password)
    }*/
    @DataTableType
    public Customer customerEntry(Map<String, String> entry) {
        return new Customer(entry.get("username"), entry.get("password"));
    }
    /*@DataTableType
    public Customer customerEntry(DataTable dataTable){
        return new Customer(dataTable.row(0).get(1), dataTable.row(1).get(1)); // return |john|john123|
    }*/

    @Given("my credentials is single row with no header")
    public void my_credentials_is_single_row_with_no_header(DataTable dataTable) {
        List<String> creds = dataTable.row(0); // Can also use .values();
        System.out.println("Username = " + creds.get(0));
        System.out.println("Password = " + creds.get(1));
    }

    @Given("my credentials is multiple rows with no header")
    public void my_credentials_is_multiple_rows_with_no_header(List<List<String>> creds) {
        //List<List<String>> creds = dataTable.asLists();
        System.out.println("Username [row0] = " + creds.get(0).get(0));
        System.out.println("Password [row0] = " + creds.get(0).get(1));
        System.out.println("Username [row1] = " + creds.get(1).get(0));
        System.out.println("Password [row1] = " + creds.get(1).get(1));
    }

    @Given("my credentials is multiple rows with no header with Datatable Type")
    public void my_credentials_is_multiple_rows_with_no_header_with_datatable_type(List<Customer> customers) {
        System.out.println("Username [row0] = " + customers.get(0).getUsername());
        System.out.println("Password [row0] = " + customers.get(0).getPassword());
        System.out.println("Username [row1] = " + customers.get(1).getUsername());
        System.out.println("Password [row1] = " + customers.get(1).getPassword());
    }

    @Given("my credentials is single row with with header using List of List")
    public void my_credentials_is_single_row_with_with_header_using_list_of_list(List<List<String>> customers) {
        // We need to ignore row number 0 as it's the header
        System.out.println("Username [row1] = " + customers.get(1).get(0));
        System.out.println("Password [row1] = " + customers.get(1).get(1));
    }

    @Given("my credentials is single row with with header using List of Map")
    public void my_credentials_is_single_row_with_with_header_using_list_of_map(List<Map<String, String>> customers) {
        // with Map cucumber ignores the row 0 which is the headers
        System.out.println("Username [row1] = " + customers.get(0).get("username"));
        System.out.println("Password [row1] = " + customers.get(0).get("password"));
    }

    @Given("my credentials is multiple rows with with header using List of Map")
    public void my_credentials_is_multiple_rows_with_with_header_using_list_of_map(List<Map<String, String>> customers) {
        System.out.println("Username [row0] = " + customers.get(0).get("username"));
        System.out.println("Password [row0] = " + customers.get(0).get("password"));
        System.out.println("Username [row1] = " + customers.get(1).get("username"));
        System.out.println("Password [row1] = " + customers.get(1).get("password"));
    }

    @Given("my credentials is single row with with header using Data Table Type")
    public void my_credentials_is_single_row_with_with_header_using_data_table_type(Customer customers) {
        System.out.println("Username [row0] = " + customers.getUsername());
        System.out.println("Password [row0] = " + customers.getPassword());
    }

    @Given("my credentials is multiple rows with with header using Data Table Type")
    public void my_credentials_is_multiple_rows_with_with_header_using_data_table_type(List<Customer> customers) {
        System.out.println("Username [row0] = " + customers.get(0).getUsername());
        System.out.println("Password [row0] = " + customers.get(0).getPassword());
        System.out.println("Username [row1] = " + customers.get(1).getUsername());
        System.out.println("Password [row1] = " + customers.get(1).getPassword());
    }

    @Given("my credentials is single column with with no header")
    public void my_credentials_is_single_column_with_with_no_header(List<String> customer) {
        System.out.println("Username = " + customer.get(0));
        System.out.println("Password = " + customer.get(1));
    }

    @Given("my credentials is single column with with no header using DataTable")
    public void my_credentials_is_single_column_with_with_no_header_using_data_table(DataTable dataTable) {
        List<String> customer = dataTable.asList(); // Transform the datatable into List
        System.out.println("Username = " + customer.get(0));
        System.out.println("Password = " + customer.get(1));
    }

    @Given("my credentials is single column with with header using DataTable")
    public void my_credentials_is_single_column_with_with_header_using_data_table(DataTable dataTable) {
        Map<String, String> customer = dataTable.asMap(); // Transform the datatable into Map
        System.out.println("Username = " + customer.get("username"));
        System.out.println("Password = " + customer.get("password"));
    }

    @Given("my credentials is single column with no header using Data Table Type")
    public void my_credentials_is_single_column_with_no_header_using_data_table_type(@Transpose Customer customer) {
        // the @Transpose annotation will transform the single column into a row |john|john123|
        System.out.println("Username = " + customer.getUsername());
        System.out.println("Password = " + customer.getPassword());
    }

    @Given("my credentials is single column with header using Data Table Type")
    public void my_credentials_is_single_column_with_header_using_data_table_type(Customer customer) {
        // the @Transpose annotation will transform the rows into Map
        System.out.println("Username = " + customer.getUsername());
        System.out.println("Password = " + customer.getPassword());
    }

    @Given("my credentials is multiple columns with header using Data Table Type")
    public void my_credentials_is_multiple_columns_with_header_using_data_table_type(@Transpose List<Customer> customer) {
        System.out.println("Username [col1] = " + customer.get(0).getUsername());
        System.out.println("Password [col1] = " + customer.get(0).getPassword());
        System.out.println("Username [col2] = " + customer.get(1).getUsername());
        System.out.println("Password [col2] = " + customer.get(1).getPassword());
    }
}

