package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService
{
   private final UserRepository userRepository;


   public UserService( final UserRepository userRepository )
   {
      this.userRepository = userRepository;
   }

   public List< User > createSomeUsers()
   {

      User pesho = new User();
      pesho.setFirstName( "Petar" );
      pesho.setLastName( "Petrov" );

      userRepository.saveCustom( pesho );
//      userRepository.saveAndFlushCustom( pesho );
//      userRepository.saveAndFlushAndEvict( pesho );

//      userRepository.findById( pesho.getId() );
//      userRepository.findAll();

      User max = new User();
      max.setFirstName( "Max" );
      max.setLastName( "Mustermann" );

      userRepository.saveCustom( max );
//      userRepository.saveAndFlushCustom( max );
//      userRepository.saveAndFlushAndClear( max );

      return List.of( userRepository.findById( pesho.getId() ).orElseThrow(),
                      userRepository.findById( max.getId() ).orElseThrow() );
   }

   public long createManyUsers()
   {
      for( int i = 0; i < 10; i++ ) {

         var users = new ArrayList< User >();
         for( int j = 0; j < 10000; j++ ) {
            User pesho = new User();
            pesho.setFirstName( "Petar" );
            pesho.setLastName( "Petrov" );
            users.add( pesho );
         }

         userRepository.saveAll( users );
//         userRepository.saveAllAndFlush( users );

         try {
            Thread.sleep( 1000 );
         }
         catch( InterruptedException e ) {
            e.printStackTrace();
         }
      }

//      if( true ) {
//         throw new RuntimeException();
//      }

      return userRepository.count();
   }

   public long createHeavyUsers()
   {
      var heavyString = RandomStringUtils.random( 100000000, true, true );
      for( int i = 0; i < 10; i++ ) {
         var users = new ArrayList< User >();
         for( int j = 0; j < 10; j++ ) {
            User pesho = new User();
            pesho.setFirstName( "Petar" );
            pesho.setLastName( "Petrov" );
            pesho.setHeavyString( heavyString + "" );
            users.add( pesho );
         }

         userRepository.saveAll( users );
//         userRepository.saveAllAndFlush( users );
//         userRepository.saveAllAndFlushAndClear( users );
      }

      return userRepository.count();

   }

   @Transactional( isolation = Isolation.READ_UNCOMMITTED, readOnly = true )
   public long countUsers()
   {
      return userRepository.count();
   }
}
