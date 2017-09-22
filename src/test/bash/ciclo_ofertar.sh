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
printf "\n\n[= postular_oferta ========================]\n"

curl --cookie cookies.txt --cookie-jar newcookies.txt \
	-v -X POST \
	-F "aviso.id=$AVISO_ID" \
	-F "precio=1" \
	-F "plazo.id=$PLAZO_ID" \
	$SERVER_IP/aviso/postular_oferta

 # exit
# ---------------
# show
# ---------------
printf "\n\n[= postular_oferta ========================]\n"

curl --cookie cookies.txt --cookie-jar newcookies.txt \
	-v -X GET \
	$SERVER_IP/aviso/show/$AVISO_ID

# ---------------
# aprobar_oferta
# ---------------
printf "\n\n[= aprobar_oferta ========================]\n"

curl --cookie cookies.txt --cookie-jar newcookies.txt \
	-v -X POST \
	-F "oferta.id=$OFERTA_ID" \
	$SERVER_IP/aviso/aprobar_oferta# 

# ---------------
# aceptar_oferta
# ---------------
printf "\n\n[= aceptar_oferta ========================]\n"

curl --cookie cookies.txt --cookie-jar newcookies.txt \
	-v -X POST \
	-F "oferta.id=$OFERTA_ID" \
	$SERVER_IP/aviso/aceptar_oferta