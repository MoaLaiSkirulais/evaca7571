export SERVER_IP=172.22.107.5:3000
export AVISO_ID=1
export PLAZO_ID=1
export OFERTA_ID=1

# ---------------
# login admin
# ---------------
printf "\n\n[= login ========================]\n"

curl --cookie-jar cookies.txt \
	-v -X POST \
	-F 'username=administrador' \
	-F 'password=' \
	$SERVER_IP/usuario/login

	# exit

# ---------------
# usuario/desaprobar
# ---------------
printf "\n\n[= usuario/desaprobar ========================]\n"

curl --cookie cookies.txt \
	-v -X POST \
	-F "usuario.id=2" \
	$SERVER_IP/usuario/desaprobar
	
# ---------------
# propietario1 admin
# ---------------
printf "\n\n[= login ========================]\n"

curl --cookie-jar cookies.txt \
	-v -X POST \
	-F 'username=propietario1' \
	-F 'password=' \
	$SERVER_IP/usuario/login
# exit
# ---------------
# postular2
# ---------------
printf "\n\n[= postular2 ========================]\n"

curl --cookie cookies.txt \
	-v -X POST \
	-F "raza.id=1" \
	-F "categoria.id=1" \
	-F "provincia=San Juan" \
	-F "ubicacion=San Juan" \
	$SERVER_IP/lote/postular2

	
	
	
	
