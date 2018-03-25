RED='\033[0;31m'
NC='\033[0m' # No Color

printf "I ${RED}index${NC}\n"
curl -v http://172.22.107.5:3000/raza/index

printf "I ${RED}edit${NC}\n"
curl -v http://172.22.107.5:3000/raza/edit

printf "I ${RED}save${NC}\n"
curl -v http://172.22.107.5:3000/raza/save

printf "I ${RED}create${NC}\n"
curl -v http://172.22.107.5:3000/raza/create

