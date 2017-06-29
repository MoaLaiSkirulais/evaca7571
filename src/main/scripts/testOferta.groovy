// import evaca.*
// def myService = ctx.getBean('populateService')

// /* limpia todo */
// myService.clearAll()

// /* usuario */
// def usuario = new Usuario(
    // username: "mporto1", 
    // nombre: "Martin", 
    // apellido: "Porto", 
    // email: "martinporto1@gmail.com", 
    // tbTipo: "Productor", 
    // password: "1234", 
    // comision: 11					
// ).save(flush:true, failOnError: true)

// /* raza & categoria */
// def raza = new Raza(usuario: usuario, nombre: "Aberdeen Angus1").save(flush:true, failOnError: true)
// def categoria = new Categoria(usuario: usuario, nombre: "Preñadas1").save(flush:true, failOnError: true)

// /* lote */
// def lote = new Lote(
    // usuario: usuario,  
    // raza: raza, 
    // categoria: categoria, 
    // cantidad: 15, 
    // pesoPromedio: 300, 
    // pesoMaximo: 500, 
    // pesoMinimo: 250, 
    // trazada: true, 
    // ubicacion: "San Justo, Santa Fe", 
    // edad: 1, 
    // descarte: "", 
    // marcaLiquida: true, 
    // pesada: "", 
    // desbaste: "", 
    // cuit: "1-22344566-22", 
    // imagen: "http://i.imgur.com/hmo2zOp.gif"
// ).save(flush:true, failOnError: true)	

// /* aviso */
// def aviso = new Aviso(
    // lote: lote, 
    // consignatario: usuario, 
    // precio: 3200
// )

// println aviso.dump()
// println "1 " + aviso.validate()
// aviso.save(flush:true, failOnError: true)
