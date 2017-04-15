package evaca

class Categoria {

      String name
      static hasMany = [lotes:Lote]
      
	  Set lotes
      static constraints = {
              name(nullable:false, blank:false)
      }

      String toString(){
              this.name
      }

}

