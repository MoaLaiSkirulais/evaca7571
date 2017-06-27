package evaca

class AvisoValidator {
    static def consignatario = {it ->
		if (it.tbTipo != 'Consignatario') {
			throw new DomainException(message : "Debe seleccionar un consignatario")
		}
	}
}
