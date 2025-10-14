package com.spotfy.spotfyproject.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "TBEMPRESA")
public class EmpresaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CDEMPRESA")
    private Integer cdEmpresa;
    @Column(name = "NMRAZAO", length = 500 , nullable = false)
    private String nmRazao;
    @Column(name = "NMFANTASIA" , length = 100)
    private String nmFantasia;
    @Column(name = "NUCNPJ" , length = 20 , nullable = false , unique = true)
    private String nuCnpj;
    @Column(name = "NUTELEFONE" , length = 14)
    private String nuTelefone;
    @Column(name = "NUENDERECO")
    private String nuEndereco;
    @Column(name = "DSENDERECO" , length = 100)
    private String dsEndereco;
    @Column(name = "FLATIVO" , length = 1 , nullable = false)
    private String flAtivo;
}
