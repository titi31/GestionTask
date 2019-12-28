package co.simplon.gestiontask.dao;

import co.simplon.gestiontask.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser,Long> {
    public AppUser findByUsername(String username);
}
