package com.example.demo;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/users" )
public class UserController
{

   private final UserService userService;

   public UserController( final UserService userService )
   {
      this.userService = userService;
   }

   @PostMapping
   public List< User > createUsers()
   {
      return userService.createSomeUsers();
   }

   @PostMapping
   @RequestMapping( "/bulk" )
   public long createManyUsers()
   {
      return userService.createManyUsers();
   }

   @PostMapping
   @RequestMapping( "/heavy" )
   public long createHeavyUsers()
   {
      return userService.createHeavyUsers();
   }

   @GetMapping
   @RequestMapping( "/count" )
   public long countUsers()
   {
      return userService.countUsers();
   }
}
