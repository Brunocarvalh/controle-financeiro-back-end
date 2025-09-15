package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="despesa ")
public class Despesa  {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String description;
    private double value;
    private LocalDate dataDespesa;

    @ManyToOne
    @JoinColumn(name = "user_id") // chave estrangeira
    private User user;

}
