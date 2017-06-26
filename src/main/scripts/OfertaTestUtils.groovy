import evaca.*
def myService = ctx.getBean('populateService')
myService.clearAll()

def usuario = new Usuario(
	username: "mporto1", 
	nombre: "Martin", 
	apellido: "Porto", 
	email: "martinporto1@gmail.com", 
	tbTipo: "Productor", 
	password: "1234", 
	comision: 11					
).save(flush:true, failOnError: true)

def raza = new Raza(usuario: usuario, nombre: "Aberdeen Angus1").save(flush:true, failOnError: true)
def categoria = new Categoria(usuario: usuario, nombre: "Preñadas1").save(flush:true, failOnError: true)
def plazo = new Plazo(usuario: usuario, nombre: "Contado1").save(flush:true, failOnError: true)

def lote = new Lote(
	usuario: usuario,  
	raza: raza, 
	categoria: categoria, 
	cantidad: 15, 
	pesoPromedio: 300, 
	pesoMaximo: 500, 
	pesoMinimo: 250, 
	trazada: true, 
	ubicacion: "San Justo, Santa Fe", 
	edad: 1, 
	descarte: "", 
	marcaLiquida: true, 
	pesada: "", 
	desbaste: "", 
	cuit: "1-22344566-22", 
	imagen: "http://i.imgur.com/hmo2zOp.gif"
).save(flush:true, failOnError: true)

def aviso = new Aviso(
	lote: lote, 
	consignatario: usuario, 
	precio: 3200
).save(flush:true, failOnError: true)

def oferta = new Oferta(
	aviso: aviso, 
	usuario: usuario, 
	plazo: plazo,
	precio: 1000
).save(flush:true, failOnError: true)
myService.countAll()
println "1-----"
usuario.tbTipo = 'Administrador'
println usuario.dump()
oferta.activar(usuario);
println "2-----"
println lote.raza.dump()
println lote.usuario.dump()
println "3-----"
println oferta.aviso.lote.usuario.dump()
oferta.aceptar();

//myService.countAll()