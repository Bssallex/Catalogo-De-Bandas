package CatalogoDeBandas.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "catalogo")
public class BandEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_banda")
    private String nome;

    @Column(name = "ano_criação")
    private int ano;

    @Column(name = "descrição")
    private String descricao;

    @Column(name = "membros")
    private int membros;

    @ManyToMany
    @JoinTable(
            name = "banda_genero",
            joinColumns = @JoinColumn(name = "banda_id"),
            inverseJoinColumns = @JoinColumn(name = "genero_id")
    )
    private List<GeneroEntity> generos;


}
