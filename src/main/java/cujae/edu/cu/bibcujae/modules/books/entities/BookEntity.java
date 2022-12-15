package cujae.edu.cu.bibcujae.modules.books.entities;

import javax.persistence.Id;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;

@Data
@Entity
@javax.persistence.Table(name = "\"libros\"")
public class BookEntity {

    public BookEntity() {
    }

    /*
     * Identificación del libro.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long libroId;

    /*
     * Título del libro.
     */
    @Column(name = "titulo", nullable = false)
    private String title;

    /*
     * Entrada del libro.
     */
    @Column(name = "entrada")
    private String enter;

    /*
     * Autor del libro.
     */
    @Column(name = "autor")
    private String author;

    /*
     * Otros autores del libro.
     */
    @Column(name = "otrosAutores")
    private String anotherAuthors;

    /*
     * Edición del libro.
     */
    @Column(name = "edicion")
    private String edition;

    /*
     * Serie del libro.
     */
    @Column(name = "serie")
    private String serie;

    /*
     * Notas del libro.
     */
    @Column(name = "notas")
    private String notes;

    /*
     * Entrada del libro.
     */
    @Column(name = "tipoAutor")
    private String typeAuthor;

    /*
     * Año publicación del libro.
     */
    @Column(name = "annoPub", nullable = false)
    private int annoPub;

    /*
     * Menciones del libro.
     */
    @Column(name = "mencionResp")
    private String mentionResp;

    /*
     * Código de domicilio del libro.
     */
    @Column(name = "codDomicilio", nullable = false)
    private String domCode;

    /*
     * Código ISBN del libro.
     */
    @Column(name = "isbn")
    private String isbnCode;

    /*
     * Código dewey del libro.
     */
    @Column(name = "dewey")
    private String deweyCode;

    /*
     * Evento del libro.
     */
    @Column(name = "evento")
    private String event;

    /*
     * Publicación del libro.
     */
    @Column(name = "publicacion")
    private String publication;

    /*
     * Colación del libro.
     */
    @Column(name = "colacion")
    private String colation;

    /*
     * Otros títulos del libro.
     */
    @Column(name = "otrosTitulos")
    private String anotherTitles;

    /*
     * Folleto del libro.
     */
    @Column(name = "folleto")
    private String folleto;

    /*
     * Referencias del libro.
     */
    @Column(name = "referencia")
    private String references;
    /*
     * Clasificación del libro.
     */
    @Column(name = "clasif")
    private String clasification;

    /*
     * Idioma del libro.
     */
    @Column(name = "idioma")
    private String language;

    /*
     * País del libro.
     */
    @Column(name = "pais")
    private String country;

    public Long getLibroId() {
        return libroId;
    }

    public void setLibroId(Long libroId) {
        this.libroId = libroId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEnter() {
        return enter;
    }

    public void setEnter(String enter) {
        this.enter = enter;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAnotherAuthors() {
        return anotherAuthors;
    }

    public void setAnotherAuthors(String anotherAuthors) {
        this.anotherAuthors = anotherAuthors;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getTypeAuthor() {
        return typeAuthor;
    }

    public void setTypeAuthor(String typeAuthor) {
        this.typeAuthor = typeAuthor;
    }

    public int getAnnoPub() {
        return annoPub;
    }

    public void setAnnoPub(int annoPub) {
        this.annoPub = annoPub;
    }

    public String getMentionResp() {
        return mentionResp;
    }

    public void setMentionResp(String mentionResp) {
        this.mentionResp = mentionResp;
    }

    public String getDomCode() {
        return domCode;
    }

    public void setDomCode(String domCode) {
        this.domCode = domCode;
    }

    public String getIsbnCode() {
        return isbnCode;
    }

    public void setIsbnCode(String isbnCode) {
        this.isbnCode = isbnCode;
    }

    public String getDeweyCode() {
        return deweyCode;
    }

    public void setDeweyCode(String deweyCode) {
        this.deweyCode = deweyCode;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    public String getColation() {
        return colation;
    }

    public void setColation(String colation) {
        this.colation = colation;
    }

    public String getAnotherTitles() {
        return anotherTitles;
    }

    public void setAnotherTitles(String anotherTitles) {
        this.anotherTitles = anotherTitles;
    }

    public String getFolleto() {
        return folleto;
    }

    public void setFolleto(String folleto) {
        this.folleto = folleto;
    }

    public String getReferences() {
        return references;
    }

    public void setReferences(String references) {
        this.references = references;
    }

    public String getClasification() {
        return clasification;
    }

    public void setClasification(String clasification) {
        this.clasification = clasification;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    /*
     * Materias del libro
     */
    /*
     * @ManyToMany
     * 
     * @JoinColumn(name = "materia_id")
     * private MateriaLibroEntity materiaId;
     */

}
