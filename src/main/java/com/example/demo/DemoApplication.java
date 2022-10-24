package com.example.demo;

import com.example.demo.service.AuthorService;
import com.example.demo.service.BookService;
import com.example.demo.service.InspectorService;
import com.example.demo.service.DefectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import javax.annotation.PostConstruct;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class DemoApplication {

    @Autowired
    private AuthorService authorService;
    @Autowired
    private BookService bookService;
    @Autowired
    private InspectorService inspectorService;
    @Autowired
    private DefectService defectService;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(DemoApplication.class);

    }


    @PostConstruct
    public void init() throws Exception {
        authorService.deleteAll();
        bookService.deleteAll();
        inspectorService.deleteAll();
        defectService.deleteAll();
        defectService.add("12","Youssef","Flaw 1 Desc","1","2","4","Low","10/19/2022","Yes");
        defectService.add("7","Anhelina","Flaw 2 Desc","1","3","2","High","10/17/2022","No");
        defectService.add("4","Arsalan","Flaw 3 Desc","1","1","6","High","10/22/2022","Yes");
        defectService.add("2","Sokhey","Flaw 4 Desc","1","4","1","Low","10/24/2022","No");
        inspectorService.add("781","3204","50","36","5","82");
        inspectorService.add("324","1607","23","78","2","67");
        inspectorService.add("561","2431","12","15","9","103");
        inspectorService.add("405","2604","41","66","7","81");
        authorService.add("Arthur", "Conan Doyle");
        authorService.add("Agatha", "Christie");
        authorService.add("Luc", "Besson");
        authorService.add("Christie", "Golden");
        bookService.add("Sherlock Holmes","978-5-907120-60-0");
        bookService.add("Professor Challenger","978-5-8475-1121-6");
        bookService.add("Murder on the Orient Express","978-5-04-098115-1");
        bookService.add("Ten Little Niggers","978-5-9925-0837-6");
        bookService.add("Poirot Investigates","978-5-04-107820-1");
        bookService.add("Arthur and minipyts","978-90225-43-009");
        bookService.add("'World of Warcraft","978-5-17-112285-0");
    }

}