package com.veterinaria.ms_servicios.controller;

import com.veterinaria.ms_servicios.model.Servicio;
import com.veterinaria.ms_servicios.service.ServicioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servicios")
@CrossOrigin(origins = "*")
@Tag(name = "Servicios Veterinarios", description = "Operaciones CRUD para la administración de servicios de la clínica veterinaria")
public class ServicioController {

    @Autowired
    private ServicioService service;

    @Operation(
            summary = "Listar todos los servicios",
            description = "Obtiene la lista completa de servicios veterinarios registrados en la base de datos."
    )
    @ApiResponse(responseCode = "200", description = "Lista de servicios obtenida exitosamente")
    @GetMapping
    public ResponseEntity<List<Servicio>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @Operation(
            summary = "Buscar servicio por código",
            description = "Devuelve el detalle de un servicio específico utilizando su código identificador único (ej. SE001)."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Servicio encontrado"),
            @ApiResponse(responseCode = "404", description = "No se encontró ningún servicio con el código proporcionado")
    })
    @GetMapping("/{codigo}")
    public ResponseEntity<Servicio> obtenerPorCodigo(
            @Parameter(description = "Código único del servicio", example = "SE001", required = true)
            @PathVariable String codigo) {
        return service.buscarPorCodigo(codigo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(
            summary = "Registrar un nuevo servicio",
            description = "Crea un nuevo servicio en el catálogo validando que el código no exista previamente y que los campos cumplan las restricciones."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Servicio creado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos o campos obligatorios faltantes"),
            @ApiResponse(responseCode = "409", description = "Conflicto: ya existe un servicio registrado con ese código")
    })
    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody Servicio servicio) {
        if (service.existePorCodigo(servicio.getCodigo())) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Ya existe un servicio con el código: " + servicio.getCodigo());
        }
        Servicio nuevo = service.guardar(servicio);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @Operation(
            summary = "Actualizar un servicio existente",
            description = "Modifica los datos de un servicio existente identificado por su código."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Servicio actualizado correctamente"),
            @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos"),
            @ApiResponse(responseCode = "404", description = "No existe el servicio que se intenta actualizar")
    })
    @PutMapping("/{codigo}")
    public ResponseEntity<Servicio> actualizar(
            @Parameter(description = "Código único del servicio a actualizar", example = "SE001", required = true)
            @PathVariable String codigo,
            @Valid @RequestBody Servicio servicio) {
        if (!service.existePorCodigo(codigo)) {
            return ResponseEntity.notFound().build();
        }
        servicio.setCodigo(codigo);
        return ResponseEntity.ok(service.guardar(servicio));
    }

    @Operation(
            summary = "Eliminar un servicio",
            description = "Elimina permanentemente un servicio del catálogo según su código."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Servicio eliminado exitosamente (sin contenido de retorno)"),
            @ApiResponse(responseCode = "404", description = "No se encontró el servicio a eliminar")
    })
    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> eliminar(
            @Parameter(description = "Código único del servicio a eliminar", example = "SE001", required = true)
            @PathVariable String codigo) {
        if (!service.existePorCodigo(codigo)) {
            return ResponseEntity.notFound().build();
        }
        service.eliminar(codigo);
        return ResponseEntity.noContent().build();
    }
}