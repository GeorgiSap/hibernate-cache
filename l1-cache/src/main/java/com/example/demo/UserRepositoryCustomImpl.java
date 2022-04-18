package com.example.demo;

import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;

public class UserRepositoryCustomImpl implements UserRepositoryCustom
{
   private final EntityManager entityManager;

   private final Session session;

   public UserRepositoryCustomImpl( final EntityManager entityManager )
   {
      this.entityManager = entityManager;
      this.session       = entityManager.unwrap( Session.class );
   }

   public void saveCustom( User user )
   {
      System.out.println( "Saving... " + user );
      entityManager.persist( user );
      System.out.println( "Session contains..." + user + " - " + session.contains( user ) );
   }

   public void saveAndFlushCustom( User user )
   {
      saveCustom( user );

      System.out.println( "Flushing..." );
      session.flush();
      System.out.println( "Session contains..." + user + " - " + session.contains( user ) );
   }

   public void saveAndFlushAndEvict( User user )
   {
      saveAndFlushCustom( user );

      System.out.println( "Evicting..." );
      session.evict( user );
      System.out.println( "Session contains..." + user + " - " + session.contains( user ) );
   }

   public void saveAndFlushAndClear( User user )
   {
      saveAndFlushCustom( user );

      System.out.println( "Clearing..." );
      session.clear();
      System.out.println( "Session contains..." + user + " - " + session.contains( user ) );
   }

   public void saveAllAndFlushAndClear( List< User > users )
   {
      users.forEach( entityManager::persist );
      entityManager.flush();
      entityManager.clear();
   }

}
