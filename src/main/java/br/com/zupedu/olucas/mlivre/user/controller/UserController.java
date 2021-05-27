package br.com.zupedu.olucas.mlivre.user.controller;

import br.com.zupedu.olucas.mlivre.user.model.User;
import br.com.zupedu.olucas.mlivre.user.repository.UserRepository;
import br.com.zupedu.olucas.mlivre.user.request.UserRequest;
import br.com.zupedu.olucas.mlivre.user.validators.ValidatePassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ValidatePassword validatePassword;

    @PostMapping
    public ResponseEntity createUser(@RequestBody @Valid UserRequest userRequest) {
        User user = userRequest.convertRequestToEntity();
        userRepository.save(user);
        return ResponseEntity.ok().build();
    }

    @InitBinder
    public void init(WebDataBinder webDataBinder) {
        webDataBinder.addValidators(validatePassword);
    }

}
