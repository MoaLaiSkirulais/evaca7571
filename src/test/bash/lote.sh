RED='\033[0;31m'
NC='\033[0m' # No Color

printf "I ${RED}lote.index${NC}\n"
curl -iv http://172.22.97.51:8080/lote/index

printf "I ${RED}lote.edit${NC}\n"
curl -v http://172.22.97.51:8080/lote/edit

printf "I ${RED}lote.save${NC}\n"
curl -v http://172.22.97.51:8080/lote/save

printf "I ${RED}lote.create${NC}\n"
curl -iv http://172.22.97.51:8080/lote/create

