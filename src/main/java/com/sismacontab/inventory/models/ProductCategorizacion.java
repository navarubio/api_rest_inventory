package com.sismacontab.inventory.models;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table(name = "products_categorizacion", schema = "fdw_vegfarm")
public class ProductCategorizacion {
    @Id
    @Column(name = "codigo_interno")
    private String codigoInterno;

    @Column(name = "upc")
    private String upc;

    @Column(name = "nombre_producto", nullable = false)
    private String nombreProducto;

    @Column(name = "presentacion_original")
    private Double presentacionOriginal;

    @Column(name = "laboratorio")
    private String laboratorio;

    @Column(name = "categoria_original")
    private String categoriaOriginal;

    // Relaciones con la jerarquía de categorías
    @Column(name = "category_id")
    private Integer categoryId;

    @Column(name = "subcategory_id")
    private Integer subcategoryId;

    @Column(name = "specific_1_id")
    private Integer specific1Id;

    @Column(name = "specific_2_id")
    private Integer specific2Id;

    @Column(name = "categoria_principal")
    private String categoriaPrincipal;

    @Column(name = "subcategoria_1")
    private String subcategoria1;

    @Column(name = "subcategoria_2")
    private String subcategoria2;

    @Column(name = "subcategoria_3")
    private String subcategoria3;

    @Column(name = "forma_farmaceutica")
    private String formaFarmaceutica;

    @Column(name = "concentracion_dosis")
    private String concentracionDosis;

    @Column(name = "contenido_envase")
    private String contenidoEnvase;

    @Column(name = "via_administracion")
    private String viaAdministracion;

    @Column(name = "poblacion_diana")
    private String poblacionDiana;

    @Column(name = "tags_indicaciones")
    private String tagsIndicaciones;

    @Column(name = "pais_fabricacion")
    private String paisFabricacion;

    @Column(name = "requiere_prescripcion_medica")
    private Boolean requierePrescripcionMedica;

    @Column(name = "es_psicotropico")
    private Boolean esPsicotropico;

    @Column(name = "requiere_cadena_de_frio")
    private Boolean requiereCadenaDeFrio;

    @Column(name = "principio_activo", columnDefinition = "TEXT")
    private String principioActivo;

    @Column(name = "patologia", columnDefinition = "TEXT")
    private String patologia;

    @Column(name = "posologia", columnDefinition = "TEXT")
    private String posologia;

    @Column(name = "contraindicaciones", columnDefinition = "TEXT")
    private String contraindicaciones;

    @Column(name = "sustituto_sugerido", columnDefinition = "TEXT")
    private String sustitutoSugerido;

    @Column(name = "nivel_completacion")
    private Integer nivelCompletacion;

    @Column(name = "fecha_creacion_registro")
    private ZonedDateTime fechaCreacionRegistro;

    @Column(name = "fecha_ultima_modificacion")
    private ZonedDateTime fechaUltimaModificacion;

    @Column(name = "usuario_ultima_modificacion")
    private String usuarioUltimaModificacion;

    public String getCodigoInterno() {
        return codigoInterno;
    }

    public void setCodigoInterno(String codigoInterno) {
        this.codigoInterno = codigoInterno;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Double getPresentacionOriginal() {
        return presentacionOriginal;
    }

    public void setPresentacionOriginal(Double presentacionOriginal) {
        this.presentacionOriginal = presentacionOriginal;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public String getCategoriaOriginal() {
        return categoriaOriginal;
    }

    public void setCategoriaOriginal(String categoriaOriginal) {
        this.categoriaOriginal = categoriaOriginal;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getSubcategoryId() {
        return subcategoryId;
    }

    public void setSubcategoryId(Integer subcategoryId) {
        this.subcategoryId = subcategoryId;
    }

    public Integer getSpecific1Id() {
        return specific1Id;
    }

    public void setSpecific1Id(Integer specific1Id) {
        this.specific1Id = specific1Id;
    }

    public Integer getSpecific2Id() {
        return specific2Id;
    }

    public void setSpecific2Id(Integer specific2Id) {
        this.specific2Id = specific2Id;
    }

    public String getCategoriaPrincipal() {
        return categoriaPrincipal;
    }

    public void setCategoriaPrincipal(String categoriaPrincipal) {
        this.categoriaPrincipal = categoriaPrincipal;
    }

    public String getSubcategoria1() {
        return subcategoria1;
    }

    public void setSubcategoria1(String subcategoria1) {
        this.subcategoria1 = subcategoria1;
    }

    public String getSubcategoria2() {
        return subcategoria2;
    }

    public void setSubcategoria2(String subcategoria2) {
        this.subcategoria2 = subcategoria2;
    }

    public String getSubcategoria3() {
        return subcategoria3;
    }

    public void setSubcategoria3(String subcategoria3) {
        this.subcategoria3 = subcategoria3;
    }

    public String getFormaFarmaceutica() {
        return formaFarmaceutica;
    }

    public void setFormaFarmaceutica(String formaFarmaceutica) {
        this.formaFarmaceutica = formaFarmaceutica;
    }

    public String getConcentracionDosis() {
        return concentracionDosis;
    }

    public void setConcentracionDosis(String concentracionDosis) {
        this.concentracionDosis = concentracionDosis;
    }

    public String getContenidoEnvase() {
        return contenidoEnvase;
    }

    public void setContenidoEnvase(String contenidoEnvase) {
        this.contenidoEnvase = contenidoEnvase;
    }

    public String getViaAdministracion() {
        return viaAdministracion;
    }

    public void setViaAdministracion(String viaAdministracion) {
        this.viaAdministracion = viaAdministracion;
    }

    public String getPoblacionDiana() {
        return poblacionDiana;
    }

    public void setPoblacionDiana(String poblacionDiana) {
        this.poblacionDiana = poblacionDiana;
    }

    public String getTagsIndicaciones() {
        return tagsIndicaciones;
    }

    public void setTagsIndicaciones(String tagsIndicaciones) {
        this.tagsIndicaciones = tagsIndicaciones;
    }

    public String getPaisFabricacion() {
        return paisFabricacion;
    }

    public void setPaisFabricacion(String paisFabricacion) {
        this.paisFabricacion = paisFabricacion;
    }

    public Boolean getRequierePrescripcionMedica() {
        return requierePrescripcionMedica;
    }

    public void setRequierePrescripcionMedica(Boolean requierePrescripcionMedica) {
        this.requierePrescripcionMedica = requierePrescripcionMedica;
    }

    public Boolean getEsPsicotropico() {
        return esPsicotropico;
    }

    public void setEsPsicotropico(Boolean esPsicotropico) {
        this.esPsicotropico = esPsicotropico;
    }

    public Boolean getRequiereCadenaDeFrio() {
        return requiereCadenaDeFrio;
    }

    public void setRequiereCadenaDeFrio(Boolean requiereCadenaDeFrio) {
        this.requiereCadenaDeFrio = requiereCadenaDeFrio;
    }

    public String getPrincipioActivo() {
        return principioActivo;
    }

    public void setPrincipioActivo(String principioActivo) {
        this.principioActivo = principioActivo;
    }

    public String getPatologia() {
        return patologia;
    }

    public void setPatologia(String patologia) {
        this.patologia = patologia;
    }

    public String getPosologia() {
        return posologia;
    }

    public void setPosologia(String posologia) {
        this.posologia = posologia;
    }

    public String getContraindicaciones() {
        return contraindicaciones;
    }

    public void setContraindicaciones(String contraindicaciones) {
        this.contraindicaciones = contraindicaciones;
    }

    public String getSustitutoSugerido() {
        return sustitutoSugerido;
    }

    public void setSustitutoSugerido(String sustitutoSugerido) {
        this.sustitutoSugerido = sustitutoSugerido;
    }

    public Integer getNivelCompletacion() {
        return nivelCompletacion;
    }

    public void setNivelCompletacion(Integer nivelCompletacion) {
        this.nivelCompletacion = nivelCompletacion;
    }

    public ZonedDateTime getFechaCreacionRegistro() {
        return fechaCreacionRegistro;
    }

    public void setFechaCreacionRegistro(ZonedDateTime fechaCreacionRegistro) {
        this.fechaCreacionRegistro = fechaCreacionRegistro;
    }

    public ZonedDateTime getFechaUltimaModificacion() {
        return fechaUltimaModificacion;
    }

    public void setFechaUltimaModificacion(ZonedDateTime fechaUltimaModificacion) {
        this.fechaUltimaModificacion = fechaUltimaModificacion;
    }

    public String getUsuarioUltimaModificacion() {
        return usuarioUltimaModificacion;
    }

    public void setUsuarioUltimaModificacion(String usuarioUltimaModificacion) {
        this.usuarioUltimaModificacion = usuarioUltimaModificacion;
    }

    // Getters and Setters
    // ... (implement all getters and setters)
}