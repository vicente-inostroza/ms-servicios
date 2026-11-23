package com.veterinaria.ms_servicios.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "servicios")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Entidad que representa un servicio clínico o estético ofrecido por la veterinaria")
public class Servicio {

    @Id
    @NotBlank(message = "El código es obligatorio")
    @Schema(description = "Identificador único del servicio", example = "SE007")
    private String codigo;

    @NotBlank(message = "El nombre es obligatorio")
    @Schema(description = "Nombre comercial del servicio", example = "Radiografía Digital")
    private String nombre;

    @NotBlank(message = "La categoría es obligatoria")
    @Schema(description = "Área clínica o estética a la que pertenece", example = "Diagnóstico por Imagen")
    private String categoria;

    @NotBlank(message = "La especie es obligatoria")
    @Schema(description = "Especie(s) objetivo del servicio", example = "Perro / Gato")
    private String especie;

    @NotBlank(message = "La duración es obligatoria")
    @Schema(description = "Tiempo estimado de atención", example = "30 min")
    private String duracion;

    @NotNull(message = "El precio es obligatorio")
    @Min(value = 0, message = "El precio no puede ser negativo")
    @Schema(description = "Valor del servicio en pesos chilenos (CLP)", example = "28000")
    private Integer precio;

    @Schema(description = "Ruta relativa o URL de la imagen referencial", example = "/imagenes/radiografia.jpg")
    private String imagen;

    @Schema(description = "Descripción detallada de lo que incluye el servicio", example = "Toma radiográfica digital con entrega inmediata de placas.")
    private String detalle;
}