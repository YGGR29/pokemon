package com.example.pokemon.entities;

public class Pokemon {
	private int id;
	private String nombre;
	private String descripcion;
	private String tipo_pokemon;
	private String fecha_descubrimiento;
	private String generacion;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo_pokemon() {
        return tipo_pokemon;
    }

    public void setTipo_pokemon(String tipo_pokemon) {
        this.tipo_pokemon = tipo_pokemon;
    }

    public String getFecha_descubrimiento() {
        return fecha_descubrimiento;
    }

    public void setFecha_descubrimiento(String fecha_descubrimiento) {
        this.fecha_descubrimiento = fecha_descubrimiento;
    }

    public String getGeneracion() {
        return generacion;
    }

    public void setGeneracion(String generacion) {
        this.generacion = generacion;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
        
        
	

}
