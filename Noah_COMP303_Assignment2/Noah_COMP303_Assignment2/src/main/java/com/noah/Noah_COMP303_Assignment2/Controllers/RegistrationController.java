package com.noah.Noah_COMP303_Assignment2.Controllers;

import com.noah.Noah_COMP303_Assignment2.Models.Enrollment;
import com.noah.Noah_COMP303_Assignment2.Models.Program;
import com.noah.Noah_COMP303_Assignment2.Models.Student;
import com.noah.Noah_COMP303_Assignment2.Repositories.EnrollmentRepo;
import com.noah.Noah_COMP303_Assignment2.Repositories.ProgramRepo;
import com.noah.Noah_COMP303_Assignment2.Repositories.StudentRepo;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class RegistrationController {

    @Autowired
    private StudentRepo myStudentRepo;
    @Autowired
    private ProgramRepo myProgramRepo;
    @Autowired
    private EnrollmentRepo myEnrollmentRepo;
    @GetMapping("/")
    public String getHome(Model model) {
        model.addAttribute("student", new Student());
        return "Index";
    }

    @GetMapping("/Program")
    public String getProgram(){
        return "Program";
    }

    @GetMapping("/Login")
    public String getLogin(){return "Login";}

    @PostMapping("/Pay")
    public String Pay(@RequestParam String courseName, Model model, HttpSession session){
        Long studentId = (Long) session.getAttribute("studentId");
        if (studentId != null) {
            Optional<Student> optionalStudent = myStudentRepo.findById(studentId);
            if (optionalStudent.isPresent()) {
                Student student = optionalStudent.get();
                model.addAttribute("student", student);
            }
        }

        Program program = myProgramRepo.findByprogramName(courseName);
        if(program != null){
            model.addAttribute("program", program);
            return "Pay";
        }
        return "";
    }
    @PostMapping("/TransactionComplete")
    public String Enroll(@RequestParam Long studentId,@RequestParam Long programCode,@RequestParam double amountPaid){
        Optional<Program> program = myProgramRepo.findById(programCode);
        Optional<Student> student = myStudentRepo.findById(studentId);
        if (program.isPresent() && student.isPresent()) {
            Student myStudent = student.get();
            Program myProgram = program.get();
            Enrollment myEnrollment = new Enrollment(myStudent, myProgram, myProgram.getFee());
            myEnrollmentRepo.save(myEnrollment);
        }
        return"Transaction";
    }
    @PostMapping("/UserAuthenticate")
    public String authUser(@RequestParam String userName, @RequestParam String password, Model model, HttpSession session){
        Student student = myStudentRepo.findByuserName(userName);

        if (student != null && student.getPassword().equals(password)) {
            session.setAttribute("studentId", student.getStudentId());
            model.addAttribute("student", student);
            return "Program";
        }

        model.addAttribute("errorMessage", "Invalid username or password");
        return "Login";
    }
    @GetMapping("/Profile")
    public String getProfile(HttpSession session, Model model) {
        Long studentId = (Long) session.getAttribute("studentId");
        if (studentId != null) {
            Optional<Student> optionalStudent = myStudentRepo.findById(studentId);
            if (optionalStudent.isPresent()) {
                Student student = optionalStudent.get();
                model.addAttribute("student", student);
                return "profile";
            }
        }
        return "redirect:/login";
    }

    @PostMapping("/SaveStudent")
    public String SaveStudent(@ModelAttribute Student myStudent, RedirectAttributes redirectAttributes){
        myStudentRepo.save(myStudent);
        redirectAttributes.addFlashAttribute("message", "You Have Successfully Signed Up");
        return"redirect:/Login";
    }

    @GetMapping("/Logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/Login";
    }
}
