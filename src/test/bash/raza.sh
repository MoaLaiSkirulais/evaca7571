RED='\033[0;31m'
NC='\033[0m' # No Color

printf "I ${RED}index${NC}\n"
curl -v http://172.22.97.51:8080/raza/index

printf "I ${RED}edit${NC}\n"
curl -v http://172.22.97.51:8080/raza/edit

printf "I ${RED}save${NC}\n"
curl -v http://172.22.97.51:8080/raza/save

printf "I ${RED}create${NC}\n"
curl -v http://172.22.97.51:8080/raza/create

