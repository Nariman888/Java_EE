package Sprint1.DB;

import Sprint1.model.Brands;
import Sprint1.model.Items;
import Sprint1.model.Users;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBConnector {
    private static Connection connection;
    static {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/javaee_db", "postgres", "Postgres");

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<Items> getAllItems() {
ArrayList<Items> items = new ArrayList<>();
try{
    PreparedStatement statement = connection.prepareStatement("" +
            "SELECT it.id, it.name, it.price, it.description, it.brand_id, " +
            "tb.name AS brandName, tb.country AS brandCountry " +
            "FROM table_items it " +
            "INNER JOIN table_brands tb on it.brand_id = tb.id "+
            "ORDER BY it.id");
    ResultSet resultSet = statement.executeQuery();

    while (resultSet.next()) {
        Long id = resultSet.getLong("id");
        String name = resultSet.getString("name");
        String description = resultSet.getString("description");
        double price = resultSet.getDouble("price");

        Brands brand = new Brands();
        brand.setId(resultSet.getLong("brand_id"));
        brand.setName(resultSet.getString("brandName"));
        brand.setCountry(resultSet.getString("brandCountry"));

        Items item = new Items();
        item.setId(id);
        item.setName(name);
        item.setDescription(description);
        item.setPrice(price);
        item.setBrand(brand);

        items.add(item);
    }
    statement.close();

} catch (Exception e){
    e.printStackTrace();
}
        return items;
}
    public static ArrayList<Users> getAllUsers(){

        ArrayList<Users> users = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM table_users ORDER BY id");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                String full_name = resultSet.getString("full_name");

                Users user = new Users();
                user.setId(id);
                user.setEmail(email);
                user.setPassword(password);
                user.setFullName(full_name);

                users.add(user);
            }
            statement.close();

        } catch (Exception e){
            e.printStackTrace();
        }
        return users;
    }

    public static Users getUsers(Long id){

        Users user = null;

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM table_items WHERE id = ? LIMIT 1");

            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                String full_name = resultSet.getString("full_name");

                user = new Users();
                user.setId(id);
                user.setEmail(email);
                user.setPassword(password);
                user.setFullName(full_name);
            }
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
    public static Items getItem(Long id){

        Items item = null;

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT it.id, it.name, it.price, it.description, it.brand_id, " +
                    "tb.name AS brandName, tb.country AS brandCountry " +
                    "FROM table_items it " +
                    "INNER JOIN table_brands tb on it.brand_id = tb.id " +
                    "WHERE it.id = ? LIMIT 1");

            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String desc = resultSet.getString("description");
                double price = resultSet.getDouble("price");

                Brands brand = new Brands();
                brand.setId(resultSet.getLong("brand_id"));
                brand.setName(resultSet.getString("brandName"));
                brand.setCountry(resultSet.getString("brandCountry"));

                item = new Items();
                item.setId(id);
                item.setName(name);
                item.setPrice(price);
                item.setDescription(desc);
                item.setBrand(brand);
            }
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }

    public static ArrayList<Items> getAllItemsTop(){

        ArrayList<Items> items = new ArrayList<>();
        int count_item = 1; //количество товаров в топ листе

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT it.id, it.name, it.price, it.description, it.brand_id, " +
                    "tb.name AS brandName, tb.country AS brandCountry " +
                    "FROM table_items it " +
                    "INNER JOIN table_brands tb on it.brand_id = tb.id " +
                    "ORDER BY it.price ASC ");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next() && count_item <= 3) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                double price = resultSet.getDouble("price");

                Brands brand = new Brands();
                brand.setId(resultSet.getLong("brand_id"));
                brand.setName(resultSet.getString("brandName"));
                brand.setCountry(resultSet.getString("brandCountry"));

                Items item = new Items();
                item.setId(id);
                item.setName(name);
                item.setPrice(price);
                item.setDescription(description);
                item.setBrand(brand);

                items.add(item);
                count_item++;
            }
            statement.close();

        } catch (Exception e){
            e.printStackTrace();
        }
        return items;
    }

    public static void addItem(Items item){

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO table_items (name, description, price, brand_id) " +
                    "VALUES (?, ?, ?, ?)");

            statement.setString(1, item.getName());
            statement.setString(2, item.getDescription());
            statement.setDouble(3, item.getPrice());
            statement.setLong(4, item.getBrand().getId());

            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveItem(Items item){

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "UPDATE table_items SET name = ?, description = ?, price = ?, brand_id = ? " +
                    "WHERE id = ?");

            statement.setString(1, item.getName());
            statement.setString(2, item.getDescription());
            statement.setDouble(3, item.getPrice());
            statement.setLong(4, item.getBrand().getId());
            statement.setLong(5, item.getId());

            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteItem(Items item){

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "DELETE FROM table_items WHERE id = ?");

            statement.setLong(1, item.getId());

            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static ArrayList<Brands> getAllBrands(){

        ArrayList<Brands> brands = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM table_brands ORDER BY name");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String country = resultSet.getString("country");

                Brands brand = new Brands();
                brand.setId(id);
                brand.setName(name);
                brand.setCountry(country);

                brands.add(brand);
            }
            statement.close();

        } catch (Exception e){
            e.printStackTrace();
        }
        return brands;
    }

    public static Brands getBrand(Long id){

        Brands brand = null;

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "SELECT * FROM table_brands WHERE id = ? LIMIT 1");

            statement.setLong(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String country = resultSet.getString("country");

                brand = new Brands();
                brand.setId(id);
                brand.setName(name);
                brand.setCountry(country);
            }
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return brand;
    }

    public static void addBrand(Brands brand){

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO table_brands (name, country) " +
                    "VALUES (?, ?)");

            statement.setString(1, brand.getName());
            statement.setString(2, brand.getCountry());

            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveBrand(Brands brand){

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "UPDATE table_brands SET name = ?, country = ? " +
                    "WHERE id = ?");

            statement.setString(1, brand.getName());
            statement.setString(2, brand.getCountry());
            statement.setLong(3, brand.getId());

            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteBrand(Brands brand){

        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "DELETE FROM table_brands WHERE id = ?");

            statement.setLong(1, brand.getId());

            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
