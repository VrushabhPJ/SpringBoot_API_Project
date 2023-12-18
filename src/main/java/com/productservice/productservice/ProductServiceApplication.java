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
    private final OrderRepository orderRepository;

    public ProductServiceApplication(CategoryRepository categoryRepository,
                                     ProductRepository productRepository,
                                     PriceRepository priceRepository,
                                     OrderRepository orderRepository) {
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
        this.priceRepository = priceRepository;
        this.orderRepository = orderRepository;
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
//        Price savedPrice = priceRepository.save(price);
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
//        product.setPrice(savedPrice);
//
//        Product savedProduct= productRepository.save(product);

//        priceRepository.deleteById(UUID.fromString("f234acc5-a593-4a7e-8981-891e00a8f6dd")); /* Not Allowed*/

    }
}
