package co.simplon.gestiontask;

import co.simplon.gestiontask.dao.TaskRepository;
import co.simplon.gestiontask.entities.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GestiontaskApplication implements CommandLineRunner {
	@Autowired
	private TaskRepository taskRepository;
	public static void main(String[] args) {
		SpringApplication.run(GestiontaskApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		taskRepository.save(new Task(null,"aller aux toilettes"));
		taskRepository.save(new Task(null,"brosser les dents"));
		taskRepository.save(new Task(null,"mettre la table"));
		taskRepository.save(new Task(null,"ranger sa chambre"));
		taskRepository.findAll().forEach(task->{
			System.out.println(task);
		});
	}
}
