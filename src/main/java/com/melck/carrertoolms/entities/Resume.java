package com.melck.carrertoolms.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_resume")
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

   @ManyToOne
   @JoinColumn(name = "user_id")
   private User user;

   private HashMap<String, String> skills;
//   @JsonIgnore
//   @OneToMany(mappedBy = "resume")
//   private Set<Skill> skills = new HashSet<>();

}
