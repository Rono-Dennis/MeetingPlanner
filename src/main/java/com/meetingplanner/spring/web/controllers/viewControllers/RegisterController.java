package com.meetingplanner.spring.web.controllers.viewControllers;

import com.meetingplanner.spring.domain.User;
import com.meetingplanner.spring.service.EmailService;
import com.meetingplanner.spring.service.UserService;
import com.meetingplanner.spring.web.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


@Controller
@RequestMapping("")
public class RegisterController {
    private UserService userService;
    private EmailService emailService;

    public RegisterController(UserService userService, EmailService emailService) {
        this.userService = userService;
        this.emailService = emailService;
    }

    @PostMapping(value = "/submit-registration")
    public ModelAndView saveUser(ModelAndView modelAndView, @ModelAttribute("userDto") @Valid final UserDto userDto,
                                 BindingResult bindingResult, HttpServletRequest request, Errors errors){

        User emailExists = userService.findByEmail(userDto.getEmail());
        User userNameExists = userService.findByUsername(userDto.getUsername());

        System.out.println(emailExists);

        if (emailExists != null) {
            modelAndView.setViewName("website/register");
            bindingResult.rejectValue("email", "emailAlreadyExists");
        }

        if (userNameExists!= null) {
            modelAndView.setViewName("website/register");
            bindingResult.rejectValue("username", "usernameAlreadyExists");
        }

        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("website/register");
        }
        else { // new user so we create user and send confirmation e-mail

            User user = userService.createNewAccount(userDto);
            // Disable user until they click on confirmation link in email

            user.setEnabled(true);
            userService.save(user);


            /*String appUrl = request.getScheme() + "://" + request.getServerName();

            SimpleMailMessage registrationEmail = new SimpleMailMessage();
            registrationEmail.setTo(user.getEmail());
            registrationEmail.setSubject("Registration Confirmation");
            registrationEmail.setText("Please confirm the registration");
            registrationEmail.setFrom("email@email.com");

            emailService.sendEmail(registrationEmail);*/

            modelAndView.addObject("confirmationMessage", "A confirmation e-mail has been set as "
                                    + userDto.getEmail());
            modelAndView.setViewName("website/registered");
        }

        return modelAndView;
    }
}
