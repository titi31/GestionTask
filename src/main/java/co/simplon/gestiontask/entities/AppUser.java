package co.simplon.gestiontask.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AppUser 
{
    
    @Id
    @GeneratedValue
    private  Long id;
    
    @Column(unique = true)
    private String username;
    
    private String password;
    
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<AppRole> roles=new ArrayList<>();

    public Collection<AppRole> getRoles() 
    {
        return roles;
    }

    public void setRoles(Collection<AppRole> roles) 
    {
        this.roles = roles;
    }

    public String getUsername() 
    {
        return username;
    }

    public void setUsername(String username) 
    {
        this.username = username;
    }
    
    @JsonIgnore
    public String getPassword() {
        return password;
    }
    
    @JsonSetter
    public void setPassword(String password) 
    {
        this.password = password;
    }
}
