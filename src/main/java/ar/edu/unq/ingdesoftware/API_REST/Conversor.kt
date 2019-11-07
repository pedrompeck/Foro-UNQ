package ar.edu.unq.ingdesoftware.API_REST

import ar.edu.unq.ingdesoftware.model.Materia

class Conversor {

    fun materiaToREST(materia: Materia): MateriaREST {
        return MateriaREST(materia.id, materia.name, materia.descripcion, materia.nombresDePublicaciones())
    }

    fun materiasToREST(materias: List<Materia>): List<MateriaREST> {
        return materias.map { materiaToREST(it) }
    }


}
