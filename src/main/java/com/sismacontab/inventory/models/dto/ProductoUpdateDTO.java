package com.sismacontab.inventory.models.dto;

import java.time.LocalDateTime;

public class ProductoUpdateDTO {
    // Identificadores
    private String codigoInterno;
    private String upc;
    private String nombreProducto;
    private String laboratorio;
    private String categoriaOriginal;
    private Integer presentacionOriginal;
    private Integer nivelCompletacion;
    private LocalDateTime fechaCreacionRegistro;
    
    // Categorización
    private Integer categoryId;
    private Integer subcategoryId;
    private Integer specific1Id;
    private Integer specific2Id;
    private String categoriaPrincipal;
    private String subcategoria1;
    private String subcategoria2;
    private String subcategoria3;
    
    // Atributos
    private String formaFarmaceutica;
    private String concentracionDosis;
    private String contenidoEnvase;
    private String viaAdministracion;
    private String poblacionDiana;
    private String tagsIndicaciones;
    
    // Regulatorios
    private String paisFabricacion;
    private Boolean requierePrescripcionMedica;
    private Boolean esPsicotropico;
    private Boolean requiereCadenaDeFrio;
    
    // Vademécum
    private String principioActivo;
    private String patologia;
    private String posologia;
    private String contraindicaciones;
    private String sustitutoSugerido;
    
    // Metadatos
    private LocalDateTime fechaUltimaModificacion;
    private String usuarioUltimaModificacion;

    // Constructor vacío
    public ProductoUpdateDTO() {}

    // Getters and Setters
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

    public Integer getPresentacionOriginal() {
        return presentacionOriginal;
    }

    public void setPresentacionOriginal(Integer presentacionOriginal) {
        this.presentacionOriginal = presentacionOriginal;
    }

    public Integer getNivelCompletacion() {
        return nivelCompletacion;
    }

    public void setNivelCompletacion(Integer nivelCompletacion) {
        this.nivelCompletacion = nivelCompletacion;
    }

    public LocalDateTime getFechaCreacionRegistro() {
        return fechaCreacionRegistro;
    }

    public void setFechaCreacionRegistro(LocalDateTime fechaCreacionRegistro) {
        this.fechaCreacionRegistro = fechaCreacionRegistro;
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

    public LocalDateTime getFechaUltimaModificacion() {
        return fechaUltimaModificacion;
    }

    public void setFechaUltimaModificacion(LocalDateTime fechaUltimaModificacion) {
        this.fechaUltimaModificacion = fechaUltimaModificacion;
    }

    public String getUsuarioUltimaModificacion() {
        return usuarioUltimaModificacion;
    }

    public void setUsuarioUltimaModificacion(String usuarioUltimaModificacion) {
        this.usuarioUltimaModificacion = usuarioUltimaModificacion;
    }
}
