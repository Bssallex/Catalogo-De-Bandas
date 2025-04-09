package CatalogoDeBandas.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Catalogo")
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
}
