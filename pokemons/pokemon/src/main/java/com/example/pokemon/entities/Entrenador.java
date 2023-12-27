package com.example.pokemon.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Entrenador")

public class Entrenador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int id;

	@Column(name = "nombre")
	private String nombre;
	@Column(name = "email")
	private String email;
	@Column(name = "apellido")
	private String apellido;
	@Column(name = "fecha nacimiento")
	private String fecha_nacimiento;
	@Column(name = "fecha vinculacion")
	private String fecha_vinculacion;
	@Column(name = "pueblo id")
	private String pueblo_id;
	@Column(name = "uuid")
	private String uuid;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getFecha_vinculacion() {
		return fecha_vinculacion;
	}

	public void setFecha_vinculacion(String fecha_vinculacion) {
		this.fecha_vinculacion = fecha_vinculacion;
	}

	public String getPueblo_id() {
		return pueblo_id;
	}

	public void setPueblo_id(String pueblo_id) {
		this.pueblo_id = pueblo_id;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public List<Pokemon> getPokemon() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<com.example.pokemon.entities.Pokemon> getPokemon1() {
		// TODO Auto-generated method stub
		return null;
	}

	public void agregarPokemon(Pokemon pokemon) {
		// TODO Auto-generated method stub
		
	}

}
