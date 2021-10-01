package com.meetingplanner.spring.web.controllers.viewControllers;


import com.meetingplanner.spring.domain.MeetingRepository;
import com.meetingplanner.spring.domain.meeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AppController {
//    @Autowired
//    private UserRepository repo;

    @Autowired
    private MeetingRepository meetingRepository;
//
//    @Autowired
//    private RoomsRepository roomsRepository;


//    @GetMapping("/")
//    public String viewHomePage()
//    {
//        return "index";
//    }


//    @GetMapping("/register")
//    public String showSignUpForm(Model model)
//    {
//        model.addAttribute("user",new User());
//        return "signup_form";
//    }

    @GetMapping("/meeting_form")
    public  String meetingForm(Model model)
    {
        model.addAttribute("meet", new meeting());

        return "website/meeting_form";
    }


//    @GetMapping("/Addrooms")
//    public String AddRoom(Model model)
//    {
//        model.addAttribute("rooms", new TracomRooms());
//
//        return "Addrooms";
//    }

//    @PostMapping("/Saveroom")
//    public String RoomSave(TracomRooms tracomRooms)
//    {
//        roomsRepository.save(tracomRooms);
//        return "Saveroom";
//    }

//    @GetMapping("/Saveroom")
//    public String AddRooms(Model model)
//    {
//        List<TracomRooms> addrromm=roomsRepository.findAll();
//        model.addAttribute("listrooms",addrromm);
//
//        return "Saveroom";
//    }

//    @PostMapping("/process_register")
//    public String processRegister(User user)
//    {
//        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
//        String encodedpassword=encoder.encode(user.getPassword());
//        user.setPassword(encodedpassword);
//        repo.save(user);
//        return "register_success";
//    }

    @PostMapping("/meetingdetails")
    public  String meetingSave (meeting meett)
    {
        meetingRepository.save(meett);
        return "website/meetingdetails";
    }

//    @GetMapping("/process_register")
//    public String Process(Model model)
//    {
//        List<User> listUsers=repo.findAll();
//        model.addAttribute("listUsers",listUsers);
//        return "register_success";
//    }

    @GetMapping("/meetingdetails")
    public String Meeting(Model model)
    {
        List<meeting> listmeeting=meetingRepository.findAll();
        model.addAttribute("listmeeting",listmeeting);

        return "website/meetingdetails";
    }

//    @GetMapping("/list_users")
//    public String viewUsersList(Model model)
//    {
//        List<User> listUsers=repo.findAll();
//        model.addAttribute("listUsers",listUsers);
//        return "users";
//    }
//
//    @GetMapping("/add_users")
//    public String addUser(Model model){
//
//        model.addAttribute("user", new User());
//
//        return "add_users";
//    }




}
