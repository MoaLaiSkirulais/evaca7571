export SERVER_IP=172.22.107.5:3000

# ---------------
# login
# ---------------
printf "\n\n[= login ========================]\n"

curl --cookie-jar cookies.txt -vi --keepalive \
	-X POST \
	-F 'username=productor1' \
	-F 'password=' \
	$SERVER_IP/usuario/login


# ---------------
# postular_oferta
# ---------------
printf "\n\n[= postular_oferta ========================]\n"

curl --cookie cookies.txt --cookie-jar newcookies.txt \
	-v -X POST \
	-F 'aviso.id=2' \
	-F 'precio=1' \
	-F 'plazo.id=2' \
	$SERVER_IP/aviso/postular_oferta

exit
# ---------------
# show
# ---------------
printf "\n\n[= postular_oferta ========================]\n"

curl --cookie cookies.txt --cookie-jar newcookies.txt \
	-v -X GET \
	$SERVER_IP/aviso/show/17
