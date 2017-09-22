export SERVER_IP=172.22.97.51:8080
export AVISO_ID=1
export PLAZO_ID=1
export OFERTA_ID=1

# ---------------
# login
# ---------------
printf "\n\n[= login ========================]\n"

curl --cookie-jar cookies.txt \
	-v -X POST \
	-F 'username=productor1' \
	-F 'password=' \
	$SERVER_IP/usuario/login


# ---------------
# postular_oferta
# ---------------
printf "\n\n[= postular_lote ========================]\n"

curl --cookie cookies.txt --cookie-jar newcookies.txt \
	-v -X POST \
	-F "raza.id=1" \
	-F "categoria.id=1" \
	-F "provincia=San Juan" \
	-F "ubicacion=San Juan" \
	$SERVER_IP/lote/postular2

