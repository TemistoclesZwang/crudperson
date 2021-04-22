package com.dio.crudperson.dto.request;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import com.dio.crudperson.entities.Person;
import com.dio.crudperson.entities.Phone;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class PersonRequestDto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@NotNull(message = "Preenchimento obrigatório - Nome")
    @Size(min = 2, max = 100)
	private String firstName;
	
	@NotNull(message = "Preenchimento obrigatório - Sobrenome")
    @Size(min = 2, max = 100)
	private String lastName;
	
	@NotNull(message = "Preenchimento obrigatório - CPF")
	@CPF
	private String cpf;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate birthDate;

	private List<Phone> phones;
	
	public Person transformToDto() {
		Person person = new Person(null, this.firstName, this.lastName, this.cpf, this.birthDate);
		
		return person;
	}
}