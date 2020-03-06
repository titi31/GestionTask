package co.simplon.gestiontask;

import co.simplon.gestiontask.dao.TaskRepository;
import co.simplon.gestiontask.entities.AppRole;
import co.simplon.gestiontask.entities.AppUser;
import co.simplon.gestiontask.entities.Task;
import co.simplon.gestiontask.service.AccountService;
import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
public class GestiontaskApplication implements CommandLineRunner {
	@Autowired
	private TaskRepository taskRepository;
	@Autowired
	private AccountService accountService;
	public static void main(String[] args) {
		SpringApplication.run(GestiontaskApplication.class, args);
	}
	@Bean
	public BCryptPasswordEncoder getBCPE(){
		return new BCryptPasswordEncoder();
	}
	@Override
	public void run(String... args) throws Exception {
		accountService.saveUser(new AppUser(null,"admin","YxvbY36U",null));
		accountService.saveUser(new AppUser(null,"user","33Fz!Jx2019",null));
		accountService.saveRole(new AppRole(null,"ADMIN"));
		accountService.saveRole(new AppRole(null,"USER"));
		accountService.addRoleToUse("admin","ADMIN");
		accountService.addRoleToUse("user","USER");
		taskRepository.save(new Task(null,"aller aux toilettes"));
		taskRepository.save(new Task(null,"brosser les dents"));
		taskRepository.save(new Task(null,"mettre la table"));
		taskRepository.save(new Task(null,"ranger sa chambre"));
		taskRepository.findAll().forEach(task->{
			System.out.println(task);
		});
	}
	
}
