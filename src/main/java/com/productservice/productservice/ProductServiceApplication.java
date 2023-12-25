package com.productservice.productservice;

//import com.productservice.productservice.inheritancerelation.mappedsuperclass.Mentor;
//import com.productservice.productservice.inheritancerelation.mappedsuperclass.MentorRepository;
import com.productservice.productservice.inheritancerelation.singletable.Mentor;
import com.productservice.productservice.inheritancerelation.singletable.MentorRepository;
import com.productservice.productservice.inheritancerelation.singletable.Student;
import com.productservice.productservice.inheritancerelation.singletable.StudentRepository;
import com.productservice.productservice.inheritancerelation.singletable.User;
import com.productservice.productservice.inheritancerelation.singletable.UserRepository;
//import com.productservice.productservice.inheritancerelation.tableperclass.*;
import com.productservice.productservice.models.Category;
import com.productservice.productservice.models.Order;
import com.productservice.productservice.models.Price;
import com.productservice.productservice.models.Product;
import com.productservice.productservice.repository.CategoryRepository;
import com.productservice.productservice.repository.OrderRepository;
import com.productservice.productservice.repository.PriceRepository;
import com.productservice.productservice.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootApplication
public class ProductServiceApplication implements CommandLineRunner {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final PriceRepository priceRepository;

    public ProductServiceApplication(CategoryRepository categoryRepository,
                                     ProductRepository productRepository,
                                     PriceRepository priceRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.priceRepository = priceRepository;
    }

//    private MentorRepository mentorRepository;
//    private StudentRepository studentRepository;
//    private UserRepository userRepository;
//    ProductServiceApplication (@Qualifier("st_mentorrepository") MentorRepository mentorRepository,
//                               @Qualifier("st_studentrepository")StudentRepository studentRepository,
//                               @Qualifier("st_userrepository")UserRepository userRepository) {
//        this.mentorRepository= mentorRepository;
//        this.studentRepository= studentRepository;
//        this.userRepository= userRepository;
//    }


//    private MentorRepository mentorRepository;
//    private StudentRepository studentRepository;
//    private UserRepository userRepository;
//    ProductServiceApplication( @Qualifier("tpc_mentorrepository")
//                               MentorRepository mentorRepository ,
//                               StudentRepository studentRepository,
//                               UserRepository userRepository) {
//        this.mentorRepository= mentorRepository;
//        this.studentRepository= studentRepository;
//        this.userRepository= userRepository;
//    }

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }


    @Override
    //@Transactional
    public void run(String... args) throws Exception {

//        Mentor mentor= new Mentor();
//        mentor.setName("Deepak");
//        mentor.setEmail("deepak@gmail.com");
//        mentor.setAvgRating(4.7);
//
//        mentorRepository.save(mentor); //save mentor in DB

        //tpc_mentor
        /*Mentor mentor= new Mentor();
        mentor.setName("tarun");
        mentor.setEmail("tarun@scaler.com");
        mentor.setAvgRating(4.8);
        mentorRepository.save(mentor);

        Student student= new Student();
        student.setEmail("vrush@gmail.com");
        student.setName("Vrushabh");
        student.setPsp(81);
        studentRepository.save(student);

        User user= new User();
        user.setName("suraj");
        user.setEmail("suraj@yahoo.com");
        userRepository.save(user);


        List<User> users= userRepository.findAll();

        for(User user1: users) {
            System.out.println(user1.toString());
        }

         */
        /*
        User user= new User();
        user.setName("Arshi");
        user.setEmail("arshi@scaler.com");
        userRepository.save(user);

        Mentor mentor= new Mentor();
        mentor.setName("Deepak");
        mentor.setEmail("deepak@gmail.com");
        mentor.setAvgRating(4.5);
        mentorRepository.save(mentor);

        Student student= new Student();
        student.setName("Harsh");
        student.setEmail("harsh@gmail.com");
        student.setPsp(4.8);
        studentRepository.save(student);
        List<User> users= userRepository.findAll();
        for (User user1: users) {
            System.out.println(user1.toString());
        }
        */

//        Category category= new Category();
//        category.setName("Apple devices");
//
//        Category savedCategory= categoryRepository.save(category);

//        Optional<Category> optionalCategory= categoryRepository.findById(UUID.fromString("d6db2038-b875-48cd-bf6f-b9135656e058"));
//        if (optionalCategory.isEmpty()) {
//            throw new Exception("category is empty");
//        }
//        Category category= optionalCategory.get();
//        Product product =new Product();
//        product.setTitle("iPhone 15 pro plus");
//        product.setDescription("Best iPhone with camera");
//        product.setPrice(150000);
//        product.setCategory(category.get());
//
//        Product savedProduct= productRepository.save(product);

        //find all the product with category = Apple devices
//        List<Product> products= category.getProducts();
//        for (Product product: products) {
//            System.out.println(product.getTitle());
//        }
        //find all the product
//        List<Product> products= productRepository.findAll();
//        for (Product product: products) {
//            System.out.println(product.getTitle());
//        }

//        Price price= new Price();
//        price.setCurrency("INR");
//        price.setValue(100000);
//
//        //Price savedPrice = priceRepository.save(price);
//
//        Category category=new Category();
//        category.setName("Apple devices");
//
//        Category savedCategory= categoryRepository.save(category);
//
//        Product product= new Product();
//        product.setTitle("iPhone 15 pro plus");
//        product.setDescription("Best iPhone ever for camera");
//        product.setCategory(savedCategory);
//        product.setPrice(price);

//        Product savedProduct= productRepository.save(product);

        //priceRepository.deleteById(UUID.fromString("f234acc5-a593-4a7e-8981-891e00a8f6dd")); /* Not Allowed*/

        //productRepository.deleteById(UUID.fromString("74607eff-3556-4899-aa0f-b8c17c13c825"));

//        Category category= new Category();
//        category.setName("Apple devices");
//        Category savedCategory = categoryRepository.save(category);
//
//        Price price=new Price();
//        price.setValue(100000);
//        price.setCurrency("INR");

//        Optional<Price> price= priceRepository.findById(UUID.fromString("19de745d-0023-4558-9b31-e852e5ff95eb"));
//        if(price.isEmpty()) {
//            throw new Exception("price is empty");
//        }
//        Price price1= price.get();

//        Optional<Category> optionalCategory= categoryRepository.findById(UUID.fromString("ccf960c4-98d8-4efc-9093-02c4586521b5"));
//        if(optionalCategory.isEmpty()) {
//            throw  new Exception("Category is empty");
//        }
//        Category category= optionalCategory.get();
//
//        Price price1=new Price();
//        price1.setValue(112000);
//        price1.setCurrency("INR");
//
//        Product product1= new Product();
//        product1.setPrice(price1);
//        product1.setTitle("iPhone 14 pro plus +");
//        product1.setDescription("Best camera");
//        product1.setImage("IMG");
//        product1.setCategory(category);
//
//        Product savedProduct1= productRepository.save(product1);
//
//        Price price2=new Price();
//        price2.setValue(150300);
//        price2.setCurrency("INR");
//
//        Product product2= new Product();
//        product2.setPrice(price2);
//        product2.setTitle("iPhone 14 pro plus");
//        product2.setDescription("Best camera");
//        product2.setImage("IMG");
//        product2.setCategory(category);
//
//        Product savedProduct2= productRepository.save(product2);
//
//        Price price3=new Price();
//        price3.setValue(200000);
//        price3.setCurrency("INR");
//
//        Product product3= new Product();
//        product3.setPrice(price3);
//        product3.setTitle("iPhone 14 pro plus");
//        product3.setDescription("Best camera");
//        product3.setImage("IMG");
//        product3.setCategory(category);
//
//        Product savedProduct3= productRepository.save(product3);

//        Optional<Category> optionalCategory= categoryRepository.findById(UUID.fromString("ccf960c4-98d8-4efc-9093-02c4586521b5"));
//
//        Category category= optionalCategory.get();

//        List<Product> products= category.getProducts();
//
//        for (Product product1 : products) {
//            System.out.println(product1.getTitle());
//        }

//        List<Product> products= productRepository.findAllByTitle("iPhone 14 pro plus");

//        List<Product> products= productRepository.findAllByTitleAndDescription("iPhone 14 pro plus" , "Best camera");

//        List<Product> products= productRepository.findAllByPrice_ValueGreaterThan(150000);

//        Category category= new Category();
//        category.setName("Andriod");
//        Category savedCategory = categoryRepository.save(category);
//
//        Product product4= new Product("Samsung Fold 5" , "Best Fold Phone", "IMG", savedCategory, new Price("INR" , 49000.0));
//
//        Product savedProduct4= productRepository.save(product4);

        List<Product> products= productRepository.findAllByPrice_ValueBetween(100000 , 170000);

    }
}
