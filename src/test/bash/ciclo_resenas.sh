export SERVER_IP=172.22.97.51:8080
export AVISO_ID=1
export RESENA_ID=2

# ---------------
# login user
# ---------------
printf "\n\n[= login ========================]\n"

curl --cookie-jar cookies.txt \
	-v -X POST \
	-F 'username=productor1' \
	-F 'password=' \
	$SERVER_IP/usuario/login


# ---------------
# postular_resena
# ---------------
printf "\n\n[= postular_resena ========================]\n"

curl --cookie cookies.txt  \
	-v -X POST \
	-F "aviso.id=$AVISO_ID" \
	-F "puntaje=1" \
	-F "comentario=Estuvo todo muy bien" \
	-F "respuestas[1].pregunta.id = 1" \
	-F "respuestas[1].puntaje = 3" \
	-F "respuestas[1].respuesta = 3" \
	-F "respuestas[2].pregunta.id = 1" \
	-F "respuestas[2].puntaje = 3" \
	-F "respuestas[2].respuesta = 3" \
	-F "respuestas[3].pregunta.id = 1" \
	-F "respuestas[3].puntaje = 3" \
	-F "respuestas[3].respuesta = 3" \
	$SERVER_IP/resena/postular
	
# ---------------
# login admin
# ---------------
printf "\n\n[= login admin ========================]\n"

curl --cookie-jar cookies.txt \
	-v -X POST \
	-F 'username=administrador' \
	-F 'password=' \
	$SERVER_IP/usuario/login	

# ---------------
# aprobar_resena
# ---------------
printf "\n\n[= aprobar_resena ========================]\n"

curl --cookie cookies.txt  \
	-v -X POST \
	-F "resena.id=$RESENA_ID" \
	$SERVER_IP/resena/aprobar
	
	
	
	
	