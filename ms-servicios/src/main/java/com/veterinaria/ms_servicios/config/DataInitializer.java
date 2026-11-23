package com.veterinaria.ms_servicios.config;

import com.veterinaria.ms_servicios.model.Servicio;
import com.veterinaria.ms_servicios.repository.ServicioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initServicios(ServicioRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                List<Servicio> iniciales = List.of(
                    new Servicio("SV001", "Consulta general", "Consultas", "Perro / Gato", "30 min", 15000, "/imagenes/consulta.webp", "Evaluación clínica general y control de signos vitales."),
                    new Servicio("SV002", "Consulta urgencia", "Consultas", "Perro / Gato", "30 min", 25000, "/imagenes/consulta.webp", "Atención prioritaria fuera de horario o malestar agudo."),
                    new Servicio("SV003", "Control postoperatorio", "Consultas", "Perro / Gato", "20 min", 10000, "/imagenes/consulta.webp", "Revisión de heridas y evolución quirúrgica."),
                    new Servicio("SV004", "Consulta ave / conejo", "Consultas", "Ave / Conejo", "30 min", 18000, "/imagenes/consulta.webp", "Medicina especializada para mascotas exóticas."),
                    new Servicio("SV005", "Segunda opinión médica", "Consultas", "Todas", "40 min", 20000, "/imagenes/consulta.webp", "Evaluación integral de diagnósticos complejos previos."),
                    new Servicio("VA001", "Vacuna antirrábica canina", "Vacunación", "Perro", "10 min", 12000, "/imagenes/vacunas.webp", "Inmunización preventiva para perros."),
                    new Servicio("VA002", "Vacuna séxtuple canina", "Vacunación", "Perro", "10 min", 18000, "/imagenes/vacunas.webp", "Protección frente a múltiples enfermedades víricas."),
                    new Servicio("VA003", "Vacuna bivalente felina", "Vacunación", "Gato", "10 min", 15000, "/imagenes/vacunas.webp", "Inmunización preventiva para gatos."),
                    new Servicio("VA004", "Vacuna triple felina", "Vacunación", "Gato", "10 min", 17000, "/imagenes/vacunas.webp", "Refuerzo anual preventivo felino."),
                    new Servicio("VA005", "Vacuna Bordetella canina", "Vacunación", "Perro", "10 min", 14000, "/imagenes/vacunas.webp", "Prevención de tos de las perreras."),
                    new Servicio("CI001", "Esterilización hembra canina", "Cirugía", "Perra", "90 min", 80000, "/imagenes/veterinaria.webp", "Incluye anestesia y hospitalización 24 h."),
                    new Servicio("CI002", "Esterilización macho canino", "Cirugía", "Perro", "60 min", 60000, "/imagenes/veterinaria.webp", "Control reproductivo con anestesia incluida."),
                    new Servicio("CI003", "Esterilización hembra felina", "Cirugía", "Gata", "60 min", 65000, "/imagenes/veterinaria.webp", "Incluye anestesia y hospitalización 12 h."),
                    new Servicio("CI004", "Esterilización macho felino", "Cirugía", "Gato", "45 min", 50000, "/imagenes/veterinaria.webp", "Control reproductivo felino."),
                    new Servicio("CI005", "Extirpación de tumor cutáneo", "Cirugía", "Perro / Gato", "60 min", 120000, "/imagenes/veterinaria.webp", "Precio referencial; varía según tamaño."),
                    new Servicio("CI006", "Cesárea de urgencia", "Cirugía", "Perra / Gata", "120 min", 180000, "/imagenes/veterinaria.webp", "Intervención quirúrgica de emergencia."),
                    new Servicio("DE001", "Desparasitación interna pequeños (<10 kg)", "Desparasitación", "Perro", "5 min", 8000, "/imagenes/Antiparasitario.jpeg", "Tratamiento contra parásitos internos."),
                    new Servicio("DE002", "Desparasitación interna medianos (10-25 kg)", "Desparasitación", "Perro", "5 min", 9500, "/imagenes/Antiparasitario.jpeg", "Tratamiento en comprimido."),
                    new Servicio("DE003", "Desparasitación interna grandes (>25 kg)", "Desparasitación", "Perro", "5 min", 11000, "/imagenes/Antiparasitario.jpeg", "Tratamiento antiparasitario especializado."),
                    new Servicio("DE004", "Desparasitación interna felina", "Desparasitación", "Gato", "5 min", 8000, "/imagenes/Antiparasitario.jpeg", "Control de parásitos para gatos."),
                    new Servicio("DE005", "Antiparasitario externo (pipeta)", "Desparasitación", "Perro / Gato", "5 min", 7500, "/imagenes/Antiparasitario.jpeg", "Aplicación contra pulgas y garrapatas."),
                    new Servicio("EX001", "Hemograma completo", "Exámenes", "Perro / Gato", "30 min", 22000, "/imagenes/veterinaria.webp", "Resultado estimado en 24-48 h."),
                    new Servicio("EX002", "Perfil bioquímico completo", "Exámenes", "Perro / Gato", "30 min", 35000, "/imagenes/veterinaria.webp", "Análisis de función orgánica."),
                    new Servicio("EX003", "Radiografía (1 proyección)", "Exámenes", "Perro / Gato", "20 min", 28000, "/imagenes/veterinaria.webp", "Estudio imagenológico."),
                    new Servicio("EX004", "Ecografía abdominal", "Exámenes", "Perro / Gato", "30 min", 45000, "/imagenes/veterinaria.webp", "Evaluación de órganos internos."),
                    new Servicio("OT001", "Corte de uñas", "Otros", "Perro / Gato", "15 min", 5000, "/imagenes/consulta.webp", "Higiene y mantención estética."),
                    new Servicio("OT002", "Limpieza dental", "Otros", "Perro / Gato", "45 min", 55000, "/imagenes/consulta.webp", "Limpieza dental con ultrasonido; requiere anestesia."),
                    new Servicio("OT003", "Microchip identificación", "Otros", "Perro / Gato", "10 min", 15000, "/imagenes/consulta.webp", "Incluye registro de identificación."),
                    new Servicio("OT004", "Hospitalización (por día)", "Otros", "Perro / Gato", "24 h", 30000, "/imagenes/consulta.webp", "Incluye monitoreo y alimentación básica.")
                );
                repository.saveAll(iniciales);
                System.out.println(">>> 29 Servicios iniciales cargados en servicios_db <<<");
            }
        };
    }
}