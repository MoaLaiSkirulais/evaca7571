package evaca

import grails.transaction.Transactional
 
@Transactional
class ScriptService {
	
	def mySessionService
	def PopulateXProService
	
	
	// -----------
	// resenaSetup
	// -----------
	
	def resenaSetup() {
	
		/* reset all */
		populateXProService.clearAll()

		/* tablas basicas */
		populateXProService.usuarios()
		populateXProService.razas()
		populateXProService.categorias()
		populateXProService.plazos()
		populateXProService.preguntas()
		
		/* transacciones */
		populateXProService.lotes()
		populateXProService.avisos()
		populateXProService.ofertas()

		/* usuarios */
		def administrador = Usuario.findByUsername("administrador")
		def productor1 = Usuario.findByUsername("productor1")
		def productor2 = Usuario.findByUsername("productor2")

		/* aceptaciones de ofertas */
		println "[log] Acepta la oferta el productor1"
		def oferta = productor1.ofertas.find{oferta -> oferta.propietario == productor2}
		oferta.aceptar(productor1)

		/* resenas */
		populateXProService.resenas()
		def resena = new Resena()
		resena.puntaje = 4
		resena.prepare()
		resena.propietario = productor2
		lote.aviso.postularResena(resena)

		/* aprobar */
		resena.aprobar(administrador)
		
		/* audit */
		populateXProService.countAll()
	}
	
	
	// ---------
	// demoSetup
	// ---------
	
	def demoSetup() {
	
		/* reset all */
		populateXProService.clearAll()

		/* populate */
		populateXProService.usuarios()
		populateXProService.razas()
		populateXProService.categorias()
		populateXProService.plazos()
		populateXProService.preguntas()

		/* transaccional */
		def u = new UsuarioReader()
		u.loadFromCsv()

		def r = new LoteReader()
		r.loadFromCsv()

		def o = new OfertaReader()
		o.loadFromCsv()

		def re = new ResenaReader()
		re.loadFromCsv()
		
		/*
		import evaca.*
		def srv = ctx.getBean('testGenericService')
		srv.demoSetup()
		*/

	}
}







