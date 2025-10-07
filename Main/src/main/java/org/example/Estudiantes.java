package org.example;


public class Estudiantes {
    // Atributos
    private String nombre = "";
    private int edad = -1;
    private double media = -1;
    private Boolean matricula;

    // Constructor
    public Estudiantes(String nombre, int edad, double media, Boolean matricula) {
        this.nombre = nombre;
        this.edad = edad;
        this.media = media;
        this.matricula = matricula;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public double getMedia() {
        return media;
    }

    public Boolean getMatricula() {
        return matricula;
    }

    // Setters
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public void setMatricula(Boolean matricula) {
        this.matricula = matricula;
    }
}