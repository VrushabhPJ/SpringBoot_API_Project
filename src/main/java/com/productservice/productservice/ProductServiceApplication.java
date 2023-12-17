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
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ProductServiceApplication implements CommandLineRunner {
    private MentorRepository mentorRepository;
    private StudentRepository studentRepository;
    private UserRepository userRepository;
    ProductServiceApplication (@Qualifier("st_mentorrepository") MentorRepository mentorRepository,
                               @Qualifier("st_studentrepository")StudentRepository studentRepository,
                               @Qualifier("st_userrepository")UserRepository userRepository) {
        this.mentorRepository= mentorRepository;
        this.studentRepository= studentRepository;
        this.userRepository= userRepository;
    }


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
    }
}
