// import evaca.*
// def myService = ctx.getBean('populateService')
// myService.clearAll()

// def usuario = new Usuario(
    // username: "mporto1", 
    // nombre: "Martin", 
    // apellido: "Porto", 
    // email: "martinporto1@gmail.com", 
    // tbTipo: "Productor", 
    // password: "1234", 
    // comision: 11					
// ).save(flush:true, failOnError: true)

// def raza = new Raza(usuario: usuario, nombre: "Aberdeen Angus1").save(flush:true, failOnError: true)
// def categoria = new Categoria(usuario: usuario, nombre: "Preñadas1").save(flush:true, failOnError: true)

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

// //println lote.dump()
// //usuario.tbTipo='Consignatario'
// def aviso = new Aviso(
    // lote: lote, 
    // consignatario: usuario, 
    // precio: 3200
// )


// println aviso.dump()
// println "1 " + aviso.validate()
// println aviso.errors.allErrors.join(' \n') //each error is an instance of  org.springframework.validation.FieldError    
// aviso.save(flush:true, failOnError: true)

// usuario.tbTipo='Productor'
// usuario.save(flush:true, failOnError: true)
// println "2" + aviso.validate()



// aviso.save(flush:true, failOnError: true)
// //println lote.dump()

// /*
// aviso.save()

// aviso.tbState='Borrador'
// //println "1 " + aviso.validate()
// //println "1 " + aviso.dump()
// aviso.save()

// aviso.tbState='Publicado'
// //println "2 " + aviso.validate()
// println "2 " + aviso.consignatario.dump()
// aviso.save()
// aviso.save()

// aviso.tbState='Vendido'
// //println "3 " + aviso.validate()
// aviso.save()

// println "3 " + aviso.validate()
// println aviso.validate()


// */