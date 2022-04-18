package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User
{
   @Id
   @GeneratedValue
   Long id;

   String firstName;

   String lastName;

   @Column( length = 100000000 )
   String heavyString;

   public Long getId()
   {
      return id;
   }

   public void setId( final Long id )
   {
      this.id = id;
   }

   public String getFirstName()
   {
      return firstName;
   }

   public void setFirstName( final String firstName )
   {
      this.firstName = firstName;
   }

   public String getLastName()
   {
      return lastName;
   }

   public void setLastName( final String lastName )
   {
      this.lastName = lastName;
   }

   public String getHeavyString()
   {
      return heavyString;
   }

   public void setHeavyString( final String heavyString )
   {
      this.heavyString = heavyString;
   }

   @Override
   public boolean equals( final Object o )
   {
      if( this == o ) {
         return true;
      }
      if( !( o instanceof User ) ) {
         return false;
      }
      final User user = ( User ) o;
      return id.equals( user.id );
   }

   @Override
   public int hashCode()
   {
      return getClass().hashCode();
   }

   @Override
   public String toString()
   {
      return "User{" +
             "firstName='" + firstName + '\'' +
             ", lastName='" + lastName + '\'' +
             '}';
   }
}
