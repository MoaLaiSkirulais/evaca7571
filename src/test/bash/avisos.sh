# curl -v http://172.22.97.51:8080/aviso/postular_oferta
export SERVER_IP=172.22.97.51:8080

# postular_oferta
printf "\n\n[= postular_oferta! ========================]\n"

export PARAMS="ofertaId=1&param2=value2"

export VAR1=`cat <<EOF
ofertaId=1
&param2=value2
EOF
`
curl -X POST \
	-F 'ofertaId=1' \
	-F 'id=10' \
	-F 'password=something' \
	$SERVER_IP/aviso/postular_oferta
