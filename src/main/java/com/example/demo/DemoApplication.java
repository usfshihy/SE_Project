package com.example.demo;

import com.example.demo.service.JobService;
import com.example.demo.service.PhaseService;
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
    private InspectorService inspectorService;
    @Autowired
    private DefectService defectService;

    @Autowired
    private JobService jobService;

    @Autowired
    private PhaseService phaseService;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(DemoApplication.class);

    }

    @PostConstruct
    public void init() throws Exception {
//        jobService.deleteAll();
//        phaseService.deleteAll();
//        inspectorService.deleteAll();
//        defectService.deleteAll();

        defectService.add("12","Youssef","Flaw 1 Desc","1","2","4","Low","10/19/2022","Yes");
        defectService.add("7","Anhelina","Flaw 2 Desc","1","3","2","High","10/17/2022","No");
        defectService.add("4","Arsalan","Flaw 3 Desc","1","1","6","High","10/22/2022","Yes");
        defectService.add("2","Sokhey","Flaw 4 Desc","1","4","1","Low","10/24/2022","No");
        inspectorService.add("781","3204","50","36","5","82");
        inspectorService.add("324","1607","23","78","2","67");
        inspectorService.add("561","2431","12","15","9","103");
        inspectorService.add("405","2604","41","66","7","81");

//        phaseService.add("authentication", "Allow users to register and login", "1", "4", "High", "11/02/2022","Waterfall", "1", "No");
//        phaseService.add("User Role", "Create user Role", "1", "4", "Low", "13/02/2022","Waterfall", "1", "No");
//        phaseService.add("Product", "Create product item", "1", "4", "Low", "21/11/2022","Waterfall", "1", "No");
//        phaseService.add("Menu", "Manage menus all menu in which other users can see", "1", "2", "Low", "22/11/2022","Waterfall", "1", "No");
//        phaseService.add("Web admin", "Web admin for manage data of the project such as products, user roles, .etc.", "1", "4", "Low", "23/11/2022","Waterfall", "1", "No");
//        phaseService.add("Inventory adjustment", "Inventory adjust to manage or track the products whether instock or not. Be able to create delete, update.", "1", "2", "Low", "24/12/2022","Agile", "1", "No");
//        phaseService.add("Purchase order", "Manage purchase order, able to create, update, delete purchase.", "1", "2", "Low", "24/12/2022","Agile", "1", "No");
//        phaseService.add("Purchase Payment", "Manage purchase payment", "1", "3", "Low", "25/12/2022","Agile", "1", "No");
//        phaseService.add("Payment", "Manage Payment, able to search payment id", "2", "1", "Low", "10/01/2023","Agile", "1", "No");
//        phaseService.add("Receipt", "Manage receipt, able to search, filter, create, update receipt", "1", "2", "Low", "12/01/2023","Agile", "1", "No");

//        jobService.add("Register", "Create register form", "1", "High", "10/11/2022", "1", "Yes");
//        jobService.add("Login", "Create Login function", "1", "Low", "12/11/2022", "1", "NO");
//        jobService.add("Login", "Edit Login function", "1", "Low", "13/11/2022", "1", "Yes");
//        jobService.add("Login", "Delete Login function", "1", "Low", "14/11/2022", "1", "Yes");
//        jobService.add("Role Form", "Create user role form", "2", "High", "16/11/2022", "2", "NO");
//        jobService.add("Role", "Create user role function", "2", "Low", "17/11/2022", "2", "N0");
//        jobService.add("Role", "Edit user role function", "2", "Low", "18/11/2022", "2", "NO");
//        jobService.add("Role", "Delete user role function", "2", "Low", "19/11/2022", "2", "NO");
//        jobService.add("Product form", "Create product form", "3", "Low", "21/11/2022", "3", "NO");
//        jobService.add("Create Product", "Create product function", "3", "Low", "22/11/2022", "3", "NO");
//        jobService.add("Update Product", "Update product function", "3", "Low", "23/11/2022", "3", "NO");
//        jobService.add("Edit Product", "Edit product function", "3", "Low", "23/11/2022", "3", "NO");
//        jobService.add("Delete Product", "Delete product function", "3", "Low", "24/11/2022", "3", "NO");
//        jobService.add("Product Filter", "Create product filter", "3", "Low", "25/11/2022", "3", "NO");
//        jobService.add("Product review", "Review all function of product", "4", "Low", "27/11/2022", "3", "NO");

    }

}