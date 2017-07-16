# curl -s -X POST -H "Content-Type:application/json" \
# -d '{"email": "martinporto@gmail.com", "password": "1234", "ttl": 1209600000}' \
# http://172.22.97.51:3000/api/users/login | jq .

# curl -v http://172.22.97.51:8080/aviso/index
curl -v http://172.22.97.51:8080/aviso/edit/1
