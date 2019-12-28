package co.simplon.gestiontask.service;

import co.simplon.gestiontask.entities.AppRole;
import co.simplon.gestiontask.entities.AppUser;

public interface AccountService {
    public AppUser saveUser(AppUser user);
    public AppRole saveRole(AppRole role);
    public void addRoleToUse(String username,String roleName);
    public AppUser findUserByUsername(String username);

}
