package com.example.demo;

import java.util.List;

public interface UserRepositoryCustom
{
   void saveCustom( User user );

   void saveAndFlushCustom( User user );

   void saveAndFlushAndEvict( User user );

   void saveAndFlushAndClear( User user );

   void saveAllAndFlushAndClear( List< User > users );
}
