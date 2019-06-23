package com.lambdaschool.wanderlust;


import com.lambdaschool.wanderlust.model.Role;
import com.lambdaschool.wanderlust.model.User;
import com.lambdaschool.wanderlust.model.UserRoles;
import com.lambdaschool.wanderlust.repository.RoleRepository;
import com.lambdaschool.wanderlust.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Transactional
@Component
public class SeedData implements CommandLineRunner
    {
        RoleRepository rolerepos;
        UserRepository userrepos;

        public SeedData(RoleRepository rolerepos, UserRepository userrepos)
        {
            this.rolerepos = rolerepos;
            this.userrepos = userrepos;
        }

        @Override
        public void run(String[] args) throws Exception
        {
            Role r1 = new Role("user");

            ArrayList<UserRoles> users = new ArrayList<>();
            users.add(new UserRoles(new User(), r1));

            rolerepos.save(r1);

            User u1 = new User("username", "password", users);

            userrepos.save(u1);
        }


}
