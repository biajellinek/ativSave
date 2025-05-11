package app.ativSave.entity;

import java.time.LocalDate;

import app.ativSave.enums.SituacaoEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Atividades {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String atividade;
	private String pessoa; //relacionar atividade com pessoa

	private LocalDate dataExpiracao;
	
	@Enumerated(EnumType.STRING)//deixando o enum branco
	private SituacaoEnum situacao;
	
}
