package co.simplon.gestiontask.dao;

import co.simplon.gestiontask.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TaskRepository extends JpaRepository<Task,Long> {
}
