import evaca.*
def bindingMap = [name: 'Peter']
def raza = new Raza(bindingMap)
assert raza.name == 'Peter'

/* */

def bindingMap = [name: 'Petero']

def raza = Raza.get(1)
print raza

raza.properties = bindingMap
print raza
