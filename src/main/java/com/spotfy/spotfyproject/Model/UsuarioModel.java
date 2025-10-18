package com.spotfy.spotfyproject.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "TBUSUARIO")
public class UsuarioModel {
  @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CDUSUARIO")
  private Integer cdUsuario;
    @Column(name = "NMUSUARIO",length = 50,nullable = false)
    private String nmUsuario;
    @Column(name = "NUCPF",length = 11 ,nullable = false)
    private String nuCpf;
    @Column(name = "NUTELEFONE",length = 50)
    private String nuTelefone;
    @Column(name = "DTUSUARIO",nullable = false)
    private Date dtUsuario;
    @Column(name = "NMSENHAUSUARIO", length = 50,nullable = false)
    private String nmSenhaUsuario;
}
